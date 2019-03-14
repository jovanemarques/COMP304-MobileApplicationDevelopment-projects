package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class BookInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);

        Intent intent = getIntent();

        TextView textViewMovieName = findViewById(R.id.textViewMovieName);
        TextView textViewDate = findViewById(R.id.textViewDate);
        TextView textViewTime = findViewById(R.id.textViewTime);

        textViewMovieName.setText(intent.getStringExtra("movieName"));
        textViewDate.setText(intent.getStringExtra("movieDate"));
        textViewTime.setText(intent.getStringExtra("movieTime"));
        textViewTime.setText(intent.getStringExtra("price"));

    }

    public void btnNavigation_Click(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}
