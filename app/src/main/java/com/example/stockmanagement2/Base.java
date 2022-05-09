package com.example.stockmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.stockmanagement2.databinding.ActivityBaseBinding;
import com.google.android.material.card.MaterialCardView;

import org.intellij.lang.annotations.JdkConstants;



public class Base extends Home {



    ActivityBaseBinding activityBaseBinding;

    MaterialCardView iphone_cardview, samsung_cardview, realme_cardview;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBaseBinding= ActivityBaseBinding.inflate(getLayoutInflater());
        setContentView(activityBaseBinding.getRoot());

        iphone_cardview = findViewById(R.id.iphone_cardview);
        samsung_cardview = findViewById(R.id.samsung_cardview);
        realme_cardview = findViewById(R.id.realme_cardeview);

        getSupportActionBar().setDisplayShowHomeEnabled(false);

        iphone_cardview.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(Base.this, Card1.class));
            }
        });
        samsung_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Base.this, Card2.class));
            }
        });
        realme_cardview.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick (View view){
                startActivity(new Intent(Base.this, Card3.class));
            }
        }));

        allocateActivityTitle("");

    }
}