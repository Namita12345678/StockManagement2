package com.example.stockmanagement2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout =(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_home, null);
        FrameLayout container = drawerLayout.findViewById(R.id.acitivityContainer);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar= drawerLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        drawerLayout.closeDrawer(GravityCompat.START);
        switch(item.getItemId()){



            case R.id.nav_dashboard:
                startActivity(new Intent(this, Dashboard.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_categories:
                startActivity(new Intent(this, Categories.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_product:
                startActivity(new Intent(this, Products.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_home1:
                startActivity(new Intent(this, Base.class));
                overridePendingTransition(0,0);
                break;

        }


        return false;
    }

    protected  void allocateActivityTitle(String titleString){
        if(getSupportActionBar() !=null) {
            getSupportActionBar().setTitle(titleString);
        }
    }
}





