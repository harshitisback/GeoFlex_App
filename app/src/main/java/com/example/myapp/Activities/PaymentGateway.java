package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapp.R;

public class PaymentGateway extends AppCompatActivity {
    String PlanName, PlanCost,PlanCostFormat, Useremailid, Userpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_payment_gateway);

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


    }
}