package com.example.setiyawan.mobileapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_utama extends AppCompatActivity {
    Button btn1,btn2;
    EditText edit1;
    TextView txtHilmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
        btn1 = (Button) findViewById(R.id.button5);
        btn2 = (Button) findViewById(R.id.button4);
        edit1 = (EditText) findViewById(R.id.editText);
        txtHilmi = (TextView) findViewById(R.id.textView2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Toast.makeText(Activity_utama.this,"Hai "+edit1.getText().toString(),Toast.LENGTH_LONG).show();
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
}
