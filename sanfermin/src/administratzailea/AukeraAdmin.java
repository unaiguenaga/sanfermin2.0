package administratzailea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import user.BotikaKud;
import user.BotikaLag;
import user.BotikaTableModel;
import user.TaulaBozkaketa;
import Logika.GanadutegiKud;
import Logika.GanadutegiLag;
import Logika.Hasiera;
import Logika.TableDemo;
import Logika.TratamenduTableModel;


public class AukeraAdmin extends JFrame {
	JButton bGanadutegiBerri = new JButton("Sortu ganadutegi berria");
	JButton bHautatutakoaEzabatu = new JButton("Hautatutakoa ezabatu");
	JButton bAldaketakGorde = new JButton("Aldaketak gorde");
	JButton bEntzierroBerri = new JButton("Sortu entzierro berria");
	JButton bDatuakAldatu = new JButton("Datuak aldatu");
	JButton bAldaketakGorde2 = new JButton("Aldaketak gorde");
	JButton bBotikaBerri = new JButton("Gehitu botika berria");
	JButton bBajanEman = new JButton("Bajan eman");
	JButton bAldaketakGorde3 = new JButton("Aldaketak gorde");
	JButton bAldatuGanadutegia = new JButton("Datuak Aldatu");
	JButton bBotikaAldatu = new JButton("Botika Aldatu");
	JTabbedPane pestañak = new JTabbedPane();
	JPanel panela = new JPanel();
	JPanel entzierroakPestaña = new JPanel();
	JPanel ganadutegiakPestaña = new JPanel();
	JPanel botikakPestaña = new JPanel();
	JPanel eskumakoPanela1 = new JPanel();
	JPanel eskumakoPanela2 = new JPanel();
	JPanel eskumakoPanela3 = new JPanel();
	JPanel botikaPanela = new JPanel();
	JPanel entzierroPanela = new JPanel();
	JPanel ganadutegiPanela = new JPanel();
	JMenuBar barra= new JMenuBar();
	JMenu menua=new JMenu("Menua");
	JMenu erabiltzailea=new JMenu("Erabiltzaileak");
	JMenuItem erabBerria=new JMenuItem("Sortu erabiltzaile berria");
	JMenuItem erabKendu=new JMenuItem("Erabiltzailea borratu");

	JMenuItem atzera=new JMenuItem("Atzera");
	JMenuItem exit=new JMenuItem("Exit");
	
	GanadutegiTableModel gtm = new GanadutegiTableModel();
	EntzierroTableModel etm =new EntzierroTableModel();
	//TratamenduTableModel ttm = new TratamenduTableModel();
	BotikaTableModel btm = new BotikaTableModel();
	TableDemo tableGanadutegiak = new TableDemo(gtm);
	TableDemo tableEntzierroak = new TableDemo(etm);
	TableDemo tableBotikak = new TableDemo(btm);

	private static AukeraAdmin instantzia = new AukeraAdmin();
	
	public static AukeraAdmin getInstantzia(){
		return instantzia;
	}
	
	public AukeraAdmin() {
		hasieratu();
	}

	public void main(String izena) {
		AukeraAdmin aukera = AukeraAdmin.getInstantzia();
		aukera.setTitle("San Ferminen kudeaketa ADMINISTRATZAILEA:"+izena);
		aukera.setVisible(true);
		aukera.setSize(1000, 500);
		aukera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void hasieratu() {

		setContentPane(panela);
		panela.setLayout(null);
		setJMenuBar(barra);
		barra.add(menua);
		barra.add(erabiltzailea);
		erabiltzailea.add(erabBerria);
		erabBerria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ErabiltzaileBerria.main(null);
			}
		});
		erabiltzailea.add(erabKendu);
		erabKendu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ErabiltzaileaKendu.main(null);
				
			}
		});
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

		pestañak.addTab("Entzierroak", null, entzierroakPestaña, null);
		pestañak.addTab("Ganadutegiak", null, ganadutegiakPestaña, null);
		pestañak.addTab("Botikak", null, botikakPestaña, null);

		// ENTZIERROA
		entzierroakPestaña.setLayout(new BorderLayout());
		entzierroPanela.setLayout(new BorderLayout());
		JScrollPane jScrollPane1 = new JScrollPane(tableEntzierroak);
		entzierroPanela.add(jScrollPane1);
		entzierroakPestaña.add(entzierroPanela);
		entzierroakPestaña.add(eskumakoPanela1, BorderLayout.EAST);

		eskumakoPanela1.setLayout(new BoxLayout(eskumakoPanela1, BoxLayout.Y_AXIS));
		eskumakoPanela1.add(Box.createVerticalGlue());
		eskumakoPanela1.add(bEntzierroBerri);
		eskumakoPanela1.add(bDatuakAldatu);
		eskumakoPanela1.add(bAldaketakGorde2);
		eskumakoPanela1.add(Box.createVerticalGlue());

		// GANADUTEGIA
		ganadutegiakPestaña.setLayout(new BorderLayout());
		ganadutegiPanela.setLayout(new BorderLayout());
		JScrollPane jScrollPane2 = new JScrollPane(tableGanadutegiak);
		ganadutegiPanela.add(jScrollPane2);
		ganadutegiakPestaña.add(ganadutegiPanela);
		ganadutegiakPestaña.add(eskumakoPanela2, BorderLayout.EAST);
		
		eskumakoPanela2.setLayout(new BoxLayout(eskumakoPanela2, BoxLayout.PAGE_AXIS));
		eskumakoPanela2.add(Box.createVerticalGlue());
		eskumakoPanela2.add(bGanadutegiBerri);
		eskumakoPanela2.add(bHautatutakoaEzabatu);
		eskumakoPanela2.add(bAldatuGanadutegia);
		eskumakoPanela2.add(bAldaketakGorde);
		eskumakoPanela2.add(Box.createVerticalGlue());

		// BOTIKAK
		botikakPestaña.setLayout(new BorderLayout());
		botikaPanela.setLayout(new BorderLayout());
		JScrollPane jScrollPane3=new JScrollPane(tableBotikak);
		botikaPanela.add(jScrollPane3);
		botikakPestaña.add(botikaPanela);
		botikakPestaña.add(eskumakoPanela3, BorderLayout.EAST);
		
		eskumakoPanela3.setLayout(new BoxLayout(eskumakoPanela3, BoxLayout.PAGE_AXIS));
		eskumakoPanela3.add(Box.createVerticalGlue());
		eskumakoPanela3.add(bBotikaBerri);
		eskumakoPanela3.add(bBajanEman);
		eskumakoPanela3.add(bBotikaAldatu);
		eskumakoPanela3.add(bAldaketakGorde3);
		eskumakoPanela3.add(Box.createVerticalGlue());

		// LISTENERS

		bEntzierroBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SortuEntzierroa.main(null);
			}
		});

		bDatuakAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EntzierroaAldatu.main(null);
			}
		});

		bGanadutegiBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SortuGanadutegia.main(null);
			}
		});
		
		bHautatutakoaEzabatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int lerro = tableGanadutegiak.getHautatutakoLerroa();
				GanadutegiLag lag = gtm.lortuLerroa(lerro);
				String izena = lag.getIzena();
				GanadutegiKud.getInstantzia().ezabatu(izena);
				gtm.removeRow(lerro);
				gtm.fireTableDataChanged();
			}
		});

		bBotikaBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SortuBotika.main(null);
				btm.fireTableDataChanged();
			}
		});
		
		bBajanEman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Saguarekin hautatutako gelaxkaren (celda) balioa lortzeko
				
				int lerro = tableBotikak.getHautatutakoLerroa();
				BotikaLag lag = btm.lortuLerroa(lerro);
				int kodea = lag.getKodea();
				BotikaKud.getInstantzia().ezabatu(kodea);
				btm.removeRow(lerro);
				btm.fireTableDataChanged();
/*
 				String izena=tableBotikak.lortuBalioa(btm, tableBotikak.table);
 
				System.out.println("balioa: "+izena);
				
				//String-etik integer formatura pasatzeko
				int kodea = Integer.parseInt(izena);
				BotikaKud.getInstantzia().ezabatu(kodea);
*/				
			}
		});

		bAldatuGanadutegia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GanadutegiaAldatu.main(null);
			}
		});

		bBotikaAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotikaAldatu.main(null);
			}
		});
	}

}