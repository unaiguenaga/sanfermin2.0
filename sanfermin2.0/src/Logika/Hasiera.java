package Logika;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Hasiera extends JFrame {
	JLabel erabiltzailea = new JLabel("Erabiltzailea:");
	JLabel pasahitza = new JLabel("Pasahitza:");
	JTextField erabTestua = new JTextField(15);
	JPasswordField pasahitzaTestua = new JPasswordField(15);
	JPanel behekoPanela = new JPanel();
	JButton kautotu = new JButton("Kautotu");
	JButton aldatuPasahitza = new JButton("PasahitzaAldatu");
	JPanel panellag = new JPanel();
	JLabel hutsunea = new JLabel(" ");
	
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	class Entzule implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			ErabiltzaileKudeatzailea era = new ErabiltzaileKudeatzailea();
			if(era.konprobatuPasahitzaEtaErabiltzailea(erabTestua.getText(),pasahitzaTestua.getText())){
				era.hasieratuAdminEdoUser(erabTestua.getText(), pasahitzaTestua.getText());
				dispose();
			}
			else{
				ErroreaPasahitza errorea= new ErroreaPasahitza();
				erabTestua.setText("");
				pasahitzaTestua.setText("");
			}
			System.out.println("Erabiltzailea: "+erabTestua.getText());	
		}
	}

	public Hasiera() {
		gridBagHasieratu();
	}

	public static void main(String[] args) {
		new DatuBaseaKargatu();
		Hasiera hasiera = new Hasiera();
		hasiera.setTitle("San Ferminak");
		hasiera.setVisible(true);
		hasiera.setSize(400, 200);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(erabiltzailea, 1, 1, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pasahitza, 3, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(erabTestua, 1, 4, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pasahitzaTestua, 3, 4, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		
		panellag.setLayout(new BoxLayout(panellag, BoxLayout.X_AXIS));
		panellag.add(Box.createVerticalGlue());
		panellag.add(kautotu);
		panellag.add(hutsunea);
		panellag.add(aldatuPasahitza);
		panellag.add(Box.createVerticalGlue());

		behekoPanela.add(BorderLayout.SOUTH, panellag);
		gehituOsagaia(behekoPanela, 5, 1, 6, 1);
		
		kautotu.addActionListener(new Entzule());
		
		aldatuPasahitza.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				PasahitzaAldatu.main(null);
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
