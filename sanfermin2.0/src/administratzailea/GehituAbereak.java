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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GehituAbereak extends JFrame {
	private static String erabiltzailea=null;

	JButton zezena = new JButton("Zezena");
	JButton joalduna = new JButton("Joalduna");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	public GehituAbereak() {
		gridBagHasieratu();

	}

	public static void main(String erabiltzaileIzena) {
		erabiltzailea=erabiltzaileIzena;
		GehituAbereak hasiera = new GehituAbereak();
		hasiera.setTitle("Gehitu Aberea");
		hasiera.setVisible(true);
		hasiera.setSize(300, 100);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(zezena, 1, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(joalduna, 1, 10, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		zezena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SortuZezena.main(erabiltzailea);
				dispose();
			}
		});
		
		joalduna.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SortuJoalduna.main(erabiltzailea);
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
