package com.fpt.edu.DomanticHelper.ObjectHelper;

import static com.fpt.edu.DomanticHelper.ObjectHelper.Common.split;

import com.fpt.edu.DomanticHelper.entity.Location;

public class Common {
	public static String[] split(String input,String delimiter) {
		if(input== null || delimiter ==null) {
			return new String[0];
		}
		return input.split( delimiter);
	}
	public static Location covertLocation(String location)
	{
	
	 String[] arrQueQuan = split(location,",");
	String[] arrSoNha = split(arrQueQuan[0], "\\s");
	String group="";		
	for(int i=1;i<arrSoNha.length;i++) {
		group+=arrSoNha[i]+" ";			
	}
	Location newLocation = new Location(arrQueQuan[4], arrQueQuan[3], arrQueQuan[2], arrQueQuan[1],group , Integer.valueOf(arrSoNha[0]));
	return newLocation;
	
}
}
