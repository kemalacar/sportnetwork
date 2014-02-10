package com.sportnetwork.common.model;

import java.util.Date;

public class MobileDevice extends MongoModel {

	private String registrationId;
	private Date registrationDate;
	private String deviceId;

	private User user;
	
	public MobileDevice() {
	}
	
	public MobileDevice(String registrationId) {
		this.registrationId = registrationId;
	}
	

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
