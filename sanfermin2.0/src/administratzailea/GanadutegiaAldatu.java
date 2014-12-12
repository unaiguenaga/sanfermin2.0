package administratzailea;

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

import Logika.GanadutegiKud;

public class GanadutegiaAldatu extends JFrame {
	JLabel kodeZaharra = new JLabel("Kode Zaharra:");
	JLabel kodeBerria = new JLabel("Kode Berria:");
	JLabel helbideBerria = new JLabel("Helbide berria:");
	JLabel ganadutegia	= new JLabel("Ganadutegiak:");
	JTextField kodeZaharraTestua = new JTextField(10);
	JTextField kodeBerriaTestua = new JTextField(10);
	JTextField helbideBerriaTestua = new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton gorde = new JButton("Aldaketak gorde");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	
	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	private Vector<String> vGanadutegiIzenak = gk.getIzenak();
	JComboBox ganadutegiak = new JComboBox(vGanadutegiIzenak);

	public GanadutegiaAldatu() {
		gridBagHasieratu();
	}

	public static void main(String[] args) {
		GanadutegiaAldatu hasiera = new GanadutegiaAldatu();
		hasiera.setTitle("Ganadutegiaren datuak aldatu");
		hasiera.setVisible(true);
		hasiera.setSize(400, 175);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(ganadutegia, 1, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeZaharra, 3, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeBerria, 5, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(helbideBerria, 7, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(ganadutegiak, 1, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeZaharraTestua, 3, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeBerriaTestua, 5, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(helbideBerriaTestua, 7, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		behekoPanela.add(BorderLayout.SOUTH, gorde);
		gehituOsagaia(behekoPanela, 16, 3, 9, 1);
		
		gorde.addActionListener(new ActionListener() {

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
