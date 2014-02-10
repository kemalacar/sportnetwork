package com.sportnetwork.common.mongoservice;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.sportnetwork.common.model.MongoModel;
import com.sportnetwork.common.model.Point;
import com.sportnetwork.common.model.User;
import com.sportnetwork.common.model.VenueItem;
import com.sportnetwork.web.utils.MapUtil;

@Repository
public class VenueService extends MongoService implements IVenueService {

	
	public static final String COLLECTION_NAME = "venueItem";
	
	@Deprecated
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
		return mongoTemplate.find(new Query(Criteria.where("point.latitude").gt(westPoint.getLatitude()).lt(eastPoint.getLatitude()).
				and("point.longitude").gt(southPoint.getLongitude()).lt(northPoint.getLongitude())
				), VenueItem.class);
		
	}
	

	@Override
	public List<VenueItem> findNearestVenuesByDistance(Point point, int distance) {
		List<Point> points =  MapUtil.findBoundOfLocation(point, distance);
		return findNearestVenues(points);
	}
	
	
	public void deleteVenue(VenueItem venueItem) {
		mongoTemplate.remove(venueItem, COLLECTION_NAME);
	}
	
	public void updateVenue(VenueItem venueItem) {
		mongoTemplate.updateFirst(new Query(Criteria.where("uniqeId").is(venueItem.getUniqeId())),
				Update.update("subscriberList", venueItem.getSubscriberList()), VenueItem.class);
	}

	@Override
	public void addSubscriber(String subscriberId, String venueUnieqId) {

		VenueItem venue = findVenueById(venueUnieqId);
		if(venue!=null && !venue.getSubscriberList().contains(subscriberId)){
			venue.addSubscriber(subscriberId);
			updateVenue(venue);
		}
	}

	@Override
	public VenueItem findVenueById(String venueId) {

		if(!StringUtils.isEmpty(venueId)){
			
			List<VenueItem> venue = mongoTemplate.find(
					new Query(Criteria.where("uniqeId").is(venueId)),VenueItem.class);
			
			if(venue.size()==1)
				return venue.get(0);
		}
		
		return null;
	}

}
