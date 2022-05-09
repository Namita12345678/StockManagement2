package com.example.stockmanagement2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.stockmanagement2.databinding.ActivityDashboardBinding;
import com.google.android.material.card.MaterialCardView;

public class Dashboard extends Home {

    private static final String TAG = "Dashboard";

    private TextView thedate;
    private Button btngocalendar;


    ActivityDashboardBinding activityDashboardBinding;
    MaterialCardView available_stk, total_order;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
        //allocateActivityTitle("Dashboard");
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        thedate = (TextView) findViewById(R.id.date);
        btngocalendar = (Button) findViewById(R.id.btngocalendar);

        Intent incoming = getIntent();
        String date = incoming.getStringExtra("date");
        thedate.setText(date);

        btngocalendar.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 Intent intent = new Intent(Dashboard.this, CalendarActivity.class);
                                                 startActivity(intent);
                                             }
                                         });

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