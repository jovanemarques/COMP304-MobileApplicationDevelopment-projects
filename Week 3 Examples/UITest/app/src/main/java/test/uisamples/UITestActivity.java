package test.uisamples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class UITestActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //handling check boxes
        final CheckBox check_button = (CheckBox) findViewById(R.id.chkDegree);

        final TextView tv = (TextView)findViewById(R.id.txtProgram);

        check_button.setOnClickListener(new View.OnClickListener()  {

	        public void onClick (View v) {		        
		        tv.setText(check_button.isChecked() ? 
		        "This option is checked" :
		        "This option is not checked");
	        }
        });
        //handling radio buttons
        final RadioGroup group = (RadioGroup)findViewById(R.id.RadioGroup01);
        
        group.setOnCheckedChangeListener(new
	        RadioGroup.OnCheckedChangeListener() {
		        public void onCheckedChanged(
		        RadioGroup group, int checkedId) {
			        if (checkedId != -1) {
			        RadioButton rb = (RadioButton)
			        findViewById(checkedId);
			        if (rb != null) {
			        	tv.setText("You chose: " + rb.getText());
			        }
			        } 
			        else {
			        	tv.setText("Choose 1");
			        }
	        }
        });
        
        //handling a rating bar
        RatingBar rate = (RatingBar) findViewById(R.id.ratebar1);
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
	        {
	        public void onRatingChanged(RatingBar ratingBar,float rating, boolean fromTouch) 
	        {
	        	tv.setText("Rating: "+ rating);
	        }
        });
        
    }
}