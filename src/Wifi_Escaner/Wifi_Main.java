package Wifi_Escaner;

import java.io.File;

import VIEW.Wifi_Escaner;

public class Wifi_Main {

	public static void main(String[] args) {
		String disco = System.getProperty("user.home").substring(0,System.getProperty("user.home").indexOf(":"))+":\\ProgramData\\WIFI_ESCANER";
		create_dir(disco);
		new Wifi_Escaner("Wifi Escaner v3.5",disco);
	}
	
	public static void create_dir(String disco) {
		try {
			File directorio=new File(disco); 
			if(directorio.exists()==false) { directorio.mkdir();  }
		}catch(Exception e){}
	}

}
