package mbaas.com.nifty.advancepush;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.FetchFileCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBFile;
import com.nifty.cloud.mb.core.NCMBInstallation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sci01445 on 2016/08/03.
 */
public class ShopActivity extends AppCompatActivity {

    private static final String TAG = "ShopActivity";
    private static final int REQUEST_RESULT  = 0;

    TextView _shop_name;
    ImageView _shop_image;
    ImageView _favorite_image;
    Button _btn_favorite;
    private Common common;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        common = (Common) getApplication();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        _shop_name = (TextView) findViewById(R.id.txtShop);
        _shop_image = (ImageView) findViewById(R.id.imgShop);
        _favorite_image = (ImageView) findViewById(R.id.imgFavorite);
        _btn_favorite = (Button) findViewById(R.id.btnFavorite);

        //intentから前のActivityからゲット
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            final String objectId = extras.getString("objectId");
            final String name = extras.getString("name");
            final String shop_image = extras.getString("shop_image");

            _shop_name.setText(name);

            NCMBFile file = new NCMBFile(shop_image);
            file.fetchInBackground(new FetchFileCallback() {
                @Override
                public void done(byte[] data, NCMBException e) {
                    if (e != null) {
                        //失敗
                    } else {
                        //成功
                        Bitmap bmp = null;
                        if (data != null) {
                            bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                        }
                        _shop_image.setImageBitmap(bmp);
                    }
                }
            });

            Log.d("test", common.currentUser.getList("favorite").toString());
            //Show favorite information
            if (common.currentUser.getList("favorite").contains(objectId)) {
                _favorite_image.setImageResource(R.drawable.favorite);
                _btn_favorite.setEnabled(false);
            }else {
                _favorite_image.setImageResource(R.drawable.nofavorite);
                _btn_favorite.setEnabled(true);
            }

            //Btn favorite update の処理を実装
            _btn_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the Signup activity
                    doFavoriteRegister(objectId, name, shop_image);
                }
            });

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.onHomeShopFab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the Info activity
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult(intent, REQUEST_RESULT);
                }
            });
        }

    }

    //**************** 【mBaaS/User: 会員情報更新】***************
    protected void doFavoriteRegister(final String objId, final String name, final String shop_image) {
        List<String> list = new ArrayList<String>();
        list = common.currentUser.getList("favorite");
        list.add(objId);
        common.currentUser.put("favorite", list);
        common.currentUser.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    //リクエストに失敗した場合の処理
                    new AlertDialog.Builder(ShopActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Save failed! Error:" + e.getMessage())
                            .setPositiveButton("OK", null)
                            .show();
                } else {
                    //保存成功
                    new AlertDialog.Builder(ShopActivity.this)
                            .setTitle("Notification from Nifty")
                            .setMessage("Save successfull! Thank you for registration.")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //Yesボタンが押された時の処理
                                    Toast.makeText(ShopActivity.this, "Go to Main!", Toast.LENGTH_LONG).show();
                                    Intent intent = new Intent(getApplicationContext(), ShopActivity.class);
                                    intent.putExtra("objectId", objId);
                                    intent.putExtra("name", name);
                                    intent.putExtra("shop_image", shop_image);
                                    startActivityForResult(intent, REQUEST_RESULT);
                                }
                            })
                            .show();
                }
            }
        });

        //**************** 【mBaaS/Push: 端末情報更新】***************
        NCMBInstallation currInstallation  = NCMBInstallation.getCurrentInstallation();
        currInstallation.put("favorite", list);
        currInstallation.saveInBackground(new DoneCallback() {
            @Override
            public void done(NCMBException e) {
                if (e != null) {
                    //リクエストに失敗した場合の処理
                    Log.d(TAG, "端末情報を保存失敗しました。");
                } else {
                    //保存成功
                    Log.d(TAG, "端末情報を保存成功しました。");
                }
            }
        });

    }

}
