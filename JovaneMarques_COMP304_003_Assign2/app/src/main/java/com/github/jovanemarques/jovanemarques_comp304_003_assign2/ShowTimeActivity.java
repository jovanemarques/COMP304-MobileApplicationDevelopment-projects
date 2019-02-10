package com.github.jovanemarques.jovanemarques_comp304_003_assign2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ShowTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_time);

        Intent previewsInt = getIntent();
        final String movie = previewsInt.getStringExtra("movie");
        final Intent nextInt = new Intent(this, TicketTypeActivity.class);

        ImageView imgMovie = findViewById(R.id.imgMovieDetail);
        TextView txtMovieDetail = findViewById(R.id.txtMovieDetail);

        if (movie.equals("Bumblebee")) {
            imgMovie.setImageResource(R.drawable.bumblebee);
            txtMovieDetail.setText("Bumblebee");
        } else if (movie.equals("Escape Room")) {
            imgMovie.setImageResource(R.drawable.escaperoom);
            txtMovieDetail.setText("Escape Room");
        } else if (movie.equals("Glass")) {
            imgMovie.setImageResource(R.drawable.glass);
            txtMovieDetail.setText("Glass");
        } else if (movie.equals("Replicas")) {
            imgMovie.setImageResource(R.drawable.replicas);
            txtMovieDetail.setText("Replicas");
        } else if (movie.equals("The Mule")) {
            imgMovie.setImageResource(R.drawable.mule);
            txtMovieDetail.setText("The Mule");
        } else {
            imgMovie.setImageResource(0);
            txtMovieDetail.setText("");
        }

        RadioGroup rgTimeList = findViewById(R.id.rgTimeList);
        rgTimeList.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = findViewById(radioGroup.getCheckedRadioButtonId());
                nextInt.putExtra("movie", movie);
                nextInt.putExtra("time", rb.getText());
                startActivity(nextInt);
            }
        });
    }
}
