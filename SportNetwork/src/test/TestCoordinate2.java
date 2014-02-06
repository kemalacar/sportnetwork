package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Distinct;

public class TestCoordinate2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ArrayList<Distinct> distincts = readFromFile("C:\\Users\\EXT0173773\\workspace3\\FoursquareTest\\resources\\coordinates2");

		for (Distinct distinct : distincts) {
			System.out.println(distinct.getName()+"\t"+distinct.getLatitudeAsDouble()+"\t"+distinct.getLongitudeAsDouble());
		}

	}

	public static ArrayList<Distinct> readFromFile(String file ) throws Exception{

		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<Distinct> distincts= new ArrayList<Distinct>();

		try {
			String line = br.readLine();

			while (line != null) {
				String[] array = line.split(",");

				if(array.length==5){
					try{
						Distinct distinct = new Distinct();
						distinct.setName(array[2].trim());

						distinct.setLatitudeAsDouble(Double.parseDouble(array[3].trim()));
						distinct.setLongitudeAsDouble(Double.parseDouble(array[4].trim()));
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


	public static void writeToFile(File f,StringBuffer content){
		BufferedWriter bw = null;
		try{
			FileWriter fw = new FileWriter(f.getAbsoluteFile());
			bw = new BufferedWriter(fw);
			bw.write(content.toString());
			bw.close();
		}catch (Exception e) {
		
		}
	}
}
