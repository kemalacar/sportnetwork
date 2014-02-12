package com.sportnetwork.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sportnetwork.common.enums.EventType;

public class Event extends MongoModel{

	private String 		 title;
	private String 		 description;
	private String 		 venueId;
	private Date 		 createDate;
	private Date 		 startDate;
	private Date 		 endDate;
	private Date 		 cancelDate;
	private EventType 	 type ;
	private List<String> participants;
	private List<String> owners;
	
	public Event(String title, String description, String venueId) {
		this.title = title;
		this.description = description;
		this.venueId = venueId;
		
		participants =  new ArrayList<>();
		owners =  new ArrayList<>();
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getVenueId() {
		return venueId;
	}


	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Date getCancelDate() {
		return cancelDate;
	}


	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}


	public EventType getType() {
		return type;
	}


	public void setType(EventType type) {
		this.type = type;
	}


	public List<String> getParticipants() {
		return participants;
	}


	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}

	public void addParticipant(String id){
		if(!participants.contains(id)){
			participants.add(id);
		}
	}
	
	public void addOwner(String id){
		if(!owners.contains(id)){
			owners.add(id);
		}
	}

	public List<String> getOwners() {
		return owners;
	}


	public void setOwners(List<String> owners) {
		this.owners = owners;
	}

}
