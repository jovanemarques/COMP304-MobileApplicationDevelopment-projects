package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBManager dbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbManager = new DBManager(this);
    }

    public void btnLogin_Click(View view) {
        //Toast.makeText(getApplicationContext(), "btnLogin_Click", Toast.LENGTH_LONG).show();
        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        RadioButton rbStaff = findViewById(R.id.rbStaff);
        if (rbStaff.isChecked()) {
            if (dbManager.checkAdminLogin(edtUsername.getText().toString(), edtPassword.getText().toString())) {
                Intent intent = new Intent(this, NavigationActivity.class);
                saveOnSharedPreferences("username", edtUsername.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Wrong User/Password", Toast.LENGTH_LONG).show();
            }
        } else {
            if (dbManager.checkAudienceLogin(edtUsername.getText().toString(), edtPassword.getText().toString())) {
                Intent intent = new Intent(this, NavigationActivity.class);
                saveOnSharedPreferences("username", edtUsername.getText().toString());
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Wrong User/Password", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void saveOnSharedPreferences(String var, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences("Assignment4SharedPreferences", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(var, str);
        editor.commit();
    }

    public void btnSignUp_Click(View view) {
        //Toast.makeText(getApplicationContext(), "btnSignUp_Click", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
