package com.example.roomdbexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    public void insert(Student_entity entity);
    @Update
    public void update(Student_entity entity);
    @Delete
    public void delete(Student_entity entity);

    @Query("select * from student_table")
    //public List<Student_entity> retrive();
    public LiveData<List<Student_entity>> livedata();
}