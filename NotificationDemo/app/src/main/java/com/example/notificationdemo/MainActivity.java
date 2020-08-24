package com.example.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
   /* NotificationManager nm;
    PendingIntent pi;
    Intent i;

    public static final String CHANNEL_ID="Nagamani Pasagadugula";*/
   OneTimeWorkRequest one;
   PeriodicWorkRequest repeatedwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=new OneTimeWorkRequest.Builder(FirstClass.class).build();
        repeatedwork=new PeriodicWorkRequest.Builder(SecondClass.class,3, TimeUnit.MINUTES).build();
        /*i=new Intent(this,MainActivity.class);
        pi=PendingIntent.getActivity(this,123,i,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);*/
        //createChannel();
    }

    /*private void createChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            NotificationChannel nc=new NotificationChannel(CHANNEL_ID,"Nagamani",NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }
    }*/

    public void showMyNotification(View view) {
        WorkManager.getInstance(this).enqueue(one);
        WorkManager.getInstance(this).enqueue(repeatedwork);

        /*NotificationCompat.Builder builder=new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setContentTitle("This is my notification");
        builder.setContentText("Never let the world change your smile");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        nm.notify(12345,builder.build());*/
    }
}

