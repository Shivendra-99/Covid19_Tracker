package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static com.example.covid19tracker.MainActivity.acti;
import static com.example.covid19tracker.MainActivity.confi;
import static com.example.covid19tracker.MainActivity.dead;
import static com.example.covid19tracker.MainActivity.reco;
import static com.example.covid19tracker.MainActivity.state;
public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        PieChart chart=findViewById(R.id.chart);
        TextView textView=findViewById(R.id.state);
        float active=Float.parseFloat(intent.getStringExtra(acti));
        float death=Float.parseFloat(intent.getStringExtra(dead));
        float conf=Float.parseFloat(intent.getStringExtra(confi));
        float rec=Float.parseFloat(intent.getStringExtra(reco));
        String s=intent.getStringExtra(state);
        textView.setText(s);
        ArrayList<PieEntry>  b=new ArrayList();
        b.add(new PieEntry(conf,"Confirmed"));
        b.add(new PieEntry(death,"Death"));
        b.add(new PieEntry(active,"Active"));
        b.add(new PieEntry(rec,"Recovered"));
        PieDataSet dataSet=new PieDataSet(b,"Data Value");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.animateXY(5000,5000);
        PieData pieData=new PieData(dataSet);
        chart.setData(pieData);
        chart.setCenterText("Covid 19");
        chart.setCenterTextSize(30f);
        pieData.setValueTextSize(20f);
        chart.animate();

    }
}