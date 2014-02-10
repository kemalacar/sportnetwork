package com.sportnetwork.web.test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sportnetwork.common.model.Distinct;

import fi.foyt.foursquare.api.FoursquareApi;
import fi.foyt.foursquare.api.Result;
import fi.foyt.foursquare.api.entities.CompactVenue;
import fi.foyt.foursquare.api.entities.VenuesSearchResult;

public class FTest {
	static FoursquareApi api = new FoursquareApi("WIAZN0I3J12CXK3HRLDMIHS0RDOV5KF0WMWA11M0X2MGQX5M",
			"5JY3ZKK51JVDGOY5PBWF5KHJMXJMCGQKQLCF0C1UV1U0H4JH", "");
	static Map<String, String> searchMap = new HashMap<String, String>();

	
		public static void main(String[] args) throws Exception {
//			searchMap.put("categoryId", "4cce455aebf7b749d5e191f5");
			searchMap.put("query", "halisaha");
			searchMap.put("limit", "250");
			searchMap.put("ll","40.917566,29.180585");
			Result result = api.venuesSearch(searchMap);
			
			VenuesSearchResult  vResult = (VenuesSearchResult)result.getResult();
			for (CompactVenue ven : vResult.getVenues()){
					System.out.println(ven.getId()+"\t" + ven.getName()+"\t"+ven.getLocation().getLat()+","+ven.getLocation().getLng());
			}
			
		}
	
	public static void main2(String[] args) throws Exception {
		

		searchMap.put("categoryId", "4cce455aebf7b749d5e191f5");
		searchMap.put("limit", "250");
		//		searchMap.put("query", "halisaha");


		ArrayList<Distinct> distincts = TestCoordinate2.readFromFile("C:\\Users\\EXT0173773\\workspace3\\FoursquareTest\\resources\\coordinates2");
		Map<String,CompactVenue> places = new HashMap<String,CompactVenue>();

		for (Distinct distinct : distincts) {
			searchMap.put("ll", distinct.getLatitudeAsDouble()+","+distinct.getLongitudeAsDouble());
			String ll;
			Result result = api.venuesSearch(searchMap);

			VenuesSearchResult  vResult = (VenuesSearchResult)result.getResult();

			for (CompactVenue ven : vResult.getVenues()){
				if(places.containsKey(ven.getId())){
					System.err.println(ven.getId()+"\t" + ven.getName()+"\t"+ven.getLocation().getLat()+","+ven.getLocation().getLng());
				}else{
					places.put(ven.getId(), ven);
				}
			}

		}
		
		StringBuffer buffer = new StringBuffer();
		System.out.println("*************************************************");
		for (String key : places.keySet()) {
			CompactVenue ven = places.get(key);
			buffer.append(ven .getId()+"\t" + ven.getName()+"\t"+ven.getLocation().getLat()+","+ven.getLocation().getLng()+"\n");
			System.out.println(ven .getId()+"\t" + ven.getName()+"\t"+ven.getLocation().getLat()+","+ven.getLocation().getLng());
		}

		TestCoordinate2.writeToFile(new File("C:\\Users\\EXT0173773\\workspace3\\FoursquareTest\\resources\\halisahaList"), buffer);
		//		for (Category category : api.venuesCategories().getResult()) {
		//			System.out.println(category.getName());
		//			for (Category cat: category.getCategories()) {
		//				System.out.println( "\t"+ cat.getName()  );
		//				if(cat.getCategories().length>0){
		//					for (Category ca: cat.getCategories()) {
		//						System.out.println( "\t\t"+ ca.getName() + " : "+ca.getId());
		//					}
		//				}
		//			}
		//		}



	}
}
