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

import Logika.EntzierroKud;
import Logika.GanadutegiKud;
import Logika.TratamenduKud;

public class BotikaAldatu extends JFrame {

	JLabel botika = new JLabel("Botika:");
	JLabel kodeZaharra = new JLabel("Kode Zaharra:");
	JLabel kodeBerria = new JLabel("Kode Berria:");
	JLabel izenBerria = new JLabel("Izen Berria:");
	JTextField kodeZaharraTestua = new JTextField(10);
	JTextField kodeBerriaTestua = new JTextField(10);
	JTextField izenBerriaTestua = new JTextField(10);

	JPanel behekoPanela = new JPanel();
	JButton gorde = new JButton("Aldaketak gorde");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	
	private TratamenduKud tk = TratamenduKud.getInstantzia();
	private Vector<String> vBotikak = tk.getIzenak();
	JComboBox cbBotika = new JComboBox(vBotikak);
	
	public BotikaAldatu() {
		gridBagHasieratu();
	}

	public static void main(String[] args) {
		BotikaAldatu hasiera = new BotikaAldatu();
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
		
		gehituOsagaia(botika, 1, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeZaharra, 3, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeBerria, 6, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(izenBerria, 9, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(cbBotika, 1, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeZaharraTestua, 3, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kodeBerriaTestua, 6, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);	
		gehituOsagaia(izenBerriaTestua, 9, 5, 5, 1);
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
