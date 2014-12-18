package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;

public class ZezenKud  {

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

	public void gehitu(int kodea, String izena, String jaiotzeData, String pisua, String altuera, String adarLuzera, String ganadutegiaKode) {
		dbk.execSQL("INSERT INTO zezena (id, izenaZezen, jaiotzeData, pisua, altuera,adarrenLuzera, fk_ganadutegia) VALUES  ('" + kodea + "', '" + izena + "', '" + jaiotzeData
				+ "', '" + pisua + "', '" + altuera + "', '" + adarLuzera + "', '" + ganadutegiaKode +"');");
	}
	

	private void ezabatu(int kodea) {
		dbk.execSQL("DELETE FROM zezena WHERE kodea='" + kodea + "';");
	}
	
	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM zezenak;");
	}
	

	public Vector<ZezenLag> getLag() {
		Vector<ZezenLag> v = new Vector<ZezenLag>();
		try {
			ResultSet rs = dbk.execSQL("SELECT * FROM zezena;");
			while (rs.next()) {
				v.add(new ZezenLag(rs.getInt("id"), rs.getString("izenaZezen"), rs.getString("jaiotzeData"), rs.getFloat("pisua"), rs.getFloat("altuera"), rs.getFloat("adarrenLuzera")));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	

	public Vector<Integer> getKod() {
		Vector<Integer> v = new Vector<Integer>();
		try {
			ResultSet rs = dbk.execSQL("SELECT kodea FROM zezena;");
			while (rs.next()) {
				v.add(rs.getInt("kodea"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	
	public Vector<String> getIzenak() {
		Vector<String> v = new Vector<String>();
		try {
			ResultSet rs = dbk.execSQL("SELECT izenaZezen FROM zezena;");
			while (rs.next()) {
				v.add(rs.getString("izenaZezen"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	
}
