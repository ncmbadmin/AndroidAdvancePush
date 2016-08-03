package mbaas.com.nifty.advancepush;



import com.nifty.cloud.mb.core.LoginCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBUser;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class
LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    EditText _loginEmail;
    EditText _loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


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
                // Start the Signup activity
                doLogin();
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
                    //保存成功
                    new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Login successfull! Please check your mail box.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int which) {
                                    //Yesボタンが押された時の処理
                                    Toast.makeText(LoginActivity.this, "Yes Clicked!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivityForResult(intent, REQUEST_SIGNUP);
                                }})
                            .show();

                }
            }
        });


    }


}
