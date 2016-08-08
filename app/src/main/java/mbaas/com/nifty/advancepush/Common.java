package mbaas.com.nifty.advancepush;

/**
 * Created by sci01445 on 2016/08/03.
 */
import android.app.Application;

import com.nifty.cloud.mb.core.NCMBObject;
import com.nifty.cloud.mb.core.NCMBUser;

import java.util.List;

/**
 * グローバル変数を扱うクラス
 * Created by XXXXX on 20XX/XX/XX.
 */
public class Common extends Application{
    // グローバルに扱う変数
    NCMBUser currentUser;
    // List of shops that is loaded
    List<NCMBObject> shops;

    /**
     * 変数を初期化する
     */
    public void init(){
        currentUser = null;
        shops = null;
    }
}
