package com.example.android.quakereport;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
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
	
		TextView date = (TextView) listItemView.findViewById(R.id.time);
		date.setText(currentData.getDate());
	
		TextView felt = (TextView) listItemView.findViewById(R.id.felt);
		felt.setText(""+currentData.getFelt());
	
		return listItemView;
		}
		}
