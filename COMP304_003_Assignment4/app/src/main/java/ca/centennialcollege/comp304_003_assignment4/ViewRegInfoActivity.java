package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class ViewRegInfoActivity extends AppCompatActivity {

    DBManager dbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reg_info);

        dbManager = DBManager.getDb(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("email");

        showInfo(username);
    }

    private void showInfo(String emailId) {
        List<String> userInfo = dbManager.getAudienceInfo(emailId);

        if (userInfo.size() > 0) {
            TextView textViewName = findViewById(R.id.textViewName);
            TextView textViewLastName = findViewById(R.id.textViewLastName);
            TextView textViewEmail = findViewById(R.id.textViewEmail);
            TextView textViewUsername = findViewById(R.id.textViewUsername);
            TextView textViewAddress = findViewById(R.id.textViewAddress);
            TextView textViewCity = findViewById(R.id.textViewCity);
            TextView editTextPostalCode = findViewById(R.id.editTextPostalCode);

            textViewEmail.setText(userInfo.get(0));
            textViewUsername.setText(userInfo.get(1));
            textViewName.setText(userInfo.get(3));
            textViewLastName.setText(userInfo.get(4));
            textViewAddress.setText(userInfo.get(5));
            textViewCity.setText(userInfo.get(6));
            editTextPostalCode.setText(userInfo.get(7));
        }
    }

    public void btnGoBack_Click(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
