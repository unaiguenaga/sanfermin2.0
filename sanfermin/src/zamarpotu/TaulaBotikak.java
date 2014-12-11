package zamarpotu;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TaulaBotikak extends AbstractTableModel {
	private Vector<String> columnNames = new Vector<String>();

	public TaulaBotikak() {
		kargatu();
	}

	// laguntzailea
	class LagBotika {
		String zer;
		int zenbat;
		String zeini;
		String noiz;

		public LagBotika(String zer, int zenbat, String zeini, String noiz) {
			this.zer = zer;
			this.zenbat = zenbat;
			this.zeini = zeini;
			this.noiz = noiz;

		}

		public Object getBalioa(int i) {
			Object objetua = null;
			if (i == 0)
				objetua = this.zer;
			else if (i == 1)
				objetua = this.zenbat;
			else if (i == 2)
				objetua = this.zeini;
			else if (i == 3)
				objetua = this.noiz;

			return objetua;
		}

		public void insertElementAt(Object value, int i) {
			if (i == 0)
				this.zer = (String) value;
			else if (i == 1)
				this.zenbat = (Integer) value;
			else if (i == 2)
				this.zeini = (String) value;
			else if (i == 3)
				this.noiz = (String) value;

		}
	}

	private Vector<LagBotika> data = new Vector<LagBotika>();

	public void kargatu() {
		columnNames.add("Zer");
		columnNames.add("Zenbat");
		columnNames.add("Zeini");
		columnNames.add("Data");

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
		LagBotika lag = data.get(row);
		lag.insertElementAt(value, col);
		data.setElementAt(lag, row);
	}

	public Class getColumnClass(int col) {
		switch (col) {
		case 0:
			return String.class;
		case 1:
			return Integer.class;
		case 2:
		case 3:
			return String.class;

		default:
			break;
		}
		return null;

	}

	public boolean isCellEditable(int row, int col) {
		return true;

	}

	private void gehituLaguntzailea(String zer, int zenbat, String zeini, String noiz) {
		data.add(new LagBotika(zer, zenbat, zeini, noiz));
		fireTableDataChanged();

	}
}