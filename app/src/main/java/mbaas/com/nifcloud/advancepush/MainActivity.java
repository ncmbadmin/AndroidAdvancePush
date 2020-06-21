package mbaas.com.nifcloud.advancepush;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nifcloud.mbaas.core.DoneCallback;
import com.nifcloud.mbaas.core.NCMB;
import com.nifcloud.mbaas.core.NCMBException;
import com.nifcloud.mbaas.core.NCMBUser;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int REQUEST_RESULT  = 0;
    private Common common;
    ListView lstShop;
    private ArrayAdapter<String> listAdapter;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //**************** 【mBaaS/Initialization: APIキーを指定する】***************
        NCMB.initialize(this.getApplicationContext(),"YOUR_APPLICATION_KEY","YOUR_CLIENT_KEY");

        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();
        if (common.currentUser != null) {

            lstShop = (ListView) findViewById(R.id.lstShop);

            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.onFavoriteFab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // お気に入り画面遷移する
                    Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
                    startActivityForResult(intent, REQUEST_RESULT );
                }
            });

            //ショップ一覧を取得する
            try {
                doLoadShop();
            } catch (NCMBException e) {
                e.printStackTrace();
            }
        } else {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivityForResult(intent, REQUEST_RESULT );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            // Start the Info activity
            Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
            startActivityForResult(intent, REQUEST_RESULT );
            return true;
        } else if (id == R.id.action_logout) {
            doLogout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //**************** 【mBaaS/User④: 会員ログアウト】***************
    public void doLogout() {
        NCMBUser.logoutInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    //ログインに失敗した場合の処理
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Notification from mBaas")
                            .setMessage("ログアウト失敗しました。発生したエラーはこちら：" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    //グローバル変数を初期化する
                    common.init();
                    //ログイン画面遷移する
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivityForResult(intent, REQUEST_RESULT );
                }
            }
        });
    }


    public void doLoadShop() throws NCMBException {
        //**************** 【mBaaS/Shop①: 「Shop」クラスのデータを取得】***************

    }


    @Override
    public void onResume() {
        super.onResume();

        //**************** 【mBaaS：プッシュ通知⑥】リッチプッシュ通知を表示させる処理 ***************

    }


}
