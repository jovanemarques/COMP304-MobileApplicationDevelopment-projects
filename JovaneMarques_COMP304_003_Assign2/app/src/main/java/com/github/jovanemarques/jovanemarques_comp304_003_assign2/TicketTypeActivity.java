package com.github.jovanemarques.jovanemarques_comp304_003_assign2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

public class TicketTypeActivity extends AppCompatActivity {

    private String movie;
    private String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_type);

        // getting the extra variables
        Intent previewsInt = getIntent();
        movie = previewsInt.getStringExtra("movie");
        time = previewsInt.getStringExtra("time");

        Spinner spAdults = findViewById(R.id.spAdults);
        Spinner spChildren = findViewById(R.id.spChildren);

        // using array string to provide the numbers
        ArrayAdapter<CharSequence> adaptNumbers = ArrayAdapter.createFromResource(this,
                R.array.tickets_quantity, android.R.layout.simple_spinner_item);
        adaptNumbers.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spAdults.setAdapter(adaptNumbers);
        spChildren.setAdapter(adaptNumbers);
    }

    public void btnCheckout_onClick(View view) {

        Spinner spChildren = findViewById(R.id.spChildren);
        CheckBox chbxChildren = findViewById(R.id.chbxChildren);
        Spinner spAdults = findViewById(R.id.spAdults);
        CheckBox chbxAdults = findViewById(R.id.chbxAdults);

        Intent nextInt = new Intent(this, CheckoutActivity.class);
        // passing forward the extra variables
        nextInt.putExtra("movie", movie);
        nextInt.putExtra("time", time);
        nextInt.putExtra("quantityAdult", chbxAdults.isChecked() ? spAdults.getSelectedItem().toString() : "0");
        nextInt.putExtra("quantityChildren", chbxChildren.isChecked() ? spChildren.getSelectedItem().toString() : "0");
        startActivity(nextInt);
    }
}
