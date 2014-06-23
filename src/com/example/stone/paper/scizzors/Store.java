package com.example.stone.paper.scizzors;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Store extends Activity{

	String Name;
	String Chances;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.store);
		
		final EditText editText1 = (EditText) findViewById(R.id.editText1);
		Button InputRead = (Button) findViewById(R.id.buttonSave);
		
		InputRead.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Name = editText1.getText().toString();
				try{
					FileOutputStream fos = openFileOutput("names.txt", MODE_WORLD_READABLE);
				    OutputStreamWriter osw = new OutputStreamWriter(fos);
				    try{
					osw.write(Name);
					osw.flush();
					osw.close();
					startActivity(new Intent("com.example.stone.paper.scizzors.MAINACTIVITY"));
				    finish();
				    } 
				    catch (IOException e) 
				    {
				    e.printStackTrace();
				    }
				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		});
	}
}

