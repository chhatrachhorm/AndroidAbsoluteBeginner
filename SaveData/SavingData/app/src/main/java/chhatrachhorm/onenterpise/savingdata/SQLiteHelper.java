package chhatrachhorm.onenterpise.savingdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by chhormchhatra on 8/30/17.
 *
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "sqlite_local";
    private static final String TABLE_NAME = "users";
    private static final String COL_1 = "id";
    private static final String COL_2 = "username";
    public static final String COL_3 = "email";



    SQLiteHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                        COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COL_2 + " VARCHAR(100) NOT NULL, "+
                        COL_3 + " VARCHAR(100) NOT NULL);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    boolean insertDat(String username, String email){
        // instantiate SQLiteDatabase and pass the instance of this class to get to write data
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        // content value is just like Map
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, username);
        contentValues.put(COL_3, email);

        Long newRowId = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        // return (newRowId != -1)?true:false;
        // if success newRowId will be returned else -1 will be return
        return newRowId != -1;
    }

    Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
    }

    Cursor getDataByEmail(String email){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        // cols to return
        String[] projection = { COL_2, COL_3 };
        // where clause - always contain ? operator, = ?, > ?, < ? and etc
        String selection = COL_3 + " Like ?";
        // value for where clause
        String e = "%"+email+"%";
        String[] selectArg = {e};
        // sorting
        String sortOder = COL_3 + " DESC";
        return sqLiteDatabase.query(
                TABLE_NAME,
                projection,
                selection,
                selectArg,
                null,
                null,
                sortOder
        );

    }

//    Delete Data
//    boolean deleteData(){
//        // Define 'where' part of query.
//        String selection = COL_1 + " LIKE ?";
//        // Specify arguments in placeholder order.
//        String[] selectionArgs = { "MyTitle" };
//        // Issue SQL statement.
//        db.delete(FeedEntry.TABLE_NAME, selection, selectionArgs);
//
//    }

//    Update Data
//    SQLiteDatabase db = mDbHelper.getWritableDatabase();
//
//    // New value for one column
//    ContentValues values = new ContentValues();
//    values.put(FeedEntry.COLUMN_NAME_TITLE, title);
//
//    // Which row to update, based on the title
//    String selection = FeedEntry.COLUMN_NAME_TITLE + " LIKE ?";
//    String[] selectionArgs = { "MyTitle" };
//
//    int count = db.update(
//            FeedReaderDbHelper.FeedEntry.TABLE_NAME,
//            values,
//            selection,
//            selectionArgs);


//    Persisting DB
//    @Override
//    protected void onDestroy() {
//        mDbHelper.close();
//        super.onDestroy();
//    }

}
