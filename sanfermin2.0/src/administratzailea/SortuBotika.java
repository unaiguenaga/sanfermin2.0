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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import user.BotikaKud;

public class SortuBotika extends JFrame{

	JLabel kodea=new JLabel("Kodea:"); 
	JLabel izena=new JLabel("Izena:"); 

	JTextField kodeTestua= new JTextField(10);
	JTextField izenaTestua= new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton gehitu= new JButton("Gehitu");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	

	
	public SortuBotika() {
		gridBagHasieratu();
	}
	
	public static void main(String[] args) {
		SortuBotika hasiera = new SortuBotika();
		hasiera.setTitle("Gehitu botika");
		hasiera.setVisible(true);
		hasiera.setSize(250, 200);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu(){
		edukiontzia = getContentPane();
		eskema= new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak= new GridBagConstraints();
		
		gehituOsagaia(kodea, 1, 1, 4, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(izena, 3, 1, 4, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		
		gehituOsagaia(kodeTestua, 1, 5, 10, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		gehituOsagaia(izenaTestua, 3, 5, 10, 1);
		mugak.insets=new Insets(3, 3, 3, 3);
		
		behekoPanela.add(BorderLayout.SOUTH, gehitu);
		gehituOsagaia(behekoPanela,16, 5, 9, 1);
		
		gehitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int kodea = Integer.parseInt((String) kodeTestua.getText());
				BotikaKud.getInstantzia().gehituBotika(kodea, (String) izenaTestua.getText());
				
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
