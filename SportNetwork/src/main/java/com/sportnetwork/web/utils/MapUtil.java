package com.sportnetwork.web.utils;

import java.util.ArrayList;
import java.util.List;

import com.sportnetwork.common.model.Point;
import com.sportnetwork.common.model.PointType;


public class MapUtil {


	public static double[] getLituAndLongFromString(String string){

		String[] values =  string.split(",");

		if(values.length==2){
			try
			{
				double[] dVals=new double[2];
				dVals[0]  =  Double.parseDouble(values[0]);
				dVals[1]  =	 Double.parseDouble(values[1]);
				return dVals;
			}
			catch(NumberFormatException e)
			{
				return null;
			}
		}

		return null;
	}

	public static double getDistanceAsKM(Point p1, Point p2){
		return distance(p1, p2, 'K');
	}
	
	private static final double distance(Point p1, Point p2, char unit)
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
