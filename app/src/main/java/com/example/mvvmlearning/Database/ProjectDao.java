package com.example.mvvmlearning.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProjectDao {

    @Query("SELECT * FROM projectmodel")
    List<ProjectModel> getAllProjects();

    @Query("SELECT * FROM projectmodel WHERE pId=:id")
    ProjectModel getProject(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProject(ProjectModel projectModel);

    @Update
    void updateProject(ProjectModel projectModel);

    @Delete
    void deleteProject(ProjectModel projectModel);


//    @Delete
//    List<Integer> deleteListofProject(List<ProjectModel> projectModelList);
//
//    @Update
//    List<Integer> updateListofProject(List<ProjectModel> projectModelList);
//
//    @Insert
//    List<Integer> insertListofProject(List<ProjectModel> projectModelList);

}
