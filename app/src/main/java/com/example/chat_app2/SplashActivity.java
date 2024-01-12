package com.example.chat_app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.chat_app2.utils.FirbaseUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splah);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(FirbaseUtil.isLoggedIn()){
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }else{
                    startActivity(new Intent(SplashActivity.this,loginPhoneNumberActivity.class));
                }

                finish();

            }
        },1000);
    }
}