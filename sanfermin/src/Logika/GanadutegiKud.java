package Logika;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultListModel;

import Logika.DBKudeatzaile;

public class GanadutegiKud {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static GanadutegiKud instantzia = new GanadutegiKud();

	private GanadutegiKud() {
	}

	public static GanadutegiKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	public void gehitu(int id, String izena, String arduraduna, int tlf,
			String helbidea) {
		dbk.execSQL("INSERT INTO ganadutegia (id, helbidea, izena, arduraduna,tlf) VALUES ('"
				+ id
				+ "', '"
				+ helbidea
				+ "', '"
				+ izena
				+ "', '"
				+ arduraduna
				+ "', '" + tlf + "');");
	}

	public void ezabatu(String id) {
		dbk.execSQL("DELETE FROM ganadutegia WHERE izena='" + id +"'"+";");
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM ganadutegia;");
	}

	public Vector<GanadutegiLag> getLag() {
		Vector<GanadutegiLag> v = new Vector<GanadutegiLag>();
		try {
			ResultSet rs = dbk.execSQL("SELECT * FROM ganadutegia;");
			while (rs.next()) {
				v.add(new GanadutegiLag(rs.getString("izena"), rs
						.getString("arduraduna"), rs.getInt("tlf"), rs
						.getInt("id"), rs.getString("helbidea")));
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

	// Metodo honek bozkatu ahal diren Ganadutegiak aterako ditu, bozkatzen
	// dagoena kenduta
	public Vector<String> getBozkatzekoak(String izena) {
		Vector<String> v = new Vector<String>();

		try {
			ResultSet rs = dbk
					.execSQL("SELECT izena FROM ganadutegia WHERE arduraduna!='"
							+ izena + "'");
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

	public static DefaultListModel kargatuModeloa(DefaultListModel model, Vector<String> data) {
		for (int i = 0; i < data.size(); i++) {
			model.addElement(data.get(i));
		}
		return model;
	}
}
