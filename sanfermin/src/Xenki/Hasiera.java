package Xenki;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Hasiera extends JFrame{
	JLabel erabiltzailea=new JLabel("Erabiltzailea:"); 
	JLabel pasahitza=new JLabel("Pasahitza:"); 
	JButton aldatuPasahitza = new JButton("Pasahitza aldatu");
	JTextField erabTestua= new JTextField(10);
	JTextField pasahitzaTestua= new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton kautotu= new JButton("Kautotu");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	

	
	public Hasiera() {
		gridBagHasieratu();
	}
	
	public static void main(String[] args) {
		Hasiera hasiera = new Hasiera();
		hasiera.setTitle("San Ferminak");
		hasiera.setVisible(true);
		hasiera.setSize(300, 150);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu(){
		edukiontzia = getContentPane();
		eskema= new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak= new GridBagConstraints();
		

		gehituOsagaia(erabiltzailea, 1, 1, 3, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(pasahitza, 3, 1, 5, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(erabTestua, 1, 4, 3, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(pasahitzaTestua, 3, 4, 5, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		
		behekoPanela.add(BorderLayout.SOUTH, kautotu);
		gehituOsagaia(behekoPanela,5, 1, 6, 1);
		
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
