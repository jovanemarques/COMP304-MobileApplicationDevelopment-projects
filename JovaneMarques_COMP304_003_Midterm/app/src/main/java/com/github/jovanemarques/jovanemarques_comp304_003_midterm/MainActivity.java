package com.github.jovanemarques.jovanemarques_comp304_003_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().setTitle("COMP 304-003 Midterm");

        ListView lvOptions = findViewById(R.id.lvOptions);

        lvOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, YourHeartActivity.class);

                intent.putExtra("option", i);

                startActivity(intent);
            }
        });
    }
}
