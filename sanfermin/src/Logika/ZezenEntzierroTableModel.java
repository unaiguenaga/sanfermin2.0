package Logika;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ZezenEntzierroTableModel extends AbstractTableModel {

	private Vector<String> columNames = new Vector<String>();
	private ZezenEntzierroKud zek = ZezenEntzierroKud.getInstantzia();
	private Vector<ZezenEntzierroLag> data = new Vector<ZezenEntzierroLag>();

	private int zezena = 0;

	public ZezenEntzierroTableModel(String zeinData) {
		hasieratuZutabeIzenak();
		kargatu(zeinData);
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
		return false;
	}

	public void setValueAt(Object value, int row, int col) {
		data.get(row).insertElementAt(value, col);
	}

	public void hasieratuZutabeIzenak() {
		columNames.add("ParteHartu");
		columNames.add("Denbora");
		columNames.add("Zezena");
		columNames.add("EnzierroData");
	}
	
	public void eguneratu(String zeinData){
		this.data = new Vector<ZezenEntzierroLag>();
		this.kargatu(zeinData);
		this.fireTableDataChanged();
	}

	public void kargatu(String zeinData) {
		Vector<ZezenEntzierroLag> v3 = zek.getLag(zeinData);
		for (int i = 0; i <= v3.size() - 1; i++) {
			data.addElement(v3.elementAt(i));
		}
	}
}
