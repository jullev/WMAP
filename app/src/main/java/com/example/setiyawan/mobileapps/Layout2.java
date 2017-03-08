package com.example.setiyawan.mobileapps;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by setiyawan on 3/1/17.
 */

public class Layout2 extends Activity {
    Button btn;
    EditText edTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        String shared = getSharedPreferences("CacheApp",MODE_PRIVATE).getString("pref","a").toString();
        Toast.makeText(Layout2.this,"Share : "+shared,Toast.LENGTH_LONG).show();
        //perubahan
        btn = (Button) findViewById(R.id.button);
        edTest = (EditText) findViewById(R.id.editText2);
        edTest.setText(shared);
    }
}
