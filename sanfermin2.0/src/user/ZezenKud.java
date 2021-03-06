package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import Logika.DBKudeatzaile;
import Logika.ErabiltzaileKudeatzailea;
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

	public void gehitu(int kodea, String izena, String jaiotzeData, float pisua, float altuera, float adarLuzera, int ganadutegiaKode) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
//		String kontsulta = "INSERT INTO zezena set id=?, izena=?, jaiotzeData=?, pisua=?, altuera=?, adarrenLuzera=?, fk_ganadutegia=?";
//		String[] datuMotak={"int", "String", "String", "float", "float", "float", "int"};
//		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
//		Object[] datuakArrayObjects={kodea, izena,jaiotzeData, pisua, altuera, adarLuzera, ganadutegiaKode};
//		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
//		dbk.filter(kontsulta, bektorea, datuak);
		
		String kontsulta2 = "INSERT INTO zezena SET id="+kodea+", izena='"+izena+"'"+", jaiotzeData='"+jaiotzeData+"'"+", pisua="+pisua+", altuera="+altuera+", adarrenLuzera="+adarLuzera+", fk_ganadutegia="+ganadutegiaKode;           
		dbk.execSQL(kontsulta2);
	}
	

	public void ezabatu(int kodea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "DELETE FROM zezena WHERE id=?";
		String[] datuMotak={"Integer"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={kodea};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
	}
	
	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM zezenak;");
	}
	

	public Vector<ZezenLag> getLag(String erab) {
		int kodea = GanadutegiKud.getInstantzia().getId(erab);
		Vector<ZezenLag> v = new Vector<ZezenLag>();
		try {
			//System.out.println("SELECT * FROM zezena WHERE fk_ganadutegia="+kodea+"");
			ResultSet rs = dbk.execSQL("SELECT * FROM zezena WHERE fk_ganadutegia="+kodea+"");
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

	public Vector<String> getZezenak(int ganadutegia, String data) {
		Vector<String> v = new Vector<String>();
		try {
			ResultSet rs = dbk.execSQL("SELECT izena FROM zezena WHERE fk_ganadutegia="+ganadutegia+" AND id NOT IN (SELECT fk_zezena FROM zezenaEntzierroa)");
			while (rs.next()) {
				v.add(rs.getString("izena"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	
	public int getZezena(int ganadutegia, String zezena) {
		int kodea = 0;
		try {
			ResultSet rs = dbk.execSQL("SELECT id FROM zezena WHERE izena='"+zezena+"'"+"AND fk_ganadutegia="+ganadutegia+";");
			while (rs.next()) {
				int zezen = rs.getInt("id");
				kodea=zezen;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return kodea;
	}
	public boolean existitzenDaZezena(String kodea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "SELECT * FROM zezena WHERE id='"
				+ kodea+ "'";
		ResultSet rs = dbk.execSQL(kontsulta);
		try {
			while (rs.next()) {
				String id = rs.getString("id");
				if (kodea.equals(id))
					return true;
				else
					return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean existitzenDaJoalduna(String kodea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "SELECT * FROM Joalduna WHERE id='"
				+ kodea+ "'";
		ResultSet rs = dbk.execSQL(kontsulta);
		try {
			while (rs.next()) {
				String id = rs.getString("id");
				if (kodea.equals(id))
					return true;
				else
					return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public int getGanadutegia(String erab){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "select id from ganadutegia where arduraduna= '"+erab+"'";
		System.out.println("select id from ganadutegia where arduraduna= '"+erab+"'");
		ResultSet rs = dbk.execSQL(kontsulta);
		int emaitza=0;
		try {
			if(rs.next());
				int emaitz = rs.getInt("id");
				emaitza=emaitz;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emaitza;
	}

	public void gehituJoalduna(int kod, String jaiotzeData, float pisua,
			float altuera, String kolorea, int ganaduKod) {
		
		String kontsulta2 = "INSERT INTO Joalduna SET id="+kod+", jaiotzeData='"+jaiotzeData+"'"+", pisua="+pisua+", altuera="+altuera+", kolorea='"+kolorea+"'"+", fk_ganadutegia="+ganaduKod;           
		dbk.execSQL(kontsulta2);
		
	}
	
}