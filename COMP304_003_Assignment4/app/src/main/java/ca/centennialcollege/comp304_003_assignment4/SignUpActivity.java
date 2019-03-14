package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {

    DBManager dbManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dbManager = DBManager.getDb(this);

        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.shared_preferences), MODE_PRIVATE);
        String username = sharedPreferences.getString(getString(R.string.username), "");

        //if admin logged
        if (dbManager.isStaff(username)) {
            Spinner spAudience = findViewById(R.id.spAudience);
            List<String> data = dbManager.getAllAudienceIds();

            ArrayAdapter<String> adapter = new ArrayAdapter<>
                    (this, android.R.layout.simple_spinner_item, data);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spAudience.setAdapter(adapter);
            spAudience.setVisibility(View.VISIBLE);
            spAudience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    List<String> audienceData = dbManager.getAudienceInfo(adapterView.getSelectedItem().toString());

                    EditText edtEmail = findViewById(R.id.edtEmail);
                    EditText edtUsername = findViewById(R.id.edtUsername);
                    EditText edtPassword = findViewById(R.id.edtPassword);
                    EditText edtFirstName = findViewById(R.id.edtFirstName);
                    EditText edtLastName = findViewById(R.id.edtLastName);
                    EditText edtAddress = findViewById(R.id.edtAddress);
                    EditText edtCity = findViewById(R.id.edtCity);
                    EditText edtPostalCode = findViewById(R.id.edtPostalCode);

                    edtEmail.setText(audienceData.get(0));
                    edtEmail.setEnabled(false);
                    edtUsername.setText(audienceData.get(1));
                    edtPassword.setText(audienceData.get(2));
                    edtFirstName.setText(audienceData.get(3));
                    edtLastName.setText(audienceData.get(4));
                    edtAddress.setText(audienceData.get(5));
                    edtCity.setText(audienceData.get(6));
                    edtPostalCode.setText(audienceData.get(7));
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
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
