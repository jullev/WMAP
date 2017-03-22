package com.example.setiyawan.mobileapps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_utama extends AppCompatActivity {
    Button btn1, btn2;
    EditText edit1,password;
    TextView txtHilmi;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        btn1 = (Button) findViewById(R.id.button5);
        btn2 = (Button) findViewById(R.id.button4);
        edit1 = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText3);
        txtHilmi = (TextView) findViewById(R.id.textView2);

        String shared = getSharedPreferences("CacheApp",MODE_PRIVATE).toString();
            Toast.makeText(Activity_utama.this,"Data "+shared,Toast.LENGTH_LONG).show();
        if(getSharedPreferences("CacheApp",MODE_PRIVATE).getString("pref","").isEmpty()){
            Toast.makeText(Activity_utama.this,"Cache Kosong",Toast.LENGTH_LONG).show();
        }
        else{
            startActivity(new Intent(Activity_utama.this,Layout2.class));
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kirimData();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = edit1.getText().toString();
                txtHilmi.setText(nama);

            }
        });

    }
    void kirimData(){
        if(edit1.getText().toString().equals("Admin")&&password.getText().toString().equals("1")) {
            Toast.makeText(Activity_utama.this,"Data"+password.getText().toString(),Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Activity_utama.this, Layout2.class);
            intent.putExtra("username", edit1.getText().toString());
            startActivity(intent);
            Cache();
//            finish();
        }
        else{
            Toast.makeText(Activity_utama.this,"Gagal Login",Toast.LENGTH_LONG).show();
        }
    }
    void Cache(){
        pref = getApplicationContext().getSharedPreferences("CacheApp",MODE_PRIVATE);
        SharedPreferences.Editor editPref = pref.edit();
        editPref.putString("pref",edit1.getText().toString());
        editPref.commit();
    }
}
