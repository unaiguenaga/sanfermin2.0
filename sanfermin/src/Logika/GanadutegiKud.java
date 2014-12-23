package Logika;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

	public void gehitu(int id, String izena, String arduraduna, int tlf, String helbidea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "INSERT INTO ganadutegia set id=?, helbidea=? ,izena=?, arduraduna=?, tlf=?";
		String[] datuMotak={"Integer","String", "String","String","Integer"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id, helbidea, izena, arduraduna, tlf};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
	}

	public void ezabatu(int id) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "DELETE FROM ganadutegia WHERE id=?";
		String[] datuMotak={"Integer"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		System.out.println(bektorea + " "+ datuak);
		dbk.filter(kontsulta, bektorea, datuak);
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM ganadutegia;");
	}
	
	public void aldatuArduraduna(int id, String ard){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "UPDATE ganadutegia set arduraduna=? where id=?";
		String[] datuMotak={"Integer", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id,ard};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
	}
	
	public void aldatuTlf(int id, int tlf){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "UPDATE ganadutegia set tlf=? where id=?";
		String[] datuMotak={"Integer", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id,tlf};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
	}
	
	public void aldatuHelbidea(int id, String helb){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "UPDATE ganadutegia set helbidea=? where id=?";
		String[] datuMotak={"Integer", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={id,helb};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
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
			ResultSet rs = dbk.execSQL("SELECT * FROM ganadutegia;");
			while (rs.next()) {
				v.add(rs.getString("izena"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	
	public Vector<String> getIzenak(String erabiltzailea) {
		Vector<String> v = new Vector<String>();
		try {
			ResultSet rs = dbk.execSQL("SELECT izena FROM ganadutegia WHERE arduraduna != '"+erabiltzailea+"';");
			System.out.println("SELECT izena FROM ganadutegia WHERE arduraduna != '"+erabiltzailea+"';");
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
			ResultSet rs = dbk.execSQL("SELECT * FROM ganadutegia;");
			while (rs.next()) {
				v.add(rs.getInt("id"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	
	public int getId(String erabiltzailea) {
		Vector<Integer> v = new Vector<Integer>();
		try {
			ResultSet rs = dbk.execSQL("SELECT id FROM ganadutegia WHERE arduraduna = '"+erabiltzailea+"';");
			while (rs.next()) {
				return rs.getInt("id");
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return 0;
	}

	public boolean badago(String erabIzena) {
		String kontsulta= "Select iderabiltzailea From erabiltzailea where iderabiltzailea='" + erabIzena+ "'";
		ResultSet rs=dbk.execSQL(kontsulta);
		try {
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
