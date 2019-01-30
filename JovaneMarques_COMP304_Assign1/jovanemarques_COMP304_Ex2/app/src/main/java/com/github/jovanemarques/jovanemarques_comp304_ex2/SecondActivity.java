package com.github.jovanemarques.jovanemarques_comp304_ex2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        //getting the controls to work
        EditText edtMovieName = findViewById(R.id.edtMovieName);
        EditText edtDirector = findViewById(R.id.edtDirector);
        EditText edtLanguage = findViewById(R.id.edtLanguage);
        EditText edtReleasedYear = findViewById(R.id.edtReleasedYear);

        //getting the data from the intent and
        // putting the it in the controls
        edtMovieName.setText(intent.getStringExtra("movieName"));
        edtDirector.setText(intent.getStringExtra("director"));
        edtLanguage.setText(intent.getStringExtra("language"));
        edtReleasedYear.setText(intent.getStringExtra("releasedYear"));
    }
}
