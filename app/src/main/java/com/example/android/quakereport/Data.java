package com.example.android.quakereport;

public class Data
{
	private String mCityName;
	private double mMag;
	private long mDateinMls;
	private String GS_URL;

	public Data(double mag, String city, long date,String url) {
		mMag = mag;
		mCityName = city;
		mDateinMls = date;
		GS_URL = url;

	}
	public String getCityName() {
		return mCityName;
	}
	public double getMagnitude(){
		return mMag;
	}
	public long getDate(){
		return mDateinMls;
	}
	public String getUrl(){
		return GS_URL;
	}
}

