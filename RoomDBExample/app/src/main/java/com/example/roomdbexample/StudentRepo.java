package com.example.roomdbexample;

import android.app.Application;
import android.os.AsyncTask;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

import androidx.lifecycle.LiveData;

public class StudentRepo {
    StudentDataBase database;
    LiveData<List<Student_entity>> listLiveData;
    public StudentRepo(Application app){
        database=StudentDataBase.getDataBase(app);
        listLiveData=database.studentDAO().livedata();
    }
    public class MyAsyncTaskInsert extends AsyncTask<Student_entity,Void,Void>{

        @Override
        protected Void doInBackground(Student_entity... student_entities) {
            database.studentDAO().insert(student_entities[0]);
            return null;
        }
    }
    public class MyAsyncTaskUpdate extends AsyncTask<Student_entity,Void,Void>{

        @Override
        protected Void doInBackground(Student_entity... student_entities) {
            database.studentDAO().update(student_entities[0]);
            return null;
        }
    }
    public class MyAsyncTaskDelete extends AsyncTask<Student_entity,Void,Void>{

        @Override
        protected Void doInBackground(Student_entity... student_entities) {
            database.studentDAO().delete(student_entities[0]);
            return null;
        }
    }
    public void insert(Student_entity entity){
         new MyAsyncTaskInsert().execute(entity);
    }
    public void update(Student_entity entity){
        new MyAsyncTaskUpdate().execute(entity);
    }
    public void delete(Student_entity entity){
        new MyAsyncTaskDelete().execute(entity);
    }
    public LiveData<List<Student_entity>> liveData(){
        return listLiveData;
    }
}
