package com.sportnetwork.manager;

import com.sportnetwork.common.model.Event;
import com.sportnetwork.common.model.VenueItem;

public class EventManager  extends AbstractManager{

	public void addEvent(Event event) {
		
		eventService.addEvent(event);
		
	}
	
}
