package com.github.jovanemarques.intentexamplefornasif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Intent previewsIntent = getIntent();

        String text = previewsIntent.getStringExtra("ContentFromActivity2");
        String text2 = previewsIntent.getStringExtra("ContentFromActivity3");

        TextView t2 = findViewById(R.id.textView2);
        TextView t3 = findViewById(R.id.textView3);

        t2.setText(text);
        t3.setText(text2);
    }
}
