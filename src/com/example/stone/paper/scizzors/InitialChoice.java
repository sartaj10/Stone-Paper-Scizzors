package com.example.stone.paper.scizzors;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class InitialChoice extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial);
		Thread timer = new Thread() {
			@Override
			public void run() {
				try{
					sleep(3000);
					startActivity(new Intent("com.example.stone.paper.scizzors.STORE"));
					finish();
				} catch(InterruptedException e){
					e.printStackTrace();
				} 
			}
		};
		timer.start();
	}
}
