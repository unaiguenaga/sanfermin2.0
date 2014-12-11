package zamarpotu;

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
import javax.swing.JTextField;

import administratzailea.BotikaAldatu;

public class BotikakKudeatu  extends JFrame {

	JLabel kodeZaharra = new JLabel("Kode Zaharra:");
	JLabel kodeBerria = new JLabel("Kode Berria:");
	JTextField kodeZaharraTestua = new JTextField(10);
	JTextField kodeBerriaTestua = new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton gorde = new JButton("Aldaketak gorde");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	public BotikakKudeatu() {
		gridBagHasieratu();
	}

	public static void main(String[] args) {
		BotikakKudeatu hasiera = new BotikakKudeatu();
		hasiera.setTitle("Botiken datuak aldatu");
		hasiera.setVisible(true);
		hasiera.setSize(400, 175);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(kodeZaharra, 1, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeBerria, 3, 0, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(kodeZaharraTestua, 1, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeBerriaTestua, 3, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		behekoPanela.add(BorderLayout.SOUTH, gorde);
		gehituOsagaia(behekoPanela, 16, 3, 9, 1);

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
