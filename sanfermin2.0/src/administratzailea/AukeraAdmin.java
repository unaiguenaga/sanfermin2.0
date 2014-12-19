package administratzailea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;

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

import Logika.EntzierroKud;
import Logika.GanadutegiKud;
import Logika.Hasiera;
import Logika.TableDemo;


public class AukeraAdmin extends JFrame {
	JButton bGanadutegiBerri = new JButton("Sortu ganadutegi berria");
	JButton bHautatutakoaEzabatu = new JButton("Hautatutakoa ezabatu");
	JButton bEntzierroBerri = new JButton("Sortu entzierro berria");
	JButton bEntzierroaAldatu = new JButton("Datuak aldatu");
	JButton bEntzierroaEzabatu = new JButton("Hautatutakoa ezabatu");
	JButton bTratamenduBerri = new JButton("Gehitu botika berria");
	JButton bBajanEman = new JButton("Bajan eman");
	JButton bAldaketakGorde3 = new JButton("Aldaketak gorde");
	JButton bGanadutegiaAldatu = new JButton("Datuak Aldatu");
	JButton bTratamenduaAldatu = new JButton("Botika Aldatu");
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
	
	String[] args = null;

	JMenuItem atzera=new JMenuItem("Atzera");
	JMenuItem exit=new JMenuItem("Exit");
	
	GanadutegiTableModel gtm = new GanadutegiTableModel();
	EntzierroTableModel etm =new EntzierroTableModel();
	TratamenduTableModel ttm = new TratamenduTableModel();
	TableDemo tableGanadutegiak = new TableDemo(gtm);
	TableDemo tableEntzierroak = new TableDemo(etm);
	TableDemo tableBotikak = new TableDemo(ttm);

	private static AukeraAdmin instantzia = new AukeraAdmin();
	
	public static AukeraAdmin getInstantzia(){
		return instantzia;
	}
	
	public AukeraAdmin() {
		hasieratu();
	}
	
	public void bistaratu(String izena) {
		setTitle("San Ferminen kudeaketa ADMINISTRATZAILEA:"+izena);
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
		pestañak.addTab("Tratemenduak", null, botikakPestaña, null);

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
		eskumakoPanela2.add(bGanadutegiBerri);
		eskumakoPanela2.add(bHautatutakoaEzabatu);
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
		eskumakoPanela3.add(bTratamenduBerri);
		eskumakoPanela3.add(bBajanEman);
		eskumakoPanela3.add(bTratamenduaAldatu);
		eskumakoPanela3.add(bAldaketakGorde3);
		eskumakoPanela3.add(Box.createVerticalGlue());

		// LISTENERS
		
		
		// ENTZIERROAK
		bEntzierroBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EntzierroaSortu.main(args);
			}
		});

		bEntzierroaAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new EntzierroaAldatu(etm.getValueAt(tableEntzierroak.getTable().getSelectedRow(),0).toString());
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

		bGanadutegiBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SortuGanadutegia.main(null);
			}
		});
		
		bGanadutegiaAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//GanadutegiaAldatu.main(null);
				new GanadutegiaAldatu(tableGanadutegiak.getTable().getSelectedRow());
			}
		});
		
		bHautatutakoaEzabatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = GanadutegiKud.getInstantzia().getId().get(tableGanadutegiak.getTable().getSelectedRow());
				GanadutegiKud.getInstantzia().ezabatu(id);
				gtm.eguneratu();
			}
		});
		
		// TRATAMENDUAK

		bTratamenduBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//SortuBotika.main(null);
				new TratamenduaSortu();
			}
		});

		bTratamenduaAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotikaAldatu.main(null);
			}
		});
	}

}