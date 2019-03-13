package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    DBManager dbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dbManager = DBManager.getDb(this);
    }

    public void btnSave_Click(View view) {
        EditText edtCity = findViewById(R.id.edtCity);
        EditText edtPassword = findViewById(R.id.edtPassword);
        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtAddress = findViewById(R.id.edtAddress);
        EditText edtEmail = findViewById(R.id.edtEmail);
        EditText edtFirstName = findViewById(R.id.edtFirstName);
        EditText edtLastName = findViewById(R.id.edtLastName);
        EditText edtPostalCode = findViewById(R.id.edtPostalCode);

        dbManager.signUpSaveOrUpdate(
                edtCity.getText().toString(),
                edtPassword.getText().toString(),
                edtUsername.getText().toString(),
                edtAddress.getText().toString(),
                edtEmail.getText().toString(),
                edtFirstName.getText().toString(),
                edtLastName.getText().toString(),
                edtPostalCode.getText().toString()
        );

        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, ViewRegInfoActivity.class);
        intent.putExtra("email", edtEmail.getText().toString());
        startActivity(intent);
    }
}
