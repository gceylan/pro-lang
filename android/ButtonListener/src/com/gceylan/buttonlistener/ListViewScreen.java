package com.gceylan.buttonlistener;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewScreen extends ListActivity {
	
	String activityNames[] = {
			"OsSelectActivity", "MainActivity"
	};
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		switch (position) {
		case 0:
			startActivity(new Intent(ListViewScreen.this, OsSelectActivity.class));
			break;
		
		case 1:
			startActivity(new Intent(ListViewScreen.this, MainActivity.class));
			break;

		default:
			break;
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, activityNames));
	}
}
