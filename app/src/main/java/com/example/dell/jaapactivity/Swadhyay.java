package com.example.dell.jaapactivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dell.jaapactivity.ReportManager.ReportData;
import com.example.dell.jaapactivity.ReportManager.ReportDataBaseHandler;
import com.example.dell.jaapactivity.Swadhaya.SwadhyayData;
import com.example.dell.jaapactivity.Swadhaya.SwadhyayDatabaseHandler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Swadhyay extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
     EditText swadhyayTime;
     TextView swadhyayTextView;
     TextView swadhyayaTv;
     SharedPreferences sharedPreferences;
     SharedPreferences.Editor editor;
     TextView timerTextView;
     Button startSwadhyay;
     Button stopSwadhyay;
     Long time_in_minutes = 0l;
     Long time_in_milli = 0l;
     int id=0;
    float actualTime = 0f;
     MyCountdownTimer myCountdownTimer;
     public static final String SWADHYAYPREFERENCES = "TimePref";
     public static final String ENTERED_TIME = "time_entered";
    private static final String TAG = "SwadhyayActivity";
    SwadhyayDatabaseHandler sDb = new SwadhyayDatabaseHandler(this);

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swadhyay);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_scrolling);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_scrolling);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        swadhyayTextView = findViewById(R.id.textViewSwadhyay);
        timerTextView = findViewById(R.id.swadhyayTimer);
        startSwadhyay = findViewById(R.id.startSwadhyay);
        stopSwadhyay = findViewById(R.id.stopSwadhyay);
        swadhyayaTv = findViewById(R.id.swadhyayTimermilli);
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.prompts,null);

        Date currentTime = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("MMM");
        final String formattedDate = df.format(currentTime);

        SimpleDateFormat timeFormat = new SimpleDateFormat("dd");
        final String formattedTime = timeFormat.format(currentTime);

        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");
        final String formattedDay = dayFormat.format(currentTime);

        Calendar calender = Calendar.getInstance();
        final int year  = calender.get(Calendar.YEAR);


        //
        final ReportDataBaseHandler rDb = new ReportDataBaseHandler(this);

        //adding dummy data to the database

        rDb.addUserReportData(new ReportData("Swadhyay","Dec","22",
                "Sun",4L,2l,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","24",
                "Tue",3L,2L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","27",
                "Fri",6L,2L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","29",
                "Sun",1L,1L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","30",
                "Sun",7L,2L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","30",
                "Sun",8L,2L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","30",
                "Sun",3L,2L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","31",
                "Mon",6L,2L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","31",
                "Mon",6L,2L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Dec","31",
                "Mon",3L,2L,"2018"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","1",
                "Tue",7L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","2",
                "Wed",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","3",
                "Thu",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","4",
                "Fri",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","6",
                "Sun",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","8",
                "Tue",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","9",
                "Wed",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","11",
                "Fri",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","12",
                "Sat",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","24",
                "Sun",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","26",
                "Tue",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","28",
                "Wed",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","29",
                "Fri",4L,2L,"2019"));
        rDb.addUserReportData(new ReportData("Swadhyay","Jan","30",
                "Sat",4L,2L,"2019"));



        //Alert dialog builder
        AlertDialog.Builder alertDialogBuilder =  new AlertDialog.Builder(this);
        alertDialogBuilder.setView(promptsView);

        swadhyayTime = promptsView.findViewById(R.id.editTextDialogUserInput);
        //shared preferences for storing time
        sharedPreferences = getSharedPreferences(SWADHYAYPREFERENCES, Context.MODE_PRIVATE);


        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        id++;
                        swadhyayTextView.setText(swadhyayTime.getText());
                        time_in_minutes = Long.parseLong(String.valueOf(swadhyayTime.getText()));
                        time_in_milli = time_in_minutes * 60000;
                        Log.d(TAG, "onClick: Time in minutes: "+ time_in_minutes);
                        Log.d(TAG, "onClick: Time in milli seconds: "+ time_in_milli);
                        editor = sharedPreferences.edit();
                        editor.putLong(ENTERED_TIME,time_in_milli);
                        editor.apply();

                        
                        


                    }
                });
        alertDialogBuilder
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

         startSwadhyay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startSwadhyay.setEnabled(false);
                 Log.d(TAG, "onClick: startSwadhyay button clicked ");
                    sharedPreferences = getSharedPreferences(SWADHYAYPREFERENCES,Context.MODE_PRIVATE);
                    Long timer_time = sharedPreferences.getLong(ENTERED_TIME,0);
                 Log.d(TAG, "onClick: time slected "+ timer_time);
                    myCountdownTimer = new MyCountdownTimer(timer_time,100);
                    myCountdownTimer.start();

                 long inserted = sDb.addSwadhyay(new SwadhyayData(time_in_minutes));
                 Log.d(TAG, "onClick: Inserted : "+inserted);
                 List<SwadhyayData> swadhyayDataList = sDb.getAllSwadhyayData();
                 for(SwadhyayData sd : swadhyayDataList){
                     String log = "Id : "+ sd.getId() + ", Time : "+ sd.getTime();
                     Log.d(TAG, "onClick: Data "+ log);
                 }


                 long reportInserted = rDb.addUserReportData(new ReportData("Swadhyay",formattedDate,formattedTime,formattedDay,
                         Long.parseLong(String.valueOf(time_in_minutes)),Long.parseLong(String.valueOf(time_in_minutes)),String.valueOf(year)));
                 Log.d(TAG, "onClick: report inserted : "+ reportInserted);
                 List<ReportData> reportDataList = rDb.getAllUserReportData();
                 Log.d(TAG, "onClick: "+reportDataList);
                 for (ReportData rp : reportDataList) {
                     Log.d(TAG, "onClick: For loop");
                     String reportLog = "Id: "+rp.getId() //0
                             + ", Mode: "+ rp.getMode()   //1
                             + ", User Time: "+ rp.getUserTime() //2
                             + ", Actual Time: "+ rp.getActualTime() //3
                             + ", Date : "+rp.getDate() //4
                             + ", Time : "+rp.getTime()  //5
                             + ", Day: "+rp.getDay()  //6
                             + ", Type: "+rp.getType() //7
                             + ", Audio Name : "+rp.getAudioName(); //8
                     Log.d("Report: ",reportLog);
                 }
             }
         });

         stopSwadhyay.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 actualTime = time_in_milli - Long.parseLong(String.valueOf(swadhyayaTv.getText()));
                 startSwadhyay.setEnabled(true);
                 timerTextView.setText("00:00:00");
                 myCountdownTimer.cancel();

                 rDb.getLastId();
                 Log.d(TAG, "onClick: last Id "+ rDb.getLastId());

                 //update actual time
                 rDb.updateData(String.valueOf(rDb.getLastId()),actualTime/60000);
                 List<ReportData> reportDataList = rDb.getAllUserReportData();
                 Log.d(TAG, "onClick: "+reportDataList);
                 for (ReportData rp : reportDataList) {
                     Log.d(TAG, "onClick: For loop");
                     String reportLog = "Id: "+rp.getId() //0
                             + ", Mode: "+ rp.getMode()   //1
                             + ", User Time: "+ rp.getUserTime() //2
                             + ", Actual Time: "+ rp.getActualTime() //3
                             + ", Date : "+rp.getDate() //4
                             + ", Time : "+rp.getTime()  //5
                             + ", Day: "+rp.getDay()  //6
                             + ", Type: "+rp.getType() //7
                             + ", Audio Name: "+ rp.getAudioName();//8
                     Log.d("Report: ",reportLog);
                 }
             }
         });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.all_reports) {
            // Handle the camera action
            Intent reportsIntet = new Intent(Swadhyay.this,ReportActivity.class);
            startActivity(reportsIntet);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class MyCountdownTimer extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public  MyCountdownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                    TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
            swadhyayaTv.setText(String.valueOf(millisUntilFinished));
            timerTextView.setText(hms);
        }
        @Override
        public void onFinish() {

        }
    }
}
