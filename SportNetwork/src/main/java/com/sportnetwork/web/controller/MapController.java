package com.sportnetwork.web.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportnetwork.web.model.Point;
import com.sportnetwork.web.model.VenueItem;
import com.sportnetwork.web.service.VenueService;
import com.sportnetwork.web.test.HaliSahaTest;
import com.sportnetwork.web.utils.MapUtil;

@Controller
@RequestMapping(value = "/map")
public class MapController extends AbstractController {


	@Autowired
	private VenueService venueService;
	
	
	@RequestMapping(value = "/addToMongo", method = RequestMethod.GET)
	public  void  addToMongo(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<VenueItem> venues =HaliSahaTest.getFromFile(new File( servletContext.getRealPath("/WEB-INF/resources/halisahaList") ));
		
		venueService.refreshColection();
		
		for (VenueItem venueItem : venues) {
			venueService.addVenue(venueItem);
		}
		
		createJSONResponse(response, venueService.listVenue());
	}
	
	@RequestMapping(value = "/findNearestVenues2")
	public  void findNearestVenues2(@RequestParam String ll,int dist, HttpServletRequest request, HttpServletResponse response) {
		double[] coordinates = MapUtil.getLituAndLongFromString(ll);
		if(coordinates!=null){
			Point p =  new Point(coordinates[0], coordinates[1]);
			
			List<Point> points =  HaliSahaTest.findBoundOfLocation(p, dist);
			List<VenueItem> venues = venueService.findNearestVenues(points);// search in rectangle
			
			
			ArrayList<VenueItem> nearetsVenues = new ArrayList<>();
			
			for (VenueItem venueItem : venues) {
				double distt =HaliSahaTest.distance(p, venueItem.getPoint(), 'K');
				
				if(distt < dist ){	//look fror distance. because we searched in rectangle
					nearetsVenues.add(venueItem);
				}
			}
			//TODO client ajax
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
		    response.addHeader("Access-Control-Allow-Headers", "Content-Type");
			createJSONResponse(response, nearetsVenues);
		}else{
			
			createJSONResponse(response, new String());
		}
	}
	
	@RequestMapping(value = "/findNearestVenues")
	public  void findNearestVenues(@RequestParam String ll,int dist, 
			HttpServletRequest request, HttpServletResponse response) {
		
		double[] coordinates = MapUtil.getLituAndLongFromString(ll);
		if(coordinates!=null){
			Point p =  new Point(coordinates[0], coordinates[1]);
			
			List<Point> points =  HaliSahaTest.findBoundOfLocation(p, dist);
			
			ArrayList<VenueItem> venues =HaliSahaTest.getFromFile(points, new File( servletContext.getRealPath("/WEB-INF/resources/halisahaList") ));
			
			ArrayList<VenueItem> nearetsVenues = new ArrayList<>();
			
			for (VenueItem venueItem : venues) {
				double distt =HaliSahaTest.distance(p, venueItem.getPoint(), 'K');

				if(distt < dist ){
					nearetsVenues.add(venueItem);
				}
			}
			
			//TODO client ajax
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE");
		    response.addHeader("Access-Control-Allow-Headers", "Content-Type");
			createJSONResponse(response, nearetsVenues);
		}else{
			
			createJSONResponse(response, new String());
		}
		
	}
	
}