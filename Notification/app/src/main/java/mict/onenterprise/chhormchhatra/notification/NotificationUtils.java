package mict.onenterprise.chhormchhatra.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;

/**
 * Created by chhatrachhorm on 9/6/2017.
 * Creating Notification Channel
 * min sdk >= 26
 */

public class NotificationUtils extends ContextWrapper {

    private NotificationManager mNotificationManager;
    public static final String ANDROID_CHANNEL_ID = "mict.onenterpise.chhatrachhorm.channel.android";
    public static final String IOS_CHANNEL_ID = "mict.onenterprise.chhatrachhorm.channel.ios";
    public static final String ANDROID_CHANNEL_NAME = "Android Channel";
    public static final String IOS_CHANNEL_NAME = "IOS Channel";
    public static final String CHANNEL_GROUP_ID = "mict.onenterprise.group.1";


    public NotificationUtils(Context base) {
        super(base);
        createChannels();

    }
    private void createChannels(){
        /*
        * ANDROID Channel
        * */
        NotificationChannel androidChannel = new NotificationChannel(
                ANDROID_CHANNEL_ID,
                ANDROID_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
                );
        androidChannel.enableLights(true);
        androidChannel.enableVibration(true);
        androidChannel.setLightColor(Color.BLUE);
        androidChannel.setVibrationPattern(new long[]{
                100, 200, 300, 0, 500, 600, 700, 800, 900
        });
        androidChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        getNotificationManager().createNotificationChannel(androidChannel);

        /*
        * IOS Channel
        * */
        NotificationChannel iosChannel = new NotificationChannel(
                IOS_CHANNEL_ID,
                IOS_CHANNEL_NAME,
                NotificationManager.IMPORTANCE_HIGH
        );
        iosChannel.enableLights(true);
        iosChannel.enableVibration(true);
        iosChannel.setLightColor(Color.DKGRAY);
        iosChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
        // to turn off badges of notification
        iosChannel.setShowBadge(false);
        getNotificationManager().createNotificationChannel(iosChannel);


        groupingChannels();
        androidChannel.setGroup(CHANNEL_GROUP_ID);
        iosChannel.setGroup(CHANNEL_GROUP_ID);
    }

    public void groupingChannels(){
        CharSequence groupName = "Channel Group Name";
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannelGroup(new NotificationChannelGroup(CHANNEL_GROUP_ID, groupName));
    }


    public NotificationManager getNotificationManager(){
        if(mNotificationManager == null)
            mNotificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        return mNotificationManager;
    }


    /*
    * To maintain compatibility, use NotificationCompat.Builder instead
    * */
    public Notification.Builder getAndroidChannelNotification(String title, String body){
        return new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true);
    }
    public Notification.Builder getIOSChannelNotification(String title, String body){
        return new Notification.Builder(getApplicationContext(), IOS_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setAutoCancel(true);
    }
}
