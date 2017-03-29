package com.example.setiyawan.mobileapps;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import Database.DBAdapter;

/**
 * Created by setiyawan on 3/29/17.
 */

public class Akses_DB extends Activity{
    DBAdapter adapter;
    SQLiteDatabase database;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        adapter = new DBAdapter(Akses_DB.this);
        database=adapter.getWritableDatabase();
    }

}
