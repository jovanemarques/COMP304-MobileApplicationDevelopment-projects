package com.github.jovanemarques.intentexamplefornasif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private String textToPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent previewsIntent = getIntent();
        //getting the text from the preview activity
        String text = previewsIntent.getStringExtra("ContentFromActivity2");
        TextView tv = findViewById(R.id.textView);
        // setting in a textview to see
        tv.setText(text);
        //saving in a field, otherwise we need to get the intent again on the click method below
        textToPass = text;
    }

    public void Click(View view) {
        Intent nextIntent = new Intent(this, Activity4.class);
        //passing the previews text
        nextIntent.putExtra("ContentFromActivity2", textToPass);
        //passing new text
        nextIntent.putExtra("ContentFromActivity3", "Hello");
        startActivity(nextIntent);
    }
}
