package com.github.jovanemarques.jovanemarques_comp304_003_assign2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TicketTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_type);

        Spinner spin = findViewById(R.id.spAdults);

        ArrayAdapter<CharSequence> adapt = ArrayAdapter.createFromResource(this,
                R.array.tickets_quantity, android.R.layout.simple_spinner_item);
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spin.setAdapter(adapt);
    }
}
