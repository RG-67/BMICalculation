package com.example.bmicalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editAge, editFeet, editInch, editWeight;
    private TextView textView, result;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAge = findViewById(R.id.editAge);
        editFeet = findViewById(R.id.editFeet);
        editInch = findViewById(R.id.editInch);
        editWeight = findViewById(R.id.editWeight);
        textView = findViewById(R.id.textView);
        result = findViewById(R.id.result);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String age = editAge.getText().toString();
                String feet = editFeet.getText().toString();
                String inch = editInch.getText().toString();
                String weight = editWeight.getText().toString();
                double intAge = Double.parseDouble(age);
                double intFeet = Double.parseDouble(feet);
                double intInch = Double.parseDouble(inch);
                double intWeight = Double.parseDouble(weight);
                double inchToFeet = intInch/12;
                double feetToMeter = (intFeet+inchToFeet)/3.281;
                double height = feetToMeter * feetToMeter;
                double bmi = intWeight/height;

                if (intAge>0 && intFeet>0 && intInch>0 && intWeight>0 && bmi<18.5) {
                    result.setText("BMI = " + String.format("%.2f", bmi) + " -- " + "UNDERWEIGHT");
                }
                if (intAge>0 && intFeet>0 && intInch>0 && intWeight>0 && bmi>=18.5 && bmi<=24.9) {
                    result.setText("BMI = " + String.format("%.2f", bmi) + " -- " + "NORMAL WEIGHT");
                }
                if (intAge>0 && intFeet>0 && intInch>0 && intWeight>0 && bmi>=25.0 && bmi<=29.9) {
                    result.setText("BMI = " + String.format("%.2f", bmi) + " -- " + "OVERWEIGHT");
                }
                if (intAge>0 && intFeet>0 && intInch>0 && intWeight>0 && bmi>=30.0 && bmi<=34.9) {
                    result.setText("BMI = " + String.format("%.2f", bmi) + " -- " + "OBESE");
                }
                if (intAge>0 && intFeet>0 && intInch>0 && intWeight>0 && bmi>=35.0) {
                    result.setText("BMI = " + String.format("%.2f", bmi) + " -- " + "EXTREMELY OBESE");
                }
                if (intAge<1 || intFeet<1 || intInch<1 || intWeight<1) {
                    Toast.makeText(MainActivity.this, "Enter valid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AbotBMI.class);
                startActivity(intent);
            }
        });
    }
}