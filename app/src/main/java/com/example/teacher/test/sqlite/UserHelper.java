package com.example.teacher.test.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

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


}
