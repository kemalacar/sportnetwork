package com.sportnetwork.web.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;

import com.sportnetwork.manager.EventManager;
import com.sportnetwork.manager.MapManager;
import com.sportnetwork.manager.NotificationManager;

public class AbstractController {
	
	@Autowired
	MapManager mapManager;
	
	@Autowired
	NotificationManager notificationManager;
	
	@Autowired
	EventManager eventManager;
	
	@Autowired
	ServletContext servletContext;
	
	protected void createJSONResponse(HttpServletResponse response, Object jsonBean, MediaType jsonMimeType) {
		MappingJacksonHttpMessageConverter jsonConverter = new MappingJacksonHttpMessageConverter();
		if ( jsonConverter.canWrite(jsonBean.getClass(), jsonMimeType) ) {
			try {
				jsonConverter.write(jsonBean, jsonMimeType, new ServletServerHttpResponse(response));
			} catch (IOException ex) {
			} catch (HttpMessageNotWritableException ex) {
			}
		}
	}
	
	protected void createJSONResponse(HttpServletResponse response, Object jsonBean) {
		createJSONResponse(response, jsonBean, MediaType.APPLICATION_JSON);
	}
	
}
