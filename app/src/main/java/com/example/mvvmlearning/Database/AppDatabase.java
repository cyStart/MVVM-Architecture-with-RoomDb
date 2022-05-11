package com.example.mvvmlearning.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ProjectModel.class}, exportSchema = false, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProjectDao projectDao();

    public static final String DATABASE_NAME = "project_db.db";
    public static AppDatabase instance;
    public static final Object LOCK = new Object();

    // creating database name
    public static AppDatabase getDbInstance(Context context) {

        if (instance==null) {
            synchronized (LOCK) {

                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }

        return instance;
    }

}
