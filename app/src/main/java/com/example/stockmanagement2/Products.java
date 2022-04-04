package com.example.stockmanagement2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.stockmanagement2.databinding.ActivityProductsBinding;
import com.google.android.material.card.MaterialCardView;

public class Products extends Home {

    ActivityProductsBinding activityProductsBinding;
    MaterialCardView add_product, manage_product;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProductsBinding= ActivityProductsBinding.inflate(getLayoutInflater());
        setContentView(activityProductsBinding.getRoot());
        //allocateActivityTitle("Products");

        add_product = findViewById(R.id.add_product);
        manage_product = findViewById(R.id.manage_product);

        add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Products.this, Add_product.class));
            }
        });
manage_product.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(Products.this, Manage_product.class));
    }
});

    }
}