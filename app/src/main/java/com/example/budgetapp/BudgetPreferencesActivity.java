package com.example.budgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.Toast;

public class BudgetPreferencesActivity extends AppCompatActivity {
    private Intent intent;
    private CheckBox housingCheck,utilsCheck, funCheck, personCheck, clothingCheck,transportCheck, foodCheck, insuranceCheck, savingsCheck;
    private Button clickedIDs;
    private int checkBoxesCount;
    public static double housing = .11;
    public static double utils = .11;
    public static double fun = .11;
    public static double person = .11;
    public static double clothing = .11;
    public static double transport = .11;
    public static double food= .11;
    public static double insurance = .11;
    public static double savings = .11;
    String value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_preferences);
        value = getIntent().getExtras().getString("grossIncome");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        housingCheck = findViewById(R.id.housingCheck);
        utilsCheck = findViewById(R.id.utilsCheck);
        funCheck = findViewById(R.id.funCheck);
        personCheck = findViewById(R.id.personCheck);
        clothingCheck = findViewById(R.id.clothingCheck);
        transportCheck = findViewById(R.id.transportCheck);
        foodCheck = findViewById(R.id.foodCheck);
        insuranceCheck = findViewById(R.id.insuranceCheck);
        savingsCheck = findViewById(R.id.savingsCheck);
        clickedIDs = findViewById(R.id.clickedIDs);
        clickedIDs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateChangesInPercent();
                checkBoxesCount = 0;

            }
        });


    }
    private void calculateChangesInPercent(){
        // make sure that only three are checked (or less)
        if(housingCheck.isChecked()){
            checkBoxesCount+=1;
        }
        if(utilsCheck.isChecked()){
            checkBoxesCount+=1;
        }
        if(funCheck.isChecked()){
            checkBoxesCount+=1;
        }
        if(personCheck.isChecked()){
            checkBoxesCount+=1;
        }
        if(clothingCheck.isChecked()){
            checkBoxesCount+=1;
        }
        if(transportCheck.isChecked()){
            checkBoxesCount+=1;
        }
        if(foodCheck.isChecked()){
            checkBoxesCount+=1;
        }
        if(insuranceCheck.isChecked()){
            checkBoxesCount+=1;
        }
        if(savingsCheck.isChecked()){
            checkBoxesCount+=1;
        }

        if (checkBoxesCount == 3) {
            if(housingCheck.isChecked()){
                housing=.15;
            }
            if(utilsCheck.isChecked()){
                utils+=.15;
            }
            if(funCheck.isChecked()){
                fun+=.15;
            }
            if(personCheck.isChecked()){
                person+=.15;
            }
            if(clothingCheck.isChecked()){
                clothing+=.15;
            }
            if(transportCheck.isChecked()){
                transport+=.15;
            }
            if(foodCheck.isChecked()){
                food+=.15;
            }
            if(insuranceCheck.isChecked()){
                insurance+=.15;
            }
            if(savingsCheck.isChecked()){
                savings+=.15;
            }

            // account for checkboxes that arent checked
            if(!housingCheck.isChecked()){
                housing = 0.091;
            }
            if(!utilsCheck.isChecked()){
                utils=0.091;
            }
            if(!funCheck.isChecked()){
                fun=.091;
            }
            if(!personCheck.isChecked()){
                person=.091;
            }
            if(!clothingCheck.isChecked()){
                clothing=.091;
            }
            if(!transportCheck.isChecked()){
                transport=.091;
            }
            if(!foodCheck.isChecked()){
                food=.091;
            }
            if(!insuranceCheck.isChecked()){
                insurance=.091;
            }
            if(!savingsCheck.isChecked()){
                savings=.091;
            }
            String houseValue = String.valueOf(housing);
            Toast.makeText(this, houseValue, Toast.LENGTH_SHORT).show();

            Intent x = new Intent(BudgetPreferencesActivity.this, ChartActivity.class);
            x.putExtra("housingPercentage", housing);
            x.putExtra("utilsPercentage", utils);
            x.putExtra("funPercentage", fun);
            x.putExtra("personPercentage", person);
            x.putExtra("clothingPercentage", clothing);
            x.putExtra("transportPercentage", transport);
            x.putExtra("foodPercentage", food);
            x.putExtra("insurancePercentage", insurance);
            x.putExtra("savingsPercentage", savings);
            x.putExtra("grossIncome", value);
            startActivity(x);
        }
        else {
            Toast.makeText(this, "Select 3 of the following categories", Toast.LENGTH_SHORT).show();
        }



    }

}
