package user;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Logika.GanadutegiLag;

public class BotikaTableModel extends AbstractTableModel{
	
	private Vector<String> columNames = new Vector<String>();
	private BotikaKud bk = BotikaKud.getInstantzia();
	private Vector<BotikaLag> data = new Vector<BotikaLag>();

	public BotikaTableModel() {
		hasieratuZutabeIzenak();
		kargatu();
		
	}
	
	public void setZezena(int id){
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
	
	public String getColumnName (int col){
		return columNames.elementAt(col);
	}
	
	public void removeRow(int row){
		data.remove(row);
	}
	
	public BotikaLag lortuLerroa(int lerro){
		return data.elementAt(lerro);
	}

	public Class getColumnClass(int col){
		return data.elementAt(0).getBalioa(col).getClass();
	}
	
	public boolean isCellEditable(int row, int col){
		return true;
	}
	
	public void setValueAt(Object value, int row, int col){
		data.get(row).insertElementAt(value, col);
	}
	
	public void hasieratuZutabeIzenak(){
		columNames.add("Kodea");
		columNames.add("Izena");
		
	}
	
	public void eguneratu(){
		this.data = new Vector<BotikaLag>();
		this.kargatu();
		this.fireTableDataChanged();
	}
	
	public void kargatu(){
		Vector<BotikaLag> v1 = bk.getLag();
		for (int i = 0; i<=v1.size()-1; i++){
			data.addElement(v1.elementAt(i));
		}
	}
	
	public void gehitu(BotikaLag lag){
		data.addElement(lag);
		fireTableDataChanged();
	}

	public Vector<BotikaLag> getData() {
		return data;
	}
}