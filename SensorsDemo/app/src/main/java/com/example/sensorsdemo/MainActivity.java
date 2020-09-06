package com.example.sensorsdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.github.nisrulz.sensey.LightDetector;
import com.github.nisrulz.sensey.Sensey;
import com.github.nisrulz.sensey.ShakeDetector;
import com.github.nisrulz.sensey.TouchTypeDetector;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Switch s1,s2,s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1=findViewById(R.id.shake);
        s2=findViewById(R.id.light);
        s3=findViewById(R.id.touch);
        tv=findViewById(R.id.tv);
        Sensey.getInstance().init(MainActivity.this);
        final ShakeDetector.ShakeListener shakeListener= new ShakeDetector.ShakeListener() {
            @Override
            public void onShakeDetected() {
                   tv.setText("Shake Sensor Detected");
            }

            @Override
            public void onShakeStopped() {
                 tv.setText("Shake Sensor Stopped");
            }
        };
        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Sensey.getInstance().startShakeDetection(shakeListener);
                }else{
                    Sensey.getInstance().stopShakeDetection(shakeListener);
                }
            }
        });
        final LightDetector.LightListener lightListener=new LightDetector.LightListener() {
            @Override
            public void onDark() {
                tv.setText("Dark Mode");
            }

            @Override
            public void onLight() {
                      tv.setText("Light Mode");
            }
        };
        s2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Sensey.getInstance().startLightDetection(lightListener);
                }else{
                    Sensey.getInstance().stopLightDetection(lightListener);
                }
            }
        });
        final TouchTypeDetector.TouchTypListener touchTypListener=new TouchTypeDetector.TouchTypListener() {
            @Override
            public void onDoubleTap() {
                tv.setText("Double tapped");
            }

            @Override
            public void onLongPress() {
                tv.setText("Long pressed");
            }

            @Override
            public void onScroll(int i) {
                 tv.setText("Scrolled");
            }

            @Override
            public void onSingleTap() {
                 tv.setText("single tapped");
            }

            @Override
            public void onSwipe(int i) {
                 tv.setText("swiped");
            }

            @Override
            public void onThreeFingerSingleTap() {
                   tv.setText("Three fingers singletap");
            }

            @Override
            public void onTwoFingerSingleTap() {
                  tv.setText("Two fingers singletap");
            }
        };
        s3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    Sensey.getInstance().startTouchTypeDetection(MainActivity.this,touchTypListener);
                }
                else{
                    Sensey.getInstance().stopTouchTypeDetection();
                }
            }
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Sensey.getInstance().setupDispatchTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Sensey.getInstance().stop();
    }
}