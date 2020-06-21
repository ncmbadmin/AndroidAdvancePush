package mbaas.com.nifcloud.advancepush;

import com.google.firebase.messaging.RemoteMessage;
import com.nifcloud.mbaas.core.NCMBFirebaseMessagingService;

public class MyCustomFirebaseMessagingService extends NCMBFirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    private static final int REQUEST_RESULT = 0;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //**************** 【mBaaS：プッシュ通知⑦】プッシュ通知からデータを取得する***************

        //デフォルトの通知
        super.onMessageReceived(remoteMessage);
    }



}
