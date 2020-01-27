package com.example.budgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class fillBudgetActivity extends AppCompatActivity {
    private EditText editTextButton;
    private double taxRate;
    private double grossIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_budget);
        Button nextButton = findViewById(R.id.next);
        editTextButton = findViewById(R.id.editTextIncome);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGrossIncome();
                Intent c = new Intent(fillBudgetActivity.this, BudgetPreferencesActivity.class);
                String grossIncomex = String.valueOf(grossIncome);
                c.putExtra("grossIncome", grossIncomex);
                startActivity(c);
            }
        });
    }
    private void getGrossIncome(){
        String s = editTextButton.getText().toString().trim();
        double netIncome = Double.parseDouble(s);
        if(netIncome >= 0 && netIncome <= 9525){
            taxRate = 0.10;
        }

        else if (netIncome >= 9525 && netIncome <= 38700){
            taxRate = 0.12;
        }

        else if (netIncome >= 38701 && netIncome <= 82500){
            taxRate = 0.22;
        }
        else if (netIncome >= 82501 && netIncome <= 157500){
            taxRate = 0.24;
        }

        else if (netIncome >= 157501 && netIncome <= 200000) {
            taxRate = 0.3;
        }

        else if (netIncome >= 200001 && netIncome <= 500000){
            taxRate = 0.35;
        }
        else if (netIncome >= 500001){
            taxRate = 0.37;
        }

        grossIncome = netIncome - (netIncome * taxRate);


    }
}
