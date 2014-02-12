package com.sportnetwork.common.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sportnetwork.common.model.Event;
import com.sportnetwork.common.model.MongoModel;
import com.sportnetwork.common.service.IMongoService;

public abstract class MongoService implements IMongoService {
	
	public  abstract String getTemplateName();
	
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	@Deprecated
	public void refreshColection(Class c) {
		if (!mongoTemplate.collectionExists(c)) {
			mongoTemplate.createCollection(c);
		}else{
			mongoTemplate.dropCollection(c);
			mongoTemplate.createCollection(c);
		}
		
	}
	
	@Override
	public void add(MongoModel model) {
		model.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(model, getTemplateName());	
	}
	
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(MongoModel model) {
		// TODO Auto-generated method stub
		
	}
}
