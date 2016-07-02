package com.example.teacher.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends BaseActivity {

    // 通常ダイアログ
    @OnClick(R.id.btnDialog)
    void onBtnDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("タイトルです");
        dialog.setMessage("通常ダイアログです");
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this,"okおしたよ",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("cancel",null);
        dialog.show();
    }

    int cwhich = 0;
    // 単一選択ダイアログ
    @OnClick(R.id.btnSingleDialog)
    void onBtnSingleDialog() {
        final String[] choiceItems = new String[]{"test1", "test2","test3"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("タイトルです1");
        dialog.setSingleChoiceItems(
                choiceItems,
                0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int choiceWhich) {
                cwhich = choiceWhich;
            }
        });
        dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this,"選択：" + choiceItems[cwhich],Toast.LENGTH_LONG).show();
            }
        });
        dialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }
}
