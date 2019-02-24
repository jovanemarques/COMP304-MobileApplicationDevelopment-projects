package com.github.jovanemarques.jovane_marques_practicetest;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class StorageActivity extends AppCompatActivity {

    ImageView imageView;
    Paint paint;
    Bitmap bitmap;
    Canvas canvas;

    public static long[] getTotalMemorySize() {

        long size[] = new long[2];
        try {
            Runtime info = Runtime.getRuntime();
            size[0] = info.totalMemory() / 1024;
            size[1] = info.freeMemory() / 1024;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        //get the value from the intent object
        Bundle extras = getIntent().getExtras();
        //extract the variable values from bundle object
        String selectedSetting = extras.getString("selectedSetting");
        this.getSupportActionBar().setTitle(selectedSetting);

        TextView tView = (TextView) findViewById(R.id.txtView);
        // set up the paint
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(20);
        //
        imageView = (ImageView) findViewById(R.id.imageView);
        int width = (int) getResources().getDimension(R.dimen.img_width);
        int height = (int) getResources().getDimension(R.dimen.img_height);
        //
        //create a bitmap as content view for the canvas
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        imageView.draw(canvas);

        //set a bitmap as content view for the image
        imageView.setImageBitmap(bitmap);
        //compute the ratio of free space
        long memory[] = getTotalMemorySize();
        double ratio = (double) memory[1] / (double) memory[0];
        int percentAv = (int) (ratio * 100);
        tView.setText("Memory map: " + String.valueOf(percentAv) + "% free");

        //draw occupied space with blue
        double widthOfOccupiedSpace = (1. - ratio) * width; //(100-(int)(availableSpace*100.))*width/100;
        canvas.drawRect(0, 0, (int) widthOfOccupiedSpace, height, paint);
        //draw available space with yellow
        paint.setColor(Color.YELLOW);
        canvas.drawRect((int) widthOfOccupiedSpace, 0, width, height, paint);
        imageView.invalidate();
        //Display total memory
        TextView tvTotalMemory = (TextView) findViewById(R.id.txtTotalMemory);
        tvTotalMemory.setText("Total memory: " + String.valueOf(memory[0]));
        //
        //create the legend for available space
        ColorDrawable avDraw = (ColorDrawable) getDrawable(R.drawable.yellowDrawable);
        ImageView imgViewAv = (ImageView) findViewById(R.id.iconAvailableSpace);
        imgViewAv.setImageDrawable(avDraw);
        //TextView txtAvailableSpace = (TextView)findViewById(R.id.txtAvailableSpace);
        //
        //create the legend for used space
        ColorDrawable usDraw = (ColorDrawable) getDrawable(R.drawable.blueDrawable);
        ImageView imgViewUs = (ImageView) findViewById(R.id.iconUsedSpace);
        imgViewUs.setImageDrawable(usDraw);
        //TextView txtUsedSpace = (TextView)findViewById(R.id.txtUsedSpace);

    }

}