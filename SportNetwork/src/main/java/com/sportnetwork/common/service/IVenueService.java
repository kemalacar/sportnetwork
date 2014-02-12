package com.sportnetwork.common.service;

import java.util.List;




import com.sportnetwork.common.model.Point;
import com.sportnetwork.common.model.User;
import com.sportnetwork.common.model.VenueItem;


public interface IVenueService  {
	public void addVenue(VenueItem venueItem);
	public List<VenueItem> listVenue() ;
	public List<VenueItem> findNearestVenues(List<Point> points);
	public List<VenueItem> findNearestVenuesByDistance(Point point, int distance);
	public  void deleteVenue(VenueItem venueItem);
	public  void updateVenue(VenueItem venueItem);
	public  void addSubscriber(String subscriberId, String venueUnieqId);
	public VenueItem findVenueById(String venueId);
	
	@Deprecated
	public void refreshColection( );
	void removeSubscriber(String subscriberId, String venueUnieqId);
}
