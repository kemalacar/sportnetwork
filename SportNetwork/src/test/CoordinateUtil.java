package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import model.Distinct;

public class CoordinateUtil {

	public static void main(String[] args) throws Exception {
		ArrayList<Distinct> distincts = readFromFile("C:\\Users\\EXT0173773\\workspace3\\FoursquareTest\\resources\\coordinates");

		for (Distinct distinct : distincts) {
			System.out.println(distinct.getName()+"\t\t"+distinct.getLatitudeAsDouble()+"\t"+distinct.getLongitudeAsDouble());
		}

	}

	public static ArrayList<Distinct> readFromFile(String file ) throws Exception{

		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<Distinct> distincts= new ArrayList<Distinct>();

		try {
			String line = br.readLine();

			while (line != null) {
				String[] array = line.split("\t");

				if(array.length==5){
					try{
						Distinct distinct = new Distinct();
						distinct.setName(array[0]);
						distinct.setLatitude(Integer.parseInt(array[1]));
						distinct.setLatitude_min(Integer.parseInt(array[2].split(",")[0] ) ) ; 
						distinct.setLatitude_sec(Integer.parseInt(array[2].split(",")[1] ) ) ;
						
						distinct.setLongitude(Integer.parseInt(array[3]));
						distinct.setLongitude_min(Integer.parseInt(array[4].split(",")[0] ) ) ; 
						distinct.setLongitude_sec(Integer.parseInt(array[4].split(",")[1] ) ) ;
						distincts.add(distinct);
					}catch (Exception e) {
						e.printStackTrace();
					}
				}


				line = br.readLine();
			}
			return distincts;

		} finally {
			br.close();
		}
	}


}
