package com.github.jovanemarques.jovane_marques_midtermpractice2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class ChartActivity extends AppCompatActivity {
    private ImageView imageView;
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    //
    int barStartY = 0;
    int barY = 0;
    int barHeight = 100;
    //
    int[] checkedStates = new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        this.getSupportActionBar().setTitle("Vitamin Chart");

        checkedStates=getIntent().getExtras().getIntArray("checkedStates");

        // set up the paint
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        //create the big image view to show memory map
        imageView = (ImageView)findViewById(R.id.imageView);
        int width = (int) getResources().getDimension(R.dimen.img_width);
        int height = (int) getResources().getDimension(R.dimen.img_height);
        //
        //prepare drawing environment
        //create a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        //set canvas background
        canvas.drawColor(Color.BLACK);
        //set a bitmap as content view for the image
        imageView.setImageBitmap(bitmap);
        //render the view to the canvas
        imageView.draw(canvas);
        //
        try {
            //compute the width of vitamin A consumption and draw with blue
            double barWidthOfVitaminA = checkedStates[0] * width;
            canvas.drawRect(0, barY, (int) barWidthOfVitaminA, barY + barHeight, paint);
            paint.setTextSize(100);
            paint.setColor(Color.CYAN);
            canvas.drawText("A", width-100, barY + barHeight, paint);
            //compute the width of vitamin B consumption and draw with yellow
            double barWidthOfVitaminB = checkedStates[1] * width;
            barY += barHeight;
            paint.setColor(Color.YELLOW);
            canvas.drawRect(0, barY, (int) barWidthOfVitaminB, barY + barHeight, paint);
            paint.setTextSize(100);
            paint.setColor(Color.CYAN);
            canvas.drawText("B", width-100, barY + barHeight, paint);
            //compute the width of vitamin C consumtion and draw with magenta
            double barWidthOfVitaminC = checkedStates[2] * width;
            barY += barHeight;
            paint.setColor(Color.MAGENTA);
            canvas.drawRect(0, barY, (int) barWidthOfVitaminC, barY + barHeight, paint);
            //compute the width of vitamin D consumtion and draw with green
            double barWidthOfVitaminD = checkedStates[3] * width;;
            barY += barHeight;
            paint.setColor(Color.GREEN);
            canvas.drawRect(0, barY, (int) barWidthOfVitaminD, barY + barHeight, paint);
        }
        catch(Exception e)
        {
            Log.d("exception",e.getMessage());
        }
        imageView.invalidate(); //refreshes the painting
    }
}
