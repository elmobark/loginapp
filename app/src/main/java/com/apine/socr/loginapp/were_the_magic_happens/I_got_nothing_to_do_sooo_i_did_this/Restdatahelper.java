package com.apine.socr.loginapp.were_the_magic_happens.I_got_nothing_to_do_sooo_i_did_this;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.apine.socr.loginapp.were_the_magic_happens.menuitemholder;

import java.util.List;

import static com.apine.socr.loginapp.appSettings.Restorantsnames;
import static com.apine.socr.loginapp.appSettings.imguri;

/**
 * Created by Mobark on 2/15/2018.
 */

public class Restdatahelper extends SQLiteOpenHelper {
    public Restdatahelper(Context context) {
        super(context, "RESTDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE `RestutrantT` ( `ID` INTEGER PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `RID` TEXT, `RIMURI` TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `RestutrantT` ( `ID` INTEGER PRIMARY KEY AUTOINCREMENT, `Name` TEXT, `RID` TEXT, `RIMURI` TEXT )");
    }
    public void datafill(){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        for (int i =0;i<Restorantsnames.length;i++){
            sqLiteDatabase.execSQL("insert into `RestutrantT`(Name,RID,RIMURI)values('"+Restorantsnames[i]+"','"+i+"','"+imguri[i]+"')");
        }
    }
    public void dataget(List<menuitemholder> list){
        SQLiteDatabase sqLiteDatabase=getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("select * from `RestutrantT`",null);
        if (cursor.moveToFirst()) {
            do {
                menuitemholder item = new menuitemholder(cursor.getString(1), Integer.parseInt(cursor.getString(3)));
                list.add(item);
            } while (cursor.moveToNext());

            cursor.close();
        }
    }

}
