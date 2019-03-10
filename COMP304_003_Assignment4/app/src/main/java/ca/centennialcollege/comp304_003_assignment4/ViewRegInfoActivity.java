package ca.centennialcollege.comp304_003_assignment4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ViewRegInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reg_info);

        showInfo();
    }

    private void showInfo() {
        //get from the DB
        Toast.makeText(getApplicationContext(), "IMPLEMENT!!!", Toast.LENGTH_LONG).show();
    }

    public void btnGoBack_Click(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
