package com.example.roomdbexample;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MyViewModel extends AndroidViewModel {

    StudentRepo studentRepo;
    LiveData<List<Student_entity>> listLiveData;
    public MyViewModel(@NonNull Application application) {
        super(application);
        studentRepo=new StudentRepo(application);
        listLiveData=studentRepo.liveData();
    }
    public void insert(Student_entity entity){
        studentRepo.insert(entity);
    }
    public void update(Student_entity entity){
        studentRepo.update(entity);
    }
    public void delete(Student_entity entity){
        studentRepo.delete(entity);
    }
    public LiveData<List<Student_entity>> liveData(){
        return listLiveData;
    }

}
