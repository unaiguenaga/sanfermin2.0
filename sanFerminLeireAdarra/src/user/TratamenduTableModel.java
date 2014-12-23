package user;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Logika.TratamenduKud;
import Logika.TratamenduLag;

public class TratamenduTableModel extends AbstractTableModel {
	private static String erabiltzailea=null;
	
	private Vector<String> columNames = new Vector<String>();
	private TratamenduKud tk = TratamenduKud.getInstantzia();
	private Vector<TratamenduLag> data = new Vector<TratamenduLag>();
	
	private int zezena = 0;
	
	
	public TratamenduTableModel(String erabiltzaileIzena) {
		erabiltzailea=erabiltzaileIzena;
		hasieratuZutabeIzenak();
		kargatu();
	}
	
	public void setZezena(int id){
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
	
	public String getColumnName (int col){
		return columNames.elementAt(col);
	}

	public Class getColumnClass(int col){
		return data.elementAt(0).getBalioa(col).getClass();
	}
	
	public boolean isCellEditable(int row, int col){
		return false;
	}
	
	public void setValueAt(Object value, int row, int col){
		data.get(row).insertElementAt(value, col);
	}
	
	public void hasieratuZutabeIzenak(){
		columNames.add("Botika");
		columNames.add("Dosia");
		columNames.add("Zezena");
		columNames.add("Data");
	}
	
	public void kargatu(){
		Vector<TratamenduLag> v3 = tk.getLag(erabiltzailea);
		for (int i = 0; i<=v3.size()-1; i++){
			data.addElement(v3.elementAt(i));
		}
	}
	
	public void eguneratu(){
		data = new Vector<TratamenduLag>();
		kargatu();
		fireTableDataChanged();
	}
}
