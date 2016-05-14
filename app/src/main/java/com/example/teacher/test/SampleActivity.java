package com.example.teacher.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SampleActivity extends AppCompatActivity {

    public static final String EXTRA_HELLO_STRING = "EXTRA_HELLO_STRING";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        Intent intent = getIntent();
        String extraString = "";
        if(intent != null && intent.getExtras() != null) {
            extraString = intent.getExtras().getString(EXTRA_HELLO_STRING);
            Toast.makeText(this, extraString, Toast.LENGTH_SHORT).show();
        }

    }
}
