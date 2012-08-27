package com.gceylan.buttonlistener;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	TextView title;
	
	Button btnDisplay, btnListView;
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
    
    public void addListenerOnButton() {
    	btnDisplay = (Button) findViewById(R.id.btn_play);
    	btnListView = (Button) findViewById(R.id.btn_list_view);
    	
    	myListener = new Button.OnClickListener() {

 			public void onClick(View v) {
 				int buttonID = ((Button) v).getId();
 				
 				switch (buttonID) {
				case R.id.btn_play:
					Toast.makeText(MainActivity.this,
	 						R.string.popup_message1,
	 						Toast.LENGTH_LONG).show();
					break;
				
				case R.id.btn_list_view:
					Toast.makeText(MainActivity.this,
	 						R.string.popup_message2,
	 						Toast.LENGTH_SHORT).show();
					startActivity(new Intent(MainActivity.this, ListViewScreen.class));
					break;

				default:
					break;
				}
 				
 			}
 		};
 		
 		btnDisplay.setOnClickListener(myListener);
 		btnListView.setOnClickListener(myListener);
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
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch (item.getItemId()) {
		case R.id.item_about:
			Toast.makeText(MainActivity.this, "Abouth is Selected!", Toast.LENGTH_SHORT).show();
			return true;

		case R.id.item_options:
			Toast.makeText(MainActivity.this, "Options is Selected!", Toast.LENGTH_SHORT).show();
			return true;
		
		case R.id.item_theme:
			Toast.makeText(MainActivity.this, "(Sub Menu) Theme is Selected!", Toast.LENGTH_SHORT).show();
			return true;
		
		case R.id.item_settings:
			Toast.makeText(MainActivity.this, "(Sub Menu) Settings is Selected!", Toast.LENGTH_SHORT).show();
			return true;
		
		case R.id.item_exit:
			Toast.makeText(MainActivity.this, "Exit is Selected!", Toast.LENGTH_SHORT).show();
			this.finish();
			return true;
		
		case R.id.item_restart:
			Toast.makeText(MainActivity.this, "Restart is Selected!", Toast.LENGTH_SHORT).show();
			return true;

		default:
			break;
		}
    	
    	return super.onOptionsItemSelected(item);
    }
}
