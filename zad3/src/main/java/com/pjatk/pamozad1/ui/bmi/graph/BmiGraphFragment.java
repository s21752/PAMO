package com.pjatk.pamozad1.ui.bmi.graph;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.EntryXComparator;
import com.pjatk.pamozad1.R;

import java.util.ArrayList;
import java.util.Collections;

public class BmiGraphFragment extends Fragment {

    @Nullable
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_bmi_graph, container, false);
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
        mockData();
    }

    private void mockData() {

        LineChart chart = view.findViewById(R.id.bcBarChart);

        LineDataSet dataSet = getDataSet(); // add entries to dataset
        dataSet.setColor(Color.BLACK);
        dataSet.setValueTextColor(Color.BLACK);

        LineData lineData = new LineData(dataSet);
        Description description = new Description();
        description.setText("Bmi change chart");
        chart.setDescription(description);
        chart.setData(lineData);
        chart.invalidate();
    }

    private LineDataSet getDataSet() {
        ArrayList valueSet1 = new ArrayList();
        Entry v1e1 = new Entry(0, 21.00f);
        valueSet1.add(v1e1);
        Entry v1e2 = new Entry(1, 24.50f);
        valueSet1.add(v1e2);
        Entry v1e3 = new Entry(2, 20.00f);
        valueSet1.add(v1e3);
        Entry v1e4 = new Entry(3, 18.00f);
        valueSet1.add(v1e4);
        Entry v1e5 = new Entry(4, 30.45f);
        valueSet1.add(v1e5);
        Entry v1e6 = new Entry(5, 28.00f);
        valueSet1.add(v1e6);

        Collections.sort(valueSet1, new EntryXComparator());
        LineDataSet lineDataSet1 = new LineDataSet(valueSet1, getString(R.string.bmiLabel));
        lineDataSet1.setColor(Color.rgb(0, 155, 0));

        return lineDataSet1;
    }

    private ArrayList getXAxisValues() {
        ArrayList xAxis = new ArrayList();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }
}
