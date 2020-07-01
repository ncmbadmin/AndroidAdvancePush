package mbaas.com.nifcloud.advancepush;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nifcloud.mbaas.core.LoginCallback;
import com.nifcloud.mbaas.core.NCMBException;
import com.nifcloud.mbaas.core.NCMBUser;

public class LoginActivity extends AppCompatActivity {

    private Common common;
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_RESULT = 0;

    EditText _loginEmail;
    EditText _loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        _loginEmail = (EditText) findViewById(R.id.txtEmail);
        _loginPassword = (EditText) findViewById(R.id.txtPassword);

        Button _loginButton = (Button) findViewById(R.id.btnLogin);
        Button _signupButton = (Button) findViewById(R.id.btnSignup);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // サインアップ画面遷移する
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_RESULT);
            }
        });

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ログイン画面遷移する
                doLogin();
            }
        });

    }

    protected void doLogin() {
        //**************** 【mBaaS/User②】: メールアドレスとパスワードでログイン】***************


    }

}
