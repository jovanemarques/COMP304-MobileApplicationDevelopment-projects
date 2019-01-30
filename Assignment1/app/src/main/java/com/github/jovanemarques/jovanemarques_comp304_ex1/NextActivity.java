package com.github.jovanemarques.jovanemarques_comp304_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        //getting the intent
        Intent intent = getIntent();
        String msg = intent.getStringExtra("message");

        //setting the textView with the message
        TextView txtView = findViewById(R.id.textView);
        txtView.setText(msg);
    }
}
