package user;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import Logika.ErroreaBozkaketa;
import Logika.GanadutegiKud;
import Logika.Hasiera;
import Logika.TableDemo;
import administratzailea.AukeraAdmin;
import administratzailea.EntzierroTableModel;
import administratzailea.ErabiltzaileBerria;
import administratzailea.ErabiltzaileaKendu;
import administratzailea.GanadutegiTableModel;
import administratzailea.GehituAbereak;

public class AukeraUser extends JFrame {
	
	private String erabiltzaileIzena;
	
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
	JButton bBotoaEman = new JButton("Botoa eman");
	JPanel panela = new JPanel();
	JTabbedPane pestañak = new JTabbedPane();
	JPanel abereakPestaña = new JPanel();
	JPanel zezenakPestaña = new JPanel();
	JPanel botikaPestaña = new JPanel();
	JPanel bozkatuPestaña = new JPanel();
	
	JPanel zezenPanela = new JPanel();
	JPanel joaldunPanela = new JPanel();
	JPanel botikaPanela = new JPanel();
	
	JPanel eskumakoPanela1 = new JPanel();
	JPanel eskumakoPanela2 = new JPanel();
	JPanel eskumakoPanela3 = new JPanel();
	JPanel eskumakoPanela4 = new JPanel();
	JPanel aberealPanela = new JPanel();
	JPanel bozkaTaulaPanela = new JPanel();
	
	//BOTOAK
	JPanel botoakEsk = new JPanel();
	JPanel botoakErd = new JPanel();
	JPanel botoakEzk = new JPanel();
	JButton botatu = new JButton("       ---->       ");
	JButton ezeztatu = new JButton("       <----       ");
	JButton botoaEman = new JButton("Botoa eman");
	BotoTableModel btmEsk;
	BotoTableModel btmEzk;
	TableDemo t1;
	TableDemo t2;
	
	
	//////Bozkatu Aldaketa 2 panel sartzeko
	JPanel bozkatuTaulaEzkerra = new JPanel();
	JPanel bozkatuTaulaEskuina = new JPanel();
	
	///////////Bozkaketak JList batetik bestera egiteko ////////////////////////
	
	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	private BotoKud bk = BotoKud.getInstantzia();
	private Vector<String> vIzenak = new Vector<String>();
	
	DefaultListModel modeloaEzkerra = new DefaultListModel();
	DefaultListModel modeloaEskuina = new DefaultListModel();
	
	JList bozkatuEzkerra = new JList();
	JList bozkatuEskuina = new JList();
	/////////////////////////////////////////////////////////////
	
	
	ZezenaTableModel ztm = new ZezenaTableModel();
	TableDemo tableZezenak = new TableDemo(ztm);
	
	JoaldunTableModel jtm = new JoaldunTableModel();
	TableDemo tableJoaldunak = new TableDemo(jtm);
	
	/////// Azken aldaketa //////
//	TratamenduBotikaTableModel tbtm = new TratamenduBotikaTableModel();
//	TableDemo tableTratamenduaBotikak = new TableDemo(tbtm);
	/////////////////////////////
	
	
	///////Aldaketa///////
	TratamenduTableModel ttm = new TratamenduTableModel();
	TableDemo tableTratamenduak = new TableDemo(ttm);
	////////////////////
	/*
	BotikaTableModel btm = new BotikaTableModel();
	TableDemo tableBotikak = new TableDemo(btm);
	*/

	JLabel hutsunea = new JLabel("     ");
	JLabel hutsunea2 = new JLabel("     ");
	
	//Bozkaketa JList bidez egingo dira
	//JTable tableBozkak = new JTable(new TaulaBozkaketa());

	JMenuBar barra= new JMenuBar();
	JMenu menua=new JMenu("Menua");
	JMenuItem atzera=new JMenuItem("Saioa itxi");
	JMenuItem exit=new JMenuItem("Exit");
	
private static AukeraUser instantzia = new AukeraUser();
	
	public static AukeraUser getInstantzia(){
		return instantzia;
	}
	
	public AukeraUser() {
		//hasieratu();
	}

	public void main(String izena) {
		erabiltzaileIzena = izena;
		System.out.println("User:"+erabiltzaileIzena);
		hasieratu();
		setTitle("San Ferminen kudeaketa ERABILTZAILEA: "+izena);
		setVisible(true);
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public String getErabiltzaileIzana(){
		return erabiltzaileIzena;
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
		pestañak.addTab("Tratamenduak", null, botikaPestaña, null);
		pestañak.addTab("Bozkak", null, bozkatuPestaña, null);


		// ABEREAK
		abereakPestaña.setLayout(new BorderLayout());
		aberealPanela.setLayout(new BoxLayout(aberealPanela, BoxLayout.Y_AXIS));
		zezenPanela.setLayout(new BorderLayout());
		joaldunPanela.setLayout(new BorderLayout());
		//abereakPestaña.add(eskumakoPanela1, BorderLayout.EAST);
//		JScrollPane jScrollPane1 = new JScrollPane(tableZezenak);
//		JScrollPane jScrollPane2 = new JScrollPane(tableJoaldunak);
		aberealPanela.add(tableZezenak);
		aberealPanela.add(tableJoaldunak);
//		zezenPanela.add(jScrollPane1);
//		joaldunPanela.add(jScrollPane2);
		///////////// Panelak bat bestearen gainean jarri///////////////
		//abereakPestaña.add(zezenPanela, BorderLayout.WEST);
		//abereakPestaña.add(joaldunPanela);
		abereakPestaña.add(aberealPanela);
		abereakPestaña.add(eskumakoPanela1, BorderLayout.EAST);
		////////////////////////////////////////////////////////////////7
		
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
		JScrollPane jScrollPane3=new JScrollPane(tableTratamenduak);
		botikaPanela.add(jScrollPane3);
		botikaPestaña.add(botikaPanela);
		eskumakoPanela3.setLayout(new BoxLayout(eskumakoPanela3, BoxLayout.PAGE_AXIS));
		eskumakoPanela3.add(Box.createVerticalGlue());
		eskumakoPanela3.add(bBotikakKudeatu);
		eskumakoPanela3.add(Box.createVerticalGlue());
		botikaPestaña.add(eskumakoPanela3, BorderLayout.EAST);
		

		// BOZKAKETAK
		bozkatuPestaña.setLayout(new BoxLayout(bozkatuPestaña,BoxLayout.X_AXIS));
		botoakEsk.setLayout(new BorderLayout());
		botoakEzk.setLayout(new BorderLayout());
		
		btmEzk = new BotoTableModel(false);
		btmEsk = new BotoTableModel(true);
		t1 = new TableDemo(btmEzk);
		t2 = new TableDemo(btmEsk);
		
		t1.getTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		t2.getTable().setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		t1.getTable().getColumnModel().getColumn(0).setPreferredWidth(359);
		t2.getTable().getColumnModel().getColumn(0).setPreferredWidth(359);
		
		botoakEzk.add(t1, BorderLayout.CENTER);
		botoakErd.setLayout(new BoxLayout(botoakErd, BoxLayout.PAGE_AXIS));
		botoakErd.add(Box.createVerticalGlue());
		botoakErd.add(botatu);
		botoakErd.add(ezeztatu);
		botoakErd.add(botoaEman);
		botoakErd.add(Box.createVerticalGlue());
		botoakEsk.add(t2, BorderLayout.CENTER);
		
		bozkatuPestaña.add(Box.createVerticalGlue());
		bozkatuPestaña.add(botoakEzk);
		bozkatuPestaña.add(botoakErd);
		bozkatuPestaña.add(botoakEsk);
		bozkatuPestaña.add(Box.createVerticalGlue());

//		bozkatuPestaña.add(eskumakoPanela4, BorderLayout.EAST);
//		bozkaTaulaPanela.setLayout(new BorderLayout());
//		bozkaTaulaPanela.add(new TableDemo(new BotoTableModel(false)), BorderLayout.WEST);
//		bozkaTaulaPanela.add(new TableDemo(new BotoTableModel(true)), BorderLayout.EAST);
//		bozkatuPestaña.add(bozkaTaulaPanela, BorderLayout.WEST);
		
		///////Aldaketa///////
//		vIzenak = gk.getIzenak(erabiltzaileIzena);
//		for (int i = 0; i < vIzenak.size(); i++) {
//			modeloaEzkerra.addElement(vIzenak.get(i));
//		}
//		//modeloaEzkerra = gk.kargatuModeloa(modeloaEzkerra, vIzenak);
//		System.out.println("Erab: "+erabiltzaileIzena);
//		modeloaEskuina = bk.kargatuModeloa(erabiltzaileIzena);
//		bozkatuEzkerra.setModel(modeloaEzkerra);
//		bozkatuEskuina.setModel(modeloaEskuina);

		
		
		
		
		////////////////////
		
		//botikaPanela.add(tableBotikak);
		
//		eskumakoPanela4.setLayout(new BoxLayout(eskumakoPanela4, BoxLayout.Y_AXIS));
//		eskumakoPanela4.add(Box.createVerticalGlue());
//		eskumakoPanela4.add(bBotoaGorde);
//		eskumakoPanela4.add(bBotoaEman);
//		eskumakoPanela4.add(Box.createVerticalGlue());
		
		//Panel bi sartu
		//bozkatuEzkerra.setLayout(new BorderLayout());
		//bozkatuEskuina.setLayout(new BorderLayout());
		
		//bozkaTaulaPanela.add(tableBozkak);
		//bozkatuTaulaEzkerra.add(bozkatuEzkerra);
		//bozkatuTaulaEskuina.add(bozkatuEskuina);
		//bozkaTaulaPanela.add(bozkatuEzkerra, BorderLayout.WEST);
		//bozkaTaulaPanela.add(bozkatuEskuina);
		//bozkatuPestaña.add(bozkatuTaulaEzkerra, BorderLayout.WEST);
		//bozkatuPestaña.add(bozkatuTaulaEskuina, BorderLayout.CENTER);
		
		


		bAbereaGehitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GehituAbereak.main(null);
			}
		});

		bBotikakKudeatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new BotikakKudeatu(erabiltzaileIzena);
			}
		});
		
		bGehituZezena.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GehituZezena.main(null);
			}
		});
		
//		bBotoaEman.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				//3 boto baino gehiago eman ez direla konprobatzeko
//				if(bozkatuEskuina.getModel().getSize()>=3){
//					ErroreaBozkaketa er = new ErroreaBozkaketa();
//				}
//				else{
//					//Hemen ezkerreko modelotik elementu bat ateratzen du eta eskuinekoan sartzen du.
//					
//					String aukera = (String) bozkatuEzkerra.getSelectedValue();
//					System.out.println("aukeratu: "+aukera);
//					int indizea = bozkatuEzkerra.getSelectedIndex();
//					
//					modeloaEskuina.addElement(aukera);
//					bozkatuEskuina.setModel(modeloaEskuina);
//					modeloaEzkerra.removeElementAt(indizea);
//					bozkatuEzkerra.setModel(modeloaEzkerra);
//
//					System.out.println("indizea :"+indizea);
//					
////					if(indizea!=-1){
////						bozkatuEzkerra.remove(indizea);
////					}
//				}	
//			}
//		});
//		
//		bBotoaGorde.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				bk.gehituBotoak(modeloaEskuina, erabiltzaileIzena);
//			}
//		});
		
		botatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btmEsk.gehitu(btmEzk.kendu(t1.getTable().getSelectedRow()));
				
			}
		});
		
		ezeztatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btmEzk.gehitu(btmEsk.kendu(t2.getTable().getSelectedRow()));
			}
		});
		
		botoaEman.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int gordeDa = BotoKud.getInstantzia().botoakGorge(AukeraUser.getInstantzia().erabiltzaileIzena, btmEsk.getData());
				new ErroreaBozkaketa(gordeDa);
			}
		});
	}
}
