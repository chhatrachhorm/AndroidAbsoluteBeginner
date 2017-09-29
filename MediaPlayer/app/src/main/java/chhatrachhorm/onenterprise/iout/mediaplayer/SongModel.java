package chhatrachhorm.onenterprise.iout.mediaplayer;

/**
 * Created by chhatra on 9/29/2017.
 *
 */

public class SongModel {

    public String songTitle;
    public String songDesc;
    public Integer imageID;
    public String songData;
    public String songAlbum;
    public String songArtist;

    public SongModel(){}
    public SongModel(String songData, String songTitle, String songAlbum, String songArtist) {
        this.songTitle = songTitle;
        this.songDesc = "Unknown";
        this.imageID = R.drawable.musics_icon;
        this.songData = songData;
        this.songAlbum = songAlbum;
        this.songArtist = songArtist;
    }
    public SongModel(String songTitle, String songDesc, String songData) {
        this.songTitle = songTitle;
        this.songDesc = songDesc;
        this.imageID = R.drawable.musics_icon;
        this.songArtist = "Unknown";
        this.songData = songData;
    }


    public String getSongData() {
        return songData;
    }
    public String getSongTitle() {
        return songTitle;
    }
    public String getSongDesc() {
        return songDesc;
    }
    public Integer getImageID() {
        return imageID;
    }
    public String getSongArtist() {
        return songArtist;
    }
    public String getSongAlbum() {
        return songAlbum;
    }


    public void setSongData(String songData) {
        this.songData = songData;
    }
    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }
    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }
    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }
    public void setSongDesc(String songDesc) {
        this.songDesc = songDesc;
    }
    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }
}
