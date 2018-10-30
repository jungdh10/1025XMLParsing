package com.example.serviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("StartService", "시작");
    }

    //Create 다음에 호출되는 메소드입니다.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        for(int i=0; i<3;i++){
            try{
                Thread.sleep(1000);
                Log.e("StartService", i+"");
            }catch(Exception e){ }
        }

        /*
        //startItent 실행 후 Module의 화면보이기
        //방송을 송신
        Intent intent1 = new Intent();
        //?
        intent.putExtra("data", "dsljdslkj");
        //방송 액션
        intent1.setAction("com.example.sendbroadcast");
        //실행한 적이 없어도 설치되어 있으면 방송을 수신
        intent1.addFlags(
                intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        //방송을 송신
        sendBroadcast(intent1);
*/

        //스타트 서비스 종료
        stopSelf();
        //종료된 후 바로 다시 시작할 수 있도록 생성
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("StartService", "종료");
    }

    @Override
    public IBinder onBind(Intent intent) {
        //호출되는 지 확인
        Log.e("StartService", "bind 호출");

        return null;
    }
}
