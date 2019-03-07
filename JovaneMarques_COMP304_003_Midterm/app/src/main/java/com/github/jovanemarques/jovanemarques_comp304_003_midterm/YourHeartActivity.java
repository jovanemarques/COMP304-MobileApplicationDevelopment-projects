package com.github.jovanemarques.jovanemarques_comp304_003_midterm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class YourHeartActivity extends AppCompatActivity {

    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_heart);

        final int TEXT_SIZE = 50;
        final int INCREMENT = 100;
        final int IMG_WIDTH = 700;
        final int IMG_HEIGHT = 500;

        Intent intent = getIntent();
        int option = intent.getIntExtra("option", 0);

        //getting the components
        ImageView imgChart = findViewById(R.id.imgChart);

        this.getSupportActionBar().setTitle("Your Heart Rate Graph");

        paint = new Paint();
        //paint.setStrokeWidth(20);

        bitmap = Bitmap.createBitmap(IMG_WIDTH, IMG_HEIGHT, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        canvas.drawColor(Color.BLACK);

        imgChart.setImageBitmap(bitmap);
        imgChart.draw(canvas);

        int top = 0, bottom = 100;

        if (option == 0) {
            paint.setColor(Color.RED);
            canvas.drawRect(0, top, IMG_WIDTH, bottom, paint);
            paint.setTextSize(TEXT_SIZE);
            paint.setColor(Color.WHITE);
            canvas.drawText(getString(R.string.anae), INCREMENT, bottom - TEXT_SIZE, paint);
        } else if (option == 1) {
            paint.setColor(Color.YELLOW);
            top = 100;
            bottom = 200;
            canvas.drawRect(0, top, IMG_WIDTH, bottom, paint);
            paint.setTextSize(TEXT_SIZE);
            paint.setColor(Color.WHITE);
            canvas.drawText(getString(R.string.aero), INCREMENT, bottom - TEXT_SIZE, paint);
        } else if (option == 2) {
            paint.setColor(Color.GREEN);
            top = 200;
            bottom = 300;
            canvas.drawRect(0, top, IMG_WIDTH, bottom, paint);
            paint.setTextSize(TEXT_SIZE);
            paint.setColor(Color.WHITE);
            canvas.drawText(getString(R.string.weig), INCREMENT, bottom - TEXT_SIZE, paint);
        } else if (option == 3) {
            paint.setColor(Color.BLUE);
            top = 300;
            bottom = 400;
            canvas.drawRect(0, top, IMG_WIDTH, bottom, paint);
            paint.setTextSize(TEXT_SIZE);
            paint.setColor(Color.WHITE);
            canvas.drawText(getString(R.string.light), INCREMENT, bottom - TEXT_SIZE, paint);
        }
        //refreshing
        imgChart.invalidate();
    }
}
