package com.github.jovanemarques.intentexamplefornasif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void Click(View view) {
        Intent i = new Intent(this, Activity3.class);

        //passing some content here
        i.putExtra("ContentFromActivity2", "Hi");

        startActivity(i);
    }
}
