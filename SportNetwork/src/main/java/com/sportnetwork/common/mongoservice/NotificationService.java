package com.sportnetwork.common.mongoservice;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.sportnetwork.common.model.MobileDevice;

public class NotificationService extends MongoService implements INotificationService  {

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
		device.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(device, COLLECTION_NAME);
	}

	@Override
	public void unRegisterDevice(String regId) {
		mongoTemplate.remove(new Query(Criteria.where("registrationId").is(regId)),MobileDevice.class);		
	}

	@Override
	public List<MobileDevice> getRegisteredDevices() {
		return mongoTemplate.findAll(MobileDevice.class, COLLECTION_NAME);
	}

	
}
