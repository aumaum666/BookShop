package comsci.kalin.bookshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Kalin on 5/1/2017.
 */

public class UserTABLE {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase, readSqLiteDatabase;

    public static final String TABLE = "userTABLE";
    public static final String U_ID = "_id";
    public static final String U_USER = "User";
    public static final String U_PASSWORD = "Password";
    public static final String U_NAME = "Name";
    public static final String U_ADDRESS = "Address";

    public UserTABLE(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewUser (String strUser, String strPassword, String strName, String strAddress){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(U_USER, strUser);
        objContentValues.put(U_PASSWORD, strPassword);
        objContentValues.put(U_NAME, strName);
        objContentValues.put(U_ADDRESS, strAddress);
        return readSqLiteDatabase.insert(TABLE, null, objContentValues);
    }
}
