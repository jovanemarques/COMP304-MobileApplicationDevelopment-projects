package com.example.spinnertest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Spinner spin = (Spinner) findViewById(R.id.provinces_spinner);
		
		final Button submit = (Button)findViewById(R.id.submit);
		submit.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
			    TextView text_sel = (TextView)spin.getSelectedView();
				Toast.makeText(MainActivity.this, "\n spinner = "+text_sel.getText(), Toast.LENGTH_SHORT).show();
			}
			
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
