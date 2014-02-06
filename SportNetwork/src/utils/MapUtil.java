package utils;


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

}
