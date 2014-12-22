package administratzailea;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import user.BotikaTableModel;
import Logika.GanadutegiKud;
import Logika.TableDemo;
import Logika.ZezenKud;

public class TratamenduaSortu extends JFrame{

	JLabel jLabel1 = new JLabel("Sartu tratamendu berriaren datuak.");
	JLabel jLabel2 = new JLabel("Aukeratu Botika:");
	JLabel jLabel3 = new JLabel("Zezena:");
	JLabel jLabel4 = new JLabel("FILTROA");
	JLabel jLabel5 = new JLabel("Ganadutegia:");
	JLabel jLabel8 = new JLabel("Data:");
	
	
	
	
	
	
	//JComboBox botika = new JComboBox(TratamenduKud.getInstantzia().getIzenak());
	JComboBox ganadutegia = new JComboBox(GanadutegiKud.getInstantzia().getIzenak());
	JComboBox zezena = new JComboBox();
	JButton erakId = new JButton("Erakutsi id-ak");
	JButton erakIzena = new JButton("Erakutsi izenak");
	JButton gehitu= new JButton("Gehitu");
	
	JPanel ezkerra	= new JPanel();
	JPanel erdia	= new JPanel();
	JPanel eskuma	= new JPanel();
	
	BotikaTableModel btm = new BotikaTableModel();
	TableDemo botikaTaula = new TableDemo(btm);
	
	public TratamenduaSortu() {
		hasieratu();
		setTitle("Gehitu botika");
		setVisible(true);
		setSize(600, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void hasieratu(){
		
		ezkerra.setLayout(new BoxLayout(ezkerra, BoxLayout.Y_AXIS));
		ezkerra.add(Box.createVerticalGlue());
		ezkerra.add(jLabel2);
		ezkerra.add(new JScrollPane(botikaTaula));
		ezkerra.add(Box.createVerticalGlue());
		
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jLabel1, BorderLayout.NORTH);
		getContentPane().add(ezkerra, BorderLayout.WEST);
		getContentPane().add(erdia, BorderLayout.CENTER);
		getContentPane().add(eskuma, BorderLayout.EAST);
		
		gehitu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
				
		gehitu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				zezena = new JComboBox(ZezenKud.getInstantzia().getId()); 
				zezena.repaint();
			}
		});
		
	}
}
