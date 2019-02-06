package com.github.jovanemarques.intentexamplefornasif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Click(View view) {
        Intent i = new Intent(this, Activity2.class);
        // going to the next activity without pass anything
        startActivity(i);
    }
}
