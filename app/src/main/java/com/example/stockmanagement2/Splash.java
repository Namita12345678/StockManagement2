package com.example.stockmanagement2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Splash extends AppCompatActivity {

    Animation animation;
    ConstraintLayout layout;
    SharedPreferences mSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        layout = findViewById(R.id.constrained_layout);
        animation = AnimationUtils.loadAnimation(Splash.this,R.anim.fade);
        mSP = getSharedPreferences("login",MODE_PRIVATE);


        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Boolean sp = mSP.getBoolean("logged", Boolean.parseBoolean(""));

                if (sp == false)
                {
                    startActivity(new Intent(Splash.this,Login.class));
                }
                else{
                    startActivity(new Intent(Splash.this,Home.class));
                }
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        layout.startAnimation(animation);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

