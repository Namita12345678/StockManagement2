package com.example.stockmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.stockmanagement2.databinding.ActivityCategoriesBinding;
import com.google.android.material.card.MaterialCardView;

public class Categories extends Home {
ActivityCategoriesBinding activityCategoriesBinding;
    MaterialCardView add_brand, manage_brand;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategoriesBinding = ActivityCategoriesBinding.inflate(getLayoutInflater());
        setContentView(activityCategoriesBinding.getRoot());
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        //allocateActivityTitle("Categories");

        add_brand = findViewById(R.id.add_brand);
        manage_brand = findViewById(R.id.manage_brand);

        add_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Categories.this, Add_brand.class));
            }
        });
        manage_brand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Categories.this, Manage_brand.class));
            }
        });

    }
}