package com.gceylan.callingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] numberNames;

	public ImageAdapter(Context context, String[] numberNames) {
		this.context = context;
		this.numberNames = numberNames;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.mobile, null);

			// set value into textview
			TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
			textView.setText(numberNames[position]);

			// set image based on selected text
			ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);

			imageView.setImageResource(NO_SELECTION);

		} else {
			gridView = (View) convertView;
		}

		return gridView;
	}

	@Override
	public int getCount() {
		return numberNames.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
}
