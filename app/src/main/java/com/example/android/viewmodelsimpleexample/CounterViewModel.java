package com.example.android.viewmodelsimpleexample;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    public int teamApoints = 0;
    public int teamBpoints = 0;

    private MutableLiveData<Integer> liveTeamAPoints = new MutableLiveData<>();
    private MutableLiveData<Integer> liveTeamBPoints = new MutableLiveData<>();

    public LiveData<Integer> teamAPoints(){
        return liveTeamAPoints;
    }

    public LiveData<Integer> teamBPoints(){
        return liveTeamBPoints;
    }

    public void addThreePointsA(View view){
        teamApoints += 3;
        updateAPoints();
    }

    public void addTwoPointsA(View view){
        teamApoints += 2;
        updateAPoints();
    }

    public void addThreePointsB(View view){
        teamBpoints += 3;
        updateBPoints();
    }

    public void addTwoPointsB(View view){
        teamBpoints += 2;
        updateBPoints();
    }

    public void resetEverything(View view){
        teamApoints = 0;
        updateAPoints();
        teamBpoints = 0;
        updateBPoints();
    }

    private void updateBPoints(){
        liveTeamBPoints.setValue(teamBpoints);
    }

    private void updateAPoints(){
        liveTeamAPoints.setValue(teamApoints);
    }
}
