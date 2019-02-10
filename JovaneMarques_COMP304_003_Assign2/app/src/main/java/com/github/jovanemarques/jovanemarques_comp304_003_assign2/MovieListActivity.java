package com.github.jovanemarques.jovanemarques_comp304_003_assign2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MovieListActivity extends AppCompatActivity {

    TextView lblMovie;
    ImageView imgMovie;
    String menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list);
        lblMovie = findViewById(R.id.lblMovie);
        imgMovie = findViewById(R.id.imgMovie);
        lblMovie.setText("");
        imgMovie.setImageResource(0);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.movies, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        menuItem = item.getTitle().toString();
        lblMovie.setText(menuItem);
        if (item.getTitle().equals("Bumblebee")) {
            imgMovie.setImageResource(R.drawable.bumblebee);
        } else if (item.getTitle().equals("Escape Room")) {
            imgMovie.setImageResource(R.drawable.escaperoom);
        } else if (item.getTitle().equals("Glass")) {
            imgMovie.setImageResource(R.drawable.glass);
        } else if (item.getTitle().equals("Replicas")) {
            imgMovie.setImageResource(R.drawable.replicas);
        } else if (item.getTitle().equals("The Mule")) {
            imgMovie.setImageResource(R.drawable.mule);
        } else {
            imgMovie.setImageResource(0);
        }
        return true;
    }

    public void btnNext_onClick(View view) {
        if (menuItem != null) {
            Intent nextInt = new Intent(this, ShowTimeActivity.class);
            nextInt.putExtra("movie", menuItem);
            startActivity(nextInt);
        } else {
            Toast.makeText(getApplicationContext(),"Choose a movie!", Toast.LENGTH_LONG);
        }
    }
}
