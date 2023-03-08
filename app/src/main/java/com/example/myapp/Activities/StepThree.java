package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapp.R;

public class StepThree extends AppCompatActivity {
    String PlanName, PlanCost,PlanCostFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_three);

        // fetching data from activity
        Intent i = getIntent();
        PlanName = i.getStringExtra("PlanName");
        PlanCost = i.getStringExtra("PlanCost");
        PlanCostFormat = i.getStringExtra("PlanCostFormat");

        // Taosts
        Toast.makeText(this, ""+PlanName, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+PlanCost, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ""+PlanCostFormat, Toast.LENGTH_SHORT).show();
    }
}