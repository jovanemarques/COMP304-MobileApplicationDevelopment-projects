package com.example.framedanimation;

import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	AnimationDrawable mframeAnimation = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//
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
	
	//
	
	private void startAnimation()
	{
		 ImageView img = (ImageView)findViewById(R.id.ImageView_Boy);
		 
		 BitmapDrawable frame1 = (BitmapDrawable) getDrawable(R.drawable.boy1);
		 BitmapDrawable frame2 = (BitmapDrawable) getDrawable(R.drawable.boy2);
		 BitmapDrawable frame3 = (BitmapDrawable) getDrawable(R.drawable.boy3);
		 BitmapDrawable frame4 = (BitmapDrawable) getDrawable(R.drawable.boy4);
		 BitmapDrawable frame5 = (BitmapDrawable) getDrawable(R.drawable.boy5);
		 BitmapDrawable frame6 = (BitmapDrawable) getDrawable(R.drawable.boy6);

		 // Get the background, which has been compiled to an AnimationDrawable object.
		 int reasonableDuration = 250;
	     mframeAnimation = new AnimationDrawable();
	     mframeAnimation.setOneShot(false);	// loop continuously
	     mframeAnimation.addFrame(frame1, reasonableDuration);
	     mframeAnimation.addFrame(frame2, reasonableDuration);
	     mframeAnimation.addFrame(frame3, reasonableDuration);
	     mframeAnimation.addFrame(frame4, reasonableDuration);
	     mframeAnimation.addFrame(frame5, reasonableDuration);
	     mframeAnimation.addFrame(frame6, reasonableDuration);

	     
	     img.setBackgroundDrawable(mframeAnimation);
	     
	     mframeAnimation.setVisible(true,true);
	     mframeAnimation.start();
	     }
	private void stopAnimation()
	{
		mframeAnimation.stop();
		mframeAnimation.setVisible(false,false);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
