package com.example.sipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    RadioGroup radiogroup;
    RadioButton monthRadio;
    RadioButton lumpsumRadio;
    EditText amount;
    EditText interestRate;
    EditText years;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        radioWorking();
        setUpButtonListener();

    }
 
    private void radioWorking() {
        radiogroup = findViewById(R.id.radio_group_one);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radio_button_monthly:
                        String inputAmount = amount.getText().toString();
                        String inputInterestRate = interestRate.getText().toString();
                        String inputYears = years.getText().toString();

                        double finalAmount = Integer.parseInt(inputAmount);
                        double rof = Integer.parseInt(inputInterestRate);
                        double time = Integer.parseInt(inputYears);
                        double principalAmount = finalAmount  * time * 12;

                        double result = principalAmount *
                                (Math.pow((1 + rof / 100), time));

                        String compoundedValue = String.valueOf(result);
                        resultText.setText(compoundedValue);
                }
            }
        });
    }

    private void setUpButtonListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               radioWorking();
            }
        });
    }

//    private void calculateInvestment() {
//        String inputAmount = amount.getText().toString();
//        String inputInterestRate = interestRate.getText().toString();
//        String inputYears = years.getText().toString();
//
//        double finalAmount = Integer.parseInt(inputAmount);
//        double rof = Integer.parseInt(inputInterestRate);
//        double time = Integer.parseInt(inputYears);
//
//        double result = finalAmount *
//                (Math.pow((1 + rof / 100), time));
//
//        String compoundedValue = String.valueOf(result);
//        resultText.setText(compoundedValue);
//
//    }

    private void findViews(){
        resultText = findViewById(R.id.text_view_result);
        monthRadio = findViewById(R.id.radio_button_monthly);
        lumpsumRadio = findViewById(R.id.radio_button_lumpsum);

        amount = findViewById(R.id.edit_text_amount);
        interestRate = findViewById(R.id.edit_text_interestRate);

        years = findViewById(R.id.edit_text_years);
        calculateButton = findViewById(R.id.button_calculate);
    }
}