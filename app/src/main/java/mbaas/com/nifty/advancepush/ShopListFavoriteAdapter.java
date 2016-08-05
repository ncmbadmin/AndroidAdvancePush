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

import java.util.ArrayList;

import mbaas.com.nifty.advancepush.R;

public class ShopListFavoriteAdapter extends BaseAdapter {
    private Context context = null;
    private ArrayList<CharSequence> data = null;
    private int resource = 0;
    private int listPosition;
    private static final String TAG = "LoginActivity";

    public ShopListFavoriteAdapter(Context context,ArrayList<CharSequence> data,int resource){
        this.context = context;
        this.data = data;
        this.resource = resource;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        listPosition = i;
        final Activity activity =  (Activity)context;
        RelativeLayout v = (RelativeLayout)activity.getLayoutInflater().inflate(resource,null);
        ((TextView)v.findViewById(R.id.textView)).setText(data.get(i));

        Switch aSwitch = (Switch)v.findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.d(TAG, "true");
                } else {
                    Log.d(TAG," false");
                }
            }
        });

        return v;
    }
}