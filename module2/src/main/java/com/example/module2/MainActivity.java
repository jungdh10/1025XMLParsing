package com.example.module2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //방송을 송신
                Intent intent=new Intent();
                //방송 액션-카카오같은 경우 com.example.카카오택시 이런식
                intent.setAction("com.example.sendbroadcast");
                //실행한적이 없어도 설치되어 있으면 방송을 수신
                intent.addFlags(intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                //방송을 송신
                sendBroadcast(intent);
            }
        });
    }
}
