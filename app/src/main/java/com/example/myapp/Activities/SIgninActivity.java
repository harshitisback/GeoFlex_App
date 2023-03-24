package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.MainScreens.mainScreen;
import com.example.myapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class SIgninActivity extends AppCompatActivity {

    static  int couter = 0;
    static  int duration = 5000;
    ProgressBar pgbar;
    TextView forget;
    Button signIn;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_signin);
        pgbar = findViewById(R.id.pgbar);
        forget = findViewById(R.id.forgot);
        signIn = findViewById(R.id.sign_in_button);
        signup = findViewById(R.id.singup_button);


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SIgninActivity.this, mainScreen.class);
                startActivity(i);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SIgninActivity.this, SwipeScreen.class);
                startActivity(i);
            }
        });

        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SIgninActivity.this, "check you email.", Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void progress(){
        // object of java util pack
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                couter++;
                pgbar.setProgress(couter);
                if (couter==50000){
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,100);
    }
}