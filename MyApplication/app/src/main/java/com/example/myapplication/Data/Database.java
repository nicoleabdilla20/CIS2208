package com.example.myapplication.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    // Creating Database , tablees, columns
    private static final String TAG = "Database";
    private static final String TABLE_NAME = "user_table";
    private static final String COL1 = "ID";
    private static final String COL2 = "name";
    private static final String COL3 = "email";
    private static final String COL4 = "password";
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SignUp.db";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase myDB) {
        String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME + "(" +
                COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL2 + " TEXT," +
                COL3 + " TEXT," +
                COL4 + " TEXT)";
        myDB.execSQL(SQL_CREATE_ENTRIES);
    }
    // string with database
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Database.TABLE_NAME;

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oV, int nV) {
        myDB.execSQL(SQL_DELETE_ENTRIES);
        onCreate(myDB);
    }
    // method to insert data details from signup
    public boolean insertData(String name, String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,email);
        contentValues.put(COL4,password);

        Log.d(TAG, "addData: Adding " + name + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + email + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + password + " to " + TABLE_NAME);

        long result = myDB.insert(TABLE_NAME, null, contentValues);
        //if data as inserted incorrectly it will return -1
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }

    }

    // method to insert second data used in forgot password
    // rewrites data
    // aware that this is not good code
    // it should update not rewrite
    // update method did not work so it is a quick fix to have something
    public boolean insertData2(String email, String password) {
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3,email);
        contentValues.put(COL4,password);

        Log.d(TAG, "addData: Adding " + email + " to " + TABLE_NAME);
        Log.d(TAG, "addData: Adding " + password + " to " + TABLE_NAME);

        long result = myDB.insert(TABLE_NAME, null, contentValues);
        //if data as inserted incorrectly it will return -1
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }

    }
    // method to check email
   public boolean check_email (String email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from user_table where email = ?", new String[] {email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    // method to check email and password
    public boolean check_email_password(String email, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor cursor = myDB.rawQuery("Select * from user_table where email = ? and password =?", new String[] {email, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    // method to retrieve data items
    public Cursor getData(int id) {
        SQLiteDatabase myDB = this.getReadableDatabase();
        Cursor res =  myDB.rawQuery( "select * from user_table where id="+id+"", null );
        return res;

    }

}
