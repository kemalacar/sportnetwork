package com.sportnetwork.common.service.impl;


import com.sportnetwork.common.model.Event;
import com.sportnetwork.common.service.IEventService;


public class EventService extends MongoService implements IEventService {

	public static final String COLLECTION_NAME = "event";



	@Override
	public void addEvent(Event event) {
		add(event);
	}

	@Override
	public void deleteEvent(String eventID) {

	}

	@Override
	public void getEvent(String eventID) {

	}

	@Override
	public void updateEvent(String eventID) {

	}

	@Override
	public void addarticipantToEvent(String participantId, String eventID) {

	}

	@Override
	public String getTemplateName() {
		return COLLECTION_NAME;
	}


}
