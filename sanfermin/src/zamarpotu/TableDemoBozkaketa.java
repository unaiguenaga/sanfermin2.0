package zamarpotu;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import user.TaulaBozkaketa;

public class TableDemoBozkaketa extends JFrame {

	public TableDemoBozkaketa(TaulaBozkaketa taula) {

		// superra
		setTitle("Bozkatu itzazu gustukoen dituzun ganaduetegiak");
		JButton ok = new JButton("Bozkaketa egin");
		JTable table = new JTable(taula);
		JPanel behekoPanela = new JPanel();
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		behekoPanela.add(ok);
		this.getContentPane().add(BorderLayout.CENTER, scrollPane);
		this.getContentPane().add(BorderLayout.SOUTH, behekoPanela);
		this.setVisible(true);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		TableDemoBozkaketa t = new TableDemoBozkaketa(new TaulaBozkaketa());
	}
}
