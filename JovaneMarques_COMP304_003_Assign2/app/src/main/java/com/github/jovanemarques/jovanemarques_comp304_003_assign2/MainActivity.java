package com.github.jovanemarques.jovanemarques_comp304_003_assign2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnBuyClick(View view) {
        Intent nextInt = new Intent(this, MovieListActivity.class);
        startActivity(nextInt);
    }
}
