package ca.centennialcollege.comp304_003_assignment4;

import android.arch.core.util.Function;
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
        dbManager = DBManager.getDb(this);
    }

    public void btnLogin_Click(View view) {
        //Toast.makeText(getApplicationContext(), "btnLogin_Click", Toast.LENGTH_LONG).show();
        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        RadioButton rbStaff = findViewById(R.id.rbStaff);
        Function<String[], Boolean> func = null;

        if (rbStaff.isChecked()) {
            func = dbManager::checkAdminLogin;
        } else {
            func = dbManager::checkAudienceLogin;
        }

        checkLogin(new String[]{
                edtUsername.getText().toString(),
                edtPassword.getText().toString()
        }, func);
    }

    private void checkLogin(String[] data, Function<String[], Boolean> func) {
        if (func.apply(data)) {
            Intent intent = new Intent(this, NavigationActivity.class);
            // saving the username on the shared preferences
            saveOnSharedPreferences(getString(R.string.username), data[0]);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), R.string.msg_wrong_user_password, Toast.LENGTH_LONG).show();
        }
    }

    private void saveOnSharedPreferences(String var, String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), 0);
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
