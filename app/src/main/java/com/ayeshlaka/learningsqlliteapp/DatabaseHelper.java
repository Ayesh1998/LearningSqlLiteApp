package com.ayeshlaka.learningsqlliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String Database_Name = "MyData.db";
    public static final String Table_Name = "Students_Table";
    public static final String col1 = "Name";
    public static final String col2 = "Age";
    public static final String col3 = "Address";

    public DatabaseHelper(@Nullable Context context) {
        super(context, Database_Name, null, 1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + Table_Name + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Name TEXT, Age TEXT, Address TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_Name);
        onCreate(sqLiteDatabase);
    }

    public boolean insertStudent(String name, String age, String address) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1,name);
        cv.put(col2,age);
        cv.put(col3,address);
        long res = db.insert(Table_Name,null,cv);

        if (res==-1){
            return false;
        }else
            return true;

    }


}
