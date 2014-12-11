package Logika;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Xenki.DBKudeatzaile;

public class GanadutegiKud {
	
	// ATRIBUTUAK

	private  DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
	
	// SINGLETON PATROIA
	
	private static GanadutegiKud instantzia = new GanadutegiKud();
	
	private GanadutegiKud(){}
	
	public static GanadutegiKud getInstantzia(){
		return instantzia;
	}
	
	// METODOAK
	
	public void gehitu(int id, String izena, String arduraduna,int tlf, String helbidea){
		dbk.execSQL("INSERT INTO `sanfermin`.`ganadutegia` (`id`, `helbidea`, `izena`, `arduraduna`,`tlf`) VALUES ('"+id+"', '"+helbidea+"', '"+izena+"', '"+arduraduna+"', '"+tlf+"');");
	}
	
	private void ezabatu(int id){
		dbk.execSQL("DELETE FROM sanfermin.ganadutegia WHERE id='" + id + "';");
	}
	
	public void ezabatuDenak(){
		dbk.execSQL("DELETE FROM sanfermin.ganadutegia;");
	}
	
	public Vector<GanadutegiLag> getLag(){
		Vector<GanadutegiLag> v = new Vector<GanadutegiLag>();
		try{
			ResultSet rs = dbk.execSQL("SELECT * FROM sanfermin.ganadutegia;");
			while(rs.next()){
				v.add(new GanadutegiLag(rs.getString("izena"), rs.getString("arduraduna"), rs.getInt("tlf")));
			}
			rs.close();
		}
		catch(SQLException e){
		System.out.println(e);
		}	
		return v;
	}
}
