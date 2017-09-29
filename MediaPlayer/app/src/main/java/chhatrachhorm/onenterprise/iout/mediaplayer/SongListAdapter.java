package chhatrachhorm.onenterprise.iout.mediaplayer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by chhatra on 9/29/2017.
 *
 */

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder>{

    List<SongModel> mSongList;
    OnEachSongClick eachSongClick;

    SongListAdapter(List<SongModel> songLists, OnEachSongClick eachSongClick){
        this.mSongList = songLists;
        this.eachSongClick = eachSongClick;
    }

    @Override
    public SongListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.individual_song_list, parent, false);
        return new SongListAdapter.ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        SongModel song = mSongList.get(position);
        holder.mTitle.setText(song.getSongTitle());
        holder.mDesc.setText(song.getSongDesc());
        holder.imageView.setImageResource(song.getImageID());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eachSongClick.onASongClick(view, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSongList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle, mDesc;
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.list_song_title);
            mDesc = itemView.findViewById(R.id.list_song_desc);
            imageView = itemView.findViewById(R.id.list_image);
        }
    }
}
