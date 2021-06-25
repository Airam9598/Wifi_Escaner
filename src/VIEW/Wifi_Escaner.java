package VIEW;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import Refactor.Create_Table;
import Refactor.Save_wifi;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Wifi_Escaner {

	private JFrame frmWifiEscaner;
	private JTable table;
	private JButton btnNewButton,btnGuardar;
	private JLabel lblRedesEncontradas, lblGuardadasCorrectamente;
	private JLabel lblErrorNoHay;

	public Wifi_Escaner(String version, String disco) {
		initialize(version,disco);
		frmWifiEscaner.setVisible(true);
	}

	@SuppressWarnings("serial")
	private void initialize(String Version,String disco) {
		frmWifiEscaner = new JFrame();
		frmWifiEscaner.setTitle(Version);
		frmWifiEscaner.getContentPane().setBackground(new Color(135, 206, 250));
		frmWifiEscaner.setBounds(100, 100, 898, 589);
		frmWifiEscaner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWifiEscaner.getContentPane().setLayout(null);
		
		lblRedesEncontradas = new JLabel("Redes Encontradas: 0");
		lblRedesEncontradas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRedesEncontradas.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblRedesEncontradas.setBounds(569, 6, 303, 37);
		frmWifiEscaner.getContentPane().add(lblRedesEncontradas);
		
		JLabel lblRedesGuardadas = new JLabel("Redes Guardadas");
		lblRedesGuardadas.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRedesGuardadas.setBounds(10, 75, 220, 31);
		frmWifiEscaner.getContentPane().add(lblRedesGuardadas);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"SSID(NOMBRE)", "SEGURIDAD", "CIFRADO", "CONTRASE\u00D1A"},
			},
			new String[] {
				"", "", "", ""
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(24);
		table.setGridColor(Color.BLACK);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		table.setBorder(null);
		table.setBackground(new Color(30, 144, 255));
		table.setBounds(0, 119, 882, 431);
		frmWifiEscaner.getContentPane().add(table);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(144, 238, 144));
		panel.setAlignmentY(0.0f);
		panel.setAlignmentX(0.0f);
		panel.setBounds(10, 6, 112, 53);
		frmWifiEscaner.getContentPane().add(panel);
		
		btnNewButton = new JButton("Escanear");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel.setBackground(new Color(144, 238, 144));
			}
		});
		btnNewButton.setBounds(0, 0, 112, 53);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblErrorNoHay.setVisible(false);
		 		btnNewButton.setEnabled(false);
		 		btnGuardar.setEnabled(false);
		 		lblGuardadasCorrectamente.setVisible(false);
		 		Create_Table table2= new Create_Table();
		 		table=table2.add_model(table,disco);
		 		if(table2.get_Redes().contains("Error")) {
		 			lblErrorNoHay.setVisible(true);
		 		}
		 		lblRedesEncontradas.setText(table2.get_Redes());
		 		btnNewButton.setEnabled(true);
	 			btnGuardar.setEnabled(true);
			}
		});
		btnNewButton.setMaximumSize(new Dimension(84, 23));
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setAlignmentY(0.0f);
		
		lblErrorNoHay = new JLabel("Error, no hay ninguna tarjeta de red wifi conectada");
		lblErrorNoHay.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorNoHay.setForeground(Color.RED);
		lblErrorNoHay.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblErrorNoHay.setBounds(240, 73, 642, 37);
		frmWifiEscaner.getContentPane().add(lblErrorNoHay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(238, 130, 238));
		panel_1.setAlignmentY(0.0f);
		panel_1.setAlignmentX(0.0f);
		panel_1.setBounds(163, 6, 112, 53);
		frmWifiEscaner.getContentPane().add(panel_1);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(238, 130, 238));
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardar.setEnabled(false);
				btnNewButton.setEnabled(false);
				lblGuardadasCorrectamente.setVisible(true);
				lblGuardadasCorrectamente.setText("Guardando...");
	 		        	if (Save_wifi.Save_Wifi()) {
	 						lblGuardadasCorrectamente.setText("Guardadas Correctamente");
	 		        	}else {
	 						lblGuardadasCorrectamente.setText("Error al guardar");
	 		        	}
 		        		btnGuardar.setEnabled(true);
 						btnNewButton.setEnabled(true);	
			}
		});
		btnGuardar.setMaximumSize(new Dimension(84, 23));
		btnGuardar.setMargin(new Insets(0, 0, 0, 0));
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGuardar.setFocusPainted(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setAlignmentY(0.0f);
		btnGuardar.setBounds(0, 0, 112, 53);
		panel_1.add(btnGuardar);
		lblGuardadasCorrectamente = new JLabel("Guardadas Correctamente");
		lblGuardadasCorrectamente.setForeground(new Color(0, 128, 0));
		lblGuardadasCorrectamente.setVisible(false);
		lblGuardadasCorrectamente.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardadasCorrectamente.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblGuardadasCorrectamente.setBounds(301, 6, 293, 37);
		frmWifiEscaner.getContentPane().add(lblGuardadasCorrectamente);
		lblErrorNoHay.setVisible(false);
	}
	
}
