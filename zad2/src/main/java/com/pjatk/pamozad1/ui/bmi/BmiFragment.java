package com.pjatk.pamozad1.ui.bmi;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pjatk.pamozad1.R;

import java.util.Locale;

public class BmiFragment extends Fragment {

    @Nullable
    View view;

    TextView bmiField;
    EditText heightInput, weightInput;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_bmi, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViews();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
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
        if (view != null) {
            heightInput = view.findViewById(R.id.etBodyHeightInput);
            weightInput = view.findViewById(R.id.etBodyWeightInput);
            bmiField = view.findViewById(R.id.tvBmi);

            heightInput.addTextChangedListener(inputChangedWatcher);
            weightInput.addTextChangedListener(inputChangedWatcher);
        }
    }
}
