package mbaas.com.nifty.advancepush;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBInstallation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sci01445 on 2016/08/03.
 */
public class FavoriteActivity extends AppCompatActivity {

    private Common common;
    private static final int REQUEST_RESULT = 0;
    private static final String TAG = "FavoriteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);

        // グローバル変数を扱うクラスを取得する
        common = (Common) getApplication();

        //Get shoplist
        ShopListFavoriteAdapter adapter = new ShopListFavoriteAdapter(this, common.shops, R.layout.row_favorite, this);
        ListView listView = (ListView) this.findViewById(R.id.lstShopFavorite);
        listView.setAdapter(adapter);

        Button _favRegisterBtn = (Button) findViewById(R.id.btnFavoriteSave);
        _favRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the save favorite activity
                doFavoriteSave();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.onHomeFavFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the Info activity
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, REQUEST_RESULT);
            }
        });
    }

    protected void doFavoriteSave() {
        //**************** 【mBaaS/User: 会員情報更新】***************
        List<String> list = new ArrayList<String>();
        list = common.currentUser.getList("favorite");
        common.currentUser.put("favorite", list);
        common.currentUser.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    //リクエストに失敗した場合の処理
                    new AlertDialog.Builder(FavoriteActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Save failed! Error:" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    //保存成功
                    new AlertDialog.Builder(FavoriteActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Save successfull! Thank you for registration.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Yesボタンが押された時の処理
                                    Toast.makeText(FavoriteActivity.this, "Go to Main!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
                                    startActivityForResult(intent, REQUEST_RESULT);
                                }
                            })
                            .show();
                }
            }
        });

        //**************** 【mBaaS/Push: 端末情報更新】***************
        //端末情報を保存する
        NCMBInstallation currInstallation = NCMBInstallation.getCurrentInstallation();
        currInstallation.put("favorite", list);
        currInstallation.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    //リクエストに失敗した場合の処理
                    //保存失敗
                    Log.d(TAG, "端末情報を保存失敗しました。");
                } else {
                    //保存成功
                    Log.d(TAG, "端末情報を保存成功しました。");
                }
            }
        });
    }
}
