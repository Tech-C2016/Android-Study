package com.example.teacher.test.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by teacher on 2016/06/18.
 */
public class CreateProductHelper extends SQLiteOpenHelper {

    public CreateProductHelper(Context context) {
        super(context, "sample", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // テーブル作成
        db.execSQL(UserHelper.USERS_SQL);

        // サンプルデータ
        db.execSQL("insert into users(id,name,address,tel) values (1,'suzuki','tokyo','080-0000-0000')");
        db.execSQL("insert into users(id,name,address,tel) values (2,'tanaka','saitama','080-1234-0000')");
        db.execSQL("insert into users(id,name,address,tel) values (3,'okabe','tochigi','080-3333-0000')");
        db.execSQL("insert into users(id,name,address,tel) values (4,'matsumoto','kagawa','080-2222-0000')");
        db.execSQL("insert into users(id,name,address,tel) values (5,'nirei','kanagawa','080-0999-0000')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
