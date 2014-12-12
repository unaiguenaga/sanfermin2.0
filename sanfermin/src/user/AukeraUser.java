package user;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import Logika.Hasiera;
import Logika.TableDemo;
import Logika.TratamenduTableModel;
import administratzailea.EntzierroTableModel;
import administratzailea.ErabiltzaileBerria;
import administratzailea.ErabiltzaileaKendu;
import administratzailea.GanadutegiTableModel;
import administratzailea.GehituAbereak;
import administratzailea.SortuEntzierroa;

public class AukeraUser extends JFrame {
	JButton bAbereaEzabatu = new JButton("Aberea Ezabatu");
	JButton bAbereaGehitu = new JButton("Aberea Gehitu");
	JButton bGehituZezena = new JButton("Gehitu Zezena");
	JButton bZezenaEzabatu = new JButton("Ezabatu Zezena");
	JButton bBotikakKudeatu = new JButton("Botikak Kudeatu");
	JButton bAldaketakGorde2 = new JButton("Aldaketak gorde");
	JButton bBotikaBerri = new JButton("Gehitu botika berria");
	JButton bBajanEman = new JButton("Bajan eman");
	JButton bAldaketakGorde3 = new JButton("Aldaketak gorde");
	JButton bGehituAberea = new JButton("Gehitu Aberea");
	JButton bAldatuGanadutegia = new JButton("Datuak Aldatu");
	JButton bBotikaAldatu = new JButton("Botika Aldatu");
	JButton bBotoaGorde = new JButton("Botoa gorde");
	JPanel panela = new JPanel();
	JTabbedPane pestañak = new JTabbedPane();
	JPanel abereakPestaña = new JPanel();
	JPanel zezenakPestaña = new JPanel();
	JPanel botikaPestaña = new JPanel();
	JPanel bozkatuPestaña = new JPanel();
	
	JPanel zezenPanela = new JPanel();
	JPanel botikaPanela = new JPanel();
	
	JPanel eskumakoPanela1 = new JPanel();
	JPanel eskumakoPanela2 = new JPanel();
	JPanel eskumakoPanela3 = new JPanel();
	JPanel eskumakoPanela4 = new JPanel();
	JPanel bozkaTaulaPanela = new JPanel();
	
	ZezenaTableModel ztm = new ZezenaTableModel();
	TableDemo tableZezenak = new TableDemo(ztm);
	BotikaTableModel btm = new BotikaTableModel();
	TableDemo tableBotikak = new TableDemo(btm);


	JLabel hutsunea = new JLabel("     ");
	JLabel hutsunea2 = new JLabel("     ");
	
	JTable tableBozkak = new JTable(new TaulaBozkaketa());

	JMenuBar barra= new JMenuBar();
	JMenu menua=new JMenu("Menua");
	JMenuItem atzera=new JMenuItem("Atzera");
	JMenuItem exit=new JMenuItem("Exit");
	
	public AukeraUser() {
		hasieratu();
	}

	public static void main(String izena) {
		AukeraUser aukera = new AukeraUser();
		aukera.setTitle("San Ferminen kudeaketa ERABILTZAILEA: "+izena);
		aukera.setVisible(true);
		aukera.setSize(1000, 500);
		aukera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void hasieratu() {
		
		setContentPane(panela);
		panela.setLayout(null);
		setJMenuBar(barra);
		barra.add(menua);

		menua.add(atzera);
		atzera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Hasiera.main(null);
			}
		});
		menua.add(exit);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});


		pestañak.setBounds(10, 11, 850, 350);
		panela.add(pestañak);

		pestañak.addTab("Abereak", null, abereakPestaña, null);
		pestañak.addTab("Entzierroko Zezenak Kudeatu", null, zezenakPestaña, null);
		pestañak.addTab("Botikak", null, botikaPestaña, null);
		pestañak.addTab("Bozkak", null, bozkatuPestaña, null);


		// ABEREAK
		abereakPestaña.setLayout(new BorderLayout());
		zezenPanela.setLayout(new BorderLayout());
		abereakPestaña.add(eskumakoPanela1, BorderLayout.EAST);
		JScrollPane jScrollPane1 = new JScrollPane(tableZezenak);
		zezenPanela.add(jScrollPane1);
		abereakPestaña.add(zezenPanela);
		abereakPestaña.add(eskumakoPanela1, BorderLayout.EAST);

		
		eskumakoPanela1.setLayout(new BoxLayout(eskumakoPanela1, BoxLayout.Y_AXIS));
		eskumakoPanela1.add(Box.createVerticalGlue());
		eskumakoPanela1.add(bAbereaEzabatu);
		eskumakoPanela1.add(hutsunea2);
		eskumakoPanela1.add(bAbereaGehitu);
		eskumakoPanela1.add(Box.createVerticalGlue());

		// ENTZIERRO ZERRENDAK
		zezenakPestaña.setLayout(new BorderLayout());
		zezenakPestaña.add(eskumakoPanela2, BorderLayout.EAST);
		eskumakoPanela2.setLayout(new BoxLayout(eskumakoPanela2, BoxLayout.Y_AXIS));
		eskumakoPanela2.add(Box.createVerticalGlue());
		eskumakoPanela2.add(bGehituZezena);
		eskumakoPanela2.add(hutsunea);
		eskumakoPanela2.add(bZezenaEzabatu);
		eskumakoPanela2.add(Box.createVerticalGlue());

		// BOTIKAK
		botikaPestaña.setLayout(new BorderLayout());
		botikaPanela.setLayout(new BorderLayout());
		JScrollPane jScrollPane3=new JScrollPane(tableBotikak);
		botikaPanela.add(jScrollPane3);
		botikaPestaña.add(botikaPanela);
		botikaPestaña.add(eskumakoPanela3, BorderLayout.EAST);
		
		eskumakoPanela3.setLayout(new BoxLayout(eskumakoPanela3, BoxLayout.PAGE_AXIS));
		eskumakoPanela3.add(Box.createVerticalGlue());

		eskumakoPanela3.add(bBotikakKudeatu);

		eskumakoPanela3.add(Box.createVerticalGlue());	
	
		
		

		// BOZKAKETAK
		bozkatuPestaña.setLayout(new BorderLayout());
		bozkatuPestaña.add(eskumakoPanela4, BorderLayout.EAST);
		botikaPanela.setLayout(new BorderLayout());
		botikaPanela.add(tableBotikak);
		botikaPestaña.add(botikaPanela);
		eskumakoPanela4.setLayout(new BoxLayout(eskumakoPanela4, BoxLayout.Y_AXIS));
		eskumakoPanela4.add(Box.createVerticalGlue());
		eskumakoPanela4.add(bBotoaGorde);
		eskumakoPanela4.add(Box.createVerticalGlue());
		bozkaTaulaPanela.setLayout(new BorderLayout());
		bozkaTaulaPanela.add(tableBozkak);
		bozkatuPestaña.add(bozkaTaulaPanela);

		bAbereaGehitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GehituAbereak.main(null);
			}
		});

		bBotikakKudeatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotikakKudeatu.main(null);
			}
		});
		
		bGehituZezena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GehituZezena.main(null);
			}
		});
	}

}
