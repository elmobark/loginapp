package com.apine.socr.loginapp.were_the_magic_happens.I_got_nothing_to_do_sooo_i_did_this;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mobark on 2/15/2018.
 */

public class yammydatahelper extends SQLiteOpenHelper {
    public yammydatahelper(Context context) {
        super(context, "FOODDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE `FoodT` ( `ID` INTEGER PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `RestruantID` TEXT, `FoodPrize` TEXT, `FoodIMURI` TEXT, `FoodDis` TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FoodT` ( `ID` INTEGER PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `RestruantID` TEXT, `FoodPrize` TEXT, `FoodIMURI` TEXT, `FoodDis` TEXT )");
    }
}
