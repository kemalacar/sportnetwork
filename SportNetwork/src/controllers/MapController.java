package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Point;
import model.VenueItem;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import test.HaliSahaTest;
import utils.MapUtil;

@Controller
@RequestMapping(value = "/map")
public class MapController extends AbstractController {

	/**
	 * TODO remove this
	 * @param ll
	 * @param dist
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/test")
	public  String  test(HttpServletRequest request, HttpServletResponse response) {
		return "aa/test";
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
