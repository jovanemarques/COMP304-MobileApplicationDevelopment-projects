package com.github.jovanemarques.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Send_Message(View v){
        //creting a edit text object
        EditText editText = findViewById(R.id.editText);
        String edit_message = editText.getText().toString();

        String myName = getResources().getString(R.string.my_name);

        Toast.makeText(getApplicationContext(), myName, Toast.LENGTH_LONG).show();

        //initializing an intent object
        Intent intent = new Intent(MainActivity.this, SubActivity.class);

        //storing a value using an intent object
        intent.putExtra("message", edit_message);
        startActivity(intent);
    }
}
