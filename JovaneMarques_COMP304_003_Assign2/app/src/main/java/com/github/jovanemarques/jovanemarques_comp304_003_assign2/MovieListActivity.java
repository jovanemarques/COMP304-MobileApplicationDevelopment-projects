package com.github.jovanemarques.jovanemarques_comp304_003_assign2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MovieListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
    }
    public void mnuMovieClick(View view) {
        Intent nextInt = new Intent(this, ShowTimeActivity.class);
        startActivity(nextInt);
    }
}
