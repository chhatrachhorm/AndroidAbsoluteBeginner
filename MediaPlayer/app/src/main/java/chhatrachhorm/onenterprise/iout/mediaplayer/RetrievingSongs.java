package chhatrachhorm.onenterprise.iout.mediaplayer;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chhatra on 9/29/2017.
 *
 */

public class RetrievingSongs {
    public static List<SongModel> getSongData(Context ctx){
        List<SongModel> mSongList = new ArrayList<>();
        ContentResolver contentResolver = ctx.getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + "!= 0";
        String sortOrder = MediaStore.Audio.Media.TITLE + " ASC";
        Cursor cursor = contentResolver.query(
                uri, null,
                selection, null,
                sortOrder
        );
        if(cursor != null && cursor.getCount() > 0){
            while (cursor.moveToNext()){
                String data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
                String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                String album = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM));
                String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
                mSongList.add(new SongModel(data, title, album, artist));
            }
        }
        if(cursor != null)
            cursor.close();
        return mSongList;
    }
}
