package com.sportnetwork.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportnetwork.common.model.MobileDevice;


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
	public  void  nofity( HttpServletRequest request, HttpServletResponse response) {
		
		notificationManager.sendNotification(
				new MobileDevice(
				"APA91bGX1LNUMjAIWUAlcupSUwLNY58hIyY43m_AxeKY2XEHiUDvBKgw6xpUWr3WIyKBu4loef-VVcCQN5Lj83MtubyKyo34ZXPnMtUQuLG9XZJw2kJarHC0ttU7qqZY4_vuV-AB5l8CjLII7eolsYJbkNwWoZK_UjsyJoco9NB-xQcWRqQdUjM"),
				"naber la"
				);
		
	}
	
	
	
}
