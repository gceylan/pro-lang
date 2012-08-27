package com.gceylan.buttonlistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class OsSelectActivity extends Activity {
	CheckBox chkIos, chkAnd, chkWin;
	Button display;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_select);
        
        addListenerOnButton();
        addListenerOnIOS();
        
    }
    
    public void addListenerOnIOS() {
    	//chkIos = (CheckBox) findViewById(R.id.chkIos);
    	
    	chkIos.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				if (((CheckBox) v).isChecked()) {
					Toast.makeText(OsSelectActivity.this,
							"Bro, try Android :)", Toast.LENGTH_LONG).show();
				}
				
			}
		});
    }
    
    public void addListenerOnButton() {
    	
    	chkIos = (CheckBox) findViewById(R.id.chkIos);
        chkAnd = (CheckBox) findViewById(R.id.chkAnd);
        chkWin = (CheckBox) findViewById(R.id.chkWin);
        
        display = (Button) findViewById(R.id.display);
        
        display.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				StringBuffer sb = new StringBuffer();
				sb.append("IPhone check: ").append(chkIos.isChecked());
				sb.append("\nAndroid check: ").append(chkAnd.isChecked());
				sb.append("\nWindows Mobile check: ").append(chkWin.isChecked());
				
				Toast.makeText(OsSelectActivity.this, sb.toString(),
						Toast.LENGTH_LONG).show();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
