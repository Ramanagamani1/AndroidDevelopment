package com.example.hellotoast;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    int count=0;
    TextView tv;
    protected static final String KEY="Nagamani";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.mytextview);
        if (savedInstanceState!=null && savedInstanceState.containsKey(KEY)){
            count=savedInstanceState.getInt(KEY);
            tv.setText(String.valueOf(count));
        }
    }

    public void showToastMessage(View view) {

        Toast.makeText(this, "Count is :"+count, Toast.LENGTH_SHORT).show();
    }

    public void increaseCount(View view) {

        count++;
        tv.setText(String.valueOf(count));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY,count);
    }
}
