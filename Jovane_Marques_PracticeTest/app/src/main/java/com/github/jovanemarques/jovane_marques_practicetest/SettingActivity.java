package com.github.jovanemarques.jovane_marques_practicetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final ListView lvSettings = (ListView) findViewById(R.id.listView);

        lvSettings.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = null;
                String selectedSetting = (String) lvSettings.getItemAtPosition(position);
                //
                switch (position) {
                    case 0:
                        intent = new Intent(SettingActivity.this, StorageActivity.class);
                        intent.putExtra("selectedSetting", selectedSetting);

                        startActivity(intent);
                        break;
                }


            }
        });
    }
}
