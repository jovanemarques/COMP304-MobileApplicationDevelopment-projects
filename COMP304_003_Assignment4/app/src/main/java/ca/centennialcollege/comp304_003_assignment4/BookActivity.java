package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class BookActivity extends AppCompatActivity {

    DBManager dbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        dbManager = DBManager.getDb(this);

        //query db for movies to load the spinner
        Spinner spMovieName = findViewById(R.id.spMovieName);
        List<String> data = dbManager.getAllMovieNames();

        ArrayAdapter<String> spArrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, data);
        spArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMovieName.setAdapter(spArrayAdapter);

    }

    public void btnBook_Click(View view) {
        Spinner spMovieName = findViewById(R.id.spMovieName);
        Spinner spMovieDate = findViewById(R.id.spMovieDate);
        TextView txtPrice = findViewById(R.id.txtPrice);
        Spinner spMovieTime = findViewById(R.id.spMovieTime);
        //get user info to save

        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.shared_preferences), MODE_PRIVATE);
        String username = sharedPreferences.getString(getString(R.string.username), "");

        Date date = new Date();
        String today = date.getYear() + "-" + date.getMonth() + "-" + date.getDay();
        dbManager.bookSave(
                username,
                (spMovieName.getSelectedItemId() - 1) + "",
                today,
                txtPrice.getText().toString(),
                spMovieDate.getSelectedItem().toString(),
                spMovieTime.getSelectedItem().toString(),
                "Pending"
        );

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, BookInfoActivity.class);

        intent.putExtra("movieName", spMovieName.getSelectedItem().toString());
        intent.putExtra("price", txtPrice.getText().toString());
        intent.putExtra("movieDate", spMovieDate.getSelectedItem().toString());
        intent.putExtra("movieTime", spMovieTime.getSelectedItem().toString());

        startActivity(intent);
    }
}
