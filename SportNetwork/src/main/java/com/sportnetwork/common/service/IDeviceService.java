package com.sportnetwork.common.service;

import java.util.List;

import com.sportnetwork.common.model.MobileDevice;

public interface IDeviceService {
	public void registerDevice(MobileDevice device);
	public void unRegisterDevice(String regId);
	public List<MobileDevice> getRegisteredDevices ();
	MobileDevice getDeviceByRegistrationId(String regId);
}
