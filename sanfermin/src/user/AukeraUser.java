package user;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

import Logika.EntzierroKud;
import Logika.Errorea;
import Logika.GanadutegiKud;
import Logika.Hasiera;
import Logika.TableDemo;
import Logika.ZezenEntzierroTableModel;
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

	// ////Bozkatu Aldaketa 2 panel sartzeko
	JPanel bozkatuTaulaEzkerra = new JPanel();
	JPanel bozkatuTaulaEskuina = new JPanel();

	// /////////Bozkaketak JList batetik bestera egiteko
	// ////////////////////////

	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	private BotoKud bk = BotoKud.getInstantzia();
	private Vector<String> vIzenak = new Vector<String>();

	DefaultListModel modeloaEzkerra = new DefaultListModel();
	DefaultListModel modeloaEskuina = new DefaultListModel();

	JList bozkatuEzkerra = new JList();
	JList bozkatuEskuina = new JList();
	// ///////////////////////////////////////////////////////////

	// //////////Data Combo//////////
	JPanel zezenEntzierro = new JPanel();
	JPanel zezenEntzierroCombo = new JPanel();
	JComboBox dataCombo = new JComboBox();
	// ///////////////////////////////

	ZezenaTableModel ztm = new ZezenaTableModel();
	TableDemo tableZezenak = new TableDemo(ztm);

	JoaldunTableModel jtm = new JoaldunTableModel();
	TableDemo tableJoaldunak = new TableDemo(jtm);

	// /////Aldaketa///////
	TratamenduTableModel ttm = new TratamenduTableModel();
	TableDemo tableTratamenduak = new TableDemo(ttm);

	JLabel hutsunea = new JLabel("     ");
	JLabel hutsunea2 = new JLabel("     ");

	// Bozkaketa JList bidez egingo dira

	JMenuBar barra = new JMenuBar();
	JMenu menua = new JMenu("Menua");
	JMenuItem atzera = new JMenuItem("Saioa itxi");
	JMenuItem exit = new JMenuItem("Exit");

	private static AukeraUser instantzia = new AukeraUser();

	public static AukeraUser getInstantzia() {
		return instantzia;
	}

	public AukeraUser() {
	}

	public void main(String izena) {
		erabiltzaileIzena = izena;
		System.out.println("User:" + erabiltzaileIzena);
		hasieratu();
		setTitle("San Ferminen kudeaketa ERABILTZAILEA: " + izena);
		setVisible(true);
		setSize(1000, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	public String getErabiltzaileIzana() {
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
				Hasiera.bistaratu();
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
		pestañak.addTab("Entzierroko Zezenak Kudeatu", null, zezenakPestaña,
				null);
		pestañak.addTab("Tratamenduak", null, botikaPestaña, null);
		pestañak.addTab("Bozkak", null, bozkatuPestaña, null);

		// ABEREAK
		abereakPestaña.setLayout(new BorderLayout());
		aberealPanela.setLayout(new BoxLayout(aberealPanela, BoxLayout.Y_AXIS));
		zezenPanela.setLayout(new BorderLayout());
		joaldunPanela.setLayout(new BorderLayout());

		aberealPanela.add(tableZezenak);
		aberealPanela.add(tableJoaldunak);
		//
		abereakPestaña.add(aberealPanela);
		abereakPestaña.add(eskumakoPanela1, BorderLayout.EAST);
		// //////////////////////////////////////////////////////////////7

		eskumakoPanela1.setLayout(new BoxLayout(eskumakoPanela1,
				BoxLayout.Y_AXIS));
		eskumakoPanela1.add(Box.createVerticalGlue());
		eskumakoPanela1.add(bAbereaEzabatu);
		eskumakoPanela1.add(hutsunea2);
		eskumakoPanela1.add(bAbereaGehitu);
		eskumakoPanela1.add(Box.createVerticalGlue());

		// ENTZIERRO ZERRENDAK
		final JComboBox dataCombo = new JComboBox(EntzierroKud.getInstantzia()
				.getDataEntzierro(erabiltzaileIzena));
		final ZezenEntzierroTableModel zetm = new ZezenEntzierroTableModel(
				(String) dataCombo.getSelectedItem());
		TableDemo tableZezenaEntzierro = new TableDemo(zetm);
		dataCombo.setSize(10, 20);
		zezenEntzierroCombo.setLayout(new GridLayout(10, 0));
		zezenEntzierro
				.setLayout(new BoxLayout(zezenEntzierro, BoxLayout.Y_AXIS));
		// zezenEntzierro.setLayout(new BoxLayout(zezenEntzierro,
		// BoxLayout.Y_AXIS));
		zezenEntzierro.add(dataCombo);
		zezenEntzierro.setBorder(BorderFactory
				.createTitledBorder("Entzierroak"));
		zezenEntzierro.add(tableZezenaEntzierro, BorderLayout.SOUTH);
		// ///////////////////////////////////////////////////////////////////////////////////////
		zezenakPestaña.setLayout(new BorderLayout());
		zezenakPestaña.add(eskumakoPanela2, BorderLayout.EAST);
		zezenakPestaña.add(zezenEntzierro);
		eskumakoPanela2.setLayout(new BoxLayout(eskumakoPanela2,
				BoxLayout.Y_AXIS));
		eskumakoPanela2.add(Box.createVerticalGlue());
		eskumakoPanela2.add(bGehituZezena);
		eskumakoPanela2.add(hutsunea);
		eskumakoPanela2.add(bZezenaEzabatu);
		eskumakoPanela2.add(Box.createVerticalGlue());
		// BOTIKAK
		botikaPestaña.setLayout(new BorderLayout());
		botikaPanela.setLayout(new BorderLayout());

		// /////Aldaketa
		JScrollPane jScrollPane3 = new JScrollPane(tableTratamenduak);

		botikaPanela.add(jScrollPane3);
		botikaPestaña.add(botikaPanela);
		botikaPestaña.add(eskumakoPanela3, BorderLayout.EAST);

		eskumakoPanela3.setLayout(new BoxLayout(eskumakoPanela3,
				BoxLayout.PAGE_AXIS));
		eskumakoPanela3.add(Box.createVerticalGlue());

		eskumakoPanela3.add(bBotikakKudeatu);

		eskumakoPanela3.add(Box.createVerticalGlue());

		// BOZKAKETAK
		bozkatuPestaña.setLayout(new BorderLayout());
		bozkatuPestaña.add(eskumakoPanela4, BorderLayout.EAST);
		botikaPanela.setLayout(new BorderLayout());

		// /////Aldaketa///////
		vIzenak = gk.getIzenak(erabiltzaileIzena);
		for (int i = 0; i < vIzenak.size(); i++) {
			modeloaEzkerra.addElement(vIzenak.get(i));
		}
		modeloaEskuina = bk.kargatuModeloa(erabiltzaileIzena);
		bozkatuEzkerra.setModel(modeloaEzkerra);
		bozkatuEskuina.setModel(modeloaEskuina);

		botikaPanela.add(tableTratamenduak);
		// //////////////////

		botikaPestaña.add(botikaPanela);
		eskumakoPanela4.setLayout(new BoxLayout(eskumakoPanela4,
				BoxLayout.Y_AXIS));
		eskumakoPanela4.add(Box.createVerticalGlue());
		eskumakoPanela4.add(bBotoaGorde);
		eskumakoPanela4.add(bBotoaEman);
		eskumakoPanela4.add(Box.createVerticalGlue());
		bozkaTaulaPanela.setLayout(new BorderLayout());

		// Panel bi sartu
		bozkatuEzkerra.setLayout(new BorderLayout());
		bozkatuEskuina.setLayout(new BorderLayout());

		bozkatuTaulaEzkerra.add(bozkatuEzkerra);
		bozkatuTaulaEskuina.add(bozkatuEskuina);
		bozkatuPestaña.add(bozkatuTaulaEzkerra, BorderLayout.WEST);
		bozkatuPestaña.add(bozkatuTaulaEskuina, BorderLayout.CENTER);

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
				GehituZezena.main(erabiltzaileIzena,
						(String) dataCombo.getSelectedItem());
			}
		});

		bBotoaEman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 3 boto baino gehiago eman ez direla konprobatzeko
				if (bozkatuEskuina.getModel().getSize() >= 3) {
					Errorea er = new Errorea();
					er.bozkaketa();
				} else {
					// Hemen ezkerreko modelotik elementu bat ateratzen du eta
					// eskuinekoan sartzen du.

					String aukera = (String) bozkatuEzkerra.getSelectedValue();
					System.out.println("aukeratu: " + aukera);
					int indizea = bozkatuEzkerra.getSelectedIndex();

					modeloaEskuina.addElement(aukera);
					bozkatuEskuina.setModel(modeloaEskuina);
					modeloaEzkerra.removeElementAt(indizea);
					bozkatuEzkerra.setModel(modeloaEzkerra);

				}
			}
		});

		bBotoaGorde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bk.gehituBotoak(modeloaEskuina, erabiltzaileIzena);
			}
		});
	}
}
