package com.example.stockmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.stockmanagement2.databinding.ActivityHome1Binding;

public class Home1 extends Home {

    ActivityHome1Binding activityHome1Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHome1Binding= ActivityHome1Binding.inflate(getLayoutInflater());
        setContentView(activityHome1Binding.getRoot());
        allocateActivityTitle("Home");
    }
}