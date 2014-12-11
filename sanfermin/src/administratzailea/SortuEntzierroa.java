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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.BotikakKudeatu;

import com.toedter.calendar.JCalendar;

public class SortuEntzierroa extends JFrame {

	JLabel noiz = new JLabel("Noiz:");
	JLabel esleitu = new JLabel("Ganadutegia Esleitu:");
	JTextField noizTestua = new JTextField(10);
	JComboBox aukeratzeko = new JComboBox<String>();
	JPanel behekoPanela = new JPanel();
	JButton gorde = new JButton("Gorde");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	JCalendar cal = new JCalendar();

	public SortuEntzierroa() {
		gridBagHasieratu();
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(noiz, 1, 1, 1, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(cal, 3, 1, 1, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(esleitu, 1, 24, 1, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(aukeratzeko, 2, 24, 1, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		behekoPanela.add(BorderLayout.SOUTH, gorde);
		gehituOsagaia(behekoPanela, 7, 3, 3, 3);
		

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

	public static void main(String[] args) {

		SortuEntzierroa entzierroBerria = new SortuEntzierroa();
		entzierroBerria.setTitle("Entzierro berria gehitu");
		entzierroBerria.setVisible(true);
		entzierroBerria.setSize(500, 300);
		entzierroBerria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
