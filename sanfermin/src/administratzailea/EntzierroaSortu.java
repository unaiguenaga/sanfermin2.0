package administratzailea;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Logika.EntzierroKud;
import Logika.EntzierroLag;
import Logika.GanadutegiKud;

import com.toedter.calendar.JCalendar;

public class EntzierroaSortu extends JFrame{

	private EntzierroKud ek = EntzierroKud.getInstantzia();
	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	private Vector<String> vIzenak = gk.getIzenak();
	private Vector<Integer> vId = gk.getId();
	
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	JButton gehitu = new JButton("Gehitu");
	JLabel noiz = new JLabel("Noiz:");
	JLabel ganadutegia = new JLabel("Ganadutegia:");
	JCalendar cal = new JCalendar();
	JComboBox kaxa = new JComboBox(vIzenak);
	
	public EntzierroaSortu() {
		botoiakHasieratu();
		gridBagHasieratu();
		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema= new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak= new GridBagConstraints();
		
		gehituOsagaia(noiz, 1, 1, 1, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(cal, 2, 1, 8, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(ganadutegia, 3, 1, 3, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(kaxa, 3, 4, 4, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(gehitu, 4, 1, 8, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
	}
	
	private void botoiakHasieratu(){
		gehitu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				java.sql.Date sqlDate = new java.sql.Date(cal.getDate().getTime()); //java.util.Date java.sql.Date bilakatu.
	 			ek.gehitu(sqlDate, 10, vId.elementAt(kaxa.getSelectedIndex())); //Datu basean gorde.
				AukeraAdmin.getInstantzia().etm.eguneratu(); // Tabla eguneratu.
				dispose();
			}
		});
	}
	
	private void gehituOsagaia(Component osagaia, int errenkada, int zutabea, int zabalera, int altuera) {
		mugak.gridx=zutabea;
		mugak.gridy=errenkada;
		
		mugak.gridwidth=zabalera;
		mugak.gridheight=altuera;
		
		eskema.setConstraints(osagaia, mugak);
		edukiontzia.add(osagaia);
	}
}
