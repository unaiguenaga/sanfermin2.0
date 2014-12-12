package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;
import Logika.GanadutegiKud;
import Logika.GanadutegiLag;

public class AbereKud {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static AbereKud instantzia = new AbereKud();

	private AbereKud() {
	}

	public static AbereKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	public void gehitu(int id, String izena, String arduraduna, int tlf, String helbidea) {
		dbk.execSQL("INSERT INTO ganadutegia (id, helbidea, izena, arduraduna,tlf) VALUES ('" + id + "', '" + helbidea
				+ "', '" + izena + "', '" + arduraduna + "', '" + tlf + "');");
	}

	private void ezabatu(int id) {
		dbk.execSQL("DELETE FROM ganadutegia WHERE id='" + id + "';");
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM ganadutegia;");
	}

	public Vector<GanadutegiLag> getLag() {
		Vector<GanadutegiLag> v = new Vector<GanadutegiLag>();
		try {
			ResultSet rs = dbk.execSQL("SELECT * FROM ganadutegia;");
			while (rs.next()) {
				v.add(new GanadutegiLag(rs.getString("izena"), rs.getString("arduraduna"), rs.getInt("tlf")));
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
			ResultSet rs = dbk.execSQL("SELECT izena FROM ganadutegia;");
			while (rs.next()) {
				v.add(rs.getString("izena"));
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
			ResultSet rs = dbk.execSQL("SELECT id FROM ganadutegia;");
			while (rs.next()) {
				v.add(rs.getInt("id"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}

}
