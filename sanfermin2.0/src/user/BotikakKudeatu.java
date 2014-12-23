package user;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logika.DatuBaseaKargatu;
import Logika.GanadutegiKud;
import Logika.TratamenduKud;

import com.toedter.calendar.JCalendar;

public class BotikakKudeatu  extends JFrame{
	
//////////////Datu basea kargatu (zezenak soilik)
	//DatuBaseaKargatu db = new DatuBaseaKargatu();
	
///////////////////////////////////////////
	
	private BotikaKud bk = BotikaKud.getInstantzia();
	private Vector<String> vIzenakBotikak = bk.getIzenak();
	
	private ZezenKud zk = ZezenKud.getInstantzia();

	JLabel lBotika = new JLabel("Botika:");
	JLabel lZezena = new JLabel("Zezena:");
	JLabel lNoiz = new JLabel("Noiz:");
	JLabel lDosia = new JLabel("Dosia:");
	JComboBox cbBotika = new JComboBox(vIzenakBotikak);
	JComboBox cbZezena;
	JCalendar cal = new JCalendar();
	JTextField tfDosia = new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton bOnartu = new JButton("Onartu");	
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	String[] args = null;
	
	private String erabiltzailea;
	
	
	
	public BotikakKudeatu(String erabIzena) {
		
		erabiltzailea = erabIzena;
		cbZezena = new JComboBox(ZezenKud.getInstantzia().getIzenak(erabIzena));
		gridBagHasieratu();
		setTitle("Tratamendu berria gehitu");
		setVisible(true);
		setSize(550, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				String data = formato.format(cal.getDate());
				int botika = BotikaKud.getInstantzia().getKod().get(cbBotika.getSelectedIndex());
				int zezena = ZezenKud.getInstantzia().getId(erabiltzailea).get(cbZezena.getSelectedIndex());
				TratamenduKud.getInstantzia().gehitu(data, botika, Float.parseFloat(tfDosia.getText()), zezena);
				AukeraUser.getInstantzia().ttm.eguneratu();
				
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
}
