package com.github.jovanemarques.jovanemarques_comp304_ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        //getting the text from the editText
        EditText editText = findViewById(R.id.editText2);
        String message = editText.getText().toString();

        //setting the message on an intent
        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtra("message", message);
        startActivity(intent);
    }
}
