package administratzailea;

import java.awt.BorderLayout;
import java.awt.dnd.DnDConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import user.BotikaKud;
import user.BotikaLag;
import user.BotikaTableModel;
import user.TratamenduTableModel;
import Logika.DBKudeatzaile;
import Logika.DatuBaseaKargatu;
import Logika.EntzierroKud;
import Logika.Leihoak;
import Logika.GanadutegiKud;
import Logika.Hasiera;
import Logika.TableDemo;


public class AukeraAdmin extends JFrame {
	private String erabiltzaileIzena;
	
	JButton bGanadutegiaAldatu = new JButton("Datuak Aldatu");
	JButton bGanadutegiaEzabatu = new JButton("Hautatutakoa ezabatu");
	
	JButton bEntzierroBerri = new JButton("Sortu entzierro berria");
	JButton bEntzierroaAldatu = new JButton("Datuak aldatu");
	JButton bEntzierroaEzabatu = new JButton("Hautatutakoa ezabatu");
	
	JButton bBotikaBerri = new JButton("Gehitu botika");
	JButton bBotikaAldatu = new JButton("Aldaketak gorde");
	JButton bBotikaEzabatu = new JButton("Ezabatu botika");

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
	
	JMenu datuBase=new JMenu("Datu basea");
	JMenuItem kargatu=new JMenuItem("Datu basea hasieratu");

	JMenuItem atzera=new JMenuItem("Saioa itxi");
	JMenuItem exit=new JMenuItem("Exit");
	
	GanadutegiTableModel gtm = new GanadutegiTableModel();
	EntzierroTableModel etm =new EntzierroTableModel();
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
	
	public String getErabiltzaileIzena(){
		return erabiltzaileIzena;
	}
	
	public void bistaratu(String izena) {
		setTitle("San Ferminen kudeaketa ADMINISTRATZAILEA:"+izena);
		erabiltzaileIzena = izena;
		setVisible(true);
		setSize(900, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void hasieratu() {

		setContentPane(panela);
		panela.setLayout(null);
		setJMenuBar(barra);
		barra.add(menua);
		barra.add(erabiltzailea);
		barra.add(datuBase);

		datuBase.add(kargatu);
		kargatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				JOptionPane.showMessageDialog(null, "Datu basea birkargatzen ari da, segundu batzuk iraungo ditu. Exekutatu ezazu berriz programa.", "Kargatzen...",JOptionPane.INFORMATION_MESSAGE );
				new DatuBaseaKargatu();
				
			}
		});
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
				Hasiera.bistaratu();;
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
		eskumakoPanela1.add(bEntzierroaAldatu);
		eskumakoPanela1.add(bEntzierroaEzabatu);
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
		eskumakoPanela2.add(bGanadutegiaEzabatu);
		eskumakoPanela2.add(bGanadutegiaAldatu);
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
		eskumakoPanela3.add(bBotikaEzabatu);
		eskumakoPanela3.add(bBotikaAldatu);
		eskumakoPanela3.add(Box.createVerticalGlue());

				
		// ENTZIERROAK
		bEntzierroBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EntzierroaSortu();
			}
		});
		
		bEntzierroaAldatu.setEnabled(false);
		tableEntzierroak.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				bEntzierroaAldatu.setEnabled(true);
			}
		});
		
		bEntzierroaAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new EntzierroaAldatu(etm.getValueAt(tableEntzierroak.getTable().getSelectedRow(),0).toString());

				} catch (Exception e2) {
					System.out.println("ez du klikatu");
				}
			}
		});
		
		bEntzierroaEzabatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = EntzierroKud.getInstantzia().getId().get(tableEntzierroak.getTable().getSelectedRow());
				EntzierroKud.getInstantzia().ezabatu(id);
				etm.eguneratu();
			}
		});
		
		//GANADUTEGIAK

		
		bGanadutegiaAldatu.setEnabled(false);
		tableGanadutegiak.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				bGanadutegiaAldatu.setEnabled(true);
			}
		});
		bGanadutegiaAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GanadutegiaAldatu(tableGanadutegiak.getTable().getSelectedRow());
			}
		});
		
		bGanadutegiaEzabatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = GanadutegiKud.getInstantzia().getId().get(tableGanadutegiak.getTable().getSelectedRow());
				GanadutegiKud.getInstantzia().ezabatu(id);
				gtm.eguneratu();
			}
		});
		
		// BOKTIKAK

		bBotikaBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new SortuBotika();
			}
		});
		

		bBotikaAldatu.setEnabled(false);
		tableBotikak.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				bBotikaAldatu.setEnabled(true);
				bBotikaEzabatu.setEnabled(true);
			}
		});
		bBotikaAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotikaKud.getInstantzia().gordeDBan(btm.getData());
			}
		});
		bBotikaEzabatu.setEnabled(false);
		
		bBotikaEzabatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BotikaKud.getInstantzia().ezabatu(Integer.parseInt(btm.getValueAt(tableBotikak.getTable().getSelectedRow(), 0).toString()));
				btm.eguneratu();
			}
		});
	}

}