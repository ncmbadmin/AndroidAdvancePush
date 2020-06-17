package mbaas.com.nifty.advancepush;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.nifcloud.mbaas.core.DoneCallback;
import com.nifcloud.mbaas.core.NCMBException;
import com.nifcloud.mbaas.core.NCMBInstallation;

import java.util.ArrayList;
import java.util.List;

public class RegisterActivity extends AppCompatActivity {

    private Common common;
    private static final String TAG = "RegisterActivity";
    private static final int REQUEST_RESULT  = 0;

    EditText _nickname;
    EditText _prefecture;
    RadioGroup _groupGender;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        _nickname = (EditText) findViewById(R.id.txtNickname);
        _prefecture = (EditText) findViewById(R.id.txtPrefecture);
        _groupGender = (RadioGroup) findViewById(R.id.radioGroupGender);

        Button _registerButton = (Button) findViewById(R.id.btnRegisterUser);

        _registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //サインアップ画面遷移する
                doRegister();
            }
        });
    }


    protected void doRegister() {

        String nickname = _nickname.getText().toString();
        String prefecture = _prefecture.getText().toString();
        Integer id = _groupGender.getCheckedRadioButtonId();
        String selectedGender = (String) ((RadioButton) findViewById(id)).getText();
        final List<String> list = new ArrayList<>();

        //**************** 【mBaaS/User③: ユーザー情報更新】***************
        try {
            common.currentUser.put("nickname", nickname);
            common.currentUser.put("prefecture", prefecture);
            common.currentUser.put("gender", selectedGender);
            common.currentUser.put("favorite",list);

            common.currentUser.saveInBackground(new DoneCallback() {
                @Override
                public void done(NCMBException e) {
                    if (e != null) {
                        // 更新失敗時の処理
                        new AlertDialog.Builder(RegisterActivity.this)
                                .setTitle("Notification from mBaas")
                                .setMessage("Save failed! Error:" + e.getMessage())
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        // 更新成功時の処理
                        new AlertDialog.Builder(RegisterActivity.this)
                                .setTitle("Notification from mBaas")
                                .setMessage("保存成功しました! 入力ありがとうございます")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivityForResult(intent, REQUEST_RESULT );
                                    }
                                })
                                .show();
                    }
                }
            });


            //**************** 【mBaaS：プッシュ通知②】installationにユーザー情報を紐づける ***************
            NCMBInstallation currInstallation  = NCMBInstallation.getCurrentInstallation();
            currInstallation.put("prefecture", prefecture);
            currInstallation.put("gender", selectedGender);
            currInstallation.put("favorite", list);
            currInstallation.saveInBackground(new DoneCallback() {
                @Override
                public void done(NCMBException e) {
                    if (e != null) {
                        //更新失敗時の処理
                        Log.d(TAG, "端末情報を保存失敗しました。");
                    } else {
                        //更新成功時の処理
                        Log.d(TAG, "端末情報を保存成功しました。");
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivityForResult(intent, REQUEST_RESULT );
                    }
                }
            });
        } catch (NCMBException e) {
            e.printStackTrace();
        }

    }

}
