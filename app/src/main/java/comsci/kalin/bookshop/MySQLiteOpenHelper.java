package comsci.kalin.bookshop;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kalin on 5/1/2017.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase;


    public static final String DataBase_Name = "Bookshop.db";
    public static final int DataBase_Version = 1;

    public static final String TABLE = "userTABLE";
    public static final String U_ID = BaseColumns._ID;
    public static final String U_USER = "User";
    public static final String U_PASSWORD = "Password";
    public static final String U_NAME = "Name";
    public static final String U_ADDRESS = "Address";
    public String CREATE_USER_TABLE ="create table "+TABLE+" ("+U_ID+" integer primary key autoincrement, "+U_USER+" text, "+U_PASSWORD+" text, "+U_NAME+" text, "+U_ADDRESS+" text);";

    public static final String TABLE_B = "bookTABLE";
    public static final String B_ID = BaseColumns._ID;
    public static final String B_NAME = "BookName";
    public static final String B_TYPE = "BookType";
    public static final String B_PRICE = "BookPrice";
    public String CREATE_BOOK_TABLE = "create table "+TABLE_B+" ("+B_ID+" integer primary key autoincrement, "+B_NAME+" text, "+B_TYPE+" text, "+B_PRICE+" text);";

    public MySQLiteOpenHelper(Context context) {
        super(context, DataBase_Name, null, DataBase_Version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, CREATE_USER_TABLE);
        Log.i(TAG, CREATE_BOOK_TABLE);
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_BOOK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // copy เค้ามา อย่าสงสับ
        String DROP_FRIEND_TABLE = "DROP TABLE IF EXISTS " + TABLE;

        db.execSQL(DROP_FRIEND_TABLE);

        Log.i(TAG, "Upgrade Database from " + oldVersion + " to " + newVersion);

        onCreate(db);
    }
    //ยังติดปัญหาเรื่อง method
    public List<String> getFriendList() {
        List<String> ALLUSER = new ArrayList<String>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query
                (TABLE, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while(!cursor.isAfterLast()) {

            ALLUSER.add(cursor.getLong(0) + " " +
                    cursor.getString(1) + " " +
                    cursor.getString(2));

            cursor.moveToNext();
        }

        sqLiteDatabase.close();

        return ALLUSER;
    }
    //
}