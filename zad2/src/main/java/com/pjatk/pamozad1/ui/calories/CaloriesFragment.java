package com.pjatk.pamozad1.ui.calories;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pjatk.pamozad1.R;

import java.util.Locale;

public class CaloriesFragment extends Fragment {

    @Nullable
    View view;

    boolean isManSelected = true;

    TextView caloriesIntakeField;
    EditText heightInput, weightInput, ageInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_calories, container, false);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViews();
    }

    private void setViews() {
        caloriesIntakeField = view.findViewById(R.id.tvPossibleCalories);

        heightInput = view.findViewById(R.id.etBodyHeightInput);
        weightInput = view.findViewById(R.id.etBodyWeightInput);
        ageInput = view.findViewById(R.id.etAgeInput);

        heightInput.addTextChangedListener(inputChangedWatcher);
        weightInput.addTextChangedListener(inputChangedWatcher);
        ageInput.addTextChangedListener(inputChangedWatcher);

        RadioGroup sexChooserGroup = view.findViewById(R.id.rgSexChooser);
        sexChooserGroup.setOnCheckedChangeListener((group, checkedId) -> {
            isManSelected = checkedId == R.id.rbMan;
            calculateBaseCaloriesIntake();
        });

    }

    private TextWatcher inputChangedWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            calculateBaseCaloriesIntake();
        }
    };

    private void calculateBaseCaloriesIntake() {
        String weight = weightInput.getText().toString();
        String height = heightInput.getText().toString();
        String age = ageInput.getText().toString();

        if (weight != null && !weight.isEmpty() && height != null && !height.isEmpty() && age != null && !age.isEmpty()) {
            double weightNumeric = Double.parseDouble(weight);
            double heightNumeric = Double.parseDouble(height);
            double ageNumeric = Double.parseDouble(age);

            double baseCaloriesIntake;

            if (isManSelected) {
                baseCaloriesIntake = 66.5 + (13.75 * weightNumeric) + (5.003 * heightNumeric) - (6.775 * ageNumeric);
            } else {
                baseCaloriesIntake = 655.1 + (9.563 * weightNumeric) + (1.85 * heightNumeric) - (4.676 * ageNumeric);
            }

            caloriesIntakeField.setText(String.format(Locale.getDefault(), "%,.2f", baseCaloriesIntake));
        }
    }
}
