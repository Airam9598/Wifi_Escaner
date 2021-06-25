package Model;

public class Wifi {
	private String ssid,seguridad,cifrado,password;
	
	public Wifi(String ssid, String seguridad, String cifrado, String password) {
		this.ssid=ssid;
		this.seguridad=seguridad;
		this.cifrado=cifrado;
		this.password=password;
	}

	public String getSsid() {
		return ssid.trim();
	}

	public String getSeguridad() {
		return seguridad.trim();
	}

	public String getCifrado() {
		return cifrado.trim();
	}

	public String getPassword() {
		return password.trim();
	}

}
