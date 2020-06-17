package mbaas.com.nifty.advancepush;

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
        String email = _loginEmail.getText().toString();
        String password = _loginPassword.getText().toString();

        NCMBUser.loginWithMailAddressInBackground(email, password, new LoginCallback() {
            @Override
            public void done(NCMBUser user, NCMBException e) {
                if (e != null) {
                    //ログインに失敗した場合の処理
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Notification from mBaas")
                            .setMessage("Login failed! Error:" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    //ログインに成功した場合の処理
                    common.currentUser = NCMBUser.getCurrentUser();
                    AlertDialog show = new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Notification from mBaas")
                            .setMessage("ログイン成功")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    String nickname = common.currentUser.getString("nickname");
                                    if (nickname != null && !nickname.isEmpty() && !nickname.equals("null")) {
                                        //メイン画面遷移します
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivityForResult(intent, REQUEST_RESULT);
                                    } else {
                                        //初期ログイン会員登録画面遷移します
                                        Toast.makeText(LoginActivity.this, "Register user information for the first time!", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                                        startActivityForResult(intent, REQUEST_RESULT);
                                    }
                                }
                            })
                            .show();
                }
            }
        });

    }

}
