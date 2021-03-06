package Logika;

import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import administratzailea.EntzierroaAldatu;


public class PasahitzaAldatu extends JFrame {

		JLabel jlErabIzena = new JLabel("Erabiltzaile izena:");
		JLabel jlPasZahar = new JLabel("Pasahitz zaharra:");
		JLabel jlPasBerria = new JLabel("Pasahitz berria:");	
		JLabel jlPasBerriaKonprobatu = new JLabel("Errepikatu berriz:");
		JTextField jtErabIzena = new JTextField(10);
		JPasswordField jtPasZahar = new JPasswordField(10);
		JPasswordField jtPasBerria = new JPasswordField(10);
		JPasswordField jtPasBerriaKonprobatu = new JPasswordField(10);


		JPanel behekoPanela = new JPanel();
		JButton bGorde = new JButton("Pasahitz berria gorde");

		private GridBagLayout eskema;
		private Container edukiontzia;
		private GridBagConstraints mugak;

		public PasahitzaAldatu() {
			gridBagHasieratu();
		}

		public static void main(String[] args) {
			PasahitzaAldatu hasiera = new PasahitzaAldatu();
			hasiera.setTitle("Pasahitza aldatu");
			hasiera.setVisible(true);
			hasiera.setSize(400, 250);
			hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}

		private void gridBagHasieratu() {
			edukiontzia = getContentPane();
			eskema = new GridBagLayout();
			edukiontzia.setLayout(eskema);
			mugak = new GridBagConstraints();

			gehituOsagaia(jlErabIzena, 1, 1, 4, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			gehituOsagaia(jlPasZahar, 3, 1, 4, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			gehituOsagaia(jlPasBerria, 6, 1, 5, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			gehituOsagaia(jlPasBerriaKonprobatu, 9, 1, 5, 1);
			mugak.insets = new Insets(3, 3, 3, 3);

			gehituOsagaia(jtErabIzena, 1, 5, 10, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			gehituOsagaia(jtPasZahar, 3, 5, 10, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			gehituOsagaia(jtPasBerria, 6, 5, 10, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			gehituOsagaia(jtPasBerriaKonprobatu, 9, 5, 10, 1);
			mugak.insets = new Insets(3, 3, 3, 3);

			behekoPanela.add(BorderLayout.CENTER, bGorde);
			gehituOsagaia(behekoPanela, 13, 4, 10, 1);

			bGorde.addActionListener(new ActionListener() {

				
				public void actionPerformed(ActionEvent e) {
					pasahitzaAldatu(jtPasBerria.getText().toString(),jtPasBerriaKonprobatu.getText(),
							jtErabIzena.getText(),jtPasZahar.getText());
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
		
		public void pasahitzaAldatu(String pasBerri, String pasBerriKonpr, String erab, String pasZahar){
			ErabiltzaileKudeatzailea era = ErabiltzaileKudeatzailea.getInstantzia();
			System.out.println(pasBerri);
			System.out.println(pasBerriKonpr);
			if(era.konprobatuPasahitzaEtaErabiltzailea(erab, pasZahar)){
				if(pasBerri.equals(pasBerriKonpr)){
					JOptionPane.showMessageDialog(null,
							"Zure pasahitza aldatu da, aurrera segi dezakezu. ", "Aldatu da",
							JOptionPane.INFORMATION_MESSAGE);
					era.pasahitzaAldatu(erab,pasBerri);
					dispose();
					era.hasieratuAdminEdoUser(erab, pasBerri);					
				}
				else{
					JOptionPane.showMessageDialog(null,
							"Pasahitz berriak ez dira berdinak, berriro saiatu zaitez. ", "Desberdinak",
							JOptionPane.ERROR_MESSAGE);
					dispose();
					Hasiera.bistaratu();

				}
			}
			else{
				Leihoak errorea = new Leihoak();
				errorea.pasahitza();
				dispose();
				Hasiera.bistaratu();

			}
		}


}
