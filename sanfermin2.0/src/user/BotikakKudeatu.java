package user;

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

import com.toedter.calendar.JCalendar;

public class BotikakKudeatu  extends JFrame{

	JLabel lBotika = new JLabel("Botika:");
	JLabel lZezena = new JLabel("Zezena:");
	JLabel lNoiz = new JLabel("Noiz:");
	JLabel lDosia = new JLabel("Dosia:");
	JComboBox cbBotika = new JComboBox();
	JComboBox cbZezena = new JComboBox();
	JCalendar cal = new JCalendar();
	JTextField tfDosia = new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton bOnartu = new JButton("Onartu");	
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	String[] args = null;
	
	public BotikakKudeatu() {
		gridBagHasieratu();
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();
				
		gehituOsagaia(lBotika, 1, 1, 1, 1);
		mugak.insets = new Insets(3,3,3,3);
		
		gehituOsagaia(cbBotika, 1, 2, 1, 1);
		mugak.insets = new Insets(3,3,3,3);
		
		gehituOsagaia(lZezena, 3, 1, 1, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		
		gehituOsagaia(cbZezena,3,2,1,1);
		mugak.insets = new Insets(3,3,3,3);
		
		gehituOsagaia(lDosia, 4, 1, 1, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		
		gehituOsagaia(tfDosia,4,2,1,1);
		mugak.insets = new Insets(3,3,3,3);
		
		gehituOsagaia(lNoiz, 1, 6, 1, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		
		gehituOsagaia(cal,3,6,1,1);
		mugak.insets = new Insets(3,3,3,3);
		
		behekoPanela.add(BorderLayout.SOUTH, bOnartu);
		gehituOsagaia(behekoPanela, 15,3,3,3);
		
		
		bOnartu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	private void gehituOsagaia(Component osagaia, int errenkada, int zutabea, int zabalera, int altuera) {
		mugak.gridx=zutabea;
		mugak.gridy=errenkada;
		
		mugak.gridwidth=zabalera;
		mugak.gridheight=altuera;
		
		eskema.setConstraints(osagaia, mugak);
		edukiontzia.add(osagaia);

	}

	public static void main(String[] args) {
		
		BotikakKudeatu botikakKudeatu = new BotikakKudeatu();
		botikakKudeatu.setTitle("Entzierro berria gehitu");
		botikakKudeatu.setVisible(true);
		botikakKudeatu.setSize(550, 300);
		botikakKudeatu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	}

}
