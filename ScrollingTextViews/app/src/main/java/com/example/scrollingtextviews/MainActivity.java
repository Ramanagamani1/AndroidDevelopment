package com.example.scrollingtextviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.images);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  img.setImageResource(R.drawable.image_colors);
                Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
