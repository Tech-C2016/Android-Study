package com.example.teacher.test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IntentActivity extends AppCompatActivity {

    private final int REQUEST_CODE_FOR_SAMPLE = 1;

    private Button mBtnTest1;
    private Button mBtnTest2;
    private Button mBtnTest3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        // 明示的インテント(値を渡す) A → B
        mBtnTest1 = (Button) findViewById(R.id.btnTest1);
        mBtnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentActivity.this,SampleActivity.class);
                intent.putExtra(SampleActivity.EXTRA_HELLO_STRING,"hello world");
                startActivity(intent);
            }
        });

        // 明示的インテント（値を渡し、且つ値を戻す）A → B → 元A
        mBtnTest3 = (Button) findViewById(R.id.btnTest3);
        mBtnTest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentActivity.this,SampleActivity.class);
                intent.putExtra(SampleActivity.EXTRA_HELLO_STRING,"hello world");
                startActivityForResult(intent,REQUEST_CODE_FOR_SAMPLE);
            }
        });

        // 暗黙的インテント
        mBtnTest2 = (Button) findViewById(R.id.btnTest2);
        mBtnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:090-222-333");
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });
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
