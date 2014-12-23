package user;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class JoaldunTableModel extends AbstractTableModel{
	private static String erabiltzailea=null;
	
	private Vector<String> columNames = new Vector<String>();
	private JoaldunKud jk = JoaldunKud.getInstantzia();
	private Vector<JoaldunLag> data = new Vector<JoaldunLag>();

	public JoaldunTableModel(String erabiltzaileIzena) {
		erabiltzailea = erabiltzaileIzena;
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
		columNames.add("Jaiotze data");
		columNames.add("Pisua");
		columNames.add("Altuera");
		columNames.add("Kolorea");
	}
	
	public void kargatu(){
		Vector<JoaldunLag> v1 = jk.getLag(erabiltzailea);
		for (int i = 0; i<=v1.size()-1; i++){
			data.addElement(v1.elementAt(i));
		}
	}
	
	public void gehitu(JoaldunLag lag){
		
		data.addElement(lag);
		fireTableDataChanged();
	}
	
	public void eguneratu(){
		data = new Vector<JoaldunLag>();
		kargatu();
		fireTableDataChanged();
	}
}