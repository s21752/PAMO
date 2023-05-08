package com.pjatk.pamozad1.ui.bmi.graph

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.EntryXComparator
import com.pjatk.pamozad1.R

class BmiGraphFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_bmi_graph, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mockData()
    }

    private fun mockData() {
        val chart = requireView().findViewById<LineChart>(R.id.bcBarChart)
        val dataSet = dataSet // add entries to dataset
        dataSet.color = Color.BLACK
        dataSet.valueTextColor = Color.BLACK
        val lineData = LineData(dataSet)
        val description = Description()
        description.text = "Bmi change chart"
        chart.description = description
        chart.data = lineData
        chart.invalidate()
    }

    private val dataSet: LineDataSet
        private get() {
            val valueSet1 = mutableListOf<Entry>()
            val v1e1 = Entry(0f, 21.00f)
            valueSet1.add(v1e1)
            val v1e2 = Entry(1f, 24.50f)
            valueSet1.add(v1e2)
            val v1e3 = Entry(2f, 20.00f)
            valueSet1.add(v1e3)
            val v1e4 = Entry(3f, 18.00f)
            valueSet1.add(v1e4)
            val v1e5 = Entry(4f, 30.45f)
            valueSet1.add(v1e5)
            val v1e6 = Entry(5f, 28.00f)
            valueSet1.add(v1e6)

            valueSet1.sortWith(EntryXComparator())
            val lineDataSet1 = LineDataSet(valueSet1, getString(R.string.bmiLabel))
            lineDataSet1.color = Color.rgb(0, 155, 0)
            return lineDataSet1
        }
}