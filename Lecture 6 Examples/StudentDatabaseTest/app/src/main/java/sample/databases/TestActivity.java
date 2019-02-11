package sample.databases;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
  
import android.app.Activity; 
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle; 
import android.util.Log; 
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView; 
  
public class TestActivity extends Activity 
{ 
	//
    private static final String tables[]={"tbl_student","tbl_program"}; 
    //
    private static final String tableCreatorString[] =
			{"CREATE TABLE tbl_student (student_id INTEGER PRIMARY KEY AUTOINCREMENT , firstname TEXT, lastname TEXT);",
 	"CREATE TABLE tbl_program (program_id INTEGER PRIMARY KEY AUTOINCREMENT , program_name TEXT);"};
    
 	@Override
    public void onCreate(Bundle savedInstanceState)
    { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.main); 
  
        final DatabaseManager db = new DatabaseManager(this); 
        //db.createDatabase(getApplicationContext());
        db.dbInitialize( tables,tableCreatorString);
        final String fields[] = {"student_id","firstname","lastname"};
        final String record[] = new String[3];
        // Handle Save button
 		final Button btnSaveStudent = (Button) findViewById(R.id.ButtonSave);
 		final EditText studentFirstName = (EditText) findViewById(R.id.EditTextFName);
		final EditText studentLastName = (EditText) findViewById(R.id.EditTextLName);
		final TextView display = (TextView) findViewById(R.id.TextViewDisplay);
		//		
		btnSaveStudent.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

 				record[1]= studentFirstName.getText().toString();
 				record[2]= studentLastName.getText().toString();
 		        Log.d("Name: ", record[1]);	       
 		        //populate the row with some values
 		        ContentValues values = new ContentValues();
 		        //for (int i=1;i<record.length;i++)
 		        	//values.put(fields[i],record[i]);
 		        //add the row to the database
 		        db.addRecord(values, "tbl_student", fields,record);
 		        
 			}
 		});
		final Button btnShowStudent = (Button) findViewById(R.id.ButtonShowStudents);
 		btnShowStudent.setOnClickListener(new View.OnClickListener() {
 			public void onClick(View v) {

 				// Reading all records 
 		        List table = db.getTable("tbl_student");        
 		  
 		        for (Object o : table) { 
 		            ArrayList row = (ArrayList)o; 
 		                // Writing table to log
 		            String output="";
 		            for (int i=0;i<row.size();i++)
 		            {
 		            	output+= row.get(i).toString() + " ";
 		            	output+="\n";
 		            }
 		           display.setText(output);   	
 		           
 		        } 
 			}
 		});
        
    } 
} 