package administratzailea;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class TableDemo extends JPanel {
	public TableDemo(AbstractTableModel model){
		super(new GridLayout(1,0));
		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
}
