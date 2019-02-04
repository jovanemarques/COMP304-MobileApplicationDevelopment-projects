package com.example.listviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity{
	String[] activities;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView lstView = getListView();
		
        lstView.setChoiceMode(ListView.CHOICE_MODE_NONE);      
        lstView.setTextFilterEnabled(true);
		//populate the array activities
        activities = getResources().getStringArray(R.array.activities);
		//set the adpater to array activities
		//binds the array with the list view
        setListAdapter(new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, activities));
    }
    
    public void onListItemClick(
    ListView parent, View v, int position, long id)
    {
    	Intent i=null;
        switch (position)
        {
        	case 0:
        		i = new Intent(this, DrawBitmapActivity.class);
        		break;
        		
        	case 1:
        		i = new Intent(this, DrawTextActivity.class);
        		break;
        	case 2:
        		i = new Intent(this, DrawShapeActivity.class);
        		break;
        }
        startActivity(i);
        
    }

	

}
