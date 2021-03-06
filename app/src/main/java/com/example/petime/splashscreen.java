package com.example.petime;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class splashscreen extends AppCompatActivity {

    TextView appname;
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        appname=findViewById(R.id.appnanme) ;
        lottie=findViewById(R.id.lottie);

        appname.animate().translationY(-1500).setDuration(2700).setStartDelay(0);
        lottie.animate().translationX(2000).setDuration(2000).setStartDelay(2900);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Intent i=new Intent(getApplicationContext(),MainActivity.class);
                //startActivity(i);
                Intent intent=new Intent(splashscreen.this,MainActivity.class);
                splashscreen.this.startActivity(intent);
                splashscreen.this.finish();
            }
        },4000);
        }
    }