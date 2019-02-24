package com.github.jovanemarques.jovanemarques_comp304_assignment3;

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
        ListView lvTasks = findViewById(R.id.lvTasks);

        lvTasks.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                // opening the taks
                switch (i) {
                    case 0:
                        intent.setClass(MainActivity.this, TaskDrawLinesActivity.class);
                        break;
                    case 1:
                        intent.setClass(MainActivity.this, SunEarthAnimationActivity.class);
                        break;
                    case 2:
                        intent.setClass(MainActivity.this, EatEatActivity.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}
