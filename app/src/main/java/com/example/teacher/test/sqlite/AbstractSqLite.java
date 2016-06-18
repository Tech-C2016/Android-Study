package com.example.teacher.test.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by teacher on 2016/06/18.
 */
public abstract class AbstractSqLite {

    protected CreateProductHelper createProductHelper;
    protected SQLiteDatabase sqliteDatabase;

    public AbstractSqLite(Context context){
        createProductHelper = new CreateProductHelper(context);
    }

    // トランザクション開始
    public void startTransaction(){

    }

    // トランザクション確定
    public void commitTransaction(){

    }

    // トランザクション終了
    public void endTransaction(){

    }

    // DBインスタンス解放
    public void close(){

    }
}
