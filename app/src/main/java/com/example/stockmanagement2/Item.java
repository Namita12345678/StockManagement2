package com.example.stockmanagement2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class Item extends AppCompatActivity {


    private int id;
    private String title;
    private String shortdesc;
    private double rating;
    private String price;
    private String image;

    TextView tv1, tv2;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        Intent i= getIntent();


        id = i.getIntExtra( "id", 0);
        title = i.getStringExtra("title");
        shortdesc = i.getStringExtra("shortdesc");
        rating = i.getDoubleExtra("rating", 0);
        price = i.getStringExtra("price");
        image = i.getStringExtra("image");

        tv1= findViewById(R.id.tv_1);
        tv2= findViewById(R.id.tv_2);
        imageView = findViewById(R.id.img_view);
        //loading the image
        Glide.with(Item.this)
                .load(image)
                .into(imageView);


        tv1.setText(title);
        tv2.setText(shortdesc);

    }
}