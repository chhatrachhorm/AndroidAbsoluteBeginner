package chhatrachhorm.onenterprise.iout.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by chhatra on 9/29/2017.
 *
 */

public class MediaPlayerService extends Service implements
        MediaPlayer.OnCompletionListener,
        MediaPlayer.OnPreparedListener,
        MediaPlayer.OnErrorListener
{

    private final IBinder iBinder = new LocalBinder();
    private MediaPlayer mediaPlayer;
    private String mediaData;
    private static int resumePosition;

    public boolean getMediaPlayerState(){
        return (mediaPlayer != null) && mediaPlayer.isPlaying();
    }

    private void initMediaPlayer(){
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.reset();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(mediaData);
        } catch (IOException e){
            e.printStackTrace();
            stopSelf();
        }
        mediaPlayer.prepareAsync();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            mediaData = intent.getExtras().getString("mediaData");
        } catch (NullPointerException e){
            stopSelf();
        }
        if(mediaData != null && !mediaData.isEmpty())
            initMediaPlayer();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaData != null){
            mediaPlayer.release();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        stopMedia();
        stopSelf();
    }

    @Override
    public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
        Toast.makeText(getApplicationContext(), "Error Code: " + i, Toast.LENGTH_LONG).show();
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        playMedia();
    }

    public class LocalBinder extends Binder{
        public MediaPlayerService getService(){return MediaPlayerService.this;}
    }

    // Media Controller
    protected void playMedia(){
        if(!mediaPlayer.isPlaying())
            mediaPlayer.start();
    }
    protected void playMedia(String data){
        if(mediaPlayer.isPlaying()){
           stopMedia();
        }
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(data);
        } catch (IOException e) {
            e.printStackTrace();
            stopSelf();
        }
        mediaPlayer.prepareAsync();
    }
    protected void stopMedia(){
        if(mediaPlayer==null)return;
        if(mediaPlayer.isPlaying())mediaPlayer.stop();
    }
    protected void pauseMedia(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            resumePosition = mediaPlayer.getCurrentPosition();
        }
    }
    protected void resumeMedia(){
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.seekTo(resumePosition);
            mediaPlayer.start();
        }
    }
}
