package com.example.android.viewmodelsimpleexample;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    public int teamApoints = 0;
    public int teamBpoints = 0;

    private MutableLiveData<Integer> liveTeamAPoints = new MutableLiveData<>();
    private MutableLiveData<Integer> liveTeamBPoints = new MutableLiveData<>();

    public LiveData<Integer> getTeamAPoints(){
        return liveTeamAPoints;
    }

    public LiveData<Integer> getTeamBPoints(){
        return liveTeamBPoints;
    }

    public void addThreePointsA(){
        teamApoints += 3;
        updateAPoints();
    }

    public void addTwoPointsA(){
        teamApoints += 2;
        updateAPoints();
    }

    public void addThreePointsB(){
        teamBpoints += 3;
        updateBPoints();
    }

    public void addTwoPointsB(){
        teamBpoints += 2;
        updateBPoints();
    }

    public void resetEverything(){
        teamApoints = 0;
        updateAPoints();
        teamBpoints = 0;
        updateBPoints();
    }

    private void updateBPoints(){
        liveTeamBPoints.postValue(teamBpoints);
    }

    private void updateAPoints(){
        liveTeamAPoints.setValue(teamApoints);
    }
}
