package net.learn2develop.BasicViews3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class BasicViews3Activity extends Activity {
    String[] programs = {
            "Software Engineering Technology",
            "Interactive Gaming",
            "Health Informatics Technology",
            "Software Systems Design"
        };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_dropdown_item_1line, programs);

        AutoCompleteTextView textView = (AutoCompleteTextView)
            findViewById(R.id.txtPrograms);

        textView.setThreshold(3);
        textView.setAdapter(adapter);
    }
}