package com.github.jovanemarques.jovanemarques_comp304_ex2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void sendInformation(View view) {
        //intent to pass data
        Intent intent = new Intent(this, SecondActivity.class);

        //getting the data from the resource
        intent.putExtra("movieName", getResources().getString(R.string.movieName));
        intent.putExtra("director", getResources().getString(R.string.director));
        intent.putExtra("language", getResources().getString(R.string.language));
        intent.putExtra("releasedYear", getResources().getString(R.string.releasedYear));

        //going to the second activity
        startActivity(intent);
    }
}
