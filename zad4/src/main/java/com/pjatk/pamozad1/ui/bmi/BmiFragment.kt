package com.pjatk.pamozad1.ui.bmi

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.pjatk.pamozad1.R
import java.util.*

class BmiFragment : Fragment() {
    var bmiField: TextView? = null
    var heightInput: EditText? = null
    var weightInput: EditText? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_bmi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private val inputChangedWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable) {
            calculateBmi()
        }
    }

    private fun calculateBmi() {
        val weight = weightInput!!.text.toString()
        val height = heightInput!!.text.toString()
        if (weight != null && !weight.isEmpty() && height != null && !height.isEmpty()) {
            val weightNumeric = weight.toDouble()
            val heightNumeric = height.toDouble()
            val bmi = weightNumeric / Math.pow(heightNumeric / 100, 2.0)
            bmiField!!.text = String.format(Locale.getDefault(), "%,.2f", bmi)
        }
    }

    private fun setViews() {
        requireView().let { view ->
            heightInput = view.findViewById<EditText?>(R.id.etBodyHeightInput).also {
                it.addTextChangedListener(inputChangedWatcher)
            }
            weightInput = view.findViewById<EditText?>(R.id.etBodyWeightInput).also {
                it.addTextChangedListener(inputChangedWatcher)
            }
            bmiField = view.findViewById(R.id.tvBmi)

            view.findViewById<ImageButton>(R.id.bGraph).setOnClickListener { view: View? ->
                findNavController(
                    requireView()
                ).navigate(
                    BmiFragmentDirections.actionBmiToBmiGraphFragment()
                )
            }
        }
    }
}