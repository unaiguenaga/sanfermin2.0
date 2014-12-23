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

	//data
	public void gehitu(Date id, float luzera, int ganadutegia) {
		dbk.execSQL("INSERT INTO entzierroa (id, luzera, fk_ganadutegia) VALUES ('" + id + "', '" + luzera + "', '"
				+ ganadutegia + "');");
	}

	public void gehitu(String id, float luzera, int ganadutegia) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "INSERT INTO entzierroa set id=?, luzera=? ,fk_ganadutegia=?";
		String[] datuMotak={"String", "float", "int"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id, luzera, ganadutegia};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
		System.out.println(kontsulta);
	}

	public void ezabatu(String id) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "DELETE FROM entzierroa WHERE id=?";
		String[] datuMotak={"String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM entzierroa;");
	}
	
	public void aldatu(String id, int ganadutegia){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "UPDATE entzierroa set fk_ganadutegia=? where id=?";
		String[] datuMotak={"String", "int"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id, ganadutegia};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
		System.out.println(kontsulta);
	}
	
	public void aldatu(String id, int ganadutegia, float luzera){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "UPDATE entzierroa set luzera=?, fk_ganadutegia=? where id=?";
		String[] datuMotak={"String", "int", "float"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id, ganadutegia, luzera};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
		System.out.println(kontsulta);
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
	
	public Vector<String> getId(String erab) {
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
