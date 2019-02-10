package com.github.jovanemarques.jovanemarques_comp304_003_assign2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {

    TextView lblFullName;
    TextView lblMovieName;
    TextView lblNoTickets;
    TextView lblShowTime;
    TextView lblOk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        lblFullName = findViewById(R.id.lblFullName);
        lblMovieName = findViewById(R.id.lblMovieName);
        lblNoTickets = findViewById(R.id.lblNoTickets);
        lblShowTime = findViewById(R.id.lblShowTime);
        lblOk= findViewById(R.id.lblOk);
        lblFullName.setText("");
        lblMovieName.setText("");
        lblNoTickets.setText("");
        lblShowTime.setText("");
        lblOk.setText("");
    }

    public void btnConfirm_onClick(View view) {
        Intent previewsInt = getIntent();
        String movie = previewsInt.getStringExtra("movie");
        String time = previewsInt.getStringExtra("time");
        String quantityAdult = previewsInt.getStringExtra("quantityAdult");
        String quantityChildren = previewsInt.getStringExtra("quantityChildren");

        EditText txtFirstName = findViewById(R.id.txtFirstName);
        EditText txtLastName = findViewById(R.id.txtLastName);

        lblOk.setText("Tickets purchased!");
        lblFullName.setText(txtFirstName.getText().toString() + " " + txtLastName.getText().toString());
        lblMovieName.setText(movie);
        lblNoTickets.setText("Adult = " + quantityAdult + ", Children = " + quantityChildren);
        lblShowTime.setText(time);
    }
}
