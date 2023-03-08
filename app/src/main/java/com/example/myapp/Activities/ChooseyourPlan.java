package com.example.myapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapp.R;

public class ChooseyourPlan extends AppCompatActivity {

    TextView singin;
    RadioButton radiobasic, radiostard, radioprem;
    Button conti;
    String planname, plancost, planformatcost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_chooseyour_plan);

        singin = findViewById(R.id.signins1);
        conti = findViewById(R.id.btnconti);
        // finded id for radiobuttons
        findid();

        radiobasic.setOnCheckedChangeListener(new Radio_check());
        radiobasic.setChecked(true);
        radiostard.setOnCheckedChangeListener(new Radio_check());
        radioprem.setOnCheckedChangeListener(new Radio_check());

        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChooseyourPlan.this, FinishUpAccount.class);
                i.putExtra("PlanName",planname);
                i.putExtra("PlanCost",plancost);
                i.putExtra("PlanCostFormat", planformatcost);
                startActivity(i);
            }
        });

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChooseyourPlan.this, SIgninActivity.class));
            }
        });






    }

    // ADITIONAL METHODS OUTSIDE

    class Radio_check implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                if (buttonView.getId()==R.id.radiobuttonforbasic){
                    planname = "Basic";
                    plancost = "34";
                    planformatcost = "₹ 34/month";
                    radiostard.setChecked(false);
                    radioprem.setChecked(false);
                }else if(buttonView.getId()==R.id.radiobuttonforstandard){
                    planname = "Standard";
                    plancost = "64";
                    planformatcost = "₹ 64/month";
                    radiobasic.setChecked(false);
                    radioprem.setChecked(false);
                }else if(buttonView.getId()==R.id.radiobuttonforpremium){
                    planname = "Premium";
                    plancost = "84";
                    planformatcost = "₹ 84/month";
                    radiobasic.setChecked(false);
                    radiostard.setChecked(false);
                }
            }
        }
    }

    private void findid() {
        radiobasic = findViewById(R.id.radiobuttonforbasic);
        radiostard = findViewById(R.id.radiobuttonforstandard);
        radioprem = findViewById(R.id.radiobuttonforpremium);

    }
}