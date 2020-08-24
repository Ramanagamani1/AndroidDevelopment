package com.example.menusalertspickersexample;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button b_datepicker,b_timepicker;
    int c_year,c_month,c_date;
    int mhours,mMinutes,mSeconds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_datepicker=findViewById(R.id.datepicker);
        b_timepicker=findViewById(R.id.timepicker);
        b_datepicker.setOnClickListener(this);
        b_timepicker.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.ap:
                Toast.makeText(this, "You selected Apssdc", Toast.LENGTH_SHORT).show();
                break;
            case R.id.hacker:
                Toast.makeText(this, "You selected Hackerearth", Toast.LENGTH_SHORT).show();
                break;
            case R.id.alert:
                showAlert();
                Toast.makeText(this, "You selected AlertDialog", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //create an alert dialog
    public void showAlert(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alert!");
        builder.setMessage("Do you want to close app..?");
        builder.setIcon(R.drawable.ic_add_alert_black_24dp);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
    //date and time pickers
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.datepicker: openDatePicker();
                                   break;
            case R.id.timepicker: openTimePicker();
                                    break;
        }
    }

    private void openDatePicker() {
        Calendar c=Calendar.getInstance();
        c_year=c.get(Calendar.YEAR);
        c_month=c.get(Calendar.MONTH);
        c_date=c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String date=dayOfMonth+"-"+(month+1)+"-"+year;
                Toast.makeText(MainActivity.this, "Today's date is "+date, Toast.LENGTH_SHORT).show();
            }
        },c_year,c_month,c_date);
        datePickerDialog.show();
    }

    private void openTimePicker() {
      Calendar c=Calendar.getInstance();
      mhours=c.get(Calendar.HOUR_OF_DAY);
      mMinutes=c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
               String time=hourOfDay+":"+minute;
                Toast.makeText(MainActivity.this, "Time is "+time, Toast.LENGTH_SHORT).show();
            }
        },mhours,mMinutes,false);
        timePickerDialog.show();
    }
}
