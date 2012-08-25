package com.gceylan.buttonlistener;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView title;
	
	Button btn;
	Button.OnClickListener myListener;
	RadioButton.OnClickListener myRadioListener;
	
	RadioButton raRed, raGreen, raBlue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        title = (TextView) findViewById(R.id.main_activity_title);
        
        addListenerOnButton();
        addListenerOnRadioButton();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    public void addListenerOnButton() {
    	btn = (Button) findViewById(R.id.btn_play);
    	
    	myListener = new Button.OnClickListener() {

 			public void onClick(View v) {
 				Toast.makeText(MainActivity.this,
 						R.string.popup_message,
 						Toast.LENGTH_LONG).show();
 			}
 		};
 		btn.setOnClickListener(myListener);
    }
    
    public void addListenerOnRadioButton() {
    	raRed = (RadioButton) findViewById(R.id.radio_red);
    	raGreen = (RadioButton) findViewById(R.id.radio_green);
    	raBlue = (RadioButton) findViewById(R.id.redio_blue);
    	
    	myRadioListener = new RadioButton.OnClickListener() {

			public void onClick(View v) {
				int id = ((RadioButton) v).getId();
				
				if (id == R.id.radio_red)
					title.setTextColor(Color.RED);
				else if (id == R.id.radio_green)
					title.setTextColor(Color.GREEN);
				else if (id == R.id.redio_blue)
					title.setTextColor(Color.BLUE);
			}
    		
    	};
    	
    	raRed.setOnClickListener(myRadioListener);
    	raGreen.setOnClickListener(myRadioListener);
    	raBlue.setOnClickListener(myRadioListener);
    	
    }
}
