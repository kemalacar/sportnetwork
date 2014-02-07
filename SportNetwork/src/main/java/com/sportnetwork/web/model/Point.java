package com.sportnetwork.web.model;



public class Point {

	public PointType type;
	public double x ;
	public double y;
	
	
	public Point() {

	}
	
	public Point(double x,double y,PointType type) {
		this.x=x;
		this.y=y;
		this.type=type;
	}
	
	public Point(double x,double y) {
		this.x=x;
		this.y=y;
		this.type=PointType.NONE;
	}
	public PointType getType() {
		return type;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setType(PointType type) {
		this.type = type;
	}
	
	
	
}