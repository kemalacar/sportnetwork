package com.sportnetwork.common.model;


public class VenueItem extends MongoModel{
	
	
	private String uniqeId;
	private Point point;
	private String name;
	
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUniqeId() {
		return uniqeId;
	}
	public void setUniqeId(String uniqeId) {
		this.uniqeId = uniqeId;
	}
	
	
	
}
