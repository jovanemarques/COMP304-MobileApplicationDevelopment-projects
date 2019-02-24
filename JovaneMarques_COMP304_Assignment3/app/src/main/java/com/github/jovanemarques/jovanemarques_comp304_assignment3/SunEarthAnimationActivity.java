package com.github.jovanemarques.jovanemarques_comp304_assignment3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;

public class SunEarthAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sun_earth_animation);

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });

        Button btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop();
            }
        });
    }

    private void stop() {
        //stopping the animation
        ImageView imgEarth = findViewById(R.id.imgEarth);
        imgEarth.clearAnimation();
    }

    private void start() {
        //starting the animation
        ImageView imgEarth = findViewById(R.id.imgEarth);
        //loading the animation XML
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotation);
        anim.setAnimationListener(new AnimationListener());
        imgEarth.startAnimation(anim);
    }

    class AnimationListener implements Animation.AnimationListener {

        public void onAnimationEnd(Animation animation) {

        }

        public void onAnimationRepeat(Animation animation) {

        }

        public void onAnimationStart(Animation animation) {

        }

    }
}
