package user;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Logika.EntzierroKud;
import Logika.ErroreaBozkaketa;
import Logika.Hasiera;
import Logika.TableDemo;
import Logika.ZezenEntzierroTableModel;
import administratzailea.GehituAbereak;

public class AukeraUser extends JFrame {

	private String erabiltzaileIzena;

	JButton bZezenEzabatu = new JButton("Zezena Ezabatu");
	JButton bJoaldunaEzabatu = new JButton("Joalduna Ezabatu");
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

	JPanel bozkatuTaulaEzkerra = new JPanel();
	JPanel bozkatuTaulaEskuina = new JPanel();

	JPanel zezenEntzierro = new JPanel();
	JPanel zezenEntzierroCombo = new JPanel();

	public ZezenaTableModel ztm = new ZezenaTableModel();
	TableDemo tableZezenak = new TableDemo(ztm);

	public JoaldunTableModel jtm = new JoaldunTableModel();
	TableDemo tableJoaldunak = new TableDemo(jtm);

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
		pestañak.addTab("Entzierroko Zezenak Kudeatu", null, zezenakPestaña, null);
		pestañak.addTab("Tratamenduak", null, botikaPestaña, null);
		pestañak.addTab("Bozkak", null, bozkatuPestaña, null);

		// ABEREAK
		abereakPestaña.setLayout(new BorderLayout());
		aberealPanela.setLayout(new BoxLayout(aberealPanela, BoxLayout.Y_AXIS));
		zezenPanela.setLayout(new BorderLayout());
		joaldunPanela.setLayout(new BorderLayout());
		aberealPanela.add(tableZezenak);
		aberealPanela.add(tableJoaldunak);
		abereakPestaña.add(aberealPanela);
		abereakPestaña.add(eskumakoPanela1, BorderLayout.EAST);
		eskumakoPanela1.setLayout(new BoxLayout(eskumakoPanela1, BoxLayout.Y_AXIS));
		eskumakoPanela1.add(Box.createVerticalGlue());
		eskumakoPanela1.add(bZezenEzabatu);
		eskumakoPanela1.add(bJoaldunaEzabatu);
		eskumakoPanela1.add(hutsunea2);
		eskumakoPanela1.add(bAbereaGehitu);
		eskumakoPanela1.add(Box.createVerticalGlue());

		// ENTZIERRO ZERRENDAK
		final JComboBox dataCombo = new JComboBox(EntzierroKud.getInstantzia().getDataEntzierro(erabiltzaileIzena));
		final ZezenEntzierroTableModel zetm = new ZezenEntzierroTableModel((String) dataCombo.getSelectedItem());
		TableDemo tableZezenaEntzierro = new TableDemo(zetm);
		dataCombo.setSize(10, 20);
		zezenEntzierroCombo.setLayout(new GridLayout(10, 0));
		zezenEntzierro.setLayout(new BoxLayout(zezenEntzierro, BoxLayout.Y_AXIS));
		zezenEntzierro.add(dataCombo);
		zezenEntzierro.setBorder(BorderFactory.createTitledBorder("Entzierroak"));
		zezenEntzierro.add(tableZezenaEntzierro, BorderLayout.SOUTH);

		zezenakPestaña.setLayout(new BorderLayout());
		zezenakPestaña.add(eskumakoPanela2, BorderLayout.EAST);
		zezenakPestaña.add(zezenEntzierro);
		eskumakoPanela2.setLayout(new BoxLayout(eskumakoPanela2, BoxLayout.Y_AXIS));
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

		eskumakoPanela3.setLayout(new BoxLayout(eskumakoPanela3, BoxLayout.PAGE_AXIS));
		eskumakoPanela3.add(Box.createVerticalGlue());

		eskumakoPanela3.add(bBotikakKudeatu);

		eskumakoPanela3.add(Box.createVerticalGlue());

		// BOZKAKETAK
		bozkatuPestaña.setLayout(new BorderLayout());
		bozkatuPestaña.setLayout(new BoxLayout(bozkatuPestaña, BoxLayout.X_AXIS));
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

		bAbereaGehitu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GehituAbereak.main(erabiltzaileIzena);
			}
		});
		bZezenEzabatu.setEnabled(false);
		tableZezenak.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				bZezenEzabatu.setEnabled(true);
			}
		});
		bZezenEzabatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = ZezenKud.getInstantzia().getId().get(tableZezenak.getTable().getSelectedRow());
				ZezenKud.getInstantzia().ezabatu(id);
				ztm.eguneratu();
				bZezenEzabatu.setEnabled(false);

			}
		});
		bJoaldunaEzabatu.setEnabled(false);
		tableJoaldunak.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				bJoaldunaEzabatu.setEnabled(true);
				
			}
		});
		bJoaldunaEzabatu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id2 = JoaldunKud.getInstantzia().getKod().get(tableJoaldunak.getTable().getSelectedRow());
				JoaldunKud.getInstantzia().ezabatu(id2);
				jtm.eguneratu();
				bJoaldunaEzabatu.setEnabled(false);

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
				GehituZezena.main(erabiltzaileIzena, (String) dataCombo.getSelectedItem());
			}
		});

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
				int gordeDa = BotoKud.getInstantzia().botoakGorge(AukeraUser.getInstantzia().erabiltzaileIzena,
						btmEsk.getData());
				new ErroreaBozkaketa(gordeDa);
			}
		});
	}
}
