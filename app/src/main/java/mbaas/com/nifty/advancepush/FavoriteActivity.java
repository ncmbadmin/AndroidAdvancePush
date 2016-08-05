package mbaas.com.nifty.advancepush;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sci01445 on 2016/08/03.
 */
public class FavoriteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);

        ArrayList<CharSequence> testList = new ArrayList<>();
        String text = "";

        for(int i = 0; i < 10;i++){
            text = "test" + i;
            testList.add(text);
        }

        ShopListFavoriteAdapter  adapter = new ShopListFavoriteAdapter(this,testList,R.layout.row_favorite);
        ListView listView = (ListView)this.findViewById(R.id.lstShopFavorite);
        listView.setAdapter(adapter);


    }
}
