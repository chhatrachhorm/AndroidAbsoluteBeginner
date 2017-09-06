package mict.onenterprise.chhormchhatra.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Creating notification channel
         * */
        NotificationManager mNotificationManager =
                (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String channelID = getString(R.string.notify_channel_id_1);
        CharSequence channelName = getString(R.string.channel_id_1_name);
        String channelDesc = getString(R.string.channel_id_1_desc);
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel mChannel_001 = new NotificationChannel(channelID, channelName, importance);

    }
}
