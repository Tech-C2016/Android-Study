package com.example.teacher.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        Toast.makeText(this,"call StartService",Toast.LENGTH_SHORT).show();

        // サービス起動
        Intent intent = new Intent(this,StartService.class);
        startService(intent);
    }
}
