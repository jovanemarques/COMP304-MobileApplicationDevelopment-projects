package test.menus;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MenuTestActivity extends Activity {
	
	private TextView displayTextView;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        displayTextView = (TextView) findViewById(R.id.displayTextView);
    }
    //Initialize the contents of the Activity's standard options menu
    public boolean onCreateOptionsMenu(Menu menu) {
        //show the menu
    	getMenuInflater().inflate(R.menu.pizza, menu);
    	return true;
    }
    // called whenever an item in your options menu is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {    
    	//handle menu items  y their id
        switch (item.getItemId())
    	{        
    		case R.id.item1:
    			//displayTextView.setText("You selected start!");
    			Toast.makeText(this,
                        "You selected Meat Supreme!",
                        Toast.LENGTH_LONG).show();
	    		break;        
    		case R.id.item2:
    			Toast.makeText(this,
                        "You selected Super Hawaiian!",
                        Toast.LENGTH_LONG).show();
    			break;        
			case R.id.item3: Toast.makeText(this,
                    "You selected Veggie!",
                    Toast.LENGTH_LONG).show();
    			break;
    	}    
    	return true;
    }
}