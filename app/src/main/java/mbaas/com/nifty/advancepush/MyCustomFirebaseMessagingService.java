package mbaas.com.nifty.advancepush;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.messaging.RemoteMessage;
import com.nifcloud.mbaas.core.NCMBFirebaseMessagingService;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MyCustomFirebaseMessagingService extends NCMBFirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    private static final int REQUEST_RESULT = 0;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //**************** 【mBaaS：プッシュ通知⑦】プッシュ通知からデータを取得する***************
        if (remoteMessage != null && remoteMessage.getData() != null) {
            //ペイロードデータの取得
            Bundle data = new Bundle();
            Map<String, String> d = remoteMessage.getData();
            for (String key : d.keySet()) {
                data.putString(key, d.get(key));
            }

            if (data.containsKey("com.nifcloud.mbaas.Data")) {
                try {
                    JSONObject json = new JSONObject(data.getString("com.nifcloud.mbaas.Data"));

                    if (json.has("deliveryTime") && json.has("message")) {
                        Log.d(TAG, "ペイロードを取得しました！");
                        //ペイロード処理実装
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
                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerlMilli, broadcast);
                    }

                } catch (JSONException e) {
                    //エラー処理
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        //デフォルトの通知
//        super.onMessageReceived(remoteMessage);
    }



}
