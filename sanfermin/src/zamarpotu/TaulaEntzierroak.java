package zamarpotu;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import zamarpotu.TaulaBotikak.LagBotika;

public class TaulaEntzierroak extends AbstractTableModel {
	private Vector<String> columnNames = new Vector<String>();

	public TaulaEntzierroak() {
		kargatu();
	}

	// laguntzailea
	class LagEntzierroa {
		String ganadutegia;
		String noiz;

		public LagEntzierroa(String ganadutegia, String noiz) {
			this.ganadutegia = ganadutegia;
			this.noiz = noiz;

		}

		public Object getBalioa(int i) {
			Object objetua = null;
			if (i == 0)
				objetua = this.ganadutegia;

			else if (i == 1)
				objetua = this.noiz;

			return objetua;
		}

		public void insertElementAt(Object value, int i) {
			if (i == 0)
				this.ganadutegia = (String) value;

			else if (i == 1)
				this.noiz = (String) value;

		}

	}

	private Vector<LagEntzierroa> data = new Vector<LagEntzierroa>();

	public void kargatu() {
		columnNames.add("Ganadutegia");
		columnNames.add("Noiz");

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
		LagEntzierroa lag = data.get(row);
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

	private void gehituLaguntzailea(String ganadutegia, String noiz) {
		data.add(new LagEntzierroa(ganadutegia, noiz));
		fireTableDataChanged();

	}
}
