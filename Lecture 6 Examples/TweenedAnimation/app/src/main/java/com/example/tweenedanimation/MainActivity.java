package com.example.tweenedanimation;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	//
	ImageView reusableImageView;
	Animation an;
    //
	Paint paint;
	Bitmap bitmap;
	Canvas canvas;
	//
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		paint = new Paint();
		// Handle Start Button
				final Button onButton = (Button) findViewById(R.id.ButtonStart);
				onButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						startAnimation();
					}
				});
					
				// Handle Stop Button
				final Button offButton = (Button) findViewById(R.id.ButtonStop);
				offButton.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						stopAnimation();
					}
				});
				
	}
	
	private void startAnimation()
	{
		 // We will animate the imageview
		 reusableImageView = (ImageView)findViewById(R.id.ImageViewForTweening);
	     reusableImageView.setImageResource(R.drawable.green_rect);
	     reusableImageView.setVisibility(View.VISIBLE);

	     //creating a bitmap as content view for the image
		 Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
		        .getDefaultDisplay().getWidth(), (int) getWindowManager()
		        .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
		 Canvas canvas = new Canvas(bitmap);
		 reusableImageView.setImageBitmap(bitmap);
		 //
		 Paint paint = new Paint();
		 paint.setColor(Color.BLUE);
		 paint.setTextSize(60);
		 paint.setAntiAlias(true);
		 paint.setTypeface(Typeface.DEFAULT_BOLD);
		//
		 Path p = new Path();
		 p.moveTo(20, 200);
		 p.lineTo(600, 200);
		 canvas.drawTextOnPath("Should learn Android", p, 0, 0, paint);
		 
		 // Load the appropriate animation
	     an =  AnimationUtils.loadAnimation(this,
				 R.anim.translate_position);

	     // Start the animation
	     reusableImageView.startAnimation(an);

	}// end of startAnimation
	
	private void stopAnimation()
	{
		reusableImageView.clearAnimation();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
