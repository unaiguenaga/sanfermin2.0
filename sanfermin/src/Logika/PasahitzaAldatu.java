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
import javax.swing.JPanel;
import javax.swing.JTextField;

import administratzailea.EntzierroaAldatu;

import com.toedter.calendar.JCalendar;

public class PasahitzaAldatu extends JFrame {

		JLabel jlErabIzena = new JLabel("Erabiltzaile izena:");
		JLabel jlPasZahar = new JLabel("Pasahitz zaharra:");
		JLabel jlPasBerria = new JLabel("Pasahitz berria:");	

		JTextField jtErabIzena = new JTextField(10);
		JTextField jtPasZahar = new JTextField(10);
		JTextField jtPasBerria = new JTextField(10);

		JPanel behekoPanela = new JPanel();
		JButton bGorde = new JButton("Pasahitza gorde");

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
			hasiera.setSize(400, 200);
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

			gehituOsagaia(jtErabIzena, 1, 5, 10, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			gehituOsagaia(jtPasZahar, 3, 5, 10, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			gehituOsagaia(jtPasBerria, 6, 5, 10, 1);
			mugak.insets = new Insets(3, 3, 3, 3);
			

			behekoPanela.add(BorderLayout.SOUTH, bGorde);
			gehituOsagaia(behekoPanela, 16, 5, 9, 1);

			bGorde.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
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
