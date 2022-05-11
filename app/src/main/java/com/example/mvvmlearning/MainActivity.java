package com.example.mvvmlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;

import com.example.mvvmlearning.Adapter.ProjectAdapter;
import com.example.mvvmlearning.ViewModel.ProjectViewModel;
import com.example.mvvmlearning.databinding.ActivityMainBinding;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ProjectViewModel projectViewModel;
    private ProjectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.projectRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProjectAdapter();
        binding.projectRecyclerView.setAdapter(adapter);

        projectViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ProjectViewModel.class);

        try {
            adapter.setProjects(projectViewModel.getAllProject());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}