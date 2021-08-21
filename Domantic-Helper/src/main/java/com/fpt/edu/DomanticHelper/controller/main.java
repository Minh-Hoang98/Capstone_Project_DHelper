package com.fpt.edu.DomanticHelper.controller;

import static com.fpt.edu.DomanticHelper.ObjectHelper.Common.split;

import com.fpt.edu.DomanticHelper.entity.Location;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String queQuan = "63 An Nhơn 8, An Hải Bắc, Sơn Trà, Đà Nẵng,Việt Nam";
		
		 String[] arrQueQuan = split(queQuan,",");
		String[] arrSoNha = split(arrQueQuan[0], "\\s");
		String group="";		
		for(int i=1;i<arrSoNha.length;i++) {
			group+=arrSoNha[i]+" ";			
		}
		Location newLocation = new Location(arrQueQuan[4], arrQueQuan[3], arrQueQuan[2], arrQueQuan[1],group , Integer.valueOf(arrSoNha[0]));
		System.out.println(newLocation.toString());
	}

}
