package mbaas.com.nifty.advancepush;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.FindCallback;
import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBQuery;
import com.nifty.cloud.mb.core.NCMBUser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int REQUEST_SIGNUP = 0;
    private Common common;
    ListView lstShop;
    private ArrayAdapter<String> listAdapter ;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();
        lstShop = (ListView) findViewById(R.id.lstShop);

        Log.d(TAG, common.currentUser.getMailAddress());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.onFavoriteFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Info activity
                Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });

        //Load shop information
        try {
            doLoadShop();
        } catch (NCMBException e) {
            e.printStackTrace();
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
            startActivityForResult(intent, REQUEST_SIGNUP);
            return true;
        } else if (id == R.id.action_logout) {
            doLogout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doLogout() {
        NCMBUser.logoutInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    //エラー時の処理
                    //ログインに失敗した場合の処理
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Logout failed! Error:" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    common.currentUser = null;
                    // Start the Login activity
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivityForResult(intent, REQUEST_SIGNUP);
                }
            }
        });
    }

    public void doLoadShop() throws NCMBException {

        /*
        //TestClassを検索するためのNCMBQueryインスタンスを作成
        NCMBQuery<NCMBObject> query = new NCMBQuery<>("Shop");
        //データストアからデータを検索
        query.findInBackground(new FindCallback<NCMBObject>() {
            @Override
            public void done(List<NCMBObject> results, NCMBException e) {
                if (e != null) {

                    //検索失敗時の処理
                } else {

                    ListView lv= (ListView) findViewById(R.id.lstShop);
                    lv.setAdapter(new ShopListAdapter(MainActivity.class, prgmNameList,prgmImages));

                }
            }
        });
        */

        NCMBQuery<NCMBObject> query = new NCMBQuery<>("Shop");
        //データストアからデータを検索
        List<NCMBObject> results = query.find();
        //update common 変数 for global
        common.shops = results;
        ListView lv= (ListView) findViewById(R.id.lstShop);
        lv.setAdapter(new ShopListAdapter(this,results));
    }
}
