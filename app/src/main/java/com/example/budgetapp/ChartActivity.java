package com.example.budgetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;


public class ChartActivity extends AppCompatActivity {

    private Intent intent;
    double grossIncome;

    AnyChartView anyChartView;

    String[] categories = {"Housing", "Insurance", "Food", "Transportation", "Utilities", "Savings", "Fun", "Clothing", "Personal"};
    double [] money = new double[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        String houseString = getIntent().getExtras().getString("housingPercentage");
        String insuranceString = getIntent().getExtras().getString("insuranceString");
        String foodString = getIntent().getExtras().getString("foodPercentage");
        String transportationString = getIntent().getExtras().getString("transportationPercentage");
        String utilsString = getIntent().getExtras().getString("utilsPercentage");
        String savingsPercentage = getIntent().getExtras().getString("savingsPercentage");
        String funPercentage = getIntent().getExtras().getString("funPercentage");
        String clothingPercentage = getIntent().getExtras().getString("clothingPercentage");
        String personPercentage = getIntent().getExtras().getString("personPercentage");
        String grossIncomeString = getIntent().getExtras().getString("grossIncome");

        grossIncome = Double.parseDouble(grossIncomeString);

        double housePrice = BudgetPreferencesActivity.housing * grossIncome;
        double insurancePrice = BudgetPreferencesActivity.insurance * grossIncome;
        double foodPrice = BudgetPreferencesActivity.food * grossIncome;
        double transportationPrice = BudgetPreferencesActivity.transport * grossIncome;
        double utilsPrice = BudgetPreferencesActivity.utils * grossIncome;
        double savingsPrice = BudgetPreferencesActivity.savings * grossIncome;
        double funPrice = BudgetPreferencesActivity.fun * grossIncome;
        double clothingPrice = BudgetPreferencesActivity.clothing * grossIncome;
        double personPrice = BudgetPreferencesActivity.person * grossIncome;
        money[0] = housePrice;
        money[1] = insurancePrice;
        money[2] = foodPrice;
        money[3] = transportationPrice;
        money[4] = utilsPrice;
        money[5] = savingsPrice;
        money[6] = funPrice;
        money[7] = clothingPrice;
        money[8] = personPrice;


        anyChartView = findViewById(R.id.any_chart_view);
        setupPieChart();
    }

    public void setupPieChart() {
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < categories.length; i++) {
            dataEntries.add(new ValueDataEntry(categories[i], money[i]));
        }

        pie.data(dataEntries);
        anyChartView.setChart(pie);

    }
}

