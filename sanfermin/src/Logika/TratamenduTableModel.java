package Logika;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class TratamenduTableModel extends AbstractTableModel {

	private Vector<String> columNames = new Vector<String>();
	private TratamenduKud tk = TratamenduKud.getInstantzia();
	private Vector<TratamenduLag> data = new Vector<TratamenduLag>();

	private int zezena = 0;

	public TratamenduTableModel() {
		hasieratuZutabeIzenak();
		kargatu();
	}

	public void setZezena(int id) {
		zezena = id;
	}

	@Override
	public int getColumnCount() {
		return columNames.size();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data.elementAt(row).getBalioa(col);
	}

	public String getColumnName(int col) {
		return columNames.elementAt(col);
	}

	public Class getColumnClass(int col) {
		return data.elementAt(0).getBalioa(col).getClass();
	}

	public boolean isCellEditable(int row, int col) {
		/*
		 * int ler = 0, zut = 3; if (row >= ler && col >= zut){ return true;
		 * }else{ return false; }
		 */
		return false;
	}

	public void setValueAt(Object value, int row, int col) {
		data.get(row).insertElementAt(value, col);
	}

	public void hasieratuZutabeIzenak() {
		columNames.add("Data");
		columNames.add("Botika");
		columNames.add("Dosia");
		columNames.add("Zezena");
	}

	public void kargatu() {
		Vector<TratamenduLag> v3 = tk.getLag();
		for (int i = 0; i <= v3.size() - 1; i++) {
			data.addElement(v3.elementAt(i));
		}
	}
}
