package administratzailea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Logika.ErabiltzaileKudeatzailea;

public class ErabiltzaileBerria extends JFrame {
	JLabel erabiltzailea = new JLabel("Erabiltzailea:");
	JLabel pasahitza = new JLabel("Pasahitza:");
	JLabel pasahitzaBerriz = new JLabel("Pasahitza berriz:");	
	JTextField erabTestua = new JTextField(15);
	JPasswordField pasahitzaTestua = new JPasswordField(15);
	JPasswordField tpasahitzaBerriz = new JPasswordField(15);

	JPanel behekoPanela = new JPanel();
	JButton sortu = new JButton("Sortu erabiltzailea");
	JPanel panellag = new JPanel();
	
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	

	public ErabiltzaileBerria() {
		gridBagHasieratu();
	}

	public static void main(String[] args) {
		ErabiltzaileBerria erabBerria = new ErabiltzaileBerria();
		erabBerria.setTitle("Erabiltzailea gehitu");
		erabBerria.setVisible(true);
		erabBerria.setSize(400, 200);
		erabBerria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(erabiltzailea, 1, 1, 2, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pasahitza, 3, 1, 2, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pasahitzaBerriz, 5, 1, 2, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		
		gehituOsagaia(erabTestua, 1, 4, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pasahitzaTestua, 3, 4, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(tpasahitzaBerriz, 5, 4, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		
		
		panellag.setLayout(new BoxLayout(panellag, BoxLayout.X_AXIS));
		panellag.add(Box.createVerticalGlue());
		panellag.add(sortu);
		
		panellag.add(Box.createVerticalGlue());

		behekoPanela.add(BorderLayout.SOUTH, panellag);
		gehituOsagaia(behekoPanela, 8, 1, 6, 1);
		
		sortu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ErabiltzaileKudeatzailea erab=new ErabiltzaileKudeatzailea();
				if(erab.existitzenDa(erabTestua.getText())){
					JOptionPane.showMessageDialog(null,
							"Erabiltzaile izen hori jadanik existitzen da, berriro saiatu zaitez beste izen batekin. ", "Izen errepikatua",
							JOptionPane.ERROR_MESSAGE);
					erabTestua.setText("");
					pasahitzaTestua.setText("");
					tpasahitzaBerriz.setText("");
				}
				else if(pasahitzaTestua.getText().equals(tpasahitzaBerriz.getText())){
					erab.sortuErabiltzaileaEtaGehitu(erabTestua.getText(), pasahitzaTestua.getText());
					JOptionPane.showMessageDialog(null,
							"Erabiltzaile berria sortu da. ", "Erabiltzailea gehituta",
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					//lehengo leihora bidali

					
				}else{
					JOptionPane.showMessageDialog(null,
							"Pasahitz berriak ez dira berdinak, berriro saiatu zaitez. ", "Desberdinak",
							JOptionPane.ERROR_MESSAGE);
					erabTestua.setText("");
					pasahitzaTestua.setText("");
					tpasahitzaBerriz.setText("");
				}
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