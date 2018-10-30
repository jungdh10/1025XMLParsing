package com.example.serviceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //스레드
        Thread th=new Thread(){
            @Override
            public void run(){
                for(int i=0; i<3; i++){
                    try{
                        Thread.sleep(1000);
                        Log.e("Thread", i+"");
                    }catch(Exception e){}
                }
            }
        };
        th.start();

        //인텐트서비스
        Intent intent=new Intent(this, MyIntentService.class);
        //서비스 실행
        startService(intent);

        //스타트서비스
        Intent intent1=new Intent(this, MyService.class);
        startService(intent1);
    }
}
