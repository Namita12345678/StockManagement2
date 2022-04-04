package com.example.stockmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.stockmanagement2.databinding.ActivityCategoriesBinding;

public class Categories extends Home {
ActivityCategoriesBinding activityCategoriesBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategoriesBinding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(activityCategoriesBinding.getRoot());
        //allocateActivityTitle("Categories");
    }
}