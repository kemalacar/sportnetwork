package com.sportnetwork.common.mongoservice;

import java.util.List;

import com.sportnetwork.common.model.MobileDevice;

public interface IDeviceService extends IMongoService{
	public void registerDevice(MobileDevice device);
	public void unRegisterDevice(String regId);
	public List<MobileDevice> getRegisteredDevices ();
	MobileDevice getDeviceByRegistrationId(String regId);
}
