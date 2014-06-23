package com.example.stone.paper.scizzors;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

	public int your_score =0 , comp_score = 0;
	public int chances = 9;
	
	public Button invisible;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// calling our name from previous page
		
		final TextView player_name = (TextView) findViewById(R.id.textView1);
		String datax = "";
		
		try
		{
			FileInputStream fin = openFileInput("names.txt");
			InputStreamReader isr = new InputStreamReader(fin);
			BufferedReader buffereader =  new BufferedReader(isr);
			
			String readString = buffereader.readLine();
			datax = readString;
			isr.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		player_name.setText("Welcome " + datax + "!");
		
		//declaring our variables
		final TextView outputlabel = (TextView) findViewById(R.id.textView2);
		final TextView outputresult = (TextView) findViewById(R.id.textView3);
		final TextView yourscore = (TextView) findViewById(R.id.textView4);
		final TextView compscore = (TextView) findViewById(R.id.textView5);
		
		//On initial screen it shows up as 0,0
		yourscore.setText("Your score is " + Integer.toString(your_score));
		compscore.setText("Computer's score is " + Integer.toString(comp_score));
		
		Button getAnswerButton = (Button) findViewById(R.id.button1);
		Button getAnswerButton1 = (Button) findViewById(R.id.button2);
		Button getAnswerButton2 = (Button) findViewById(R.id.button3);	
		invisible = (Button) findViewById(R.id.button4);
		
		getAnswerButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String[] answers = {
						"The Computer chose...Stone",
						"The Computer chose...Paper",
						"The Computer chose...Scissors" };
				
				String answer = "";
				String result;
				if(chances>0)
				{
				Random randomGenerator = new Random();
				int randomNumber = randomGenerator.nextInt(answers.length);
				answer = answers[randomNumber];
				
				if(randomNumber == 0)
				{
					result = "Tie!";
				}
				else if(randomNumber==1)
				{
					result = "Computer wins";
					comp_score++;
					compscore.setText("Computer's score is " + Integer.toString(comp_score));
				}
				else
				{
					result = "You win!";
					your_score++;
					yourscore.setText("Your score is " + Integer.toString(your_score));
				}
				outputlabel.setText(answer);	
				outputresult.setText(result);
				}
				else if (chances == 0)
				{
					invisible.setVisibility(View.VISIBLE);
				}
				chances--;
			}
		});
		
		getAnswerButton1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String[] answers = {
						"The Computer chose...Stone",
						"The Computer chose...Paper",
						"The Computer chose...Scissors" };
				
				String answer = "";
				String result;
				if(chances>0)
				{
				Random randomGenerator = new Random();
				int randomNumber = randomGenerator.nextInt(answers.length);
				answer = answers[randomNumber];
				
				if(randomNumber == 0)
				{
					result = "You win!";
					your_score++;
					yourscore.setText("Your score is " + Integer.toString(your_score));
				}
				else if(randomNumber==1)
				{
					result = "Tie!";
				}
				else
				{
					result = "Computer wins";
					comp_score++;
					compscore.setText("Computer's score is " + Integer.toString(comp_score));

				}
	
				outputlabel.setText(answer);				
				outputresult.setText(result);
				}
				else if (chances == 0)
				{
					invisible.setVisibility(View.VISIBLE);
				}
				chances--;
			}
				
		});
		
		getAnswerButton2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String[] answers = {
						"The Computer chose...Stone",
						"The Computer chose...Paper",
						"The Computer chose...Scissors" };
				
				String answer = "";
				String result;
				if(chances>0)
				{
				Random randomGenerator = new Random();
				int randomNumber = randomGenerator.nextInt(answers.length);
				answer = answers[randomNumber];
				
				if(randomNumber == 0)
				{
					result = "Computer wins";
					comp_score++;
					compscore.setText("Computer's score is " + Integer.toString(comp_score));
				}
				else if(randomNumber==1)
				{
					result = "You win!";
					your_score++;
					yourscore.setText("Your score is " + Integer.toString(your_score));
				}
				else
				{
					result = "Tie!";
				}
				
				outputlabel.setText(answer);	
				outputresult.setText(result);
				}
				else if (chances == 0)
				{
					invisible.setVisibility(View.VISIBLE);
				}
				chances--;
				
			}
			});
		
			invisible.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.stone.paper.scizzors.FINALEND"));
				finish();
				}
			});
		
		
		
		{
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
