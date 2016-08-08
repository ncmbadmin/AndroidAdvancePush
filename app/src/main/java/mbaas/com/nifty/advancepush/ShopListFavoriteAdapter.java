package mbaas.com.nifty.advancepush;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBObject;

import java.util.ArrayList;
import java.util.List;

import mbaas.com.nifty.advancepush.R;

public class ShopListFavoriteAdapter extends BaseAdapter {

    private Common common;
    private Context context = null;
    //private ArrayList<CharSequence> data = null;
    List<NCMBObject> shops;

    private int resource = 0;
    private int listPosition;
    private static final String TAG = "LoginActivity";
    public Activity activity;

    public ShopListFavoriteAdapter(Context context,List<NCMBObject> tmpShops ,int resource, Activity act){

        this.activity = act;
        this.context = context;
        this.shops = tmpShops;
        this.resource = resource;
    }


    @Override
    public int getCount() {
        return shops.size();
    }

    @Override
    public Object getItem(int i) {
        return shops.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // グローバル変数を扱うクラスを取得する
        common = (Common) activity.getApplication();


        listPosition = i;
        final NCMBObject tmpShop = shops.get(i);
        final List<String> favList = common.currentUser.getList("favorite");

        final Activity activity =  (Activity)context;
        RelativeLayout v = (RelativeLayout)activity.getLayoutInflater().inflate(resource,null);
        ((TextView)v.findViewById(R.id.textView)).setText(tmpShop.getString("name"));

        final Switch aSwitch = (Switch)v.findViewById(R.id.favSwitch);
        if (favList.contains(tmpShop.getObjectId())) {
            aSwitch.setChecked(true);
        } else  {
            aSwitch.setChecked(false);
        }
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if (!favList.contains(tmpShop.getObjectId())) {
                        favList.add(tmpShop.getObjectId());
                    }
                    common.currentUser.put("favorite", favList);
                    Log.d(TAG, "true");
                } else {
                    if (favList.contains(tmpShop.getObjectId())) {
                        favList.remove(tmpShop.getObjectId());
                    }
                    common.currentUser.put("favorite", favList);
                    Log.d(TAG," false");
                }
            }
        });

        return v;
    }
}