package com.example.roomdbexample;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    EditText sname,srollno;
    RecyclerView r;
    static  StudentDataBase dataBase;
    Student_entity studentEntity;
    List<Student_entity> studentEntityList;
    StudentAdapter adapter;
    static MyViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sname=findViewById(R.id.student_name);
        srollno=findViewById(R.id.student_rollno);
        r=findViewById(R.id.recycler);
        /*dataBase= Room.databaseBuilder(this,StudentDataBase.class,"Nagamani")
           .allowMainThreadQueries()
                .build();*/
        viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.liveData().observe(this, new Observer<List<Student_entity>>() {
            @Override
            public void onChanged(List<Student_entity> student_entities) {
                adapter=new StudentAdapter(MainActivity.this,student_entities);
                r.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                r.setAdapter(adapter);
            }
        });

    }

    public void saveData(View view) {
        String myname=sname.getText().toString();
        String myrollno=srollno.getText().toString();
        studentEntity=new Student_entity();
        studentEntity.setName(myname);
        studentEntity.setRollno(myrollno);
        //dataBase.studentDAO().insert(studentEntity);
        viewModel.insert(studentEntity);
        Toast.makeText(this, "inserted successfully", Toast.LENGTH_SHORT).show();
    }


    /*public void retrieveData(View view) {
        studentEntityList= dataBase.studentDAO().retrive();
        adapter=new StudentAdapter(this,studentEntityList);
        r.setLayoutManager(new LinearLayoutManager(this));
        r.setAdapter(adapter);
    }*/
}
