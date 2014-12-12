package user;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class TaulaBozkaketa extends AbstractTableModel{
	private Vector<String> columnNames = new Vector<String>();

	public TaulaBozkaketa() {
		kargatu();
	}

	// laguntzailea
	class LagBozkaketa {
		String botoa;
		String ganadutegia;

		public LagBozkaketa(String botoa, String ganadutegia) {
			this.botoa=botoa;
			this.ganadutegia=ganadutegia;
		}

		public Object getBalioa(int i) {
			Object objetua = null;
			if (i == 0)
				objetua = this.ganadutegia;
			else if (i == 1)
				objetua = this.botoa;	
			return objetua;
		}

		public void insertElementAt(Object value, int i) {
			if (i == 0)
				this.ganadutegia = (String) value;
			else if (i == 1)
				this.botoa= (String) value;

		
		}

	}

	private Vector<LagBozkaketa> data = new Vector<LagBozkaketa>();

	public void kargatu() {
		columnNames.add("Ganadutegia");
		columnNames.add("Bai/Ez");

	
	}

	public int getColumnCount() {
		return columnNames.size();
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnNames.get(col);
	}

	public Object getValueAt(int row, int col) {
		return data.get(row).getBalioa(col);

	}

	public void setValueAt(Object value, int row, int col) {
		LagBozkaketa lag = data.get(row);
		lag.insertElementAt(value, col);
		data.setElementAt(lag, row);
	}

	public Class getColumnClass(int col) {
		switch (col) {
		case 0:
		case 1:
			return String.class;
		default:
			break;
		}
		return null;

	}

	public boolean isCellEditable(int row, int col) {
		return true;

	}

	private void gehituLaguntzailea(String botoa, String ganadutegia) {
		data.add(new LagBozkaketa(botoa, ganadutegia));
	    fireTableDataChanged();

	}
}
