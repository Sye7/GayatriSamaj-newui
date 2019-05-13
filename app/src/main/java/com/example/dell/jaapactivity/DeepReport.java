package com.example.dell.jaapactivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dell.jaapactivity.ReportManager.ReportDataBaseHandler;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import androidx.annotation.RequiresApi;

public class DeepReport extends AppCompatActivity {


    ReportDataBaseHandler rDb = new ReportDataBaseHandler(this);
    TextView v1;
    TextView v2;
    TextView v3;

    TextView h1;
    TextView h2;

    private BarChart deepBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_report);

        Intent intent  = getIntent();
        String head = intent.getStringExtra("name");

        v1  = findViewById(R.id.Dday);
        v2  = findViewById(R.id.Dmonth);

        h1  = findViewById(R.id.dh1);
        h2  = findViewById(R.id.dh2);

        deepBar = findViewById(R.id.deepBar);

        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_WEEK);

        int month = Calendar.getInstance().get(Calendar.MONTH);


        if(head.equalsIgnoreCase("Total Meditation"))
        {
            // Head
            h1.setText("Daily Meditation");
            h2.setText("Monthly Meditation");


            // Values
            v2.setText(rDb.totalDaysTime(today - 1));
            v1.setText(rDb.totalMonthTime(month  ));




            ArrayList<BarEntry> overAllBar = new ArrayList<BarEntry>();
            overAllBar.add(new BarEntry(1,rDb.totalDaysTime(today -1)));
            overAllBar.add(new BarEntry(2,rDb.totalMonthTime(month)));





            BarDataSet overAllBarSet = new BarDataSet(overAllBar,"deepData");
            BarData barData = new BarData(overAllBarSet);
            deepBar.setData(barData);
            overAllBarSet.setLabel("Monthly, Daily");

            int[] c = {Color.parseColor("#5C6BC0"),Color.parseColor("#33691E"),Color.parseColor("#424242"),Color.parseColor("#00E676")};
            overAllBarSet.setColors(c);
            // overAllBarSet.setStackLabels(labels);
            //lineChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
            overAllBarSet.setColors(ColorTemplate.MATERIAL_COLORS);
            deepBar.animateXY(3000,3000);
            overAllBarSet.setBarBorderColor(Color.BLACK);
            overAllBarSet.setBarBorderWidth(0.7f);
            overAllBarSet.setHighLightAlpha(3);
            deepBar.setFitBars(true);

            // change width
            overAllBarSet.setBarBorderWidth(0.00075f);


        }
        else if (head.equalsIgnoreCase("Total Japs"))
        {

            h1.setText("Daily Japs");
            h2.setText("Monthly Japs");


            // Values
            v2.setText(rDb.totalDaysTime(today - 1) +"");
            v1.setText(rDb.totalMonthTime(month ) + "");

            ArrayList<BarEntry> overAllBar = new ArrayList<BarEntry>();
            overAllBar.add(new BarEntry(1,rDb.totalDaysTime(today -1)));
            overAllBar.add(new BarEntry(2,rDb.totalMonthTime(month)));





            BarDataSet overAllBarSet = new BarDataSet(overAllBar,"deepData");
            BarData barData = new BarData(overAllBarSet);
            deepBar.setData(barData);
            overAllBarSet.setLabel("Monthly, Daily");

            int[] c = {Color.parseColor("#5C6BC0"),Color.parseColor("#33691E"),Color.parseColor("#424242"),Color.parseColor("#00E676")};
            overAllBarSet.setColors(c);
            // overAllBarSet.setStackLabels(labels);
            //lineChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
            overAllBarSet.setColors(ColorTemplate.MATERIAL_COLORS);
            deepBar.animateXY(3000,3000);
            overAllBarSet.setBarBorderColor(Color.BLACK);
            overAllBarSet.setBarBorderWidth(0.7f);
            overAllBarSet.setHighLightAlpha(3);
            deepBar.setFitBars(true);

            // change width
            overAllBarSet.setBarBorderWidth(0.00075f);



        }

        else if (head.equalsIgnoreCase("Total Swadhyay"))
        {

            h1.setText("Daily Swadhyay");
            h2.setText("Monthly Swadhyay");


            // Values
            v2.setText(rDb.totalDaysTime(today - 1) +"");
            v1.setText(rDb.totalMonthTime(month ) + "");

            ArrayList<BarEntry> overAllBar = new ArrayList<BarEntry>();
            overAllBar.add(new BarEntry(1,rDb.totalDaysTime(today -1)));
            overAllBar.add(new BarEntry(2,rDb.totalMonthTime(month)));





            BarDataSet overAllBarSet = new BarDataSet(overAllBar,"deepData");
            BarData barData = new BarData(overAllBarSet);
            deepBar.setData(barData);
            overAllBarSet.setLabel("Monthly, Daily");

            int[] c = {Color.parseColor("#5C6BC0"),Color.parseColor("#33691E"),Color.parseColor("#424242"),Color.parseColor("#00E676")};
            overAllBarSet.setColors(c);
            // overAllBarSet.setStackLabels(labels);
            //lineChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
            overAllBarSet.setColors(ColorTemplate.MATERIAL_COLORS);
            deepBar.animateXY(3000,3000);
            overAllBarSet.setBarBorderColor(Color.BLACK);
            overAllBarSet.setBarBorderWidth(0.7f);
            overAllBarSet.setHighLightAlpha(3);
            deepBar.setFitBars(true);

            // change width
            overAllBarSet.setBarBorderWidth(0.00075f);


        }
        else
        {

            h1.setText("Daily Yagya");
            h2.setText("Monthly Yagya");


            // Values
            v2.setText(rDb.totalDaysTime(today - 1) +"");
            v1.setText(rDb.totalMonthTime(month ) + "");

            ArrayList<BarEntry> overAllBar = new ArrayList<BarEntry>();
            overAllBar.add(new BarEntry(1,rDb.totalDaysTime(today -1)));
            overAllBar.add(new BarEntry(2,rDb.totalMonthTime(month)));





            BarDataSet overAllBarSet = new BarDataSet(overAllBar,"deepData");
            BarData barData = new BarData(overAllBarSet);
            deepBar.setData(barData);
            overAllBarSet.setLabel("Monthly, Daily");

            int[] c = {Color.parseColor("#5C6BC0"),Color.parseColor("#33691E"),Color.parseColor("#424242"),Color.parseColor("#00E676")};
            overAllBarSet.setColors(c);
            // overAllBarSet.setStackLabels(labels);
            //lineChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
            overAllBarSet.setColors(ColorTemplate.MATERIAL_COLORS);
            deepBar.animateXY(3000,3000);
            overAllBarSet.setBarBorderColor(Color.BLACK);
            overAllBarSet.setBarBorderWidth(0.7f);
            overAllBarSet.setHighLightAlpha(3);
            deepBar.setFitBars(true);

            // change width
            overAllBarSet.setBarBorderWidth(0.00075f);


        }






    }
}
