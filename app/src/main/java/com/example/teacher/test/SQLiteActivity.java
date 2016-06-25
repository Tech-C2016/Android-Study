package com.example.teacher.test;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.teacher.test.dto.UserDto;
import com.example.teacher.test.sqlite.UserHelper;

import java.util.List;

public class SQLiteActivity extends BaseActivity {

    private UserHelper mUserHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        mUserHelper = new UserHelper(this);

        try {
            // トランザクション開始
            mUserHelper.startTransaction();

            // データ追加
            mUserHelper.insert("matsumoto","tokyo","080-1234-5678");
            mUserHelper.insert("ide","saita","080-1234-5678");
            mUserHelper.insert("tanaka","ibaraki","080-1234-5678");
            mUserHelper.insert("sato","tokushima","080-1234-5678");

            // トランザクションコミット　
            mUserHelper.commitTransaction();
        }catch (SQLException e){
            // トランザクションを終了
            mUserHelper.endTransaction();
        }

        // データを取得
        List<UserDto> userLst = mUserHelper.select();

        // トーストに表示(リストに出力したいが時間節約のため省略)
        for(UserDto dto : userLst){
            Toast.makeText(
                    this,
                    "name:" + dto.getName() + " add:" + dto.getAddress(),
                    Toast.LENGTH_SHORT)
                    .show();
        }

    }
}
