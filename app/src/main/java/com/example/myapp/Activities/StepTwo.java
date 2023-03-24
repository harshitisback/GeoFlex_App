package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class StepTwo extends AppCompatActivity {

    String PlanName, PlanCost,PlanCostFormat, Useremailid, Userpassword;
    EditText emailiduser, userPassword;
    static  int counter = 0;
    TextView signin, st13;
    ProgressBar pb;
    Button nbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_step_two);
        // ids
        nbtn = findViewById(R.id.nextbtn);
        st13 = findViewById(R.id.step2of3);
        signin = findViewById(R.id.signins1);
        pb  = findViewById(R.id.progressbarstep2);
        emailiduser = findViewById(R.id.email_edit_text);
        userPassword = findViewById(R.id.password_edit_text);





        // fetching data from activity
        Intent i = getIntent();
        PlanName = i.getStringExtra("PlanName");
        PlanCost = i.getStringExtra("PlanCost");
        PlanCostFormat = i.getStringExtra("PlanCostFormat");



        // onclicks
        pb.setVisibility(View.GONE);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StepTwo.this, SIgninActivity.class));
            }
        });

        nbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Useremailid = emailiduser.getText().toString().trim();
                Userpassword = userPassword.getText().toString().trim();

                Intent i = new Intent(StepTwo.this,StepThree.class);
                i.putExtra("PlanName",PlanName);
                i.putExtra("PlanCost",PlanCost);
                i.putExtra("PlanCostFormat", PlanCostFormat);
                i.putExtra("EmailID", Useremailid);
                i.putExtra("PasswordID",Userpassword);
                startActivity(i);
            }
        });



        // Taosts
        Toast.makeText(this, ""+PlanName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+PlanCost, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+PlanCostFormat, Toast.LENGTH_SHORT).show();



        // Spannable class
        SpannableString st = new SpannableString("STEP 2 OF 3");
        StyleSpan boldspan = new StyleSpan(Typeface.BOLD);
        StyleSpan boldspan1 = new StyleSpan(Typeface.BOLD);

        st.setSpan(boldspan,5,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        st.setSpan(boldspan1,10,11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        st13.setText(st);

    }

    public void progress(){
        // object of java util pack
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);
                if (counter==1000){
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,100);
    }
}