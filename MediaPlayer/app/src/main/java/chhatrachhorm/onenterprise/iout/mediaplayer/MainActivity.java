package chhatrachhorm.onenterprise.iout.mediaplayer;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity
        implements PlayerListener, SongListListener{

    private MainFragment mainFragment;
    private SongsFragment songsFragment;
    private SongModel mSong;
    private static boolean resumeSate = false;
    private static int totalSong;

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
        totalSong = songsFragment.getTotalMusic();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(serviceBound) unbindService(serviceConnection);
    }

    @Override
    public void onPlayBtnClick() {
        if(!serviceBound){
            startPlayingSong(songsFragment.getCurrentSong().getSongData());
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
    public void onNextBtnClick() {
        int current = songsFragment.getCurrentMusicNumber();
        playNextPrevSong((current < totalSong -1) ? current+1 : current);
    }

    @Override
    public void onPrevBtnClick() {
        int current = songsFragment.getCurrentMusicNumber();
        playNextPrevSong((current > 0) ? current-1 : 0);
    }


    @Override
    public void onSongItemClick(SongModel song) {
        if(!serviceBound){
            startPlayingSong(song.getSongData());
        }else{
            playerService.playMedia(song.getSongData());
        }
        mainFragment.setPlayPauseBtn(true);
    }

    private void startPlayingSong(String songData){
        Intent player = new Intent(MainActivity.this, MediaPlayerService.class);
        player.putExtra("mediaData", songData);
        startService(player);
        bindService(player, serviceConnection, Context.BIND_AUTO_CREATE);
    }
    private void playNextPrevSong(int newSong){
        if(!serviceBound){
            startPlayingSong(songsFragment.getSongById(newSong).getSongData());
        }else{
            playerService.playMedia(songsFragment.getSongById(newSong).getSongData());
        }
        mainFragment.setPlayPauseBtn(true);
        songsFragment.updateCurrentSong(newSong);
    }
}
