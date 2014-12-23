package administratzailea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logika.EntzierroKud;
import Logika.EntzierroLag;
import Logika.GanadutegiKud;

import com.toedter.calendar.JCalendar;

public class EntzierroaAldatu extends JFrame {

	JLabel eguna = new JLabel("Data berria:");
	JLabel distantzia = new JLabel("Distantzia (metrotan):");
	JLabel ganadutegia = new JLabel("Ganadutegi berria:");	
	JLabel entzierroa = new JLabel("Entzierroa:");

	JTextField distantziaTestua = new JTextField(10);
	JTextField ganadutegiaTestua = new JTextField(10);

	JPanel behekoPanela = new JPanel();
	JButton gorde = new JButton("Aldaketak gorde");
	JCalendar cal = new JCalendar();

	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;

	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	private EntzierroKud ek = EntzierroKud.getInstantzia();
	private Vector<String> vDatak = ek.getId();
	private Vector<String> vIzenak = gk.getIzenak();
	private Vector<Integer> vId = gk.getId();
	JComboBox entzierroak = new JComboBox(vDatak);
	JComboBox ganadutegiak = new JComboBox(vIzenak);
	
	String entzierroId;

	public EntzierroaAldatu(String id){
		entzierroId = id;
		gridBagHasieratu();
	}
	
	private void gridBagHasieratu(){
		
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();

		gehituOsagaia(ganadutegia, 6, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(distantzia, 8, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(ganadutegiak, 6, 6, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(distantziaTestua, 8, 6, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		behekoPanela.add(BorderLayout.SOUTH, gorde);
		gehituOsagaia(behekoPanela, 16, 3, 9, 1);

		gorde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (distantziaTestua.getText().equals("")){
					ek.aldatu(entzierroId, vId.get(ganadutegiak.getSelectedIndex()));
				}else{
					ek.aldatu(entzierroId, vId.get(ganadutegiak.getSelectedIndex()), Float.parseFloat(distantziaTestua.getText()));
				}
				AukeraAdmin.getInstantzia().etm.eguneratu();
				dispose();
			}
		});
		
		this.setTitle("Entzierroaren datuak aldatu");
		this.setVisible(true);
		this.setSize(450, 350);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
