package com.example.listviewtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class DrawShapeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new ViewWithRedDot(this));
	}

	 //create another view
	 private static class ViewWithRedDot extends View {

	       //constructor
	        public ViewWithRedDot(Context context) {
	            super(context);

	        }
	        //override the onDraw method
	        @Override protected void onDraw(Canvas canvas) {
				//canvas background
	            canvas.drawColor(Color.CYAN);
				//create a paint object
	            Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	            circlePaint.setColor(Color.BLUE); //drawing color
	            //draw a shape
				canvas.drawCircle(canvas.getWidth()/2,
						canvas.getHeight()/2, canvas.getWidth()/3, circlePaint);
	            
	        }
	    }

}
