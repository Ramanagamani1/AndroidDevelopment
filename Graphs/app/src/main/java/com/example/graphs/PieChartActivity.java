package com.example.graphs;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    PieChart pieChart;
    ArrayList<PieEntry> pieEntries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        pieChart=findViewById(R.id.piechart);
        pieEntries=new ArrayList<>();
        pieEntries.add(new PieEntry((float) 1005.55,"2000"));
        pieEntries.add(new PieEntry((float) 2005.20,"2001"));
        pieEntries.add(new PieEntry((float) 3005.42,"2002"));
        pieEntries.add(new PieEntry((float) 4005.58,"2003"));
        pieEntries.add(new PieEntry((float) 5005.76,"2004"));
        pieEntries.add(new PieEntry((float) 6005.21,"2005"));

        PieDataSet pieDataSet=new PieDataSet(pieEntries,"Marketing");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextSize(17f);
        pieDataSet.setValueTextColor(Color.BLACK);
        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.setCenterText("Marketing");
    }
}