package Logika;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;

public class TratamenduKud {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static TratamenduKud instantzia = new TratamenduKud();

	private TratamenduKud() {
	}

	public static TratamenduKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	public void gehitu(Date data, String botika, float dosia, int zezena) {
		dbk.execSQL("INSERT INTO tratamendua (data, botika, dosia, fk_zezena) VALUES ('" + data + "', '" + botika
				+ "', '" + dosia + "', " + zezena + ");");
	}

	private void ezabatu(Date data) {
		dbk.execSQL("DELETE FROM tratamendua WHERE data='" + data + "';");
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM tratamendua;");
	}

	public Vector<TratamenduLag> getLag() {
		Vector<TratamenduLag> v = new Vector<TratamenduLag>();
		try {
			ResultSet rs = dbk.execSQL("SELECT * FROM tratamendua;");
			while (rs.next()) {
				v.add(new TratamenduLag(getIzena(rs.getInt("fk_botika")), rs.getFloat("dosia"), ZezenKud.getInstantzia().getIzena(rs.getInt("fk_zezena")) ,rs.getDate("data"),rs.getInt("fk_zezena") ,rs.getInt("fk_botika")));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}

	public Vector<Integer> getIdak() {
		Vector<Integer> v = new Vector<Integer>();
		try {
			ResultSet rs = dbk.execSQL("SELECT kodea FROM botika;");
			while (rs.next()) {
				v.add(rs.getInt("botika"));
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
			ResultSet rs = dbk.execSQL("SELECT izena FROM botika;");
			while (rs.next()) {
				v.add(rs.getString("botika"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	
	public String getIzena(int id){
		String izena = "";
		try {
			ResultSet rs = dbk.execSQL("SELECT izena FROM botika WHERE kodea='"+id+"';");
			while (rs.next()) {
				return rs.getString("izena");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return izena;
	}
}
