package mbaas.com.nifcloud.advancepush;

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

import com.nifcloud.mbaas.core.DoneCallback;
import com.nifcloud.mbaas.core.NCMBException;
import com.nifcloud.mbaas.core.NCMBInstallation;

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
        //**************** 【mBaaS/User ④: 会員情報更新】***************


        //**************** 【mBaaS：プッシュ通知④】installationにユーザー情報を紐づける***************


    }
}
