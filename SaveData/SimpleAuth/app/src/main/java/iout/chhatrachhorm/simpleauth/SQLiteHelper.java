package iout.chhatrachhorm.simpleauth;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by chhatra on 10/6/2017.
 *
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "simple_auth";
    private static final String TB_NAME = "users";
    private static final String COL_1 = "id";
    private static final String COL_2 = "name";
    private static final String COL_3 = "email";
    private static final String COL_4 = "phone_number";
    private static final String COL_5 = "password";
    private static int version = 1;
    SQLiteHelper(Context ctx) {
        super(ctx, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TB_NAME + " (" +
                COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_2 + " VARCHAR(50) NOT NULL, "+
                COL_3 + " VARCHAR(100) UNIQUE NOT NULL, "+
                COL_4 + " VARCHAR(10) NOT NULL, "+
                COL_5 + " VARCHAR(100) NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
    boolean insertCredential(String name, String email, String phone, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        Log.d("VALUE", String.valueOf(checkEmail(email).getCount()));
        if(checkEmail(email).getCount() == 0){
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_2, name);
            contentValues.put(COL_3, email);
            contentValues.put(COL_4, phone);
            contentValues.put(COL_5, password);
            Long newROW = sqLiteDatabase.insert(TB_NAME, null, contentValues);
            return newROW != -1;
        }else return false;
    }
    private Cursor checkEmail(String email){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projection = {COL_2, COL_3, COL_4};
        String selection = COL_3 + " = ? ";
        String[] selectArg = {email};
        return sqLiteDatabase.query(
                TB_NAME,
                projection,
                selection,
                selectArg,
                null,
                null,
                COL_2 + " DESC"
        );
    }
    Cursor getCredential(String email, String password){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String[] projection = {COL_2, COL_3, COL_4};
        String selection = COL_3 + " = ? AND " + COL_5 + " = ? ";
        String[] selectArg = {email, password};
        return sqLiteDatabase.query(
                TB_NAME,
                projection,
                selection,
                selectArg,
                null,
                null,
                COL_2 + " DESC"
        );
    }
}
