package com.gceylan.geneltekrar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Main extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.acilis);
		
		Thread thread = new Thread() {
			public void run() {
				try {
					sleep(5000);
					startActivity(new Intent("com.gceylan.geneltekrar.ACILISEKRANI"));
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					finish();
				}
				finish();
			}
		};
		
		thread.start();
	}
}