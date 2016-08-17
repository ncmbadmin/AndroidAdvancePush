package mbaas.com.nifty.advancepush;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.nifty.cloud.mb.core.NCMBGcmListenerService;
import org.json.JSONException;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomGcmListenerService extends NCMBGcmListenerService {

    private static final String TAG = "GcmService";
    private static final int REQUEST_RESULT = 0;


    @Override
    public void onMessageReceived(String from, Bundle data) {
        //**************** 【mBaaS：プッシュ通知⑦】アプリが起動中にプッシュ通知からデータを取得する***************


        //デフォルトの通知
        super.onMessageReceived(from, data);
    }



}
