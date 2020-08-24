package com.example.notificationdemo;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import static android.content.Context.NOTIFICATION_SERVICE;

public class SecondClass extends Worker {
    NotificationManager nm;
    PendingIntent pi;
    Intent i;
    public static final String CHANNEL_ID="Nagamani Pasagadugula";
    public SecondClass(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public ListenableWorker.Result doWork() {
        i=new Intent(getApplicationContext(),MainActivity.class);
        pi=PendingIntent.getActivity(getApplicationContext(),123,i,PendingIntent.FLAG_UPDATE_CURRENT);
        nm= (NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        createChannel();
        showMyNotification();
        return ListenableWorker.Result.success();
    }
    private void createChannel() {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.O)
        {
            NotificationChannel nc=new NotificationChannel(CHANNEL_ID,"Nagamani", NotificationManager.IMPORTANCE_HIGH);
            nc.setLightColor(Color.BLUE);
            nc.enableVibration(true);
            nm.createNotificationChannel(nc);
        }
    }
    public void showMyNotification() {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
        builder.setContentTitle("This is my notification");
        builder.setContentText("Never let the world change your smile");
        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setContentIntent(pi);
        nm.notify(12345,builder.build());
    }
}
