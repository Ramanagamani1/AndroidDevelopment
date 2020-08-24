package com.example.roomdbexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText editText_name,editText_rollno;
    Student_entity studentEntity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        editText_name=findViewById(R.id.student_name_update);
        editText_rollno=findViewById(R.id.student_rollno_update);
        Intent i=getIntent();
        String sn=i.getStringExtra("name");
        String sr=i.getStringExtra("rollno");
        editText_name.setText(sn);
        editText_rollno.setText(sr);
        editText_rollno.setKeyListener(null);
    }

    public void updateData(View view) {
        String myUpdatename=editText_name.getText().toString();
        String myUpdaterollno=editText_rollno.getText().toString();
        studentEntity=new Student_entity();
        studentEntity.setName(myUpdatename);
        studentEntity.setRollno(myUpdaterollno);
        //MainActivity.dataBase.studentDAO().update(studentEntity);
        MainActivity.viewModel.update(studentEntity);
        Toast.makeText(this, "updated "+myUpdatename+" successfully", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
