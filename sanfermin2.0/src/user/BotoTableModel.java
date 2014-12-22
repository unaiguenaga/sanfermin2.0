package user;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import Logika.GanadutegiKud;

public class BotoTableModel extends AbstractTableModel{
	private Vector<String> columNames = new Vector<String>();
	private GanadutegiKud gk = GanadutegiKud.getInstantzia();
	private Vector<BotoLag> data = new Vector<BotoLag>();
	private boolean emaitza;

	public BotoTableModel(boolean emaitza) {
		this.emaitza = emaitza;
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
	
	public BotoLag lortuLerroa(int lerro){
		return data.elementAt(lerro);
	}

	public Class getColumnClass(int col){
		return data.elementAt(0).getBalioa(col).getClass();
	}
	
	public boolean isCellEditable(int row, int col){
		/*int ler = 0, zut = 3;
		if (row >= ler && col >= zut){
			return true;
		}else{
			return false;
		}*/
		return false;
	}
	
	public void setValueAt(Object value, int row, int col){
		data.get(row).insertElementAt(value, col);
	}
	
	public void hasieratuZutabeIzenak(){
		if (emaitza){
			columNames.add("Emandako botoak");
		}else{
			columNames.add("Aukerak");
		}
	}
	
	public void eguneratu(){
		this.data = new Vector<BotoLag>();
		this.kargatu();
		this.fireTableDataChanged();
	}
	
	public void kargatu(){
		if(!emaitza){
			Vector<BotoLag> v1 = gk.BotoLag(AukeraUser.getInstantzia().getErabiltzaileIzana());
			for (int i = 0; i<=v1.size()-1; i++){
				data.addElement(v1.elementAt(i));
			}	
		}
	}
	
	public void gehitu(BotoLag lag){
		
		System.out.println("Gehitu aurretik: "+data.size());
		data.addElement(lag);
		System.out.println("Gehitu eta gero: "+data.size());
		fireTableDataChanged();
	}
	
	public BotoLag kendu(int row){
		BotoLag b = data.get(row);
		removeRow(row);
		fireTableDataChanged();
		return b;
	}

	public Vector<BotoLag> getData() {
		return data;
	}
}
