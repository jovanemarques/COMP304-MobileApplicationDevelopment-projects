package com.example.vinay.sharedpreferenceexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //etrieving from shared preferences
        SharedPreferences myPref = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
        String myString = myPref.getString("MyString","");

        TextView tView = findViewById(R.id.tView);
        tView.setText("Retrieving from shared preferences: "+myString);
    }
}
