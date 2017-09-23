package mict.onenterprise.chhormchhatra.notification;

import android.app.Notification;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Reference : https://code.tutsplus.com/tutorials/android-o-how-to-use-notification-channels--cms-28616
 * Reference : https://developer.android.com/guide/topics/ui/notifiers/notifications.html
 *
 * 1. Create NotificationUtils Class that extends from ContextWrapper
 *      a. create Channel ID, Channel Name and Specify other default setting
 *      b. create Channel Group if necessary
 *      c. create a method to return each channel as the Notification.Builder class
 *      d. create notification manager method
 * 2. In main activity
 *      a. instantiate NotificationUtils
 *      b. make notification by calling to method that return channel as the Notification.Builder Class
 *          Notification.Builder nb = mNotificationsUtils
 *                              .getAndroidChannelNotification(title, "By "+author);
 *      c. To make notification, use notify(id, nb.build())
 *          e.g mNotificationsUtils.getNotificationManager().notify(101, nb.build());
 *      d. To navigate user to the setting
 *          * Make an intent like this
 *              Intent s = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
 *              s.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
 *              startActivity(s);
 *          * To navigate users to a specific channel setting
 *          ADD : s.putExtra(Settings.EXTRA_CHANNEL_ID, NotificationUtils.IOS_CHANNEL_ID);
 * */


public class NormalActivity extends AppCompatActivity {

    private NotificationUtils mNotificationsUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        /*
         * Posting Notification to the Android Channel
         * */
        mNotificationsUtils = new NotificationUtils(this);
        final EditText editTextTitleAndroid = findViewById(R.id.et_android_title);
        final EditText editTextAuthorAndroid = findViewById(R.id.et_android_author);
        Button buttonAndroid = findViewById(R.id.btn_send_android);

        buttonAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitleAndroid.getEditableText().toString();
                String author = editTextAuthorAndroid.getEditableText().toString();
                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(author)){
                    Notification.Builder nb = mNotificationsUtils
                            .getAndroidChannelNotification(title, "By "+author);
                    mNotificationsUtils.getNotificationManager().notify(101, nb.build());
                }
            }
        });

        /*
        * Posting Notification to the IOS Channel
        * */
        final EditText editTextTitleIOS = findViewById(R.id.et_ios_title);
        final EditText editTextAuthorIOS = findViewById(R.id.et_ios_author);
        Button buttonIOS = findViewById(R.id.btn_send_ios);
        buttonIOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitleIOS.getEditableText().toString();
                String author = editTextAuthorIOS.getEditableText().toString();
                if(!title.isEmpty() && !author.isEmpty()){
                    Notification.Builder nb = mNotificationsUtils
                            .getIOSChannelNotification(title, "By " + author);
                    mNotificationsUtils.getNotificationManager().notify(102, nb.build());
                }
                /*
                * To maintain compatibility, use NotificationCompat.Builder instead
                * */
            }
        });

        /*
        * Notification Setting
        * */
        Button buttonAndroidNotfiSettings = findViewById(R.id.btn_android_notif_settings);
        buttonAndroidNotfiSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aSetting = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                aSetting.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                aSetting.putExtra(Settings.EXTRA_CHANNEL_ID, NotificationUtils.ANDROID_CHANNEL_ID);
                startActivity(aSetting);
            }
        });

        Button buttonIOSNotfiSettings = findViewById(R.id.btn_ios_notif_settings);
        buttonIOSNotfiSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iSetting = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
                iSetting.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                iSetting.putExtra(Settings.EXTRA_CHANNEL_ID, NotificationUtils.IOS_CHANNEL_ID);
                startActivity(iSetting);
            }
        });
        // to navigate users to general setting of your app
        Button settingBtn = findViewById(R.id.btn__notif_settings);
        settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
                s.putExtra(Settings.EXTRA_APP_PACKAGE, getPackageName());
                startActivity(s);
            }
        });

    }
}
