package com.example.stockmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.stockmanagement2.databinding.ActivityDashboardBinding;
import com.google.android.material.card.MaterialCardView;

public class Dashboard extends Home {

    ActivityDashboardBinding activityDashboardBinding;
    MaterialCardView available_stk, total_order;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        //allocateActivityTitle("Dashboard");

        available_stk = findViewById(R.id.available_stk);
        total_order = findViewById(R.id.total_order);


        available_stk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Available_stock.class));
            }
        });

        total_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this, Total_order.class));
            }
        });
    }
}