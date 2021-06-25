package Refactor;

import java.io.File;

public class Save_wifi {
		public static boolean Save_Wifi() {
			try {
					File directorio=new File("./WIFI_ESCANER"); 
					if(directorio.exists()==false) directorio.mkdir();
					Process child;
					child = Runtime.getRuntime().exec("netsh wlan export profile key=clear folder="+directorio.getAbsolutePath());
					child.waitFor();
					return true;
			}catch(Exception e) {
				return false;
			}
		}
}
