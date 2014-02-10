package com.sportnetwork.common.model;



public class Point {

	private PointType type;
	private double latitude ;
	private double longitude;
	
	
	public Point() {

	}
	
	public Point(double x,double y,PointType type) {
		this.latitude=x;
		this.longitude=y;
		this.type=type;
	}
	
	public Point(double x,double y) {
		this.latitude=x;
		this.longitude=y;
		this.type=PointType.NONE;
	}
	public PointType getType() {
		return type;
	}

	public void setType(PointType type) {
		this.type = type;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
	
}