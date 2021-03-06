package Logika;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;

public class EntzierroKud {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static EntzierroKud instantzia = new EntzierroKud();

	private EntzierroKud() {
	}

	public static EntzierroKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	public void gehitu(Date id, float luzera, int ganadutegia) {
		dbk.execSQL("INSERT INTO entzierroa (id, luzera, fk_ganadutegia) VALUES ('" + id + "', '" + luzera + "', '"
				+ ganadutegia + "');");
	}

	public void gehitu(String id, float luzera, int ganadutegia) {
		dbk.execSQL("INSERT INTO entzierroa (id, luzera, fk_ganadutegia) VALUES ('" + id + "', '" + luzera + "', '"
				+ ganadutegia + "');");
	}

	private void ezabatu(Date id) {
		dbk.execSQL("DELETE FROM entzierroa WHERE id='" + id + "';");
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM entzierroa;");
	}

	public Vector<EntzierroLag> getLag() {
		Vector<EntzierroLag> v = new Vector<EntzierroLag>();
		try {
			ResultSet rs = dbk
					.execSQL("SELECT entzierroa.id, ganadutegia.izena FROM entzierroa, ganadutegia WHERE entzierroa.fk_ganadutegia = ganadutegia.id;");
			while (rs.next()) {
				v.add(new EntzierroLag(rs.getDate("id"), rs.getString("izena")));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}

	public Vector<String> getId() {
		Vector<String> v = new Vector<String>();
		try {
			ResultSet rs = dbk.execSQL("SELECT id FROM entzierroa;");
			while (rs.next()) {
				v.add(rs.getString("id"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
}
