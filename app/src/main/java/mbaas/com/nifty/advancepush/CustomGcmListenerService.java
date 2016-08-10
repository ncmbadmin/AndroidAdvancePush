package mbaas.com.nifty.advancepush;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.nifty.cloud.mb.core.NCMBGcmListenerService;
import com.nifty.cloud.mb.core.NCMBGcmReceiver;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by sci01445 on 2016/08/10.
 */
public class CustomGcmListenerService extends NCMBGcmListenerService {

    private static final String TAG = "MainActivity";
    private static final int REQUEST_SIGNUP = 0;
    private Common common;

    @Override
    public void onMessageReceived(String from, Bundle data) {
        //ペイロードデータの取得
        if (data.containsKey("com.nifty.Data")) {
            try {
                JSONObject json = new JSONObject(data.getString("com.nifty.Data"));

                if (json.has("deliveryTime") && json.has("message")) {
                    // 変換対象の日付文字列
                    String dateStr = json.getString("deliveryTime");
                    String message = json.getString("message");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    // Date型変換
                    Date formatDate = sdf.parse(dateStr);
                    long triggerlMilli = formatDate.getTime();

                    //Local notification trigger
                    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                    Intent notificationIntent = new Intent("android.media.action.DISPLAY_NOTIFICATION");
                    notificationIntent.addCategory("android.intent.category.DEFAULT");
                    notificationIntent.putExtra("message", message);

                    PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                    alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerlMilli , broadcast);
                }

            } catch (JSONException e) {
                //エラー処理
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //デフォルトの通知が必要なければコメントアウトする
        super.onMessageReceived(from, data);
    }



}
