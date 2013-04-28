package com.gceylan.callingapp;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	TextView viewPhoneNumber;

	GridView gridView;

	static final String[] NUMBER_NAMES = new String[] { "1", "2", "3", "4",
			"5", "6", "7", "8", "9", "Çevir", "0", "Sil" };

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		viewPhoneNumber = (TextView) findViewById(R.id.phone_number);

		gridView = (GridView) findViewById(R.id.gridView1);

		gridView.setAdapter(new ImageAdapter(getApplicationContext(),
				NUMBER_NAMES));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				TextView gridItem = (TextView) v
						.findViewById(R.id.grid_item_label);
				String numberToCall = viewPhoneNumber.getText().toString();

				if (gridItem.getText().equals("Çevir")) {
					Intent callIntent = new Intent(Intent.ACTION_CALL, Uri
							.parse("tel:" + numberToCall));
					startActivity(callIntent);
				} else if (gridItem.getText().equals("Sil")) {
					if (numberToCall.length() != 0)
						numberToCall = numberToCall.substring(0,
								numberToCall.length() - 1);
				} else
					numberToCall = numberToCall + gridItem.getText().toString();

				viewPhoneNumber.setText(numberToCall);
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
