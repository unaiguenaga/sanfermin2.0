package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import Logika.DBKudeatzaile;
import Logika.GanadutegiKud;

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
		dbk.execSQL("INSERT INTO zezena (id, izena, jaiotzeData, pisua, altuera,adarrenLuzera, fk_ganadutegia) VALUES  ('" + kodea + "', '" + izena + "', '" + jaiotzeData
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
				v.add(new ZezenLag(rs.getInt("id"), rs.getString("izena"), rs.getString("jaiotzeData"), rs.getFloat("pisua"), rs.getFloat("altuera"), rs.getFloat("adarrenLuzera")));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	

	public Vector<Integer> getId() {
		Vector<Integer> v = new Vector<Integer>();
		try {
			ResultSet rs = dbk.execSQL("SELECT id FROM zezena;");
			while (rs.next()) {
				v.add(rs.getInt("id"));
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
			ResultSet rs = dbk.execSQL("SELECT izena FROM zezena;");
			while (rs.next()) {
				v.add(rs.getString("izena"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}

	public String getIzena(int id) {try {
		ResultSet rs = dbk.execSQL("SELECT izena FROM zezena WHERE id = '"+id+"';");
			while (rs.next()) {
				return rs.getString("izena");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return "Ez du izenik";
	}
	
	public Vector<Integer> getId(String arduraduna) {
		Vector<Integer> v = new Vector<Integer>();
		int id = GanadutegiKud.getInstantzia().getId(arduraduna);
		try {
			ResultSet rs = dbk.execSQL("SELECT z.id FROM zezena z INNER JOIN ganadutegia g ON z.fk_ganadutegia = g.id AND g.arduraduna= '"+arduraduna+"';");
			//ResultSet rs = dbk.execSQL("SELECT id FROM zezena WHERE fk_ganadutegia = '"+id+"';");
			while (rs.next()) {
				v.add(rs.getInt("z.id"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	
	public Vector<String> getIzenak(String arduraduna) {
		Vector<String> v = new Vector<String>();
		int id = GanadutegiKud.getInstantzia().getId(arduraduna);
		try {
			ResultSet rs = dbk.execSQL("SELECT z.izena FROM zezena z INNER JOIN ganadutegia g ON z.fk_ganadutegia = g.id AND g.arduraduna= '"+arduraduna+"';");
			//ResultSet rs = dbk.execSQL("SELECT izena FROM zezena WHERE fk_ganadutegia = '"+id+"';");
			while (rs.next()) {
				v.add(rs.getString("z.izena"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
}