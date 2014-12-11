package zamarpotu;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import zamarpotu.TaulaEntzierroak.LagEntzierroa;

public class TaulaGanadutegiak extends AbstractTableModel {
	private Vector<String> columnNames = new Vector<String>();

	public TaulaGanadutegiak() {
		kargatu();// TODO Auto-generated constructor stub
	}

	// laguntzailea
	class LagGanadutegia {

		String izena;
		String arduraduna;
		Integer telefonoa;

		public LagGanadutegia(String izena, String arduraduna,Integer telefonoa) {
			this.izena=izena;
			this.arduraduna=arduraduna;
			this.telefonoa=telefonoa;
		}

		public Object getBalioa(int i) {
			Object objetua = null;
			if (i == 0)
				objetua = this.izena;
			else if (i == 1)
				objetua = this.arduraduna;
			else if (i == 2)
				objetua = this.telefonoa;
			return objetua;
		}

		public void insertElementAt(Object value, int i) {
			if (i == 0)
				this.izena = (String) value;
			else if (i == 1)
				this.arduraduna = (String) value;
			else if (i == 2)
				this.telefonoa = (Integer) value;
		}
	
	}


	private Vector<LagGanadutegia> data = new Vector<LagGanadutegia>();

	public void kargatu() {
		columnNames.add("Izena");
		columnNames.add("Arduraduna");
		columnNames.add("Telefonoa");
	
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
		LagGanadutegia lag = data.get(row);
		lag.insertElementAt(value, col);
		data.setElementAt(lag, row);
	}

	public Class getColumnClass(int col) {
		switch (col) {
		case 0:
		case 1:
			return String.class;
		case 2: 
			return Integer.class;
		default:
			break;
		}
		return null;

	}

	public boolean isCellEditable(int row, int col) {
		return true;

	}

	private void gehituLaguntzailea(String izena, String arduraduna,Integer telefonoa) {
		data.add(new LagGanadutegia(izena, arduraduna, telefonoa));
	    fireTableDataChanged();

	}
	
}
