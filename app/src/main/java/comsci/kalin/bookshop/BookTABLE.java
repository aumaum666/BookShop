package comsci.kalin.bookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Kalin on 5/1/2017.
 */

public class BookTABLE {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE_B = "bookTABLE";
    public static final String B_ID = "_id";
    public static final String B_NAME = "BookName";
    public static final String B_TYPE = "BookType";
    public static final String B_SOURCE = "BookSource";
    public static final String B_PRICE = "BookPrice";

    public BookTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewBook (String strName, String strType, String strPrice, String strSource){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(B_NAME, strName);
        objContentValues.put(B_TYPE, strType);
        objContentValues.put(B_PRICE, strPrice);
        objContentValues.put(B_SOURCE, strSource);
        return readSqLiteDatabase.insert(TABLE_B, null, objContentValues);
    }
}
