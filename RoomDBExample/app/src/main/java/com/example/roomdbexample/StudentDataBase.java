package com.example.roomdbexample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Student_entity.class,version = 1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
    private  static StudentDataBase database;
    public abstract StudentDAO studentDAO();
    public static synchronized StudentDataBase getDataBase(Context context){
        if(database==null) {
            database = Room.databaseBuilder(context, StudentDataBase.class, "studentdb")
                    .allowMainThreadQueries()
                    .build();
        }
        return database;
    }



}
