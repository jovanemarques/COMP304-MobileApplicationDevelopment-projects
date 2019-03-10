package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class BookActivity extends AppCompatActivity {

    DBManager dbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        dbManager = new DBManager(this);
    }

    public void btnBook_Click(View view) {
        //Spinner sp = findViewById(R.id.sp);

        //get user info to save

//        "create table Booking (" +
//                "emailId       text not null, " +
//                "bookingId     integer primary key autoincrement, " +
//                "movieId       int not null, " +
//                "paymentDate   text not null, " +
//                "amountPaid    text not null, " +
//                "showDate      text not null, " +
//                "showTime      text not null, " +
//                "bookingStatus text not null " +
//                ");"

//        dbManager.bookSave(
//
//        );

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, BookInfoActivity.class);
        startActivity(intent);
    }
}
