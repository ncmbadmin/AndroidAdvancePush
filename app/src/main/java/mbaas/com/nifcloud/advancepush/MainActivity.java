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
import com.nifcloud.mbaas.core.NCMBObject;
import com.nifcloud.mbaas.core.NCMBPush;
import com.nifcloud.mbaas.core.NCMBQuery;
import com.nifcloud.mbaas.core.NCMBUser;

import java.util.List;

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
        //**************** 【mBaaS/Initialization: Specify API key】***************
        NCMB.initialize(this.getApplicationContext(),"YOUR_APPLICATION_KEY","YOUR_CLIENT_KEY");

        // グローバル変数を扱うクラスを取得する
        common = (mbaas.com.nifcloud.advancepush.Common) getApplication();
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
                    Intent intent = new Intent(getApplicationContext(), mbaas.com.nifcloud.advancepush.FavoriteActivity.class);
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
            Intent intent = new Intent(getApplicationContext(), mbaas.com.nifcloud.advancepush.LoginActivity.class);
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
            Intent intent = new Intent(getApplicationContext(), mbaas.com.nifcloud.advancepush.InfoActivity.class);
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
                    Intent intent = new Intent(getApplicationContext(), mbaas.com.nifcloud.advancepush.LoginActivity.class);
                    startActivityForResult(intent, REQUEST_RESULT );
                }
            }
        });
    }


    public void doLoadShop() throws NCMBException {
        //**************** 【mBaaS/Shop①: 「Shop」クラスのデータを取得】***************
        //**************** 【mBaaS/Shop①: Obtain data of "Shop" class】***************

        // 「Shop」クラスのクエリを作成
        // Create query for "Shop" class
        NCMBQuery<NCMBObject> query = new NCMBQuery<>("Shop");
        //データストアからデータを検索
        //Search data from datastore
        List<NCMBObject> results = query.find();
        //グローバル変数を更新する
        //Update Global Variables
        common.shops = results;
        ListView lv = (ListView) findViewById(R.id.lstShop);
        lv.setAdapter(new mbaas.com.nifcloud.advancepush.ShopListAdapter(this, results));
    }


    @Override
    public void onResume() {
        super.onResume();

        //**************** 【mBaaS：プッシュ通知⑥】リッチプッシュ通知を表示させる処理 ***************
        //********** 【mBaaS：Push Notification⑥】process for displaying rich push notifications *********

        //リッチプッシュ通知の表示
        //Diplay rich push notifications
        NCMBPush.richPushHandler(this, getIntent());

        //リッチプッシュを再表示させたくない場合はintentからURLを削除します
        //If you don't want the rich push to re-display, delete the URL from the intent
        getIntent().removeExtra("com.nifcloud.mbaas.RichUrl");
    }


}
