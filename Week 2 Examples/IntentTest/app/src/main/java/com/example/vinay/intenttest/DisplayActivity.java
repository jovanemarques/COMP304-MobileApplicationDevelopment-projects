package com.example.vinay.intenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Bundle extras = getIntent().getExtras();
        String inputString = extras.getString("message");
        TextView view = (TextView) findViewById(R.id.extra_text);
        view.setText(inputString);
    }
}
