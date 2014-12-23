package administratzailea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.ZezenKud;

import com.toedter.calendar.JCalendar;

public class SortuJoalduna extends JFrame {
	
	private static String erabiltzailea = null;

	JLabel kodea = new JLabel("Kodea:");
	JLabel jaiotzeData = new JLabel("JaiotzeData:");
	JLabel pisua = new JLabel("Pisua:");
	JLabel altuera = new JLabel("Altuera:");
	JLabel kolorea = new JLabel("Kolorea:");
	JLabel izena = new JLabel("Izena:");
	JTextField kodeTestua = new JTextField(10);
	JCalendar jaiotzeTestua = new JCalendar();
	JTextField pisuaTestua = new JTextField(10);
	JTextField altueraTestua = new JTextField(10);
	JTextField koloreaTestua = new JTextField(10);
	JTextField izenaTestua = new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton gehitu = new JButton("Gehitu");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	public SortuJoalduna() {
		gridBagHasieratu();
	}

	public static void main(String erab) {
		erabiltzailea = erab;
		SortuJoalduna hasiera = new SortuJoalduna();
		hasiera.setTitle("Gehitu joalduna");
		hasiera.setVisible(true);
		hasiera.setSize(400, 400);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(kodea, 1, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(izena, 3, 0, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kolorea, 5, 0, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pisua, 7, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(altuera, 9, 0, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(jaiotzeData, 11, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(kodeTestua, 1, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(izenaTestua, 3, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(koloreaTestua, 5, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pisuaTestua, 7, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(altueraTestua, 9, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(jaiotzeTestua, 11, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		behekoPanela.add(BorderLayout.SOUTH, gehitu);
		gehituOsagaia(behekoPanela, 16, 3, 9, 1);
		
		gehitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				String data = formato.format(jaiotzeTestua.getDate());
				String ganadutegia = ZezenKud.getInstantzia().getGanadutegia(erabiltzailea);
				sortu(Integer.parseInt(kodeTestua.getText()), izenaTestua.getText(), data, pisuaTestua.getText(), 
						altueraTestua.getText(), koloreaTestua.getText(), ganadutegia);
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
	
	public void sortu(int kod, String izena, String jaiotzeData, String pisua, String altuera, String kolorea, String ganaduKod){
		ZezenKud zk = ZezenKud.getInstantzia();
		String kodigu = ""+kod;
		if(zk.existitzenDa(kodigu)){
			JOptionPane.showMessageDialog(null,
					"Zezenaren kode hori jadanik existitzen da, saia zaitez berriro beste kode batekin. ", "Kode errepikatua",
					JOptionPane.ERROR_MESSAGE);
					this.kodeTestua.setText("");
					this.koloreaTestua.setText("");
					this.pisuaTestua.setText("");
					this.altueraTestua.setText("");
		}else{
			zk.gehitu(kod, izena, jaiotzeData, pisua, altuera, kolorea, ganaduKod);
			dispose();
		}
	}
}
