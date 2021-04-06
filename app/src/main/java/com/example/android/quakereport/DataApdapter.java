package com.example.android.quakereport;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;

public class DataApdapter extends ArrayAdapter<Data>
{
	static final String LOCATION_SEPARATOR = " of ";
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
		String originalLocation = currentData.getCityName();


		String primaryLocation;
		String locationOffset;
		if (originalLocation.contains(LOCATION_SEPARATOR)) {
			String[] parts = originalLocation.split(LOCATION_SEPARATOR);
			locationOffset = parts[0] + LOCATION_SEPARATOR;
			primaryLocation = parts[1];
		} else {
			locationOffset = getContext().getString(R.string.near_the);
			primaryLocation = originalLocation;
		}



		TextView city = (TextView) listItemView.findViewById(R.id.city);
		city.setText(primaryLocation);

		TextView offset = (TextView) listItemView.findViewById(R.id.location_offset);
		offset.setText(locationOffset);

		TextView date = (TextView) listItemView.findViewById(R.id.date);
		Date object = new Date(currentData.getDate());
		String formattedDate = formatDate(object);
		date.setText(formattedDate);
		TextView magView = (TextView) listItemView.findViewById(R.id.magnitude);
		String formattedMag = formatMag(currentData.getMagnitude());

		magView.setText(formattedMag);

		// Fetch the background from the TextView, which is a GradientDrawable.
		GradientDrawable magnitudeCircle = (GradientDrawable) magView.getBackground();

		// Get the appropriate background color based on the current earthquake magnitude
		int magnitudeColor = getMagnitudeColor(currentData.getMagnitude());

		// Set the color on the magnitude circle
		magnitudeCircle.setColor(magnitudeColor);

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
	private String formatMag(double magnitude) {
		DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
		return magnitudeFormat.format(magnitude);
	}

	private int getMagnitudeColor(double magnitude) {
		int magnitudeColorResourceId;
		int magnitudeFloor = (int) Math.floor(magnitude);
		switch (magnitudeFloor) {
			case 0:
			case 1:
				magnitudeColorResourceId = R.color.magnitude1;
				break;
			case 2:
				magnitudeColorResourceId = R.color.magnitude2;
				break;
			case 3:
				magnitudeColorResourceId = R.color.magnitude3;
				break;
			case 4:
				magnitudeColorResourceId = R.color.magnitude4;
				break;
			case 5:
				magnitudeColorResourceId = R.color.magnitude5;
				break;
			case 6:
				magnitudeColorResourceId = R.color.magnitude6;
				break;
			case 7:
				magnitudeColorResourceId = R.color.magnitude7;
				break;
			case 8:
				magnitudeColorResourceId = R.color.magnitude8;
				break;
			case 9:
				magnitudeColorResourceId = R.color.magnitude9;
				break;
			default:
				magnitudeColorResourceId = R.color.magnitude10plus;
				break;
		}
		return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
	}

}
