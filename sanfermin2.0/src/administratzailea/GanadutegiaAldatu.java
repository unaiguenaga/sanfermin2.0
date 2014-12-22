package administratzailea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logika.ErabiltzaileKudeatzailea;
import Logika.GanadutegiKud;

public class GanadutegiaAldatu extends JFrame {
	JLabel arduraduna = new JLabel("Arduradun berria:");
	JLabel tlf = new JLabel("Telefono berria:");
	JLabel helbide = new JLabel("Helbide berria:");
	JTextField arduradunaTestua = new JTextField(10);
	JTextField tlfTestua = new JTextField(10);
	JTextField helbideTestua = new JTextField(10);
	JPanel behekoPanela = new JPanel();
	JButton gorde = new JButton("Aldaketak gorde");
	private GridBagLayout eskema;
	private Container edukiontzia;
	private GridBagConstraints mugak;
	
	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	
	int ganadutegiId;

	public GanadutegiaAldatu(int row) {
		ganadutegiId = gk.getId().get(row);
		gridBagHasieratu();
	}

	private void gridBagHasieratu() {
		edukiontzia = getContentPane();
		eskema = new GridBagLayout();
		edukiontzia.setLayout(eskema);
		mugak = new GridBagConstraints();
		
		gehituOsagaia(new JLabel("Idatzi soilik aldatu nahi dituzun datuak."), 1, 1, 7, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(arduraduna, 2, 1, 4, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(tlf, 3, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(helbide, 4, 1, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		gehituOsagaia(arduradunaTestua, 2, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(tlfTestua, 3, 5, 5, 1);
		mugak.insets = new Insets(3, 3, 3, 3);
		gehituOsagaia(helbideTestua, 4, 5, 3, 1);
		mugak.insets = new Insets(3, 3, 3, 3);

		behekoPanela.add(BorderLayout.SOUTH, gorde);
		gehituOsagaia(behekoPanela, 16, 3, 9, 1);
		
		gorde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!arduradunaTestua.getText().equals("")){
					String izenZaharra = AukeraAdmin.getInstantzia().gtm.getValueAt(AukeraAdmin.getInstantzia().tableGanadutegiak.getTable().getSelectedRow(),1).toString();
					String izenBerria = arduradunaTestua.getText();
					
					ErabiltzaileKudeatzailea.getInstantzia().izenaAldatu(izenZaharra, izenBerria);
				}if(!tlfTestua.getText().equals("")){
					gk.aldatuTlf(ganadutegiId, Integer.parseInt(tlfTestua.getText()));
				}if(!helbideTestua.getText().equals("")){
					gk.aldatuHelbidea(ganadutegiId, helbideTestua.getText());
				}
				AukeraAdmin.getInstantzia().gtm.eguneratu();
				dispose();
			}
		});
		
		setTitle("Ganadutegiaren datuak aldatu");
		setVisible(true);
		setSize(400, 175);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
