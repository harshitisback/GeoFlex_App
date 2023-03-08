package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.example.myapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    static  int couter = 0;
    static  int duration = 5000;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);

        progressBar = findViewById(R.id.progressbar);

        progress();
        start();



    }

    public void progress(){
        // object of java util pack
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                couter++;
                progressBar.setProgress(couter);
                if (couter==50000){
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,100);
    }

    public  void start(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, SIgninActivity.class));
                finish();
            }
        },duration);

    }
}