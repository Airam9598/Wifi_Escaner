package Refactor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import Model.Wifi;

public class get_Wifis {
	
	public static HashMap<Integer, Wifi> Get_Wifi(String disco) throws IOException {
		HashMap<Integer,Wifi> Wifimap = new HashMap<Integer,Wifi>();
		try {
			File directorio=new File(disco); 
			if(directorio.exists()==false) directorio.mkdir();
			Process child;
			child = Runtime.getRuntime().exec("netsh wlan export profile key=clear folder="+directorio.getAbsolutePath());
			child.waitFor();
		}catch(Exception e) {
			return Wifimap;
		}
	    File[] archivo = new File(disco).listFiles();
	    for(File file: archivo) {
	    	if (file.getName().endsWith(".xml") && file.getName().startsWith("Wi-Fi")) {
	    		BufferedReader br = new BufferedReader(new FileReader(disco+"\\"+file.getName()));
				try {
					String [] datos=new String[5];
					while ((datos[0] = br.readLine()) !=null ) {
						if(datos[0].contains("<name>")) {
							datos[0]=datos[0].replace("<name>","");
							datos[0]=datos[0].replace("</name>","");
							datos[1]= datos[0];
						}else if(datos[0].contains("<keyMaterial>")) {
							datos[0]=datos[0].replace("<keyMaterial>","");
							datos[0]=datos[0].replace("</keyMaterial>","");
							datos[4]= datos[0];
						}else 	if(datos[0].contains("<authentication>")) {
							datos[0]=datos[0].replace("<authentication>","");
							datos[0]=datos[0].replace("</authentication>","");
							datos[2]= datos[0];
						}else if(datos[0].contains("<encryption>")) {
							datos[0]=datos[0].replace("<encryption>","");
							datos[0]=datos[0].replace("</encryption>","");
							datos[3]= datos[0];		  
						} 
					}
					Wifimap.put(Wifimap.size(),new Wifi(datos[1],datos[2], datos[3],datos[4]));
				}catch(Exception e) {
					br.close();
					return Wifimap;
		    	}
				br.close();
				new File(disco+"\\"+file.getName()).delete();
	    	}
	    }
	    return Wifimap;
	}
}
