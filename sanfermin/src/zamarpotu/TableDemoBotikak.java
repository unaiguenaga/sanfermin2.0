package zamarpotu;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableDemoBotikak extends JFrame {

	public TableDemoBotikak(TaulaBotikak taula) {

		// superra
		setTitle("Kudeatu botikak");

		JTable table = new JTable(taula);
		JPanel behekoPanela = new JPanel();
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
		this.getContentPane().add(BorderLayout.CENTER, scrollPane);
		this.getContentPane().add(BorderLayout.SOUTH, behekoPanela);
		this.setVisible(true);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public static void main(String[] args) {
		TableDemoBotikak t = new TableDemoBotikak(new TaulaBotikak());
	}
}
