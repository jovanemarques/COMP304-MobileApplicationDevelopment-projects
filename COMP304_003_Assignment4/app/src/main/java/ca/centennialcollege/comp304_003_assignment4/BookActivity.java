package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    DBManager dbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        dbManager = new DBManager(this);
        //query db for movies
        //fill the spinner
    }

    public void btnBook_Click(View view) {
        EditText edtDate = findViewById(R.id.edtDate);
        TextView txtPrice = findViewById(R.id.txtPrice);
        EditText edtTime = findViewById(R.id.edtTime);
        //get user info to save

        dbManager.bookSave(
                "jovanemarques@gmail.com",
                "1",
                "1",
                "2019/04/01",
                txtPrice.getText().toString(),
                edtDate.getText().toString(),
                edtTime.getText().toString(),
                "Pending"
        );

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, BookInfoActivity.class);

        intent.putExtra("txtPrice", txtPrice.getText().toString());
        intent.putExtra("edtDate", edtDate.getText().toString());
        intent.putExtra("edtTime", edtTime.getText().toString());

        startActivity(intent);
    }
}
