package Refactor;

import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Wifi;

public class Create_Table {
	private JTable table;
	private String redes;
	public Create_Table() {
		redes="";
	}
	public JTable add_model(JTable table,String disco) {
		table.setModel(new DefaultTableModel(new Object[][] {{"SSID(Nombre)", "Seguridad", "Cifrado", "Contrase\u00F1a"},},new String[] {"SSID(Nombre)", "Seguridad", "Cifrado", "Contrase\u00F1a"}));
		this.table=table;
		add_files(disco);
		return this.table;
	}
	
	private void add_files(String disco) {
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		HashMap<Integer,Wifi> Wifimap = new HashMap<Integer,Wifi>();
		try {
			Wifimap=get_Wifis.Get_Wifi(disco);
			if(!Wifimap.isEmpty()) {
				for(Wifi wifi : Wifimap.values())
					model.addRow(new Object[] {wifi.getSsid(),wifi.getSeguridad(),wifi.getCifrado(),wifi.getPassword()});
					redes="Redes Encontradas: " + Wifimap.size(); 	
			}else {
				redes="Redes Encontradas: Error";
			}
		}catch(Exception e) {
			redes="Redes Encontradas: Error";
		}
	}
	
	public String get_Redes() {
		return redes;
	}

}
