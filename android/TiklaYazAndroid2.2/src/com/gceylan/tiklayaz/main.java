package com.gceylan.tiklayaz;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class main extends Activity {
    
	TextView cikti;
	EditText girdi;
	Button button1, yeniEkran;
	MediaPlayer mp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mp = MediaPlayer.create(main.this, R.raw.click);
        
        cikti = (TextView) findViewById(R.id.cikti);
        girdi = (EditText) findViewById(R.id.girdi);
        button1 = (Button) findViewById(R.id.button1);
        yeniEkran = (Button) findViewById(R.id.button2);
        
        button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mp.start();
				cikti.setText(girdi.getText());
				girdi.setText("");
			}
		});
        
        yeniEkran.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				mp.start();
				startActivity(new Intent("com.gceylan.tiklayaz.EKRANIKI"));
			}
		});
        
    }
}