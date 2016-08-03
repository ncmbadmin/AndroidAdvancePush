package mbaas.com.nifty.advancepush;

/**
 * Created by sci01445 on 2016/08/03.
 */
import android.app.Application;

import com.nifty.cloud.mb.core.NCMBUser;

/**
 * グローバル変数を扱うクラス
 * Created by XXXXX on 20XX/XX/XX.
 */
public class Common extends Application{
    // グローバルに扱う変数
    NCMBUser currentUser;

    /**
     * 変数を初期化する
     */
    public void init(){
        currentUser = null;
    }
}
