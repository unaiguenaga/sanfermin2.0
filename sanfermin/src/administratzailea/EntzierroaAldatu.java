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

import com.toedter.calendar.JCalendar;

import user.BotikakKudeatu;

public class EntzierroaAldatu extends JFrame {

	JLabel eguna = new JLabel("Eguna:");
	JLabel distantzia = new JLabel("Distantzia (metrotan):");
	JLabel ganadutegia = new JLabel("Ganadutegiaren Kodea:");
	JTextField distantziaTestua = new JTextField(10);
	JTextField ganadutegiaTestua = new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton gorde = new JButton("Aldaketak gorde");
	JCalendar cal = new JCalendar();
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	public EntzierroaAldatu() {
		gridBagHasieratu();
	}

	public static void main(String[] args) {
		EntzierroaAldatu hasiera = new EntzierroaAldatu();
		hasiera.setTitle("Entzierroaren datuak aldatu");
		hasiera.setVisible(true);
		hasiera.setSize(450, 350);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(eguna, 1, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(ganadutegia, 4, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(distantzia, 6, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(cal, 2, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(ganadutegiaTestua, 4, 6, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(distantziaTestua, 6, 6, 5, 1);
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
