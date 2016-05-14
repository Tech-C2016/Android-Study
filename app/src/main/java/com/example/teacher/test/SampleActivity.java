package com.example.teacher.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        final EditText editText = (EditText) findViewById(R.id.editReturn);
        Button btnDo = (Button) findViewById(R.id.btnDo);
        btnDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("returnKey","返り値：" + editText.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
