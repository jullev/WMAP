package com.example.setiyawan.mobileapps;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
        //perubahan
        btn = (Button) findViewById(R.id.button);
        edTest = (EditText) findViewById(R.id.textView2);
    }
}
