package com.sportnetwork.common.mongoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.sportnetwork.common.model.MongoModel;

public abstract class MongoService {

	@Autowired
	protected MongoTemplate mongoTemplate;
	
}
