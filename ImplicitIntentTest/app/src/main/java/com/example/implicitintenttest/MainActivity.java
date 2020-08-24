package com.example.implicitintenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeCall(View view) {
        //implicent intent have 2 parameters Action,URI
        Uri u=Uri.parse("tel:9490748991");
        Intent i=new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);
    }

    public void openUrl(View view) {
         Uri u=Uri.parse("https://www.hackerrank.com");
         Intent i=new Intent(Intent.ACTION_VIEW,u);
         startActivity(i);
    }

    public void openMap(View view) {
          // Uri u=Uri.parse("geo:37.7749,-122.4194");
         //if you want to add marker
         // Uri u=Uri.parse("geo:0,0?q=15.7742,78.0568");
          Uri u=Uri.parse("geo:15.7742,78.0568?q=Hospitals");
          Intent i=new Intent(Intent.ACTION_VIEW,u);
          startActivity(i);
    }
}
