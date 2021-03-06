package com.sportnetwork.common.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.sportnetwork.common.model.MobileDevice;
import com.sportnetwork.common.service.IDeviceService;

public class DeviceService extends MongoService implements IDeviceService  {

	public static final String COLLECTION_NAME = "mobileDevice";
	
	@Deprecated
	public void refreshColection() {
		if (!mongoTemplate.collectionExists(MobileDevice.class)) {
			mongoTemplate.createCollection(MobileDevice.class);
		}else{
			mongoTemplate.dropCollection(MobileDevice.class);
			mongoTemplate.createCollection(MobileDevice.class);
		}
		
	}
	
	@Override
	public void registerDevice(MobileDevice device) {
		add(device);
	}
	
	@Override
	public void unRegisterDevice(String regId) {
		mongoTemplate.remove(new Query(Criteria.where("registrationId").is(regId)),MobileDevice.class);		
	}

	@Override
	public List<MobileDevice> getRegisteredDevices() {
		return mongoTemplate.findAll(MobileDevice.class, COLLECTION_NAME);
	}

	@Override
	public MobileDevice getDeviceByRegistrationId(String regId) {
		List<MobileDevice>  devices =mongoTemplate.find(
				new Query(Criteria.where("registrationId").is(regId)),MobileDevice.class);
		
		if(devices.size()==1){
			return devices.get(0);
		}
		return null;
	}
	
	@Override
	public String getTemplateName() {
		return COLLECTION_NAME;
	}

}
