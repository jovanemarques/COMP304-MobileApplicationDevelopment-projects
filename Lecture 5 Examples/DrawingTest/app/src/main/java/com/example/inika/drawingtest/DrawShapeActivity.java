package com.example.inika.drawingtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class DrawShapeActivity extends DrawingActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyGreenView(this));
	}

	//derive your control from View
	 private static class MyGreenView extends View {

	        public MyGreenView(Context context) {
	            super(context);

	        }
	        
	        @Override protected void onDraw(Canvas canvas) {
	            //set canvas background
				canvas.drawColor(Color.WHITE);

				//create and setup the paint object
	            Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	            circlePaint.setColor(Color.GREEN);
	            canvas.drawCircle(canvas.getWidth()/2,
						canvas.getHeight()/2,
						canvas.getWidth()/3, circlePaint);
	            
	        }
	    }

}
