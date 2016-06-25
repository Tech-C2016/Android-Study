package com.example.teacher.test.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.teacher.test.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teacher on 2016/06/18.
 */
public class UserHelper extends AbstractSqLite {

    private static final String USER_TBL = "users";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ADDRESS = "address";
    private static final String TEL = "tel";

    public static final String USERS_SQL =
            "CREATE TABLE [users] (" +
                    "[name] VARCHAR(50) NOT NULL," +
                    "[address] VARCHAR(100) NOT NULL UNIQUE," +
                    "[tel] VARCHAR(30)," +
                    "[id] INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ");";

    public UserHelper(Context context) {
        super(context);
    }

    public List<UserDto> select() {
        return select(null);
    }

    public List<UserDto> select(String where) {

        List<UserDto> lst = new ArrayList<>();

        SQLiteDatabase database = createProductHelper.getReadableDatabase();

        String col[] = {ID, NAME, ADDRESS, TEL};
        Cursor cursor = database.query(USER_TBL, col, where, null, null, null, ID);

        while (cursor.moveToNext()){
            UserDto dot = new UserDto();
            dot.setId(cursor.getInt(0));
            dot.setName(cursor.getString(1));
            dot.setAddress(cursor.getString(2));
            dot.setTel(cursor.getString(3));
            lst.add(dot);
        }

        return lst;

    }

    public void insert(String name,String address,String tel) throws SQLiteException{
        if(sqliteDatabase == null) return;

        ContentValues values = new ContentValues();
        values.put(NAME,name);
        values.put(ADDRESS,address);
        values.put(TEL,tel);

        sqliteDatabase.insertOrThrow(USER_TBL, null, values);
    }

    public void update(String name,String address,String tel,String where,String[] whereArgs){
        if(sqliteDatabase == null) return;
        ContentValues values = new ContentValues();
        values.put(NAME,name);
        values.put(ADDRESS,address);
        values.put(TEL,tel);
        sqliteDatabase.update(USER_TBL,values,where,whereArgs);
    }

    public void delete(String where,String[] whereArgs){
        if(sqliteDatabase == null) return;
        sqliteDatabase.delete(USER_TBL,where,whereArgs);
    }



}
