package com.example.android.quakereport;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataApdapter extends ArrayAdapter<Data>
{
	public DataApdapter(Activity context, ArrayList<Data> earthquakes) {
        
        super(context, 0, earthquakes);
}
	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
				R.layout.list_item, parent, false);
        }
		Data currentData = getItem(position);
		TextView city = (TextView) listItemView.findViewById(R.id.city);
		city.setText(currentData.getCityName());
	
		TextView date = (TextView) listItemView.findViewById(R.id.date);
		Date object = new Date(currentData.getDate());
		String formattedDate = formatDate(object);
		date.setText(formattedDate);
		TextView felt = (TextView) listItemView.findViewById(R.id.felt);
		felt.setText(currentData.getFelt());

		TextView time = (TextView) listItemView.findViewById(R.id.times);
		String formattedTime = formatTime(object);
		time.setText(formattedTime);
	
		return listItemView;
		}

	private String formatTime(Date object) {
		SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
		return timeFormat.format(object);
	}

	private String formatDate(Date object) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
		return dateFormat.format(object);
	}
}
