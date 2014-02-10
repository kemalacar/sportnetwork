package com.sportnetwork.web.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.sportnetwork.common.model.Point;
import com.sportnetwork.common.model.PointType;
import com.sportnetwork.common.model.VenueItem;

public class HaliSahaTest {

	
	public static ArrayList<VenueItem> getFromFile(File f){
		try{

			BufferedReader br = new BufferedReader(new FileReader(f));
			ArrayList<VenueItem> venues= new ArrayList<VenueItem>();

			try {
				String line = br.readLine();

				while (line != null) {
					String[] array = line.split("\t");
					VenueItem v = new VenueItem();
					v.setUniqeId(array[0]);
					v.setName(array[1]);
					Point p = new Point(Double.parseDouble(array[2].split(",")[0])
							, Double.parseDouble(array[2].split(",")[1]));
					v.setPoint(p);
					venues.add(v);
					line = br.readLine();
				}
				return venues;

			} finally {
				br.close();
			}
		}catch (Exception e){

		}
		return null;
	}
	
	
	@Deprecated
	public static ArrayList<VenueItem> getFromFile(List<Point> points, File f){
		try{
		
		BufferedReader br = new BufferedReader(new FileReader(f));
		ArrayList<VenueItem> venues= new ArrayList<VenueItem>();

		try {
			String line = br.readLine();

			
			Point eastPoint = points.get(0);
			Point westPoint= points.get(1);
			Point northPoint =points.get(2);
			Point southPoint= points.get(3);
			
			while (line != null) {
				String[] array = line.split("\t");
				VenueItem v = new VenueItem();
				v.setUniqeId(array[0]);
				v.setName(array[1]);
				 Point p = new Point(Double.parseDouble(array[2].split(",")[0])
						 , Double.parseDouble(array[2].split(",")[1]));
				v.setPoint(p);
				
				
				if(p.getLatitude() > westPoint.getLatitude() && p.getLatitude() < eastPoint.getLatitude()  
						&& p.getLongitude() > southPoint.getLongitude() && p.getLongitude() < northPoint.getLongitude() )
				{
					venues.add(v);
				}
				
				
				line = br.readLine();
			}
			return venues;

		} finally {
			br.close();
		}
}catch (Exception e){
			
		}
		return null;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		Point p1=  new Point(41.017729,29.136375);
		
		List<Point> points =  findBoundOfLocation(p1, 5);
		
		ArrayList<VenueItem> venues =getFromFile(points, new File("C:\\Users\\EXT0173773\\workspace3\\FoursquareTest\\resources\\halisahaList"));
		
		
		String template = "&markers=color:blue%7Clabel:F%7C";
		
		for (VenueItem venueItem : venues) {
			double dist = distance(p1, venueItem.getPoint(), 'K');

			if(dist < 5 ){
				System.out.print(template+venueItem.getPoint().getLatitude()+","+venueItem.getPoint().getLongitude());
			}
		}
		
		System.out.print("&markers=color:red%7Clabel:F%7C"+p1.getLatitude()+","+p1.getLongitude());
		System.out.print("&center="+p1.getLatitude()+","+p1.getLongitude());
		
		for (int i = 0; i < 4; i++) {
			System.out.print("&markers=color:red%7Clabel:F%7C"+points.get(i).getLatitude()+","+points.get(i).getLongitude());
		}
		
//		double distance=0 ;
//		while(distance<5){
//			p2.x+=0.001;
//			p2.y+=0.001;
//			System.out.println(distance);
//			distance = distance(p1.x, p1.y, p2.x, p2.y, 'K');
//		}
		
	}
	
	
	public static final double distance(Point p1, Point p2, char unit)
	{
	    double theta = p1.getLongitude() - p2.getLongitude();
	    double dist = Math.sin(deg2rad(p1.getLatitude())) * Math.sin(deg2rad(p2.getLatitude())) + 
	    		Math.cos(deg2rad(p1.getLatitude())) * Math.cos(deg2rad(p2.getLatitude())) * Math.cos(deg2rad(theta));
	    dist = Math.acos(dist);
	    dist = rad2deg(dist);
	    dist = dist * 60 * 1.1515;
	     
	    if (unit == 'K') {
	        dist = dist * 1.609344;
	    }
	    else if (unit == 'N') {
	        dist = dist * 0.8684;
	    }
	     
	    return (dist);
	}
	 
	/**
	 * <p>This function converts decimal degrees to radians.</p>
	 * 
	 * @param deg - the decimal to convert to radians
	 * @return the decimal converted to radians
	 */
	private static final double deg2rad(double deg)
	{
	    return (deg * Math.PI / 180.0);
	}
	 
	/**
	 * <p>This function converts radians to decimal degrees.</p>
	 * 
	 * @param rad - the radian to convert
	 * @return the radian converted to decimal degrees
	 */
	private static final double rad2deg(double rad)
	{
	    return (rad * 180 / Math.PI);
	}
	
	private static boolean isInBound(Point loc, Point target){
		
		
		return false;
				
	}
	 
	
	public static List<Point> findBoundOfLocation(Point loc, int distance){
		ArrayList<Point> points= new ArrayList<Point>();
		Point eastPoint,westPoint,northPoint,southPoint,northeastPoint,northwestPoint,southeastPoint,southwestPoint;


		Point p2=new Point(loc.getLatitude(), loc.getLongitude());

		p2.setLatitude(p2.getLatitude()+0.009*distance);

		eastPoint =  new Point(loc.getLatitude()+0.009*distance, loc.getLongitude(), PointType.EAST);
		westPoint =  new Point(loc.getLatitude()-0.009*distance, loc.getLongitude(), PointType.WEST);
		northPoint =  new Point(loc.getLatitude(), loc.getLongitude()+0.01*distance, PointType.NORTH);
		southPoint =  new Point(loc.getLatitude(), loc.getLongitude()-0.01*distance, PointType.SOUTH);

		//find cross points
		p2.setLatitude(loc.getLatitude());
		p2.setLongitude(loc.getLongitude());

		double crossDistx=Math.sqrt((double) Math.pow(distance, 2)/2)*0.009;
		double crossDisty=Math.sqrt((double)Math.pow(distance, 2)/2)*0.01;

		northeastPoint =  new Point(loc.getLatitude()+crossDistx, loc.getLongitude()+crossDisty, PointType.NORTHEAST);
		northwestPoint =  new Point(loc.getLatitude()-crossDistx, loc.getLongitude()+crossDisty, PointType.NORTHWEST);
		southwestPoint =  new Point(loc.getLatitude()-crossDistx, loc.getLongitude()-crossDisty, PointType.SOUTHWEST);
		southeastPoint =  new Point(loc.getLatitude()+crossDistx, loc.getLongitude()-crossDisty, PointType.SOUTHEAST);

		points.add(eastPoint);
		points.add(westPoint);
		points.add(northPoint);
		points.add(southPoint);
		points.add(northeastPoint);
		points.add(northwestPoint);
		points.add(southeastPoint);
		points.add(southwestPoint);

		return points;
	}
	
	
}

