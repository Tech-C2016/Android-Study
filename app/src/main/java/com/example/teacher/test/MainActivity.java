package com.example.teacher.test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.teacher.test.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    // インテントサービス
    @OnClick(R.id.btnIntent)
    void onBtnIntent(){
        Intent intent = new Intent(MainActivity.this,IntentActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
        LogUtil.i("MainActivity","onCreate");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
        LogUtil.i("MainActivity","onPause");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
        LogUtil.i("MainActivity","onRestart");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
        LogUtil.i("MainActivity","onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
        LogUtil.i("MainActivity","onDestroy");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
        LogUtil.i("MainActivity","onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
        LogUtil.i("MainActivity","onResume");
    }


}
