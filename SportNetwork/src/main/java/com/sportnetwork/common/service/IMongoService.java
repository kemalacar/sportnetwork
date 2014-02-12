package com.sportnetwork.common.service;

import com.sportnetwork.common.model.MongoModel;


public interface IMongoService {
	public void add(MongoModel model);
	public void delete(String id);
	public void update(MongoModel model);
//	public MongoModel find(String id);
}
