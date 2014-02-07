package com.sportnetwork.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class VenueItem {
	
	@Id
	private String id;
	
	private String uniqeId;
	private Point point;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
