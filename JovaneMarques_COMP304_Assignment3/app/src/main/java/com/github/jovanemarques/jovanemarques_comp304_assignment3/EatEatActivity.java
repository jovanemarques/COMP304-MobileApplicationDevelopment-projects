package com.github.jovanemarques.jovanemarques_comp304_assignment3;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EatEatActivity extends AppCompatActivity {

    ImageView imgAnimation;
    Button btnStart, btnStop;
    AnimationDrawable anDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_eat);

        anDraw = new AnimationDrawable();

        imgAnimation = findViewById(R.id.imgAnimation);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        //programming the buttons
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAnimation();
            }
        });

        int reasonableDuration = 250;

        // adding the images
        BitmapDrawable cc1 = (BitmapDrawable) getDrawable(R.drawable.comecome1);
        BitmapDrawable cc2 = (BitmapDrawable) getDrawable(R.drawable.comecome2);
        BitmapDrawable cc3 = (BitmapDrawable) getDrawable(R.drawable.comecome3);
        BitmapDrawable cc4 = (BitmapDrawable) getDrawable(R.drawable.comecome4);
        BitmapDrawable cc5 = (BitmapDrawable) getDrawable(R.drawable.comecome5);
        BitmapDrawable cc6 = (BitmapDrawable) getDrawable(R.drawable.comecome6);
        BitmapDrawable cc7 = (BitmapDrawable) getDrawable(R.drawable.comecome7);
        BitmapDrawable cc8 = (BitmapDrawable) getDrawable(R.drawable.comecome8);
        BitmapDrawable cc9 = (BitmapDrawable) getDrawable(R.drawable.comecome9);

        //putting the images on the animation
        anDraw.addFrame(cc1, reasonableDuration);
        anDraw.addFrame(cc2, reasonableDuration);
        anDraw.addFrame(cc3, reasonableDuration);
        anDraw.addFrame(cc4, reasonableDuration);
        anDraw.addFrame(cc5, reasonableDuration);
        anDraw.addFrame(cc6, reasonableDuration);
        anDraw.addFrame(cc7, reasonableDuration);
        anDraw.addFrame(cc8, reasonableDuration);
        anDraw.addFrame(cc9, reasonableDuration);

        //loop the image
        anDraw.setOneShot(false);

        imgAnimation.setBackgroundDrawable(anDraw);
    }

    private void startAnimation() {
        anDraw.start();
    }

    private void stopAnimation() {
        anDraw.stop();
    }
}
