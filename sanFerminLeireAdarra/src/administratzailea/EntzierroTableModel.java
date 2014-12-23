package administratzailea;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

import Logika.EntzierroKud;
import Logika.EntzierroLag;

public class EntzierroTableModel extends AbstractTableModel{
	
	private Vector<String> columNames = new Vector<String>();
	
	private EntzierroKud ek = EntzierroKud.getInstantzia();
	
	private Vector<EntzierroLag> data = new Vector<EntzierroLag>();
	
	public EntzierroTableModel() {
		hasieratuZutabeIzenak();
		kargatu();
		
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
	
	public void eguneratu(){
		this.data = new Vector<EntzierroLag>();
		this.kargatu();
		this.fireTableDataChanged();
	}
	
	public void hasieratuZutabeIzenak(){
		columNames.add("Data");
		columNames.add("Ganadutegia");
	}
	
	private void kargatu(){
		Vector<EntzierroLag> v2 = ek.getLag();
		for (int i = 0; i<=v2.size()-1; i++){
			data.addElement(v2.elementAt(i));
		}
	}
}
