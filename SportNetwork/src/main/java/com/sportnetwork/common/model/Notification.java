package com.sportnetwork.common.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Notification {
	
	private String apiKey;
	private Map<String,String> messages = new  HashMap<>() ; 
	private  List<String> regIdList;
	
	
	
	public Notification(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public Map<String, String> getMessages() {
		return messages;
	}
	public void setMessages(Map<String, String> messages) {
		this.messages = messages;
	}
	public List<String> getRegIdList() {
		return regIdList;
	}
	public void setRegIdList(List<String> regIdList) {
		this.regIdList = regIdList;
	}
	
	
}
