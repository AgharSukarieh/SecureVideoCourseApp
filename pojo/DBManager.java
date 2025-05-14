package com.example.myproject.pojo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManager {
    private DatabaseHelper databaseHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException {
        databaseHelper = new DatabaseHelper(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (databaseHelper != null) {
            databaseHelper.close();
        }
    }

    public boolean insert(String userName, String emailAddress, String password, String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(databaseHelper._UserName, userName);
        contentValues.put(databaseHelper._Email, emailAddress);
        contentValues.put(databaseHelper._Password, password);
        contentValues.put(databaseHelper._Phone, phone);

        long isInserted = database.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        if (isInserted > 0) {
            Log.d("DBInsert", "Insert successful");

            return true;
        } else {
            Log.d("DBInsert", "Insert failed");
            return false;
        }
    }

    public Cursor fetch() {
        String[] columns = new String[]{databaseHelper._UserName, databaseHelper._Email, databaseHelper._Password, databaseHelper._Phone};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst(); 
        }
        return cursor;
    }

    public boolean checkAccount(String email, String password) {
        Cursor cursor = null;
        try {
            cursor = database.rawQuery("SELECT * FROM " + DatabaseHelper.TABLE_NAME + " WHERE " + DatabaseHelper._Email + " = ? AND " + DatabaseHelper._Password + " = ?", new String[]{email, password});
            return cursor != null && cursor.getCount() > 0;
        } finally {
            if (cursor != null) {
                cursor.close();  
            }
        }
    }
}
