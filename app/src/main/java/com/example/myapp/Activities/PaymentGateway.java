package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapp.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentGateway extends AppCompatActivity implements PaymentResultListener {
    String PlanName, PlanCost,PlanCostFormat, Useremailid, Userpassword;
    EditText firstName, Lastname, ContactNo;
    String fname, lname, cname;
    Button startyourbtn;
    CheckBox iagree;
    TextView texturl, textview, costtypeToSet, planNameToSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_payment_gateway);

        // fetching data from activity`1
        Intent i = getIntent();
        PlanName = i.getStringExtra("PlanName");
        PlanCost = i.getStringExtra("PlanCost");
        PlanCostFormat = i.getStringExtra("PlanCostFormat");
        Useremailid = i.getStringExtra("EmailID");
        Userpassword = i.getStringExtra("PasswordID");

        // getting ids
        firstName = findViewById(R.id.paymentName);
        Lastname = findViewById(R.id.lname);
        ContactNo = findViewById(R.id.contact);
        startyourbtn = findViewById(R.id.contibtn);
        costtypeToSet = findViewById(R.id.costtypeToSet);
        planNameToSet = findViewById(R.id.planNameToSet);

        // setting up cost
        costtypeToSet.setText(PlanCostFormat);
        planNameToSet.setText(PlanName);

        startyourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }
        });

    }


    public void startPayment(){
        Checkout checkout = new Checkout();
        final Activity activity = this;
        fname = firstName.getText().toString().trim();
        lname = Lastname.getText().toString().trim();
        cname = ContactNo.getText().toString().trim();
        String name = fname+lname;
        try {
            JSONObject option = new JSONObject();
            option.put("name", name);
            option.put("description", "APP PAYMENT");
            option.put("currency", "INR");
            String payment = PlanCost;
            double total = Double.parseDouble(payment);
            total = total*100;
            option.put("amount", total);
            option.put("prefill.email", Useremailid);
            option.put("prefill.contact", ContactNo);
            checkout.open(activity,option);
        }catch (Exception e){
            Log.e("PaymentError","error occurs", e);
        }
    }

    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(this, "payement Successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(this, "payment failed", Toast.LENGTH_SHORT).show();
    }


}