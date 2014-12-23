package user;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logika.EntzierroKud;
import Logika.GanadutegiKud;
import Logika.ZezenEntzierroKud;
import administratzailea.SortuZezena;

public class GehituZezena extends JFrame {
	
	private static int kode =0;
	private static String zeinData=null;
	private ZezenKud zk = ZezenKud.getInstantzia();
	private Vector<String> vIzenakZezenak = zk.getZezenak(kode,zeinData);
	
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	
	JComboBox zezenak = new JComboBox(vIzenakZezenak);
	JButton gehitu = new JButton("Gehitu");
	
	public GehituZezena() {
		gridBagHasieratu();
	}

	public static void main(String erabiltzaileIzena, String data) {
		int kodea = GanadutegiKud.getInstantzia().getIdGanadutegia(erabiltzaileIzena);
		kode = kodea;
		zeinData=data;
		GehituZezena hasiera = new GehituZezena();
		hasiera.setTitle("Gehitu zezena");
		hasiera.setVisible(true);
		hasiera.setSize(300, 100);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(zezenak, 1, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(gehitu, 1, 10, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		
		
		gehitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				java.sql.Time denbora = java.sql.Time.valueOf("00:00:00");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = null;
				try {
					date = format.parse(zeinData);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				java.sql.Date data = new java.sql.Date(date.getTime());
				ZezenEntzierroKud.getInstantzia().gehitu("bai",denbora, ZezenKud.getInstantzia().getZezena(kode), data);
				//AukeraUser.getInstantzia().zetm.eguneratu(zeinData);
				dispose();
			}
		});

	}

	private void gehituOsagaia(Component osagaia, int errenkada, int zutabea, int zabalera, int altuera) {
		mugak.gridx = zutabea;
		mugak.gridy = errenkada;

		mugak.gridwidth = zabalera;
		mugak.gridheight = altuera;

		eskema.setConstraints(osagaia, mugak);
		edukiontzia.add(osagaia);

	}
}