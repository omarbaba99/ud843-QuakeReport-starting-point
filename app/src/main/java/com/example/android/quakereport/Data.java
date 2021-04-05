package com.example.android.quakereport;

public class Data
{ 
	private String mCityName;
	private String mMag;
	private String mDate;
	
	public Data(String mag, String city, String date) {
		mMag = mag;
		mCityName = city;
		mDate = date;
		
	}
	public String getCityName() {
		return mCityName;
	}
	public String getFelt(){
		return mMag;
	}
	public String getDate(){
		return mDate;
	}
} 

