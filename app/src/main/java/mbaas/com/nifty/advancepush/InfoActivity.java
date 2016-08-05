package mbaas.com.nifty.advancepush;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by sci01445 on 2016/08/03.
 */
public class InfoActivity extends AppCompatActivity {

    private Common common;
    private static final String TAG = "RegisterActivity";
    private static final int REQUEST_SIGNUP = 0;

    TextView _nickname;
    TextView _prefecture;
    TextView _gender;
    TextView _email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);
        _nickname = (TextView) findViewById(R.id.txtNickname_Info);
        _prefecture = (TextView) findViewById(R.id.txtPrefecture_Info);
        _gender = (TextView) findViewById(R.id.txtPrefecture_Info);
        _email = (TextView) findViewById(R.id.txtEmail_Info);

        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();

        Log.d(TAG, common.currentUser.getString("nickname"));

        _nickname.setText(common.currentUser.getString("nickname"));
        _prefecture.setText(common.currentUser.getString("prefecture"));
        _gender.setText(common.currentUser.getString("gender"));
        _email.setText(common.currentUser.getMailAddress());



    }


}
