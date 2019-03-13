package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), MODE_PRIVATE);
        String username = sharedPreferences.getString(getString(R.string.username), "");

        TextView txtWelcome = findViewById(R.id.txtWelcome);
        txtWelcome.setText(getString(R.string.welcome_user) + " " + username);
    }

    public void btnBookTicket_Click(View view) {
        Intent intent = new Intent(this, BookActivity.class);
        startActivity(intent);
    }

    public void btnUpdateInfo_Click(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
