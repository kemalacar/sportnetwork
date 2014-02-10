package com.sportnetwork.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportnetwork.common.model.MobileDevice;
import com.sportnetwork.common.model.VenueItem;


@Controller
@RequestMapping(value = "/registration")
public class RegistrationController extends AbstractController{

	@RequestMapping(value = "/register")
	public  void  registerUser(@RequestParam String registrationId, HttpServletRequest request, HttpServletResponse response) {
		
		notificationManager.registerDevice(new MobileDevice(registrationId));
		
	}
	
	@RequestMapping(value = "/unregister")
	public  void  unRegisterUser(@RequestParam String registrationId, HttpServletRequest request, HttpServletResponse response) {
		
		notificationManager.unRegisterDevice(registrationId);
		
	}
	
	
	@RequestMapping(value = "notify", method = RequestMethod.GET)
	public  void  nofity(@RequestParam String venueId, HttpServletRequest request, HttpServletResponse response) {
		
		VenueItem venue = 	mapManager.getVenueById(venueId);
		notificationManager.sendNotification(venue.getSubscriberList(), venue.getName()+ " ");
		
	}
	
}
