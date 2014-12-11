package Logika;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Xenki.DBKudeatzaile;

public class TratamenduKud {
	
	// ATRIBUTUAK

	private  DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
	
	// SINGLETON PATROIA
	
	private static TratamenduKud instantzia = new TratamenduKud();
	
	private TratamenduKud(){}
	
	public static TratamenduKud getInstantzia(){
		return instantzia;
	}
	
	// METODOAK
	
	private void gehitu(Date data, String botika, float dosia, int zezena){
		dbk.execSQL("INSERT INTO `sanfermin`.`tratamendua` (`data`, `botika`, `dosia`, `fk_zezena`) VALUES ('"+data+"', '"+botika+"', '"+dosia+"', "+zezena+");");
	}
	
	private void ezabatu(Date data){
		dbk.execSQL("DELETE FROM sanfermin.tratamendua WHERE data='" + data + "';");
	}
	
	private void ezabatuDenak(){
		dbk.execSQL("DELETE FROM sanfermin.tratamendua;");
	}
	
	public Vector<TratamenduLag> getLag(int zezena){
		Vector<TratamenduLag> v = new Vector<TratamenduLag>();
		try{
			ResultSet rs = dbk.execSQL("SELECT * FROM sanfermin.tratamendua WHERE fk_zezena='"+zezena+"';");
			while(rs.next()){
				v.add(new TratamenduLag(rs.getDate("data"), rs.getString("botika"), rs.getFloat("dosia")));
			}
			rs.close();
		}
		catch(SQLException e){
		System.out.println(e);
		}	
		return v;
	}
}
