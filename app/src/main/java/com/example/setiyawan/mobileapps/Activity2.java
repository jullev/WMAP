package com.example.setiyawan.mobileapps;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import Database.DBAdapter;
import Desain.ListView1Inflater;

/**
 * Created by setiyawan on 3/22/17.
 */

public class Activity2 extends Activity {
    ListView lv1;
    DBAdapter adapter;
    SQLiteDatabase database;
    Cursor cursor;
    ListView1Inflater inflater;
    private String nama[] = {
            "Andi",
            "Abu",
            "Budi",
            "Ahmad"
    };

    private String alamat[] = {
            "Jember",
            "Kalisat",
            "Jogja",
            "Surabaya"
    };
    private String nohp[] = {
            "08111111",
            "0821110101010",
            "083333333",
            "08444444"
    };
    private Integer imageid[]  ={
            R.drawable.bros,
            R.drawable.kalung_tumb,
            R.drawable.cincin_tumb,
            R.drawable.manik2_tumb
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);
        adapter = new DBAdapter(Activity2.this);
        database = adapter.getWritableDatabase();
        lv1 = (ListView) findViewById(R.id.list1);
//        ListView1Inflater inflater = new ListView1Inflater(Activity2.this,imageid,nama,alamat,nohp);
//        lv1.setAdapter(inflater);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Activity2.this,"yang dipilih : "+nama[i],Toast.LENGTH_LONG).show();
            }
        });
    }
    public void LoadData() {

        cursor = database.rawQuery("select _id,nama,alamat,no_hp from master_pengguna", null);
        Log.e("Jumlah Pesanan = ", "Jumlah Pesanan = " + cursor.getCount());
        cursor.moveToFirst();
        nohp = new String[cursor.getCount()];
        nama = new String[cursor.getCount()];
        alamat = new String[cursor.getCount()];

        int counter=0;
        while (!cursor.isAfterLast()) {
            String val = cursor.getString(0)+"|"+cursor.getString(1);
            nohp[counter]=cursor.getString(3);
            nama[counter]=cursor.getString(1);
            alamat[counter]=cursor.getString(2);
            Log.e("adapter", "Lokasi " + val);
            counter++;
            cursor.moveToNext();
        }
        inflater = new ListView1Inflater(Activity2.this,imageid,nama,alamat,nohp);
        lv1.setAdapter(inflater);
    }
}
