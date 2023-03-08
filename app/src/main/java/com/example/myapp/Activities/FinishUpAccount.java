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
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;

public class FinishUpAccount extends AppCompatActivity {

    String PlanName;
    String PlanCost;
    String PlanCostFormat;

    TextView st13;
    Button conti;
    TextView signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_finish_up_account);
        st13 = findViewById(R.id.step1of3finished);

        Intent i = getIntent();
        PlanName = i.getStringExtra("PlanName");
        PlanCost = i.getStringExtra("PlanCost");
        PlanCostFormat = i.getStringExtra("PlanCostFormat");



        Toast.makeText(this, ""+PlanName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+PlanCost, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+PlanCostFormat, Toast.LENGTH_SHORT).show();


        conti = findViewById(R.id.contifinishup);
        signin = findViewById(R.id.signins1);
        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinishUpAccount.this, StepTwo.class);
                i.putExtra("PlanName",PlanName);
                i.putExtra("PlanCost",PlanCost);
                i.putExtra("PlanCostFormat", PlanCostFormat);
                startActivity(i);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FinishUpAccount.this, SIgninActivity.class));
            }
        });

        SpannableString st = new SpannableString("STEP 1 OF 3");
        StyleSpan boldspan = new StyleSpan(Typeface.BOLD);
        StyleSpan boldspan1 = new StyleSpan(Typeface.BOLD);

        st.setSpan(boldspan,5,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        st.setSpan(boldspan1,10,11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        st13.setText(st);



    }
}