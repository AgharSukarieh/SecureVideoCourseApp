package com.example.myproject.pojo;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "COUNTRIES";
    public static final String _ID = "_id";
    public static final String  _UserName = "username";
    public static final String _Email = "email";
    public static final String _Phone = "phone";
    public static  final String _Password = "password";
    public static final String DB_NAME = "AGHAR.DB";
    public static final int DB_VERSION = 1;
    public static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID + " INTEGER AUTOINCREMENT PRIMARY KEY  ," + _UserName + " TEXT NOT NULL," + _Email + " TEXT NOT NULL," + _Password + " TEXT NOT NULL ,"+ _Phone + " TEXT NOT NULL );";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
    }
}
