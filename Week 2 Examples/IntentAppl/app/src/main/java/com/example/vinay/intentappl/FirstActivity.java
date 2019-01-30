package com.example.vinay.intentappl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void Button_Click(View v)
    {
        if(v.getId()==R.id.button1)
        {
            Intent i=new Intent(FirstActivity.this, SecondActivity.class);
            startActivity(i);
        }
    }
}
