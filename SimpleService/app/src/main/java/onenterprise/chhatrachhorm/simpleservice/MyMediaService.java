package onenterprise.chhatrachhorm.simpleservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.TokenWatcher;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by chhatra on 9/27/2017.
 *
 */

public class MyMediaService extends Service {
    protected MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        mediaPlayer = MediaPlayer.create(MyMediaService.this, R.raw.promise);
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
