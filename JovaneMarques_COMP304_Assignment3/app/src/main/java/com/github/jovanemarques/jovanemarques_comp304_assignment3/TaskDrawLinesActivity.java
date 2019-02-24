package com.github.jovanemarques.jovanemarques_comp304_assignment3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class TaskDrawLinesActivity extends AppCompatActivity {

    //size of increment
    private static final int INCREMENT = 10;
    Canvas canvas;
    Paint paint;
    Bitmap bitmap;
    ImageView imgCanvas, imgArrowUp, imgArrowDown, imgArrowRight, imgArrowLeft;
    TextView txtX, txtY;
    //initial positions
    int startX, stopX = 10;
    int startY, stopY = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_draw_lines);
        //preparing objects to do the draw
        imgCanvas = findViewById(R.id.imgCanvas);
        paint = new Paint();
        //default values
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);

        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);

        imgCanvas.setImageBitmap(bitmap);

        //objects used bellow
        imgArrowUp = findViewById(R.id.imgArrowUp);
        imgArrowDown = findViewById(R.id.imgArrowDown);
        imgArrowRight = findViewById(R.id.imgArrowRight);
        imgArrowLeft = findViewById(R.id.imgArrowLeft);
        // arrows click
        imgArrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawUp();
            }
        });
        imgArrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawDown();
            }
        });
        imgArrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawRight();
            }
        });
        imgArrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawLeft();
            }
        });
        //spinner code
        Spinner spLineSize = findViewById(R.id.spLineSize);
        spLineSize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //setting the line size
                paint.setStrokeWidth(Integer.parseInt(((AppCompatTextView) view).getText().toString()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //wrinting the initial position
        txtX = findViewById(R.id.txtX);
        txtX.setText(Integer.toString(startX));
        txtY = findViewById(R.id.txtY);
        txtY.setText(Integer.toString(startY));
        clean();
    }

    private void drawLeft() {
        //draw the line
        //decrementing X goes to left
        drawLine(startX, startY, stopX - INCREMENT, stopY);
        // setting the new start position
        startX = stopX = stopX - INCREMENT < 0 ? 0 : stopX - INCREMENT;
        txtX.setText(Integer.toString(startX));
    }

    private void drawRight() {
        //incrementing X goes to right
        drawLine(startX, startY, stopX + INCREMENT, stopY);
        startX = stopX = stopX + INCREMENT;
        txtX.setText(Integer.toString(startX));
    }

    private void drawDown() {
        // incrementing Y goes to down
        drawLine(startX, startY, stopX, stopY + INCREMENT);
        startY = stopY = stopY + INCREMENT;
        txtY.setText(Integer.toString(startY));
    }

    private void drawUp() {
        // decrementing Y goes to up
        drawLine(startX, startY, stopX, stopY - INCREMENT);
        startY = stopY = stopY - INCREMENT < 0 ? 0 : stopY - INCREMENT;
        txtY.setText(Integer.toString(startY));
    }

    private void drawLine(int startX, int startY, int stopX, int stopY) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);
        imgCanvas.invalidate();
    }

    // to work with the DPAD
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                drawDown();
                return true;
            case KeyEvent.KEYCODE_DPAD_UP:
                drawUp();
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                drawRight();
                return true;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                drawLeft();
                return true;
        }
        return false;
    }

    public void rdColorOnClick(View view) {
        //chosing the colour
        switch (view.getId()) {
            case R.id.rdRed:
                paint.setColor(Color.RED);
                break;
            case R.id.rdGreen:
                paint.setColor(Color.GREEN);
                break;
            case R.id.rdYellow:
                paint.setColor(Color.YELLOW);
                break;
        }
    }

    public void btnClearOnCLick(View view) {
        clean();
    }

    private void clean() {
        //reseting everything
        canvas.drawColor(Color.WHITE);
        imgCanvas.invalidate();
        startX = stopX = 0;
        startY = stopY = 0;
        txtX.setText("0");
        txtY.setText("0");
    }
}
