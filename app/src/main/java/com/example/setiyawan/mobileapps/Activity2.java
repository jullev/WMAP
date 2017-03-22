package com.example.setiyawan.mobileapps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import Desain.ListView1Inflater;

/**
 * Created by setiyawan on 3/22/17.
 */

public class Activity2 extends Activity {
    ListView lv1;
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
        lv1 = (ListView) findViewById(R.id.list1);
        ListView1Inflater inflater = new ListView1Inflater(Activity2.this,imageid,nama,alamat,nohp);
        lv1.setAdapter(inflater);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Activity2.this,"yang dipilih : "+nama[i],Toast.LENGTH_LONG).show();
            }
        });
    }
}
