package com.example.listviewtest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class DrawTextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new ViewWithText(this));
	}

	 private static class ViewWithText extends View {
	        private Paint    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	        private Typeface mType;
	        
	        public ViewWithText(Context context) {
	            super(context);

	            mPaint.setTextSize(24);
	        }
	        
	        @Override protected void onDraw(Canvas canvas) {
	            canvas.drawColor(Color.GREEN);

	            mPaint.setTypeface(null);
	            canvas.drawText("Default Typeface (Normal)", 30, 40, mPaint);

	            mType = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Sans Serif Typeface (Normal)", 30, 70, mPaint);
	            
	            mType = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Sans Serif Typeface (Bold)", 30, 100, mPaint);
	            	          
	            mType = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Monospace Typeface (Normal)", 30, 130, mPaint);
	            
	            mType = Typeface.create(Typeface.SERIF, Typeface.NORMAL);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Serif Typeface (Normal)", 30, 160, mPaint);
	            
	            mType = Typeface.create(Typeface.SERIF, Typeface.BOLD);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Serif Typeface (Bold)", 30, 190, mPaint);
	            
	            mType = Typeface.create(Typeface.SERIF, Typeface.ITALIC);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Serif Typeface (Italic)", 30, 210, mPaint);

	            mType = Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC);
	            mPaint.setTypeface(mType);
	            canvas.drawText("Serif Typeface (Bold Italic)", 30, 240, mPaint);
	                  	      
	            mPaint.setTypeface(null);
	            mPaint.setTextSize(18);
	            canvas.drawText("Text Size 18", 30, 270, mPaint);
	            
	            mPaint.setTextSize(22);
	            canvas.drawText("Text Size 22", 30, 300, mPaint);

	            mPaint.setTextSize(20);
	            mPaint.setAntiAlias(false);
	            canvas.drawText("Text Not Anti-Aliased", 30, 330, mPaint);

	            mPaint.setAntiAlias(true);
	            mPaint.setFlags(Paint.STRIKE_THRU_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
	            canvas.drawText("Strike through", 30, 360, mPaint);
	            
	            mPaint.setFlags(Paint.UNDERLINE_TEXT_FLAG|Paint.ANTI_ALIAS_FLAG);
	            canvas.drawText("Underlined", 30, 390, mPaint);
	            
	        }
	    }
}
