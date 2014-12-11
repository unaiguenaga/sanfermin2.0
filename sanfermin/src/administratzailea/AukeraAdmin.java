package administratzailea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

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

	String[] args = null;
	

	
	JTable tableBotikak = new JTable();
	JTable tableEntzierroak = new JTable();
	JTable tableGanadutegiak = new JTable();

	
	private static AukeraAdmin instantzia = new AukeraAdmin();
	
	public static AukeraAdmin getInstantzia(){
		return instantzia;
	}
	
	public AukeraAdmin() {
		hasieratu();
	}

	public static void main(String izena) {
		AukeraAdmin aukera = new AukeraAdmin();
		aukera.setTitle("San Ferminen kudeaketa ADMINISTRATZAILEA:"+izena);
		aukera.setVisible(true);
		aukera.setSize(900, 400);
		aukera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void hasieratu() {

		setContentPane(panela);
		panela.setLayout(null);

		pestañak.setBounds(10, 11, 850, 350);
		panela.add(pestañak);

		pestañak.addTab("Entzierroak", null, entzierroakPestaña, null);
		pestañak.addTab("Ganadutegiak", null, ganadutegiakPestaña, null);
		pestañak.addTab("Botikak", null, botikakPestaña, null);

		// ENTZIERROA
		entzierroakPestaña.setLayout(new BorderLayout());
		entzierroakPestaña.add(eskumakoPanela1, BorderLayout.EAST);
		entzierroPanela.setLayout(new BorderLayout());
		entzierroPanela.add(tableEntzierroak);
		entzierroakPestaña.add(entzierroPanela);
		eskumakoPanela1.setLayout(new BoxLayout(eskumakoPanela1, BoxLayout.Y_AXIS));
		eskumakoPanela1.add(Box.createVerticalGlue());
		eskumakoPanela1.add(bEntzierroBerri);
		eskumakoPanela1.add(bDatuakAldatu);
		eskumakoPanela1.add(bAldaketakGorde2);
		eskumakoPanela1.add(Box.createVerticalGlue());

		// GANADUTEGIA
		ganadutegiakPestaña.setLayout(new BorderLayout());
		ganadutegiPanela.setLayout(new BorderLayout());
		ganadutegiPanela.add(tableGanadutegiak);
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
		botikaPanela.add(tableBotikak);
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
				SortuEntzierroa.main(args);
			}
		});

		bDatuakAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EntzierroaAldatu.main(args);
			}
		});

		bGanadutegiBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SortuGanadutegia.main(args);
			}
		});

		bBotikaBerri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SortuBotika.main(args);
			}
		});

		bAldatuGanadutegia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GanadutegiaAldatu.main(args);
			}
		});

		bBotikaAldatu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BotikaAldatu.main(args);
			}
		});
	}

}
