package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;

public class StepThree extends AppCompatActivity {
    TextView signout, steps;
    String PlanName, PlanCost,PlanCostFormat, Useremailid, Userpassword;
    LinearLayout paymentbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_step_three);

        //toolbar signout
        signout = findViewById(R.id.signoutstep3);
        steps = findViewById(R.id.step3tv);
        paymentbtn = findViewById(R.id.paymentbtn);
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StepThree.this, SIgninActivity.class));
            }
        });

        // setting on click in payment button
        paymentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StepThree.this,PaymentGateway.class);
                i.putExtra("PlanName",PlanName);
                i.putExtra("PlanCost",PlanCost);
                i.putExtra("PlanCostFormat", PlanCostFormat);
                i.putExtra("EmailID", Useremailid);
                i.putExtra("PasswordID",Userpassword);
                startActivity(i);
            }
        });

        // fetching data from activity
        Intent i = getIntent();
        PlanName = i.getStringExtra("PlanName");
        PlanCost = i.getStringExtra("PlanCost");
        PlanCostFormat = i.getStringExtra("PlanCostFormat");
        Useremailid = i.getStringExtra("EmailID");
        Userpassword = i.getStringExtra("PasswordID");

        // Taosts
        Toast.makeText(this, ""+PlanName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+PlanCost, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+PlanCostFormat, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+Useremailid, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+Userpassword, Toast.LENGTH_SHORT).show();

        // spannable step
        SpannableString st = new SpannableString("STEP 3 OF 3");
        StyleSpan boldspan = new StyleSpan(Typeface.BOLD);
        StyleSpan boldspan1 = new StyleSpan(Typeface.BOLD);

        st.setSpan(boldspan,5,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        st.setSpan(boldspan1,10,11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        steps.setText(st);

    }
}