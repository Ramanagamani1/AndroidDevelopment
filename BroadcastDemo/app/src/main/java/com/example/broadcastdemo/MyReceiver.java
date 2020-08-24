package com.example.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
     ImageView  obj;
    public MyReceiver(ImageView img) {
        this.obj=img;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        switch (intent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                obj.setImageResource(R.drawable.battery_full);
                Toast.makeText(context, "Battery is full", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                obj.setImageResource(R.drawable.battery_empty);
                Toast.makeText(context, "Battery is low", Toast.LENGTH_SHORT).show();
                break;
        }
       // throw new UnsupportedOperationException("Not yet implemented");
    }
}
