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
    public static final String B_NAME = "Name";
    public static final String B_TYPE = "Type";
    public static final String B_PRICE = "Price";

    public BookTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewBook(String strName, String strType, String strPrice){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(B_NAME, strName);
        objContentValues.put(B_TYPE, strType);
        objContentValues.put(B_PRICE, strPrice);
        return readSqLiteDatabase.insert(TABLE_B, null, objContentValues);
    }
}
