package com.sportnetwork.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportnetwork.common.model.Event;
import com.sportnetwork.common.model.MobileDevice;
import com.sportnetwork.common.model.Notification;
import com.sportnetwork.common.model.VenueItem;
import com.sportnetwork.web.utils.Constants;


@Controller
@RequestMapping(value = "/registration")
public class RegistrationController extends AbstractController{

	@RequestMapping(value = "/register")
	public  void  registerUser(@RequestParam String registrationId, HttpServletRequest request, HttpServletResponse response) {
		
		notificationManager.registerDevice(new MobileDevice(registrationId));
		
	}
	
	@RequestMapping(value = "/addEvent")
	public  void  addEvent(@RequestParam String registrationId,  String title,  String desc,  String venueId,
			HttpServletRequest request, HttpServletResponse response) {
		
		Event e = new Event(title, desc, venueId);
		e.setCreateDate(new Date());
		e.addOwner(registrationId);
		eventManager.addEvent(e);
	
		System.out.println("event eklendi : "+title);
		
		VenueItem venue = mapManager.getVenueById(venueId);
		
		Notification n = new Notification(Constants.SPORTNETWORK_GOOGLE_APIKEY);
		n .setRegIdList(venue.getSubscriberList());
		n.getMessages().put("message", "mekan "+venue.getName()+"** event:"+title);
		
		notificationManager.sendNotification(n);
		
	}
	
	@RequestMapping(value = "/unregister")
	public  void  unRegisterUser(@RequestParam String registrationId, HttpServletRequest request, HttpServletResponse response) {
		
		notificationManager.unRegisterDevice(registrationId);
		
	}
	
	
	@RequestMapping(value = "notify", method = RequestMethod.GET)
	public  void  nofity(@RequestParam String venueId, HttpServletRequest request, HttpServletResponse response) {
		
		VenueItem venue = 	mapManager.getVenueById(venueId);
		
		Notification n = new Notification(Constants.SPORTNETWORK_GOOGLE_APIKEY);
		n .setRegIdList(venue.getSubscriberList());
		n.getMessages().put("message", venue.getName()+ " ");
		
		notificationManager.sendNotification(n);
		
	}
	
}
