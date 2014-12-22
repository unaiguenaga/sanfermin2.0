package Logika;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ZezenKud {
	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static ZezenKud instantzia = new ZezenKud();

	private ZezenKud() {
	}

	public static ZezenKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	public void gehitu(Date jaiotzeData, float pisua, float altuera, float adarrenLuzera, int ganadutegia) {
		dbk.execSQL("INSERT INTO sanfermin.zezena (jaiotzeData, pisua, altuera, adarrenLuzera fk_ganadutegia) VALUES ('" + jaiotzeData + "', '" + pisua
				+ "', '" + altuera + "', " + adarrenLuzera + ", " + ganadutegia + ");");
	}

	public void ezabatu(int  id) {
		dbk.execSQL("DELETE FROM zezena WHERE id='" + id + "';");
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM zezena;");
	}
	
	public String getIzena(int id){
		return "********";
	}
	
	public Vector<ZezenLag> getLag(){
		Vector<ZezenLag> v = new Vector<ZezenLag>();
		try{
			ResultSet rs = dbk.execSQL("SELECT * FROM sanfermin.zezena;");
			while(rs.next()){
				System.out.println( rs.getDate("jaiotzeData")+ " : "+rs.getInt("id"));
				
				v.add(new ZezenLag(rs.getInt("id"), rs.getDate("jaiotzeData"), rs.getFloat("pisua"), rs.getFloat("altuera"), rs.getFloat("adarrenLuzera"), rs.getInt("fk_ganadutegia")));
			}
			rs.close();
		}
		catch(SQLException e){
		System.out.println(e);
		}	
		return v;
	}
	
	public Vector<Integer> getId(){
		Vector<Integer> v = new Vector<Integer>();
		try{
			ResultSet rs = dbk.execSQL("SELECT zezena.id FROM sanfermin.zezena;");
			while(rs.next()){
				v.add(rs.getInt("id"));
			}
			rs.close();
		}
		catch(SQLException e){
		System.out.println(e);
		}	
		return v;
	}
}
