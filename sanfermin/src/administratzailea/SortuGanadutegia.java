package administratzailea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logika.ErabiltzaileKudeatzailea;
import Logika.GanadutegiKud;
import Logika.GanadutegiLag;



public class SortuGanadutegia extends JFrame {

	JLabel kodea=new JLabel("Kodea:"); 
	JLabel izena = new JLabel("Izena:");
	JLabel helbidea=new JLabel("Helbidea:"); 
	JLabel arduraduna = new JLabel("Arduraduna:");
	JLabel tlf = new JLabel("Telefonoa:");
	JTextField kodeTestua= new JTextField(10);
	JTextField izenTestua = new JTextField(10);
	JTextField helbideTestua= new JTextField(10);
	JComboBox arduradunBox;
	JTextField arduradunTestua= new JTextField(10);
	JTextField tlfTestua= new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton gehitu= new JButton("Gehitu");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	
	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	

	public SortuGanadutegia() {
		arduradunBox = new JComboBox(ErabiltzaileKudeatzailea.getInstantzia().getIzenak());
		botoiakHasieratu();
		gridBagHasieratu();
		setTitle("Gehitu Ganadutegia");
		setVisible(true);
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu(){
		edukiontzia = getContentPane();
		eskema= new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak= new GridBagConstraints();
		
		gehituOsagaia(kodea, 1, 1, 4, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(izena, 2, 1, 4, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(helbidea, 3, 1, 4, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(arduraduna, 4, 1, 4, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(tlf, 5, 1, 4, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		
		gehituOsagaia(kodeTestua, 1, 5, 3, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(izenTestua, 2, 5, 3, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(helbideTestua, 3, 5, 5, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(arduradunBox, 4, 5, 3, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(tlfTestua, 5, 5, 5, 1);
		mugak.insets=new Insets(3, 3, 3, 3);

		behekoPanela.add(BorderLayout.SOUTH, gehitu);
		gehituOsagaia(behekoPanela,16, 3, 9, 1);
		
	}
	
	private void botoiakHasieratu(){
		gehitu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gk.gehitu(Integer.parseInt(kodeTestua.getText()), izenTestua.getText(), arduradunBox.getSelectedItem().toString(), Integer.parseInt(tlfTestua.getText()), helbideTestua.getText());
				AukeraAdmin.getInstantzia().gtm.eguneratu();
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