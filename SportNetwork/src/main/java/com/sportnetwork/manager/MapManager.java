package com.sportnetwork.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sportnetwork.common.model.MobileDevice;
import com.sportnetwork.common.model.Point;
import com.sportnetwork.common.model.VenueItem;
import com.sportnetwork.common.service.IVenueService;
import com.sportnetwork.web.utils.MapUtil;

@Service
public class MapManager extends AbstractManager{

	
	public void refreshDB(){
		venueService.refreshColection();
	}
	
	public ArrayList<VenueItem> getNearestVenues(Point location , int distance) {
		List<Point> points =  MapUtil.findBoundOfLocation(location, distance);
		
		List<VenueItem> venues = venueService.findNearestVenues(points);// search in rectangle
		
		ArrayList<VenueItem> nearetsVenues = new ArrayList<>();
		
		for (VenueItem venueItem : venues) {
			double distt =MapUtil.getDistanceAsKM(location, venueItem.getPoint());
			
			if(distt < distance ){	//look fror distance. because we searched in rectangle
				nearetsVenues.add(venueItem);
			}
		}
		
		return nearetsVenues;
	}
	
	public void addVenue(VenueItem venueItem) {
		venueService.addVenue(venueItem);
	}
	
	public void addSubscriberToVenue(String venueId, String deviceRegId) {
		
		MobileDevice md   = deviceService.getDeviceByRegistrationId(deviceRegId);
		if(md!=null) {
			venueService.addSubscriber(md.getRegistrationId(), venueId);
		}
	}
	
	public void removeSubscriberFromVenue(String venueId, String deviceRegId) {
		
		MobileDevice md   = deviceService.getDeviceByRegistrationId(deviceRegId);
		if(md!=null) {
			venueService.removeSubscriber(md.getRegistrationId(), venueId);
		}
	}

	public void deleteVenue() {
		
	}
	
	public VenueItem getVenueById(String venueId) {

		return venueService.findVenueById(venueId);
	}
	

	public List<VenueItem> listVenue() {
		return venueService.listVenue();
	}
}
