package com.sportnetwork.web.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.sportnetwork.web.model.Point;
import com.sportnetwork.web.model.VenueItem;

public class MongoTest {

	public static void main(String[] args) {

		List<VenueItem>  venues = getAllHalisahaFromFile();
		
		
		
		
		for (VenueItem venueItem : venues) {
			System.out.println(venueItem.getId());
		}
	}


	public static List<VenueItem> getAllHalisahaFromFile() {
		try{

			File f = new File("C:\\Users\\EXT0173773\\git\\my rep\\SportNetwork\\WebContent\\WEB-INF\\resources\\halisahaList");

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




}
