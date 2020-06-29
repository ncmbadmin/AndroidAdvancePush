name: inverse
layout: true
class: center, middle, inverse
---
# <span style="font-size: 30%">【Android編】ニフクラmobile backend レベルアップセミナー</span><br>__クーポン配信アプリ<br>を作ろう！__</span>

@ncmbadmin

.footnote[
20160817 Created (202006 Updated)
]
---
layout: false
## 事前準備
ニフクラmobile backendのアカウント登録がお済みでない方は、<br>
[ホームページ](https://mbaas.nifcloud.com/about.htm)右上にある「無料登録」ボタンをクリックして、<br>
アカウント登録を実施してください

![mBaaS検索](readme-image/mBaaS検索.png)

![mBaaS検索](readme-image/mBaaS無料登録.png)


---
## 事前準備
登録について以下のどちらかのアカウントで登録を行ってください
- SNS ID（クレジットカード払い）の登録　※無料から利用可能
  - お持ちのSNSアカウントログインで、登録することができます。対応するSNSアカウントはFacebook、Twitter、Googleです。
  - 登録は[こちら](https://console.mbaas.nifcloud.com/signup)
  - ※海外からの利用はこちらの登録方法をオススメいたします。（次のページで説明）
- ニフクラID（請求書払い）として登録　※Expertプラン以上
  - 先にニフクラIDを取得することが必要です。
  - 登録は[こちら](https://sso.nifcloud.com/auth/realms/nifcloud/protocol/openid-connect/registrations?client_id=user-registration&response_type=code&redirect_uri=%2Fcomp-registration.html&entry_code=N00000470100)

---
## 事前準備（海外からの利用案内）

- サービスの英語サイトはこちらとなっています
https://mbaas.nifcloud.com/en/
- 管理画面は「日本語・英語・中文」の言語を対応しております。
- 言語を表示する際、以下のように行ってください。
![mBaaS言語選択1](readme-image/language1.png)
![mBaaS言語選択2](readme-image/language2.png)


---
## 動作環境
* Android Studio ver3.6.1
* Android OS ver.9 (実機)

---
## 今回のハンズオンセミナーについて
### セミナーの形式

- ３回分けて機能を実施していきます。
- 講義形式で説明と演習を繰り返してアプリを作成します
- 途中で動作確認タイムと休憩タイムで全体進捗を確認します
- 質疑応答は随時行います

---
## ハンズオンの概要
### 作成するアプリについて

* クーポン配信アプリをイメージした「mBaaS Shop List」アプリの作成を通して、mBaaSの機能を理解していきます
* mBaaSの連携部分をコーディングし、アプリを完成させ、次の内容を実現していきます
 * 会員登録をするとお店情報を見ることができます
 * お店のお気に入り登録ができ、お気に入り登録をしたお店からプッシュ通知で届きます
 * 性別や都道府県限定のプッシュ通知ができます
 * お店からのプッシュ通知でクーポンを直接配信することができます
 * 決まった時間に通知を出すようにプッシュ通知を仕掛けることができます

---
## ハンズオンの概要
### 作成するアプリについて

.center[
![mBaaS_shop_List](readme-image/mBaaS_shop_List.png)
]

---
## ニフクラ mobile backendとは
### サービス紹介

* スマホアプリで汎用的に実装される機能を、クラウドサービスとして提供しているサービスです
 * 通称「mBaaS」と呼びます
* 対応機能一覧はこちらです。

.center[
![mBaaS紹介](readme-image/mBaaS紹介.png)
]

---
## 今回のハンズオンセミナーについて
### 学ぶ内容：データストア機能活用

「mBaaS Shop List」アプリの作成を通して、お店の情報、お気に入り情報を
データストア機能を利用して、データ登録、表示、管理を行います。
これらの機能は会員機能を用いて実装を行います。

---
## 今回のハンズオンセミナーについて
### 学ぶ内容：会員管理機能活用

「mBaaS Shop List」アプリの作成を通して、ユーザログイン、ログアウトの実装、
ユーザと紐づいて、お気に入り登録、表示、管理を行います。これらの機能は会員機能を用いて
実装を行います。

---
## 今回のハンズオンセミナーについて
### 学ぶ内容：ファイルストア機能活用

「mBaaS Shop List」アプリの作成を通して、お店の表示する画像、セール情報のPR画像の管理は
ファイルストアで行います。

---
## 今回のハンズオンセミナーについて
### 学ぶ内容：プッシュ通知応用①

「mBaaS Shop List」アプリの作成を通して、アクティブユーザー率を上げる<br>
効率的なプッシュ通知の組み込み方を学びます

.center[
![セグメント配信](readme-image/seminar/セグメント配信.png)
]

---
## 今回のハンズオンセミナーについて
### 学ぶ内容：プッシュ通知応用②

「mBaaS Shop List」アプリの作成を通して、アクティブユーザー率を上げる<br>
効率的なプッシュ通知の組み込み方を学びます<br>

.center[
![リッチプッシュ](readme-image/seminar/リッチプッシュ.png)
]

---
## 今回のハンズオンセミナーについて
### 学ぶ内容：プッシュ通知応用③

「mBaaS Shop List」アプリの作成を通して、アクティブユーザー率を上げる<br>
効率的なプッシュ通知の組み込み方を学びます<br><br>

.center[
![ペイロード](readme-image/seminar/ペイロード.png)
]

---
## ニフクラ mobile backendとは
### Android SDKの特徴

* SDKのインストールが必要です
 * 今回は実装済み
 * 参考：[クイックスタート](https://mbaas.nifcloud.com/doc/current/introduction/quickstart_android.html)
* SDKの初期化処理が必要です
 * MainActivity.javaの冒頭に次のコードを追記して、インストールしたSDKを読み込みます

```java
import com.nifcloud.mbaas.core.NCMB;
```

 * アプリの初期化はこちらになります。

```java
NCMB.initialize(this.getApplicationContext(),"YOUR_APPLICATION_KEY","YOUR_YOUR_CLIENT_KEY");
```

---
## ニフクラ mobile backendとは
### Android SDKの特徴

* サーバへリクエスト処理には、__同期処理__ と __非同期処理__ があります

```java

// 例）保存の場合
/* 同期処理 */

NCMBObject obj = new NCMBObject("SaveObjectTest");
obj.put("key", "value");
obj.save();

```

---
## ニフクラ mobile backendとは
### Android SDKの特徴

* サーバへリクエスト処理には、__同期処理__ と __非同期処理__ があります

```java
/* 非同期処理 */

NCMBObject obj = new NCMBObject("SaveObjectTest");
obj.put("key", "value");
obj.saveInBackground(new DoneCallback() {
    @Override
    public void done(NCMBException e) {
        if (e != null) {
            //エラー発生時の処理
        } else {
            //成功時の処理
        }
    }
});

```

---
## ニフクラ mobile backendとは
### Android SDKの特徴

* 同期処理と非同期処理
 * 同期処理はその処理が完了するまで、次の処理が実行されません
 * 非同期処理はバックグラウンドで処理を実行し、次の処理を実行します DoneCallback()にて処理後の実装を事前に指定できます


---
## ハンズオンの流れ

__<font color="#49a7e5" size="5">第１回&nbsp;</font><font size="6">「mBaaS Shop List」アプリを作ろう！</font>__

.size_large[
1. ハンズオンの準備
1. 会員管理機能の作成
1. Shop情報の設定
]

__<font color="#49a7e5" size="5">第２回&nbsp;</font><font size="6">お気に入り機能とプッシュ通知準備！</font>__

.size_large[
1. お気に入り機能の作成
1. プッシュ通知の準備
]

__<font color="#49a7e5" size="5">第３回&nbsp;</font><font size="6">プッシュ通知を送ろう！</font>__
.size_large[
1. プッシュ通知を送信：セグメント配信
1. プッシュ通知を送信：リッチプッシュ
1. プッシュ通知を送信：ペイロード
]

---
layout: true
class: center, middle, inverse_sub
---
#「mBaaS Shop List」<br>アプリを作ろう！

.size_large[
＜第1回＞
]

---
layout: true
class: center, middle, inverse
---
# 1.ハンズオンの準備

---
layout: false
## ハンズオンの準備
### プロジェクトをダウンロード

下記リンクをクリックして、ZIPファイルでダウンロードしてください▼<br>
.size_medium[
　　　 __[AndroidAdvancePush](https://github.com/NIFCLOUD-mbaas/AndroidAdvancePush/archive/handson.zip)__
]

* zipファイルを展開します。
* AndroidStudioで先ほどダウンロードしたプロジェクトを開いてください。

.center[
![mBaaS検索](readme-image/android1.png)
]

---
layout: false
## ハンズオンの準備
### プロジェクトを準備

* AndroidStudioでプロジェクトのビューを調整します。
  - 左上のビューオプション項目で[Android]を選択します。

.center[
![AndroidStudio 2](readme-image/android2.png)
]

---
layout: false
## ハンズオンの準備
### プロジェクトを準備

* AndroidStudioでプロジェクトのファイル構成を確認します。
  - 以下のように処理のファイルが入っていることをご確認ください。

.center[
![AndroidStudio 4](readme-image/android4.png)
]

---
## ハンズオンの準備
### プロジェクトにあらかじめ実施していること

* mBaaS Android SDK v.3.0.4のインストール, build.graddleの設定, AndroidManifestの設定は実装済み
* mBaaSとの連携以外の処理のコーディング
 * アプリのデザインを`layoutフォルダー内ファイル`で作成し、処理は画面ごと`Activityのファイル`にコーディングしています

---
## ハンズオンの準備
### mBaaSの準備

* [mBaaS](https://mbaas.nifcloud.com)にログインしてアプリを作成します

![mBaaSアプリ作成](readme-image/mBaaSアプリ作成.png)

---
## ハンズオンの準備
### APIキーの設定とSDKの初期化

* `MainActivity.java`を開きます
* `onCreate()`メソッド内に処理を実装します[一部実装済み]

```java
//**************** 【mBaaS/Initialization: APIキーを指定する】***************
NCMB.initialize(this.getApplicationContext(),"YOUR_APPLICATION_KEY","YOUR_CLIENT_KEY");
```

---
## ハンズオンの準備
### APIキーの設定とSDKの初期化

* 初期化処理の「`YOUR_APPLICATION_KEY`」，「`YOUR_CLIENT_KEY`」の部分をアプリ作成時に発行されたAPIキーに書き換えてください
 * APIキーは、mBaaSのダッシュボードから「アプリ設定」→「基本」にあります

.center[
![mBaaSアプリキー設定](readme-image/apikey.png)
]

---
layout: true
class: center, middle, inverse
---
# 2.会員管理機能の作成

---
layout: false
## 会員管理機能の作成
### mBaaSの設定

* 会員管理設定の「メールアドレス/パスワード認証」を許可します

.center[
![mBaaS会員設定](readme-image/mBaaS会員設定.png)
]


---
## 会員管理機能の作成

### 会員管理①：会員登録用メールを要求する[実装済み]

.center[
![SignUpViewController](readme-image/SignUpViewController.png)
]

---
## 会員管理機能の作成
### 会員管理①：会員登録用メールを要求する[実装済み]

* `SignupActivity.java`を開きます
* `doSignupByEmail()`メソッドを開きます
* 会員登録処理は以下のように実装されます

```java
//**************** 【mBaaS/User①】: 会員登録用メールを要求する】***************
String email = _signupEmail.getText().toString();
NCMBUser.requestAuthenticationMailInBackground(email, new DoneCallback() {
     @Override
     public void done(NCMBException e) {
         if (e != null) {
             // 会員登録用メールの要求失敗時の処理
         } else {
             // 会員登録用メールの要求成功時の処理
         }
     }
 });
```

---
## 会員管理機能の作成
### 会員管理①：会員登録用メールを要求する[実装済み]

* それぞれ処理を追記しています

```java
// 会員登録用メールの要求失敗時の処理
new AlertDialog.Builder(SignupActivity.this)
        .setTitle("Notification from NIFCLOUD")
        .setMessage("Send failed! Error:" + e.getMessage())
        .setPositiveButton("OK", null)
        .show();
```

```java
// 会員登録用メールの要求成功時の処理
new AlertDialog.Builder(SignupActivity.this)
        .setTitle("Notification from NIFCLOUD")
        .setMessage("メール送信完了しました! メールをご確認ください。")
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //Login画面遷移します
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivityForResult(intent, REQUEST_RESULT);
            }
        })
        .show();
```
---
## 会員管理機能の作成
### 会員管理②：メールアドレスとパスワードでログイン<br>[実装済み]

.center[
![LoginViewController](readme-image/LoginViewController.png)
]

---
## 会員管理機能の作成
### 会員管理②：メールアドレスとパスワードでログイン<br>[実装済み]

* `LoginActivity.java`を開きます
* `doLogin()`メソッドを開きます
* ログイン処理は以下のように実装されます

```java
//**************** 【mBaaS/User②】: メールアドレスとパスワードでログイン】***************
String email = _loginEmail.getText().toString();
String password = _loginPassword.getText().toString();

NCMBUser.loginWithMailAddressInBackground(email, password, new LoginCallback() {
    @Override
    public void done(NCMBUser user, NCMBException e) {
        if (e != null) {
            //ログインに失敗した場合の処理
        } else {
            //ログインに成功した場合の処理
        }
    }
});
```

---
## 会員管理機能の作成
### 会員管理②：メールアドレスとパスワードでログイン<br>[実装済み]

* それぞれ処理を追記しています

```java
//ログインに失敗した場合の処理
new AlertDialog.Builder(LoginActivity.this)
        .setTitle("Notification from NIFCLOUD")
        .setMessage("Login failed! Error:" + e.getMessage())
        .setPositiveButton("OK", null)
        .show();
```

---
## 会員管理機能の作成
### 会員管理②：メールアドレスとパスワードでログイン<br>[実装済み]

* それぞれ処理を追記しています（続き）

```java
//ログインに成功した場合の処理
common.currentUser = NCMBUser.getCurrentUser();
AlertDialog show = new AlertDialog.Builder(LoginActivity.this)
        .setTitle("Notification from NIFCLOUD")
        .setMessage("ログイン成功")
        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                String nickname = common.currentUser.getString("nickname");
                if (nickname != null && !nickname.isEmpty() && !nickname.equals("null")) {
                    //メイン画面遷移します
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivityForResult(intent, REQUEST_RESULT);
                } else {
                    //初期ログイン会員登録画面遷移します
                    Toast.makeText(LoginActivity.this, "Register user information for the first time!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivityForResult(intent, REQUEST_RESULT);
                }
            }
        })
        .show();
```

---
## 会員管理機能の作成
### 動作確認(1)ログインをしてみましょう

* ここではシュミレーターでビルドし、動作確認を行います
* ログイン画面で「会員登録」をタップします
* 会員登録画面でメールアドレスを入力し「登録メールを送信」をタップします
 * メッセージを確認してください
 * エラーが発生したらここを見てください。
 [エラーコード一覧](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)

---
## 会員管理機能の作成
### 動作確認(1)ログインをしてみましょう

.center[
![動作確認①ログイン](readme-image/動作確認①ログイン.png)
]

---
## 会員管理機能の作成
### 動作確認(1)ログインをしてみましょう

* 会員登録メールが届くので、パスワード設定します

.center[
![動作確認①パスワード登録](readme-image/動作確認①パスワード登録.png)
]

---
## 会員管理機能の作成
### 動作確認(1)ログインをしてみましょう

* 再びログイン画面に戻り「メールアドレス」と「パスワード」でログインします
 * ログを確認してください
* mBaaSのダッシュボードを確認してください
 * 会員管理にユーザーが登録されました

.center[
![動作確認①会員登録完了](readme-image/動作確認①会員登録完了.png)
]
.footnote[
[エラーコード一覧](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)
]

---
## 会員管理機能の作成
### 会員管理③：ユーザー情報更新

.center[
![UserInfoRegistration](readme-image/UserInfoRegistration.png)
]

---
## 会員管理機能の作成
### 会員管理③：ユーザー情報更新


* `RegisterActivity.java`を開きます
* `doRegister()`を開きます
* 初回のみ表示されるユーザー情報登録画面に入力した情報をmBaaSのユーザー情報に追加する処理を実装します
* コメントの下にコードを追記していきます

```java
//**************** 【mBaaS/User③: ユーザー情報更新】***************


```

* かなり下の方にあります

---
## 会員管理機能の作成
### 会員管理③：ユーザー情報更新

```java
//**************** 【mBaaS/User③: ユーザー情報更新】***************
common.currentUser.put("nickname", nickname);
common.currentUser.put("prefecture", prefecture);
common.currentUser.put("gender", selectedGender);
common.currentUser.put("favorite",list);

common.currentUser.saveInBackground(new DoneCallback() {
    @Override
    public void done(NCMBException e) {
        if (e != null) {
            // 更新失敗時の処理

        } else {
            // 更新成功時の処理

        }
    }
});

```

---
## 会員管理機能の作成
### 会員管理③：ユーザー情報更新

* それぞれ処理を追記します

```java
// 更新失敗時の処理
new AlertDialog.Builder(RegisterActivity.this)
        .setTitle("Notification from NIFCLOUD")
        .setMessage("Save failed! Error:" + e.getMessage())
        .setPositiveButton("OK", null)
        .show();
```

```java
// 更新成功時の処理
new AlertDialog.Builder(RegisterActivity.this)
       .setTitle("Notification from NIFCLOUD")
       .setMessage("保存成功しました! 入力ありがとうございます")
       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int which) {
               Intent intent = new Intent(getApplicationContext(), MainActivity.class);
               startActivityForResult(intent, REQUEST_RESULT );
           }
       })
       .show();
```

---
layout: true
class: center, middle, inverse
---
# 3.Shop情報の設定

---
layout: false
## Shop情報の設定
### mBaaSにShop情報を用意する（データストア）

* ニフクラ mobile backendのダッシュボードから「データストア」を開き、「＋作成▼」ボタンをクリックし、「インポート」をクリックします
* クラス名に「__Shop__」と入力します
* ダウンロードしたサンプルプロジェクトにあるSettingフォルダ内の「__Shop.json__」を選択してアップロードします

.center[
![ShopClass](readme-image/ShopClass.png)
]

---
## Shop情報の設定
### mBaaSにShop情報を用意する（データストア）

こんな感じでインポートされます

.center[
![mBaaS_ShopData](readme-image/mBaaS_ShopData.PNG)
]

---
## Shop情報の設定
### mBaaSにShop情報を用意する（ファイルストア）

* ニフクラ mobile backendのダッシュボードから「ファイルストア」を開き、「↑アップロード」ボタンをクリックします
* ダウンロードしたサンプルプロジェクトにあるSettingフォルダ内の「icon」「Shop」「Sale」内にあるファイルをすべてをアップロードします

.center[
![imageUpload](readme-image/imageUpload.png)
]

---
## Shop情報の設定
### mBaaSにShop情報を用意する（ファイルストア）

* こんな感じでアップロードされます

.center[
![UploadImage](readme-image/UploadImage.png)
]

---
## Shop情報の設定
### データストア：「Shop」クラスのデータを取得

* `MainActivity.java`を開きます
* `doLoadShop()`を開きます
* インポートしたShopクラスのデータを取得する処理を実装します
  - コメントの下にコードを追記していきます

```java
//**************** 【mBaaS/Shop①: 「Shop」クラスのデータを取得】***************


```

---
## Shop情報の設定
### データストア：「Shop」クラスのデータを取得

```java
//**************** 【mBaaS/Shop①: 「Shop」クラスのデータを取得】***************
// 「Shop」クラスのクエリを作成
NCMBQuery<NCMBObject> query = new NCMBQuery<>("Shop");
//データストアからデータを検索
List<NCMBObject> results = query.find();
//グローバル変数を更新する
common.shops = results;
ListView lv = (ListView) findViewById(R.id.lstShop);
lv.setAdapter(new ShopListAdapter(this, results));
```


---
## Shop情報の設定
### ファイルストア①：icon画像の取得

.center[
![icon](readme-image/icon.png)
]

---
## Shop情報の設定
### ファイルストア①：icon画像の取得

* `ShopListAdapter.java`を開きます
 * `ShopListAdapter.java`はリストの項目を作成するファイルです
* トップ画面に各ショップのアイコンをmBaaSから取得して表示する処理を実装します
- コメントの下にコードを追記していきます

```java
////**************** 【mBaaS/File①: ショップ画像を取得】***************


```

---
## Shop情報の設定
### ファイルストア①：icon画像の取得


```java
//**************** 【mBaaS/File①: ショップ画像を取得】***************
        try {
            NCMBFile file = new NCMBFile(filename);
            file.fetchInBackground(new FetchFileCallback() {
                @Override
                public void done(byte[] data, NCMBException e) {
                    if (e != null) {
                        // 取得失敗時の処理
                        Log.d(TAG, e.getMessage());
                    } else {
                        // 取得成功時の処理
                        Bitmap bmp = null;
                        if (data != null) {
                            bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                        }
                        holder.img.setImageBitmap(bmp);
                    }
                }
            });
        } catch (NCMBException e) {
            e.printStackTrace();
        }
```

---
## Shop情報の設定
### ファイルストア①：icon画像の取得

* それぞれ処理を追記します

```java
// 取得失敗時の処理
Log.d(TAG, e.getMessage());
```

```java
// 取得成功時の処理
Bitmap bmp = null;
if (data != null) {
    bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
}
holder.img.setImageBitmap(bmp);
```

---
## Shop情報の設定
### ファイルストア②：Shop画像の取得

.center[
![Shop](readme-image/Shop.png)
]

---
## Shop情報の設定
### ファイルストア②：Shop画像の取得[実装済み]

* `ShopActivity.java`を開きます
* `onCreate()`を開きます
* Shop画面に各ショップの画像をmBaaSから取得して表示する処理も同様に実装できます


```java

//**************** 【mBaaS/File②: ショップ詳細画像を取得】***************
try {
    NCMBFile file = new NCMBFile(shop_image);
    file.fetchInBackground(new FetchFileCallback() {
        @Override
        public void done(byte[] data, NCMBException e) {
            if (e != null) {
                //取得失敗時の処理
                Log.d(TAG, e.getMessage());
            } else {
                //取得成功時の処理
                Bitmap bmp = null;
                if (data != null) {
                    bmp = BitmapFactory.decodeByteArray(data, 0, data.length);
                }
                _shop_image.setImageBitmap(bmp);
            }
        }
    });
} catch (NCMBException e) {
    e.printStackTrace();
}
```

---
## Shop情報の設定
### 動作確認(2)会員情報登録とShop情報表示

* 再びシュミレーターでビルドし、動作確認を行います
* ログイン後初回のみ、ユーザー情報登録画面が表示されます
* 入力し「登録」をタップします
 * このとき、会員情報が更新されますので、mBaaSのダッシュボードを確認してみましょう
 * ログを確認してください

.center[
![動作確認②ユーザー情報追加](readme-image/動作確認②ユーザー情報追加.png)
]
.footnote[
[エラーコード一覧](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)
]

---
## Shop情報の設定
### 動作確認(2)会員情報登録とShop情報表示

* トップ画面に「icon画像」「Shop名」「カテゴリ」が表示されます
* Shopを１つ選んでタップします
 * mBaaSに登録されているimageにアクセスし、Shopページ（画像）が表示されます
* 会員ページをタップします
 * ユーザー情報が表示されます

.center[
![動作確認②](readme-image/動作確認②.png)
]
.footnote[
[エラーコード一覧](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)
]


---
layout: true
class: center, middle, inverse_sub
---
# お気に入り機能とプッシュ通知準備！

.size_large[
＜第２回＞
]

---
layout: true
class: center, middle, inverse
---
# 4.お気に入り機能の作成

---
layout: false
## お気に入り機能の作成
### お気に入り機能について

* お気に入り機能は好きなShopをお気に入りとして保存できる機能です
 * 「お気に入り」画面ではSwitchと「登録」ボタンで設定します
 * 「Shop」画面では「お気に入りを登録する」をタップすることでShop単位で設定できます

.center[
![favorite](readme-image/favorite.png)
]

---
## お気に入り機能の作成
### 会員管理④：ユーザー情報の更新[実装済み]

* `FavoriteActivity.java`を開きます
* `doFavoriteSave()`を開きます
* お気に入り画面からfavoriteデータの更新処理はユーザー情報の登録と同様にして実装できます

---
## お気に入り機能の作成
### 会員管理④：ユーザー情報の更新[実装済み]


```java
//**************** 【mBaaS/User ④: 会員情報更新】***************
List<String> list = new ArrayList<String>();
list = common.currentUser.getList("favorite");
common.currentUser.put("favorite", list);
common.currentUser.saveInBackground(new DoneCallback() {
    @Override
    public void done(NCMBException e) {
        if (e != null) {
            //保存失敗時の処理
            <<省略>>
        } else {
            //保存成功時の処理
            new AlertDialog.Builder(FavoriteActivity.this)
                    .setTitle("Notification from NIFCLOUD")
                    .setMessage("お気に入り保存成功しました!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), FavoriteActivity.class);
                            startActivityForResult(intent, REQUEST_RESULT);
                        }
                    })
                    .show();
        }
    }
});
```

---
## お気に入り機能の作成

### 会員管理⑤：ユーザー情報の更新[実装済み]

* `ShopActivity.java`を開きます
* `doFavoriteRegister()`を開きます
* Shop画面からもfavoriteデータの更新処理はユーザー情報の登録と同様にして実装できます

---
## お気に入り機能の作成

### 会員管理⑤：ユーザー情報の更新[実装済み]


```java
//**************** 【mBaaS/User⑤: 会員情報更新】***************
List<String> list = new ArrayList<String>();
list = common.currentUser.getList("favorite");
list.add(objId);
common.currentUser.put("favorite", list);
common.currentUser.saveInBackground(new DoneCallback() {
    @Override
    public void done(NCMBException e) {
        if (e != null) {
            //更新失敗時の処理
            <<省略>>
        } else {
            //更新成功時の処理
          　<<省略>>
        }
    }
});
```

---
## お気に入り機能の作成
### 動作確認(3)お気に入り情報登録・更新

* 再びシュミレーターでビルドし、動作確認を行います
* ログイン後トップ画面下の「お気に入り」をタップします
* お気に入り画面からお気に入り登録をしてみましょう
* 各Shop画面からも同様に登録してみましょう
 * ログを確認してください

.center[
![動作確認③](readme-image/動作確認③.png)
]

.footnote[
[エラーコード一覧](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)
]

---
layout: true
class: center, middle, inverse
---
# 1.プッシュ通知の準備

---
layout: false
## プッシュ通知の準備
### このあとのデバッグについて

* 以下の用意が必要です
 * デバッグ用のAndroid実機 (4.0~)
 * プッシュ通知設定ファイル(json)
* プッシュ通知設定ファイル(json)がまだの場合は下記をご参照ください
 * [【サンプル】アプリにプッシュ通知を組み込もう！](https://github.com/NIFCLOUD-mbaas/android_push_demo#手順)


---
## プッシュ通知の準備
### mBaaSの設定

* プッシュ通知の許可を行います
* プッシュ通知設定ファイル(json)を設定します

.center[
![mBaaSプッシュ通知設定](readme-image/mBaaSプッシュ通知設定.png)
]

---
## プッシュ通知の準備
### google.service.jsonファイルの作成
1. [Firebase](https://console.firebase.google.com/u/0/) にログインして、新規プロジェクトを作成します。
2. 「プロジェクトの概要」の右側にある![設定アイコン](readme-image/settingIcon.png)をクリックして、「プロジェクトを設定」を選択します。
3. 「全般」タブで下のマイアプリで「Android」プラットフォームのアイコンを選択します。

.center[
![FirebaseSetting](readme-image/Firebasesetting.png)
]

---

## プッシュ通知の準備
### google.service.jsonファイルの設定
4.google-services.jsonを発行してアプリに登録
* アプリケーション ID を [Android パッケージ名] フィールドに入力します。</br>
例) com.nifcloud.AndroidAdvancePushApp

.center[
![アプリ登録](readme-image/RegisterApp.png)
]

---
## プッシュ通知の準備
### google.service.jsonファイルの設定

5.google-services.jsonを追加する</br>
* 「Download google-services.json」 をクリックして、Firebase Android 構成ファイル（google-services.json）を取得します。
* 構成ファイルをアプリのモジュール（アプリレベル）ディレクトリに移動します。

.center[
![設定ファイルダウンロード](readme-image/DownloadFile.png)
]

---
## プッシュ通知の準備
### google.service.jsonファイルの設定

6.アプリで Firebase プロダクトを有効にするには、Gradle ファイルに google-services プラグインを追加します。

* ルートレベル（プロジェクト レベル）の Gradle ファイル（build.gradle）に、Google サービス プラグインを含めるためのルールを追加します。

```
classpath 'com.google.gms:google-services:4.3.3'
```

* モジュール（アプリレベル）の Gradle ファイル（通常は app/build.gradle）で、ファイルの末尾に以下の行を追加します。

```
apply plugin: 'com.google.gms.google-services'
```

---
## プッシュ通知の準備
### Firebaseの秘密鍵をmobile backendに設定

* Firebaseのダッシュボードの左上付近の「Project OverView」という文章があります。その横に歯車ボタンがあり、そこにカーソルを合わせると文章が出てきます。その中の「プロジェクトの設定」をクリックします。

* クリックするとFirebaseのプロジェクトの設定画面が出てきます。その設定画面の上のメニューの中から「サービスアカウント」をクリックします。
---
## プッシュ通知の準備
### Firebaseの秘密鍵をmobile backendに設定

* クリックすると以下のような画面が出てきます。この画面の中の「新しい秘密鍵の生成」をクリックして、出てくるモーダルの中の「キーを生成」をクリックします。
* そうするとFirebaseの秘密鍵がダウンロードできます。

.center[
![projectnumber](readme-image/projectnumber.png)
]

---
## プッシュ通知の準備
### プッシュ通知①：端末を登録

* 端末を登録処理はSDK初期化時に行われますので、追加実装不要


---
layout: true
class: center, middle, inverse_sub
---
# プッシュ通知を送ろう！

.size_large[
＜第３回＞
]

---
layout: true
class: center, middle, inverse
---
# 2.プッシュ通知を送信<br>セグメント配信

---
layout: false
## プッシュ通知を送信：セグメント配信
### プッシュ通知②：installationにユーザー情報を紐づける

* `RegisterActivity.java`を開きます
* 「【mBaaS/User③: ユーザー情報更新】」の更新成功時の処理内にセグメント配信のために必要なユーザー情報をinstallationに紐付けるための処理を実装します


```java
//**************** 【mBaaS：プッシュ通知②】installationにユーザー情報を紐づける ***************

```

---
## プッシュ通知を送信：セグメント配信
### プッシュ通知②：installationにユーザー情報を紐づける

* 次のように追記します

```java
//**************** 【mBaaS：プッシュ通知②】installationにユーザー情報を紐づける ***************
NCMBInstallation currInstallation  = NCMBInstallation.getCurrentInstallation();
currInstallation.put("prefecture", prefecture);
currInstallation.put("gender", selectedGender);
currInstallation.put("favorite", list);
currInstallation.saveInBackground(new DoneCallback() {
    @Override
    public void done(NCMBException e) {
        if (e != null) {
            //更新失敗時の処理
        } else {
            //更新成功時の処理
        }
    }
});
```

---
## プッシュ通知を送信：セグメント配信
### プッシュ通知②：installationにユーザー情報を紐づける

* それぞれ処理を追記します

```java
//更新失敗時の処理
Log.d(TAG, "端末情報を保存失敗しました。");
```

```java
//更新成功時の処理
Log.d(TAG, "端末情報を保存成功しました。");
Intent intent = new Intent(getApplicationContext(), MainActivity.class);
startActivityForResult(intent, REQUEST_RESULT );
```

---
## プッシュ通知を送信：セグメント配信
### プッシュ通知③：installationにユーザー情報を紐づける<br>[実装済み]

* `FavoriteActivity.java`開きます
* `doFavoriteSave()`を開きます
* 同様に、お気に入り画面でお気に入り情報が更新されるたびに、installation情報が書き換えられます

```java
//**************** 【mBaaS：プッシュ通知④】installationにユーザー情報を紐づける***************
//端末情報を保存する
NCMBInstallation currInstallation = NCMBInstallation.getCurrentInstallation();
currInstallation.put("favorite", list);
currInstallation.saveInBackground(new DoneCallback() {
    @Override
    public void done(NCMBException e) {
        if (e != null) {
            //保存失敗
            Log.d(TAG, "端末情報を保存失敗しました。");
        } else {
            //保存成功
            Log.d(TAG, "端末情報を保存成功しました。");
        }
    }
});
```

---
## プッシュ通知を送信：セグメント配信
### プッシュ通知④：installationにユーザー情報を紐づける<br>[実装済み]

* `ShopActivity.java`開きます
* `doFavoriteRegister()`開きます
* 同様に、Shop画面でもお気に入り情報が更新されるたびに、installation情報が書き換えられます

```java
//****************【mBaaS：プッシュ通知⑤】installationにユーザー情報を紐づける***************
NCMBInstallation currInstallation  = NCMBInstallation.getCurrentInstallation();
currInstallation.put("favorite", list);
currInstallation.saveInBackground(new DoneCallback() {
    @Override
    public void done(NCMBException e) {
        if (e != null) {
            //保存失敗した場合の処理
            Log.d(TAG, "端末情報を保存失敗しました。");
        } else {
            //保存成功した場合の処理
            Log.d(TAG, "端末情報を保存成功しました。");
        }
    }
});
```
---
## プッシュ通知を送信：セグメント配信
### 動作確認の準備

* もう一度会員情報登録画面を表示するため、mBaaSの会員管理画面で「クラスの編集」をクリックします
* 「nickname」にチェックを入れて上の「削除」ボタンで削除します

.center[
![動作確認④セグメント0](readme-image/動作確認④セグメント0.png)
]

---
## プッシュ通知を送信：セグメント配信
### 動作確認の準備

* 実機でアプリをビルドします
* アプリを起動します

```text
端末情報を保存成功しました。
```

* デバイストークンの取得に成功したら、mBaaSダッシュボードで確認します

.center[
![動作確認④デバイストークン](readme-image/動作確認④デバイストークン.png)
]

.footnote[
[エラーコード一覧](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)
]

---
## プッシュ通知を送信：セグメント配信
### 動作確認の準備

* ログインをし、再びユーザー登録をします
 * このとき、installationが更新されますのでダッシュボードを確認します
 * ログを確認してください

.center[
![動作確認④installation追加](readme-image/動作確認④installation追加.png)
]
.footnote[
[エラーコード一覧](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)
]

---
## プッシュ通知を送信：セグメント配信
### 動作確認(4)セグメント配信

__shopB__ をお気に入り登録しているユーザーに絞り込んでプッシュ通知を配信してみましょう！

* あらかじめshopBをお気に入りに設定しておきます(アプリ側)
* mBaaSのダッシュボードからShopクラスのデータを開き、shopBの「objectId」をコピーします

.center[
![動作確認④セグメント2](readme-image/動作確認④セグメント2.png)
]

---
## プッシュ通知を送信：セグメント配信
### 動作確認(4)セグメント配信

* プッシュ通知を作成します
* メッセージを入力します
 * 例：ShopBセール開催中！
* 「Android端末に配信する」にチェックを入れます
* 「配信端末」を設定します

.center[
![動作確認④セグメント1](readme-image/動作確認④セグメント1.png)
]

---
## プッシュ通知を送信：セグメント配信
### 動作確認(4)セグメント配信

* 「installationクラスからの絞込み」を選択します
* 絞り込み設定をします
 * ここでコピーしたShopBのobjectIdを貼り付けます

.center[
![動作確認④セグメント3](readme-image/動作確認④セグメント3.png)
]

---
## プッシュ通知を送信：セグメント配信
### 動作確認(4)セグメント配信

* 「１端末に向けて送信されます」と表示されればOKです
* 「プッシュ通知を作成する」をクリックします
* 少し待つと配信されます→端末を確認！

.center[
![動作確認④セグメント4](readme-image/動作確認④セグメント4.png)
]

---
## プッシュ通知を送信：セグメント配信
### 動作確認(4)セグメント配信[おまけ]

.size_large[
いろいろなパターンで送ってみましょう！
* 別のショップを絞り込み
* 性別で絞込み
* ShopAをお気に入り登録かつ女性で絞込み
* ShopDをお気に入り登録かつ東京都で絞込み
* and more...
]

---
layout: true
class: center, middle, inverse
---
# 2.プッシュ通知を送信<br>リッチプッシュ

---
layout: false

## プッシュ通知を送信：リッチプッシュ
### リッチプッシュについて

* プッシュ通知登録時にURLを指定することで、開封時にWebビューを表示できる機能です
* プッシュ通知開封でアプリが起動するときに表示されます
 * アプリ起動中には表示されませんので動作確認にはアプリを閉じておく必要があります（仕様）

---
## プッシュ通知を送信：リッチプッシュ
### リッチプッシュについて

* 今回はShopのセール画像を「公開ファイル」機能を利用して配信します

.center[
![sale_image](readme-image/sale_image.png)
]


---
## プッシュ通知を送信：リッチプッシュ
### 公開ファイルとは

* 「公開ファイル」機能とは、ファイルストアに保存した画像をリンクでアクセスできるようにする機能です
* ファイルストアに登録した画像を「公開ファイル」として公開することが可能です

---
## プッシュ通知を送信：リッチプッシュ
### 公開ファイル設定

* mBaaSのダッシュボードで、公開ファイル設定「HTTPでの取得」を有効にします

.center[
![mBaaS公開ファイル設定](readme-image/mBaaS公開ファイル設定.png)
]

---
## プッシュ通知を送信：リッチプッシュ
### 公開ファイルURL確認方法

* ファイルストアで確認できます
* 今回は「ShopD_sale.png」の公開ファイルURLを使用してみます
 * URLをコピーします

.center[
![公開ファイルURL](readme-image/公開ファイルURL.png)
]

---
## プッシュ通知を送信：リッチプッシュ
### 公開ファイルURL確認方法

* ブラウザでリンクをたたいて表示されることを確認してください

.center[
![公開ファイル確認](readme-image/公開ファイル確認.png)
]

---
## プッシュ通知を送信：リッチプッシュ
### プッシュ通知⑥：リッチプッシュ通知を表示させる処理

* `MainActivity.java`を開きます
* `onResume()`を開きます
* 以下のコメントの直下にコードを追加します

```java
//**************** 【mBaaS：プッシュ通知⑥】リッチプッシュ通知を表示させる処理 ***************
```

* 次のように追記します

```java
//**************** 【mBaaS：プッシュ通知⑥】リッチプッシュ通知を表示させる処理 ***************
//リッチプッシュ通知の表示
NCMBPush.richPushHandler(this, getIntent());

//リッチプッシュを再表示させたくない場合はintentからURLを削除します
getIntent().removeExtra("com.nifcloud.mbaas.RichUrl");
```

---
## プッシュ通知を送信：リッチプッシュ
### 動作確認(5)リッチプッシュ

* 実機でアプリをビルドします
* 起動した後にホームに戻ります


---
## プッシュ通知を送信：リッチプッシュ
### 動作確認(5)リッチプッシュ

* プッシュ通知を作成します
* メッセージを入力します
* URL欄にコピーした公開ファイルURLを貼り付けます
* そのまま送信してみましょう

.center[
![動作確認⑤リッチプッシュ](readme-image/動作確認⑤リッチプッシュ.png)
]

---
## プッシュ通知を送信：リッチプッシュ
### 動作確認(5)リッチプッシュ

* しばらくするとプッシュ通知が届きます
* プッシュ通知を開くとWebView画面が現れ、公開ファイルが表示されます

.center[
![動作確認⑤リッチプッシュ2](readme-image/動作確認⑤リッチプッシュ2.png)
]

---
layout: true
class: center, middle, inverse
---
# 2.プッシュ通知を送信<br>ペイロード

---
layout: false
## プッシュ通知を送信：ペイロード
### ペイロードについて

* プッシュ通知にはJSON形式で任意のデータを含めることができ、通知を受信した時に、そのデータを受け取って処理を行うことができる機能です
* 今回は、配信時間とメッセージのデータを設定し、時限式でローカルプッシュを表示させる内容を実装します
 * プッシュ通知に設定するJSON形式のデータの例
 ```text
 {"deliveryTime":"2016-09-22 17:00:00", "message":"タイムセールスタート！"}
 ```

---
## プッシュ通知を送信：ペイロード
### プッシュ通知⑦：アプリが起動中にプッシュ通知からデータを取得する

* Androidの場合、受信する処理をカスタマイズするために、カスタムサービスを作成する必要があります
* 今回、コード内にMyCustomFirebaseMessagingServiceは作成済み
  - 作成に関して、実装方法はこちらのドキュメントをご参考ください。
  - [プッシュ通知でJSONデータを取得する](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)

---
## プッシュ通知を送信：ペイロード
### プッシュ通知⑦：アプリがプッシュ通知からデータを取得する

* `MyCustomFirebaseMessagingService.java`を開きます
* `onMessageReceived()`メソッド外に次のメソッドを実装します

```java
//**************** 【mBaaS：プッシュ通知⑦】アプリがプッシュ通知からデータを取得する***************
```

---
## プッシュ通知を送信：ペイロード
### プッシュ通知⑦：アプリがプッシュ通知からデータを取得する

以下のように追記します

```java
//**************** 【mBaaS：プッシュ通知⑦】アプリが起動中にプッシュ通知からデータを取得する***************
//ペイロードデータの取得
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

            }
        } catch (JSONException e) {
            //エラー処理
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
```

---
## プッシュ通知を送信：ペイロード
### プッシュ通知⑦：アプリがプッシュ通知からデータを取得する

* ペイロード処理実装します
* 指定した時間でローカルプッシュ通知を表示させます。

```java
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
alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerlMilli , broadcast);
```


---
## プッシュ通知を送信：ペイロード
### 動作確認(6)ペイロード（アプリ起動時）

* 実機でアプリをビルドします
* 起動し、下記ログを確認します

```text
端末情報を保存成功しました。
```

* そのままアプリを起動した状態にします

---
## プッシュ通知を送信：ペイロード
### 動作確認(6)ペイロード（アプリ起動時）

* プッシュ通知に設定するJSON形式のデータを作成します
 * JSONデータに設定する時間は、今から __５分以上未来の時間__ に変更してください
 * JSONデータに設定するメッセージは、自由に変更してください
 ```text
 {"deliveryTime":"2016-09-29 17:00:00", "message":"タイムセールスタート！"}
 ```
 * 作成したらコピーをしておいてください

---
## プッシュ通知を送信：ペイロード
### 動作確認(6)ペイロード（アプリ起動時）

* プッシュ通知を作成します
 * タイトル、メッセージを入力が無い場合、サイレントプッシュとして送られます
 * 「JSON」に作成したJSONデータを貼り付けます

.center[
![動作確認⑥ペイロード1](readme-image/動作確認⑥ペイロード1.png)
]

---
## プッシュ通知を送信：ペイロード
### 動作確認(6)ペイロード（アプリ起動時）

* プッシュ通知を送信します
* プッシュ通知を受信（サイレント）すると次のログが表示されます

```text
ペイロードを取得しました！
```

* 指定時間にプッシュ通知が表示されることを確認してください

.footnote[
[エラーコード一覧](https://mbaas.nifcloud.com/doc/current/rest/common/error.html#REST%20APIのエラーコードについて)
]
---
## プッシュ通知を送信：ペイロード
### 動作確認(6)ペイロード（非起動時）

* アプリを閉じます
* 再びプッシュ通知を作成します

.center[
![動作確認⑥ペイロード2](readme-image/動作確認⑥ペイロード2.png)
]

---
## プッシュ通知を送信：ペイロード
### 動作確認(6)ペイロード（非起動時）

* アプリが起動していないので、サイレントプッシュでは気付いてもらえません
* アプリを起動してもらう内容でプッシュ通知を作成します
 * メッセージ　例）`明日PM5時よりタイムセールを行います！`
* JSON形式のデータを貼り付けます
 * JSONデータ作成　例）明日午後5時を設定
 ```text
 {"deliveryTime":"2016-09-30 17:00:00", "message":"タイムセールスタート！"}
 ```
 * 時間は今から５分以上未来の時間に変更してください

---
## プッシュ通知を送信：ペイロード
### 動作確認(6)ペイロード（非起動時）

* プッシュ通知を受信したら、プッシュ通知からアプリを起動します
* 起動時にデータを取得します
 * １度起動してあればアプリは閉じてもOKです
* 指定時間にプッシュ通知が表示されることを確認してください

---
layout: true
class: center, middle, inverse_sub
---
# まとめ

---
layout: false
## まとめ
### 学んだこと

* mBaaSの各機能を使用してアプリ作成方法を学んだ！
 * 会員管理機能
 * データストア
 * ファイルストア
 * プッシュ通知
* プッシュ通知の活用方法がわかった！
 * セグメント配信
 * リッチプッシュ
 * ペイロード

---
## 参考

* 開催中の[セミナー](https://ncmb.connpass.com/)のご案内
 * 随時新しいセミナーを実施していきますのでぜひチェックしてください！
* ハンズオン内容が実装された完全版プロジェクト
 * __[AndroidAdvancePush【完成版】](https://github.com/NIFCLOUD-mbaas/AndroidAdvancePush/archive/master.zip)__
* コードは[GitHub](https://github.com/NIFCLOUD-mbaas/AndroidAdvancePush)に公開しています
 * __master__：完成版
 * __handson__：セミナー版
