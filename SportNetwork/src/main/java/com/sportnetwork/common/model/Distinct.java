package com.sportnetwork.common.model;

public class Distinct {

	private String name;
	private int latitude;
	private int  latitude_min;
	private int  latitude_sec;
	private int longitude;
	private int longitude_min;
	private int longitude_sec;
	
	private double latitudeAsDouble;
	private double longitudeAsDouble;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLatitude_min() {
		return latitude_min;
	}
	public void setLatitude_min(int latitude_min) {
		this.latitude_min = latitude_min;
	}
	public int getLatitude_sec() {
		return latitude_sec;
	}
	public void setLatitude_sec(int latitude_sec) {
		this.latitude_sec = latitude_sec;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public int getLongitude_min() {
		return longitude_min;
	}
	public void setLongitude_min(int longitude_min) {
		this.longitude_min = longitude_min;
	}
	public int getLongitude_sec() {
		return longitude_sec;
	}
	public void setLongitude_sec(int longitude_sec) {
		this.longitude_sec = longitude_sec;
	}
	
//	derece + (dakika/60) + (saniye/3600)
	public double getLatitudeAsDouble(){
		return latitudeAsDouble;
//		return latitude + (double)latitude_min/60 + (double)latitude_sec/3600;
	}
	
	public double getLongitudeAsDouble(){
		return longitudeAsDouble;
//		return longitude + (double)longitude_min/60 + (double)longitude_sec/3600;
	}
	public void setLatitudeAsDouble(double latitudeAsDouble) {
		this.latitudeAsDouble = latitudeAsDouble;
	}
	public void setLongitudeAsDouble(double longitudeAsDouble) {
		this.longitudeAsDouble = longitudeAsDouble;
	}
}
