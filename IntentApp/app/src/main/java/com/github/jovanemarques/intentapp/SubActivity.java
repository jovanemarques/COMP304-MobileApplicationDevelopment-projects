package com.github.jovanemarques.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent i = getIntent();
        String message = i.getStringExtra("message");

        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
    }
}
