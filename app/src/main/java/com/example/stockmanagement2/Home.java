package com.example.stockmanagement2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;

public class Home extends AppCompatActivity {

    MaterialCardView iphone_cardview, samsung_cardview, realme_cardview;
    SharedPreferences sp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iphone_cardview = findViewById(R.id.iphone_cardview);
        samsung_cardview = findViewById(R.id.samsung_cardview);
       realme_cardview = findViewById(R.id.realme_cardeview);

        iphone_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Card1.class));
            }
        });

        samsung_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Card2.class));
            }
        });

        realme_cardview.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.this, Card3.class));
            }
        }));

        }

    }



