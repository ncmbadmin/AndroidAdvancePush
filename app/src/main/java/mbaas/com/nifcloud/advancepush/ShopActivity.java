package mbaas.com.nifcloud.advancepush;

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

import com.nifcloud.mbaas.core.DoneCallback;
import com.nifcloud.mbaas.core.FetchFileCallback;
import com.nifcloud.mbaas.core.NCMBException;
import com.nifcloud.mbaas.core.NCMBFile;
import com.nifcloud.mbaas.core.NCMBInstallation;

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

            //**************** 【mBaaS/File②: ショップ詳細画像を取得】***************
            //**************** 【mBaaS/File②: acquire shop detail image】***************
            try {
                NCMBFile file = new NCMBFile(shop_image);
                file.fetchInBackground(new FetchFileCallback() {
                    @Override
                    public void done(byte[] data, NCMBException e) {
                        if (e != null) {
                            //取得失敗時の処理
                            //Process at acquiition failures
                            Log.d(TAG, e.getMessage());
                        } else {
                            //取得成功時の処理
                            //Process on successful acquisition
                            Bitmap bmp = null;
                            if (data != null) {
                                bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                            }
                            _shop_image.setImageBitmap(bmp);
                        }
                    }
                });
            } catch (NCMBException e) {
                e.printStackTrace();
            }

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


    protected void doFavoriteRegister(final String objId, final String name, final String shop_image) {
        //**************** 【mBaaS/User⑤: 会員情報更新】***************
        //**************** 【mBaaS/User⑤: Update member information】***************
        List<String> list = new ArrayList<String>();
        list = common.currentUser.getList("favorite");
        list.add(objId);
        try {
            common.currentUser.put("favorite", list);
            common.currentUser.saveInBackground(new DoneCallback() {
                @Override
                public void done(NCMBException e) {
                    if (e != null) {
                        //更新失敗時の処理
                        //Process at update failures
                        new AlertDialog.Builder(ShopActivity.this)
                                .setTitle("Notification from mBaas")
                                .setMessage("Save failed! Error:" + e.getMessage())
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        //更新成功時の処理
                        //Process on successful update
                        new AlertDialog.Builder(ShopActivity.this)
                                .setTitle("Notification from mBaas")
                                .setMessage("お気に入り保存成功しました(Saved Favorites Successfully!)")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
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
        } catch (NCMBException e) {
            e.printStackTrace();
        }


        //****************【mBaaS：プッシュ通知⑤】installationにユーザー情報を紐づける***************
        //****************【mBaaS：Push Notification⑤】link user information to installation***************

        try {
            NCMBInstallation currInstallation  = NCMBInstallation.getCurrentInstallation();
            currInstallation.put("favorite", list);
            currInstallation.saveInBackground(new DoneCallback() {
                @Override
                public void done(NCMBException e) {
                    if (e != null) {
                        //保存失敗した場合の処理
                        //Process at saving fails
                        Log.d(TAG, "端末情報を保存失敗しました。(Failed to save device information)");
                    } else {
                        //保存成功した場合の処理
                        //Process on successful save
                        Log.d(TAG, "端末情報を保存成功しました。(Saving device information succeeded.)");
                    }
                }
            });
        } catch (NCMBException e) {
            e.printStackTrace();
        }

    }

}
