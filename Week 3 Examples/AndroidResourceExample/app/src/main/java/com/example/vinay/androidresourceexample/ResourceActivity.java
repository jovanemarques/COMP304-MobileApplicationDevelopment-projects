package com.example.vinay.androidresourceexample;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResourceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        Resources.Theme theme = getTheme();

        String myString = getResources().getString(R.string.display);
        int myColor = getResources().getColor(R.color.prettyTextColor,theme);
        float myDimen = getResources().getDimension(R.dimen.textPointSize);

        ColorDrawable myDraw = (ColorDrawable) getResources().getDrawable(R.drawable.green_rect,theme);

        ImageView imgView = findViewById(R.id.imageView);
        //imgView.setImageDrawable(myDraw);

        TextView textView = findViewById(R.id.textView);
        textView.setTextSize(myDimen);
        textView.setTextColor(myColor);
        textView.setText(myString);

    }
}
