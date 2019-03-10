package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        textViewMovieName.setText("Captian Marvel");
        textViewDate.setText(intent.getStringExtra("edtDate"));
        textViewTime.setText(intent.getStringExtra("edtTime"));

    }
}
