package com.pjatk.pamozad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView bmiField;
    EditText heightInput, weightInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }

    private TextWatcher inputChangedWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}
        @Override
        public void afterTextChanged(Editable s) {
            calculateBmi();
        }
    };

    private void calculateBmi() {
        String weight = weightInput.getText().toString();
        String height = heightInput.getText().toString();

        if (weight != null && !weight.isEmpty() && height != null && !height.isEmpty()) {
            double weightNumeric = Double.parseDouble(weight);
            double heightNumeric = Double.parseDouble(height);

            double bmi = weightNumeric / Math.pow(heightNumeric / 100, 2);

            bmiField.setText(String.format(Locale.getDefault(), "%,.2f", bmi));
        }
    }

    private void setViews() {
        heightInput = findViewById(R.id.etBodyHeightInput);
        weightInput = findViewById(R.id.etBodyWeightInput);
        bmiField = findViewById(R.id.tvBmi);

        heightInput.addTextChangedListener(inputChangedWatcher);
        weightInput.addTextChangedListener(inputChangedWatcher);
    }
}