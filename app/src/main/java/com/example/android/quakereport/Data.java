package com.example.android.quakereport;

public class Data
{ 
	private String mCityName;
	private String mMag;
	private long mDateinMls;
	
	public Data(String mag, String city, long date) {
		mMag = mag;
		mCityName = city;
		mDateinMls = date;
		
	}
	public String getCityName() {
		return mCityName;
	}
	public String getFelt(){
		return mMag;
	}
	public long getDate(){
		return mDateinMls;
	}
} 

