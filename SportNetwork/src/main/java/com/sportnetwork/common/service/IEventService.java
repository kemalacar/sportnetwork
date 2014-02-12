package com.sportnetwork.common.service;

import com.sportnetwork.common.model.Event;

public interface IEventService {
	public void addEvent(Event event);
	public void deleteEvent(String eventID);
	public void getEvent(String eventID);
	public void updateEvent(String eventID);
	public void addarticipantToEvent(String participantId , String eventID);
}
