package com.sportnetwork.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportnetwork.common.mongoservice.INotificationService;
import com.sportnetwork.common.mongoservice.IVenueService;

@Service
public class AbstractManager {

	@Autowired
	protected IVenueService venueService;
	
	@Autowired
	protected INotificationService notificationService;
	
}
