package com.example.inputcontrols;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_name,et_email,et_phone,et_password;
    RadioButton r_male,r_female;
    CheckBox c_java,c_c,c_cplus;
    Spinner s_branch;
    TextView tv_data;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name=findViewById(R.id.name);
        et_email=findViewById(R.id.email);
        et_phone=findViewById(R.id.mobile);
        et_password=findViewById(R.id.password);
        r_male=findViewById(R.id.male);
        r_female=findViewById(R.id.female);
        c_java=findViewById(R.id.java);
        c_c=findViewById(R.id.c);
        c_cplus=findViewById(R.id.cplus);
        s_branch=findViewById(R.id.branches);
        tv_data=findViewById(R.id.result);
    }

    public void display(View view) {
         String name=et_name.getText().toString();
         String email=et_email.getText().toString();
         String phone=et_phone.getText().toString();
         String password=et_password.getText().toString();

         if(r_male.isChecked()){
             gender=r_male.getText().toString();
         }
         else
             gender=r_female.getText().toString();
         StringBuilder sb=new StringBuilder();

         if(c_java.isChecked()) {
             sb.append(c_java.getText().toString());
             sb.append(",");
         }
         if(c_c.isChecked()) {
             sb.append(c_c.getText().toString());
             sb.append(",");
         }
         if(c_cplus.isChecked()) {
             sb.append(c_cplus.getText().toString());
             sb.append(",");
         }
         String branches=s_branch.getSelectedItem().toString();
        tv_data.setText("Name: "+name+"\n"+"Email: "+email+"\n"+"Mobileno: "+phone+"\n"+
                "Password: "+password+"\n"+ "Gender: "+gender+"\n"+"Skills: "+sb.toString()+"\n"+"Branch: "+branches);

    }
}
