package com.example.mvvmlearning.Repository;

import android.content.Context;

import androidx.room.ColumnInfo;

import com.example.mvvmlearning.Database.AppDatabase;
import com.example.mvvmlearning.Database.ProjectModel;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppRepo {

    private AppDatabase appDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();


    public AppRepo(Context context) {
        appDatabase = AppDatabase.getDbInstance(context);
    }

    public void insertProject(ProjectModel projectModel) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.projectDao().insertProject(projectModel);
            }
        });

    }

    public void updateProject(ProjectModel projectModel) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.projectDao().updateProject(projectModel);
            }
        });
    }

    public void deleteProject(ProjectModel projectModel) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                appDatabase.projectDao().deleteProject(projectModel);
            }
        });
    }

    public List<ProjectModel> getAllProject() throws ExecutionException, InterruptedException {

        Callable<List<ProjectModel>> callable = new Callable<List<ProjectModel>>() {
            @Override
            public List<ProjectModel> call() throws Exception {
                return appDatabase.projectDao().getAllProjects();
            }
        };

        Future<List<ProjectModel>> future = Executors.newSingleThreadExecutor().submit(callable);
        return future.get();

    }
}
