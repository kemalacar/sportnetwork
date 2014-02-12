package com.sportnetwork.common.enums;

public enum EventType {
	NOTSTARTED(1), STARTED(2), DONE(3);

	private int type;
	private EventType(int type) {
		this.setType(type);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

}
