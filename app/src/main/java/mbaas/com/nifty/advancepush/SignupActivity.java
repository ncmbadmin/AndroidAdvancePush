package mbaas.com.nifty.advancepush;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBUser;


public class SignupActivity extends AppCompatActivity {

    private Common common;
    private static final String TAG = "SignActivity";
    private static final int REQUEST_RESULT = 0;
    EditText _signupEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();

        // グローバル変数を扱うクラスを初期化する
        common.init();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        _signupEmail = (EditText) findViewById(R.id.txtSignupEmail);

        Button _backButton_onsignup = (Button) findViewById(R.id.btnBack_onsignup);
        Button _btnSignupByEmail = (Button) findViewById(R.id.btnSignupByEmail);

        _btnSignupByEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                doSignupByEmail();
            }
        });

        _backButton_onsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Login activity
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivityForResult(intent, REQUEST_RESULT);
            }
        });
    }


    protected void doSignupByEmail() {
        //**************** 【mBaaS/User①】: 会員登録用メールを要求する】***************
        String email = _signupEmail.getText().toString();
        NCMBUser.requestAuthenticationMailInBackground(email, new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    // 会員登録用メールの要求失敗時の処理
                    new AlertDialog.Builder(SignupActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Send failed! Error:" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    // 会員登録用メールの要求失敗時の処理
                    new AlertDialog.Builder(SignupActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("メール送信完了しました! メールをご確認ください。")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Login画面遷移します
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivityForResult(intent, REQUEST_RESULT);
                                }
                            })
                            .show();

                }
            }
        });
    }
}
