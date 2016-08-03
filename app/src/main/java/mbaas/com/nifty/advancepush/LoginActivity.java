package mbaas.com.nifty.advancepush;



import com.nifty.cloud.mb.core.NCMB;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class
LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        //NCMB.initialize(this.getApplicationContext(),"APP_KEY","CLIENT_KEY");
        NCMB.initialize(this.getApplicationContext(),"570024d33fc60874b39b5dfc665333824693a85d8dd03100e835273faf1de308","56f7d25cc6a826fc98566d8e3a3daaf2e097dfb8c802cde1286c614fd7194bdb");


        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText _loginEmail = (EditText) findViewById(R.id.txtEmail);
        EditText _loginPassword = (EditText) findViewById(R.id.txtPassword);

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

    }

    protected void doLogin()
    {

    }


}
