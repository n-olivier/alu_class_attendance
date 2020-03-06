package com.example.aluclassattendanceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String DBNAME = "cohort 2";
    public static final int VERSION = 1;

    public static final String TABLENAME = "Student";
    public static final String COL1 = "ID";
    public static final String COL2 = "Name";
    public static final String COL3 = "Password";
    public static final String COL4 = "Email";

    public Database(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table Student (name text, password text, email text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists TABLENAME");
//        onCreate(db);
    }

    public boolean insertData(String name, String password, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues records = new ContentValues();

        records.put("name", name);
        records.put("password", password);
        records.put("email", email);

        long returnValue = db.insert("Student", null, records);
        return returnValue != -1;
    }

    public Cursor readData(){
        SQLiteDatabase db = this.getReadableDatabase();

//        String[] projection = {
//                BaseColumns._ID,
//                COL2,
//                COL3,
//                COL4
//        };

        return db.rawQuery("SELECT * FROM " + TABLENAME, null);
    }


}
