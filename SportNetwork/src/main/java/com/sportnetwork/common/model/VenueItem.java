package com.sportnetwork.common.model;

import java.util.ArrayList;
import java.util.List;


public class VenueItem extends MongoModel{


	private String uniqeId;
	private Point point;
	private String name;

	/**
	 * holds user's uniqeu id
	 */
	private List<String> subscriberList = new ArrayList<>();

	/**
	 * holds users event's id
	 */
	private List<String> eventsList = new ArrayList<>();

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
	public List<String> getSubscriberList() {
		return subscriberList;
	}
	public void setSubscriberList(List<String> subscriberList) {
		this.subscriberList = subscriberList;
	}
	public List<String> getEventsList() {
		return eventsList;
	}
	public void setEventsList(List<String> eventsList) {
		this.eventsList = eventsList;
	}

	public void addSubscriber(String suscriberId){
		subscriberList.add(suscriberId);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("unieqId : \t"+uniqeId+"\n");
		builder.append("point : \t"+point.toString());
		builder.append("name : \t"+name+"\n");
		builder.append("subscriberList \n");
		for (String subs : subscriberList) {
			builder.append(" \t\t"+subs+" \n");
		}
		return builder.toString();
	}
}
