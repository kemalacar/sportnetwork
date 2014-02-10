package com.sportnetwork.common.mongoservice;

import java.util.List;



import com.sportnetwork.common.model.Point;
import com.sportnetwork.common.model.User;
import com.sportnetwork.common.model.VenueItem;


public interface IVenueService  extends IMongoService{
	public void addVenue(VenueItem venueItem);
	public List<VenueItem> listVenue() ;
	public List<VenueItem> findNearestVenues(List<Point> points);
	public List<VenueItem> findNearestVenuesByDistance(Point point, int distance);
	public  void deleteVenue(VenueItem venueItem);
	public  void updateVenue(VenueItem venueItem);
	@Deprecated
	public  void  refreshColection();
	public  void addSubscriber(String subscriberId, String venueUnieqId);
	public VenueItem findVenueById(String venueId);
}
