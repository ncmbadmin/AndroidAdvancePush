package mbaas.com.nifcloud.advancepush;

import android.app.Application;

import com.nifcloud.mbaas.core.NCMBObject;
import com.nifcloud.mbaas.core.NCMBUser;

import java.util.List;

/**
 * グローバル変数を扱うクラス. Global variables class
 */
public class Common extends Application {

    // ログイン中ユーザー情報 Login user var
    NCMBUser currentUser;
    // サーバーからローディングしたショップの情報 Shop list var
    List<NCMBObject> shops;

    /**
     * 変数を初期化する Init variables
     */
    public void init() {
        currentUser = new NCMBUser();
        shops = null;
    }
}
