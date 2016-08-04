package mbaas.com.nifty.advancepush;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.nifty.cloud.mb.core.FetchFileCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBFile;

/**
 * Created by sci01445 on 2016/08/03.
 */
public class ShopActivity extends AppCompatActivity {

    TextView _shop_name;
    ImageView _shop_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        _shop_name = (TextView) findViewById(R.id.txtShop);
        _shop_image = (ImageView) findViewById(R.id.imgShop);

        //intentから前のActivityからゲット
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String objectId = extras.getString("objectId");
            String name = extras.getString("name");
            String shop_image = extras.getString("shop_image");

            _shop_name.setText(name);
            //File download

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

        }
    }
}
