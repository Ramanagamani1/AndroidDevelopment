package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_pass;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    String name,pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.username);
        et_pass=findViewById(R.id.password);
        sp=getSharedPreferences("nagamani",MODE_PRIVATE);
    }

    public void showDate(View view) {
        name=et_name.getText().toString();
        pwd=et_pass.getText().toString();
        editor=sp.edit();
        editor.putString("n",name);
        editor.putString("p",pwd);
        editor.apply();
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        editor=sp.edit();
        editor.putString("n",name);
        editor.putString("p",pwd);
        editor.apply();
        super.onPause();
    }

    @Override
    protected void onResume() {
        String resname=sp.getString("n","");
        String respwd=sp.getString("p","");
        et_name.setText(resname);
        et_pass.setText(respwd);
        super.onResume();
    }
}
