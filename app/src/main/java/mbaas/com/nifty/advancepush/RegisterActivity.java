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
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;

/**
 * Created by sci01445 on 2016/08/03.
 */
public class RegisterActivity extends AppCompatActivity {

    private Common common;
    private static final String TAG = "RegisterActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText _nickname;
    EditText _prefecture;
    RadioGroup _groupGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        _nickname = (EditText) findViewById(R.id.txtNickname);
        _prefecture = (EditText) findViewById(R.id.txtPrefecture);
        _groupGender = (RadioGroup)findViewById(R.id.radioGroupGender);


        Button _registerButton = (Button) findViewById(R.id.btnRegisterUser);

        _registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                doRegister();
            }
        });

    }

    protected void doRegister() {
        String nickname = _nickname.getText().toString();
        String prefecture = _prefecture.getText().toString();
        Integer id = _groupGender.getCheckedRadioButtonId();
        String selectedGender = (String) ((RadioButton) findViewById(id)).getText();

        common.currentUser.put("nickname", nickname);
        common.currentUser.put("prefecture", prefecture);
        common.currentUser.put("gender", selectedGender);

        common.currentUser.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    //リクエストに失敗した場合の処理
                    //保存失敗
                    new AlertDialog.Builder(RegisterActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Save failed! Error:" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                }else {
                    //保存成功
                    new AlertDialog.Builder(RegisterActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Save successfull! Thank you for registration.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Yesボタンが押された時の処理
                                    Toast.makeText(RegisterActivity.this, "Go to Main!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivityForResult(intent, REQUEST_SIGNUP);
                                }
                            })
                            .show();
                }
            }
        });


    }


}
