package mbaas.com.nifty.advancepush;



import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.FindCallback;
import com.nifty.cloud.mb.core.LoginCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBInstallation;
import com.nifty.cloud.mb.core.NCMBPush;
import com.nifty.cloud.mb.core.NCMBQuery;
import com.nifty.cloud.mb.core.NCMBUser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class
LoginActivity extends AppCompatActivity {

    private Common common;
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText _loginEmail;
    EditText _loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();

        // グローバル変数を扱うクラスを初期化する
        common.init();

        //NCMB.initialize(this.getApplicationContext(),"APP_KEY","CLIENT_KEY");
        NCMB.initialize(this.getApplicationContext(),"570024d33fc60874b39b5dfc665333824693a85d8dd03100e835273faf1de308","56f7d25cc6a826fc98566d8e3a3daaf2e097dfb8c802cde1286c614fd7194bdb");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        _loginEmail = (EditText) findViewById(R.id.txtEmail);
        _loginPassword = (EditText) findViewById(R.id.txtPassword);

        Button _loginButton = (Button) findViewById(R.id.btnLogin);
        Button _signupButton = (Button) findViewById(R.id.btnSignup);


        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the Login activity
                doLogin();
            }
        });

        //Installation register


        //端末情報を扱うNCMBInstallationのインスタンスを作成
        final NCMBInstallation installation = NCMBInstallation.getCurrentInstallation();

        //GCMからRegistrationIdを取得しinstallationに設定する
        installation.getRegistrationIdInBackground("848447765672", new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e == null) {
                    installation.saveInBackground(new DoneCallback() {
                        @Override
                        public void done(NCMBException e) {
                            if(e == null){
                                //保存成功
                            }else if(NCMBException.DUPLICATE_VALUE.equals(e.getCode())){
                                //保存失敗 : registrationID重複
                                updateInstallation(installation);
                            }else {
                                //保存失敗 : その他
                            }
                        }
                    });
                } else {
                    //ID取得失敗
                }
            }
        });

    }



    public static void updateInstallation(final NCMBInstallation installation) {

        //installationクラスを検索するクエリの作成
        NCMBQuery<NCMBInstallation> query = NCMBInstallation.getQuery();

        //同じRegistration IDをdeviceTokenフィールドに持つ端末情報を検索する
        query.whereEqualTo("deviceToken", installation.getDeviceToken());

        //データストアの検索を実行
        query.findInBackground(new FindCallback<NCMBInstallation>() {
            @Override
            public void done(List<NCMBInstallation> results, NCMBException e) {

                //検索された端末情報のobjectIdを設定
                installation.setObjectId(results.get(0).getObjectId());

                //端末情報を更新する
                installation.saveInBackground();
            }
        });
    }


    protected void doLogin()
    {
        String email = _loginEmail.getText().toString();
        String password = _loginPassword.getText().toString();

        NCMBUser.loginWithMailAddressInBackground(email, password, new LoginCallback() {
            @Override
            public void done(NCMBUser user, NCMBException e) {
                if (e != null) {
                    //ログインに失敗した場合の処理
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Login failed! Error:" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    common.currentUser = NCMBUser.getCurrentUser();
                    //保存成功
                    AlertDialog show = new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Login successfull!")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    String nickname = common.currentUser.getString("nickname");
                                    if (nickname != null && !nickname.isEmpty() && !nickname.equals("null")) {
                                        //Yesボタンが押された時の処理
                                        Toast.makeText(LoginActivity.this, "Yes Clicked!", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivityForResult(intent, REQUEST_SIGNUP);
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Register user information for the first time!", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                                        startActivityForResult(intent, REQUEST_SIGNUP);
                                    }

                                }
                            })
                            .show();

                }
            }
        });

    }

    //RICH PUSH
    @Override
    public void onResume() {
        Log.d(TAG, "Start resume");
        Log.d(TAG, getIntent().toString());
        super.onResume();

        //リッチプッシュ通知の表示
        NCMBPush.richPushHandler(this, getIntent());

        //リッチプッシュを再表示させたくない場合はintentからURLを削除します
        getIntent().removeExtra("com.nifty.RichUrl");
    }



}
