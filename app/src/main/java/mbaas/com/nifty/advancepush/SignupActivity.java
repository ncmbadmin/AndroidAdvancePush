package mbaas.com.nifty.advancepush;

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
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBUser;


/**
 * Created by sci01445 on 2016/08/01.
 */

public class SignupActivity extends AppCompatActivity  {

    private static final String TAG = "SignActivity";
    private static final int REQUEST_SIGNUP = 0;
    EditText _signupEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });
    }

    protected void doSignupByEmail()
    {

        String email = _signupEmail.getText().toString();
        Log.d(TAG, email);
        NCMBUser.requestAuthenticationMailInBackground(email, new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    //リクエストに失敗した場合の処理
                    //保存失敗
                    new AlertDialog.Builder(SignupActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Send failed! Error:" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                }else {
                    //保存成功
                    new AlertDialog.Builder(SignupActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Send successfull! Please check your mail box.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int which) {
                                    //Yesボタンが押された時の処理
                                    Toast.makeText(SignupActivity.this, "Yes Clicked!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                    startActivityForResult(intent, REQUEST_SIGNUP);
                                }})
                            .show();

                }
            }
        });


    }


}
