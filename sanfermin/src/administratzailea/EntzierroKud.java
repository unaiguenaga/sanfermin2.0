package administratzailea;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;

public class EntzierroKud {
	
	// ATRIBUTUAK

	private  DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
	
	// SINGLETON PATROIA
	
	private static EntzierroKud instantzia = new EntzierroKud();
	
	private EntzierroKud(){}
	
	public static EntzierroKud getInstantzia(){
		return instantzia;
	}
	
	// METODOAK
	
	public void gehitu(Date id, float luzera, int ganadutegia){
		dbk.execSQL("INSERT INTO `sanfermin`.`entzierroa` (`id`, `luzera`, `fk_ganadutegia`) VALUES ('"+id+"', '"+luzera+"', '"+ganadutegia+"');");
	}
	
	public void gehitu(String id, float luzera, int ganadutegia){
		dbk.execSQL("INSERT INTO `sanfermin`.`entzierroa` (`id`, `luzera`, `fk_ganadutegia`) VALUES ('"+id+"', '"+luzera+"', '"+ganadutegia+"');");
	}
	
	private void ezabatu(Date id){
		dbk.execSQL("DELETE FROM sanfermin.entzierroa WHERE id='"+id+"';");
	}
	
	public void ezabatuDenak(){
		dbk.execSQL("DELETE FROM sanfermin.entzierroa;");
	}
	
	public Vector<EntzierroLag> getLag(){
		Vector<EntzierroLag> v = new Vector<EntzierroLag>();
		try{
			ResultSet rs = dbk.execSQL("SELECT entzierroa.id, ganadutegia.izena FROM sanfermin.entzierroa, sanfermin.ganadutegia WHERE entzierroa.fk_ganadutegia = ganadutegia.id;");
			while(rs.next()){
				v.add(new EntzierroLag(rs.getDate("id"), rs.getString("izena")));
			}
			rs.close();
		}
		catch(SQLException e){
		System.out.println(e);
		}	
		return v;
	}
}
