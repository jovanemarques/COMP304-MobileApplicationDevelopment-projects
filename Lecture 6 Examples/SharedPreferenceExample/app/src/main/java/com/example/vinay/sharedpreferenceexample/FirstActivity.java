package com.example.vinay.sharedpreferenceexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        editText = findViewById(R.id.editText);
    }
    public void sendMessage(View view) {
        // Do something in response to button
        SharedPreferences myPreference = getSharedPreferences("MySharedPreferences", 0);
        SharedPreferences.Editor prefEditor = myPreference.edit();
        prefEditor.putString("MyString", editText.getText().toString());
        prefEditor.commit();

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

}
