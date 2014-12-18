package Logika;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TableDemo extends JPanel {
	
	private JTable table = new JTable();
	
	public TableDemo(AbstractTableModel model){
		super(new GridLayout(1,0	));
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	
	public int getHautatutakoLerroa(){
		return table.getSelectedRow();
	}
	
}
