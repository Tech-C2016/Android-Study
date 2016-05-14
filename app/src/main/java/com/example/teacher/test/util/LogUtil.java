package com.example.teacher.test.util;

import android.support.graphics.drawable.BuildConfig;
import android.util.Log;

/**
 * Created by teacher on 2016/05/07.
 */
public class LogUtil {
    
    public static void i(final String tag,final String message){
        if(BuildConfig.DEBUG)
            Log.i(tag,message);
    }

    public static void e(final String tag,final String message){
        if(BuildConfig.DEBUG)
            Log.e(tag,message);
    }

    public static void d(final String tag,final String message){
        if(BuildConfig.DEBUG)
            Log.d(tag,message);
    }

}
