package com.gceylan.buttonlistener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {
	
	Thread thread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		startSplash(5000);
		
	}
	
	public void startSplash(final long time) {
		thread = new Thread() {
			
			@Override
			public void run() {
				super.run();
				try {
					sleep(time);
					
					Intent intent = new Intent(SplashActivity.this, MainActivity.class);
					startActivity(intent);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					finish();
				}
				
			}
		};
		
		thread.start();
	}
}
