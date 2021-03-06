package administratzailea;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

import Logika.EntzierroLag;
import Logika.GanadutegiKud;
import Logika.GanadutegiLag;

public class GanadutegiTableModel extends AbstractTableModel{
	
	private Vector<String> columNames = new Vector<String>();
	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	private Vector<GanadutegiLag> data = new Vector<GanadutegiLag>();
	
	
	public GanadutegiTableModel() {
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
		columNames.add("Izena");
		columNames.add("Arduraduna");
		columNames.add("Telefonoa");
	}
	
	public void kargatu(){
		Vector<GanadutegiLag> v1 = gk.getLag();
		for (int i = 0; i<=v1.size()-1; i++){
			data.addElement(v1.elementAt(i));
		}
	}
	
	public void eguneratu(){
		this.data = new Vector<GanadutegiLag>();
		this.kargatu();
		this.fireTableDataChanged();
	}
}
