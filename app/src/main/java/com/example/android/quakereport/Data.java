package com.example.android.quakereport;

public class Data
{ 
	private String mCityName;
	private double mFelt;
	private String mDate;
	
	public Data(double felt,String city,String date) {
		mFelt = felt;
		mCityName = city;
		mDate = date;
		
	}
	public String getCityName() {
		return mCityName;
	}
	public double getFelt(){
		return mFelt; 
	}
	public String getDate(){
		return mDate;
	}
} 

