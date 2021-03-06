package user;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Logika.GanadutegiKud;
import Logika.GanadutegiLag;

public class ZezenaTableModel extends AbstractTableModel{
	
	private static String erabiltzailea;
	private Vector<String> columNames = new Vector<String>();
	private ZezenKud zk = ZezenKud.getInstantzia();
	private Vector<ZezenLag> data = new Vector<ZezenLag>();

	public ZezenaTableModel(String erab) {
		erabiltzailea=erab;
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
		columNames.add("Kodea");
		columNames.add("Izena");
		columNames.add("Jaiotze data");
		columNames.add("Pisua");
		columNames.add("Altuera");
		columNames.add("Adar luzera");
	}
	
	public void kargatu(){
		Vector<ZezenLag> v1 = zk.getLag(erabiltzailea);
		for (int i = 0; i<=v1.size()-1; i++){
			data.addElement(v1.elementAt(i));
		}
	}
	
	public void gehitu(ZezenLag lag){
		data.addElement(lag);
		fireTableDataChanged();
	}
	public void eguneratu(){
		this.data = new Vector<ZezenLag>();
		this.kargatu();
		fireTableDataChanged();
	}
}
