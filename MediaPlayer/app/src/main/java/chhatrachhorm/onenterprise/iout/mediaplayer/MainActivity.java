package chhatrachhorm.onenterprise.iout.mediaplayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements PlayerListener, SongListListener{

    private MainFragment mainFragment;
    private SongsFragment songsFragment;
    private SongModel mSong;
    private boolean resumeSate = false;

    private MediaPlayerService playerService;
    private boolean serviceBound = false;

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MediaPlayerService.LocalBinder binder = (MediaPlayerService.LocalBinder) iBinder;
            playerService = binder.getService();
            serviceBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            serviceBound = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager manager = getSupportFragmentManager();
        mainFragment = (MainFragment) manager.findFragmentById(R.id.main_main_frag);
        songsFragment = (SongsFragment) manager.findFragmentById(R.id.main_song_list_frag);

    }

    @Override
    public void onPlayBtnClick() {
        if(!serviceBound){
            Intent player = new Intent(MainActivity.this, MediaPlayerService.class);
            player.putExtra("mediaData", songsFragment.getCurrentSong().getSongData());
            startService(player);
            bindService(player, serviceConnection, Context.BIND_AUTO_CREATE);
            Toast.makeText(this, songsFragment.getCurrentSong().getSongData(), Toast.LENGTH_LONG).show();
        }else {
            if(!resumeSate)
                playerService.playMedia();
            else{
                playerService.resumeMedia();
                resumeSate = false;
            }
        }
    }

    @Override
    public void onStopBtnClick() {

    }

    @Override
    public void onPauseBtnClick() {
        playerService.pauseMedia();
        resumeSate = true;
    }

    @Override
    public void onSongListBtnClick() {
        songsFragment.displaySongList(true);
    }


    @Override
    public void onSongItemClick(SongModel song) {
        playerService.playMedia(song.getSongData());
    }

    @Override
    public void onSongItemLongClick() {

    }
}
