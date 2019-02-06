package com.github.jovanemarques.mymenu2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup = findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb1 = findViewById(R.id.rb1);
                RadioButton rb2 = findViewById(R.id.rb2);

                if (rb1.isChecked()){
                    Toast.makeText(getApplicationContext(), "Yes checked", Toast.LENGTH_LONG).show();
                } else if (rb2.isChecked()) {
                    Toast.makeText(getApplicationContext(), "No checked", Toast.LENGTH_LONG).show();
                }
            }
        });
        String[] colours = getResources().getStringArray(R.array.colours);
        Spinner spin = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, colours);
        spin.setAdapter(adapter);

        ListView lv = findViewById(R.id.list1);
        lv.setAdapter(adapter);

        AutoCompleteTextView autoComp = findViewById(R.id.autocomp1);
        autoComp.setAdapter(adapter);
        autoComp.setThreshold(2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pizza, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Meat Supreme", Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Meat Supreme", Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                Toast.makeText(getApplicationContext(), "Meat Supreme", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
