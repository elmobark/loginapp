package com.apine.socr.loginapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Mobark on 2/13/2018.
 */

public class AppUserControl extends SQLiteOpenHelper {
    public static final String TABLE_NAME="userT";
    public AppUserControl(Context context) {
        super(context, "UsersDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE 'userT' ( `ID` INTEGER PRIMARY KEY AUTOINCREMENT, `Username` TEXT, `Password` TEXT, `RecoveryKey` TEXT, `Firstname` TEXT, `Lastname` TEXT, `Email` TEXT, `Mobile` TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'userT' ( `ID` INTEGER PRIMARY KEY AUTOINCREMENT, `Username` TEXT, `Password` TEXT, `RecoveryKey` TEXT, `Firstname` TEXT, `Lastname` TEXT, `Email` TEXT, `Mobile` TEXT )");
    }
    public boolean isRegisterted(String username,String password){
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from `userT` where  `Username` like'"+username+"' and `Password` like '"+password+"'",null);
        return cursor.getCount()!=0;
    }
    public void RegistertUser(String[] data){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL("insert into userT(Username,Password,RecoveryKey,Firstname,Lastname,Email,Mobile) values ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"')");
    }
    public boolean checkuser(String Username){
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery("select * from `userT` where  `Username` like'"+Username+"'",null);
        Log.e("tttt>>",""+cursor.getCount());
        return cursor.getCount()!=0;
    }
}
