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

import user.AukeraUser;
import user.ZezenKud;

public class SortuJoalduna extends JFrame {
	
	private static String erabiltzailea=null;

	JLabel kodea = new JLabel("Kodea:");
	JLabel jaiotzeData = new JLabel("JaiotzeData:");
	JLabel pisua = new JLabel("Pisua:");
	JLabel altuera = new JLabel("Altuera:");
	JLabel kolorea = new JLabel("Kolorea:");
	JTextField kodeTestua = new JTextField(10);
	JTextField jaiotzeTestua = new JTextField(10);
	JTextField pisuaTestua = new JTextField(10);
	JTextField altueraTestua = new JTextField(10);
	JTextField koloreaTestua = new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton gehitu = new JButton("Gehitu");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	public SortuJoalduna() {
		gridBagHasieratu();
	}

	public static void main(String erab) {
		erabiltzailea=erab;
		SortuJoalduna hasiera = new SortuJoalduna();
		hasiera.setTitle("Gehitu joalduna");
		hasiera.setVisible(true);
		hasiera.setSize(400, 250);
		hasiera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(kodea, 1, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(jaiotzeData, 3, 0, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pisua, 5, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(altuera, 7, 0, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(kolorea, 9, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(kodeTestua, 1, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(jaiotzeTestua, 3, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(pisuaTestua, 5, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(altueraTestua, 7, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(koloreaTestua, 9, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		behekoPanela.add(BorderLayout.SOUTH, gehitu);
		gehituOsagaia(behekoPanela, 16, 3, 9, 1);
		
		gehitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//				String data = formato.format(jaiotzeTestua.getDate());
//				System.out.println("Erabiltzailea: "+erabiltzailea);
				int ganadutegiKod = ZezenKud.getInstantzia().getGanadutegia(erabiltzailea);
				
				sortu(Integer.parseInt(kodeTestua.getText()), jaiotzeTestua.getText(), pisuaTestua.getText(), 
						altueraTestua.getText(),koloreaTestua.getText(), ganadutegiKod);
				
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
	
	public void sortu(int kod, String jaiotzeData, String pisua, String altuera, String kolorea, int ganaduKod){
		ZezenKud zk = ZezenKud.getInstantzia();
		String kodigu = ""+kod;
		if(zk.existitzenDaJoalduna(kodigu)){
			JOptionPane.showMessageDialog(null,
					"Joaldunaren kode hori jadanik existitzen da, saia zaitez berriro beste kode batekin. ", "Kode errepikatua",
					JOptionPane.ERROR_MESSAGE);
					this.kodeTestua.setText("");
					this.jaiotzeTestua.setText("");
					this.pisuaTestua.setText("");
					this.altueraTestua.setText("");
					this.kodeTestua.setText("");
		}else{
			zk.gehituJoalduna(kod, jaiotzeData, Float.parseFloat(pisua), Float.parseFloat(altuera), kolorea, ganaduKod);
			dispose();
			JOptionPane.showMessageDialog(null, "Joalduna gehitu da.");
			AukeraUser.getInstantzia().jtm.eguneratu();
		}
	}
}
