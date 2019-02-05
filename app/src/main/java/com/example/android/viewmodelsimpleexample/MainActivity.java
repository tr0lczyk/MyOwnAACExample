package com.example.android.viewmodelsimpleexample;

import android.os.Bundle;

import com.example.android.viewmodelsimpleexample.databinding.ActivityMainBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CounterViewModel counterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setViewModel(counterViewModel);
    }
}
