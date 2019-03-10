package ca.centennialcollege.comp304_003_assignment4;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        SharedPreferences sharedPreferences = getSharedPreferences("Assignment4SharedPreferences", MODE_PRIVATE);
        String str = sharedPreferences.getString("username","");

        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText(str);
    }
}
