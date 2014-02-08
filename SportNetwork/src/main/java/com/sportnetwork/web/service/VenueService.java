package com.sportnetwork.web.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.sportnetwork.web.model.Point;
import com.sportnetwork.web.model.VenueItem;

@Repository
public class VenueService {


	@Autowired
	private MongoTemplate mongoTemplate;
	
	public static final String COLLECTION_NAME = "venueItem";
	
	public void refreshColection() {
		if (!mongoTemplate.collectionExists(VenueItem.class)) {
			mongoTemplate.createCollection(VenueItem.class);
		}else{
			mongoTemplate.dropCollection(VenueItem.class);
			mongoTemplate.createCollection(VenueItem.class);
		}
		
	}
	
	public void addVenue(VenueItem venueItem) {
		
		venueItem.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(venueItem, COLLECTION_NAME);
		 
	}
	
	public List<VenueItem> listVenue() {
		return mongoTemplate.findAll(VenueItem.class, COLLECTION_NAME);
	}
	
	/**
	 * 
	 * @param points 
	 * @return
	 */
	public List<VenueItem> findNearestVenues(List<Point> points) {
		Point eastPoint = points.get(0);
		Point westPoint= points.get(1);
		Point northPoint =points.get(2);
		Point southPoint= points.get(3);
//		if(p.x > westPoint.x && p.x < eastPoint.x  && p.y > southPoint.y && p.y < northPoint.y )
		return mongoTemplate.find(new Query(Criteria.where("point.x").gt(westPoint.x).lt(eastPoint.x).
				and("point.y").gt(southPoint.y).lt(northPoint.y)
				), VenueItem.class);
		

		
	}
	
	public void deleteVenue(VenueItem venueItem) {
		mongoTemplate.remove(venueItem, COLLECTION_NAME);
	}
	
	public void updateVenue(VenueItem venueItem) {
		mongoTemplate.insert(venueItem, COLLECTION_NAME);		
	}
}
