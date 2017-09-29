package chhatrachhorm.onenterprise.iout.mediaplayer;


import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment implements OnEachSongClick{


    private static int currentMusic = 0;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;
    private List<SongModel> mSongList = new ArrayList<>();
    private FrameLayout mFrame;
    private SongListListener songListListener;

    public SongsFragment() {
        // Required empty public constructor
    }

    public void displaySongList(boolean isVisible){
        if(isVisible)
            mFrame.setVisibility(View.VISIBLE);
        else mFrame.setVisibility(View.GONE);
    }
    public SongModel getCurrentSong(){
        return mSongList.get(currentMusic);
    }
    public int getCurrentMusicNumber(){return currentMusic;}
    public int getTotalMusic(){return mSongList.size();}
    public SongModel getSongById(int i){return mSongList.get(i);}
    public void updateCurrentSong(int newSong){currentMusic = newSong;}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_songs, container, false);

        songListListener = (SongListListener) getActivity();

        mRecyclerView = mView.findViewById(R.id.frag_song_list);
        mFrame = mView.findViewById(R.id.frag_song_list_layout);
        displaySongList(false);

        mView.findViewById(R.id.frag_song_list_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displaySongList(false);
            }
        });

        mSongList = RetrievingSongs.getSongData(getActivity().getApplicationContext());

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new SongListAdapter(mSongList, this);
        mRecyclerView.setAdapter(mAdapter);

        return mView;
    }
    @Override
    public void onASongClick(View view, int position) {
        currentMusic = position;
        songListListener.onSongItemClick(mSongList.get(position));
    }
}
