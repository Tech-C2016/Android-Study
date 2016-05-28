package com.example.teacher.test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.OnClick;

public class IntentActivity extends AppCompatActivity {

    private final int REQUEST_CODE_FOR_SAMPLE = 1;

    // 明示的インテント(値を渡す) A → B
    @OnClick(R.id.btnTest1)
    void onBtnTest1(){
        Intent intent = new Intent(IntentActivity.this,SampleActivity.class);
        intent.putExtra(SampleActivity.EXTRA_HELLO_STRING,"hello world");
        startActivity(intent);
    }

    // 暗黙的インテント
    @OnClick(R.id.btnTest2)
    void onBtnTest2(){
        Uri uri = Uri.parse("tel:090-222-333");
        Intent intent=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }

    // 明示的インテント（値を渡し、且つ値を戻す）A → B → 元A
    @OnClick(R.id.btnTest3)
    void onBtnTest3(){
        Intent intent = new Intent(IntentActivity.this,SampleActivity.class);
        intent.putExtra(SampleActivity.EXTRA_HELLO_STRING,"hello world");
        startActivityForResult(intent,REQUEST_CODE_FOR_SAMPLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_FOR_SAMPLE){
                if(data != null && data.getExtras() != null){
                    String value = data.getStringExtra("returnKey");
                    Toast.makeText(IntentActivity.this,value,Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
