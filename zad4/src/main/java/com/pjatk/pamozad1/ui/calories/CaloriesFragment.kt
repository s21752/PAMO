package com.pjatk.pamozad1.ui.calories

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pjatk.pamozad1.R
import java.util.*

class CaloriesFragment : Fragment() {
    var isManSelected = true
    var caloriesIntakeField: TextView? = null
    var heightInput: EditText? = null
    var weightInput: EditText? = null
    var ageInput: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_calories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private fun setViews() = with(requireView()){
        caloriesIntakeField = findViewById(R.id.tvPossibleCalories)
        heightInput = findViewById<EditText?>(R.id.etBodyHeightInput).also {
            it.addTextChangedListener(inputChangedWatcher)
        }
        weightInput = findViewById<EditText?>(R.id.etBodyWeightInput).also {
            it.addTextChangedListener(inputChangedWatcher)
        }
        ageInput = findViewById<EditText?>(R.id.etAgeInput).also {
            it.addTextChangedListener(inputChangedWatcher)
        }
        val sexChooserGroup = findViewById<RadioGroup>(R.id.rgSexChooser)
        sexChooserGroup.setOnCheckedChangeListener { group: RadioGroup?, checkedId: Int ->
            isManSelected = checkedId == R.id.rbMan
            calculateBaseCaloriesIntake()
        }
    }

    private val inputChangedWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            calculateBaseCaloriesIntake()
        }
    }

    private fun calculateBaseCaloriesIntake() {
        val weight = weightInput!!.text.toString()
        val height = heightInput!!.text.toString()
        val age = ageInput!!.text.toString()
        if (weight != null && weight.isNotEmpty() && height != null && height.isNotEmpty() && age != null && age.isNotEmpty()) {
            val weightNumeric = weight.toDouble()
            val heightNumeric = height.toDouble()
            val ageNumeric = age.toDouble()
            val baseCaloriesIntake = if (isManSelected) {
                66.5 + 13.75 * weightNumeric + 5.003 * heightNumeric - 6.775 * ageNumeric
            } else {
                655.1 + 9.563 * weightNumeric + 1.85 * heightNumeric - 4.676 * ageNumeric
            }
            caloriesIntakeField!!.text =
                String.format(Locale.getDefault(), "%,.2f", baseCaloriesIntake)
        }
    }
}