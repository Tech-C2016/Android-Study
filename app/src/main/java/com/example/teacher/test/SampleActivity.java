package com.example.teacher.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;

public class SampleActivity extends BaseActivity {

    public static final String EXTRA_HELLO_STRING = "EXTRA_HELLO_STRING";

    @BindView(R.id.editReturn)
    Button mEditText;

    @OnClick(R.id.btnDo)
    void onDo(){
        Intent intent = new Intent();
        intent.putExtra("returnKey","返り値：" + mEditText.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }

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
