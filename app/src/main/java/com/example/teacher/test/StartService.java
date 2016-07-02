package com.example.teacher.test;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class StartService extends Service {

    private Timer mTimer;
    private int mCountTime = 0;
    private int mCountTimeMax = 60;

    private TimerTask mTask = new TimerTask(){
        @Override
        public void run() {
            mCountTime += 5;

            if(mCountTime == mCountTimeMax){
                stopSelf();
            }else{
                // スレッドの中でUIの操作をできない →対応はhandlerでスレッドをかえす。
                mHandler.sendMessage(Message.obtain(mHandler,0,mCountTime + "秒経過"));
            }
        }
    };

    private Handler mHandler = new Handler(){
        public void handleMessage (Message msg){
            Toast.makeText(StartService.this, (String)msg.obj ,Toast.LENGTH_SHORT).show();
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"サービスを起動",Toast.LENGTH_SHORT).show();

        mTimer = new Timer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this,"サービスを開始",Toast.LENGTH_SHORT).show();

        mTimer.schedule(mTask,5000,5000);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"サービスを終了",Toast.LENGTH_SHORT).show();

        mTimer.cancel();
        mTask.cancel();
    }
}
