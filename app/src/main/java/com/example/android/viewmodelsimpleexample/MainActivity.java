package com.example.android.viewmodelsimpleexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.android.viewmodelsimpleexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CounterViewModel counterViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        counterViewModel = ViewModelProviders.of(this).get(CounterViewModel.class);

        counterViewModel.getTeamAPoints().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displayPointsA(integer);
            }
        });

        counterViewModel.getTeamBPoints().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                displayPointsB(integer);
            }
        });

        binding.buttonB3.setOnClickListener(view -> counterViewModel.addThreePointsB());

        binding.buttonB2.setOnClickListener(view -> counterViewModel.addTwoPointsB());

        binding.buttonA3.setOnClickListener(view -> counterViewModel.addThreePointsA());

        binding.buttonA2.setOnClickListener(view -> counterViewModel.addTwoPointsA());

        binding.buttonReset.setOnClickListener(view -> counterViewModel.resetEverything());
    }



    public void displayPointsA(int points){
        binding.textViewPointsA.setText(String.valueOf(points));
    }

    public void displayPointsB(int points){
        binding.textViewPointsB.setText(String.valueOf(points));
    }
}
