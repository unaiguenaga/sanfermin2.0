package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;
import Logika.ErabiltzaileKudeatzailea;

public class JoaldunKud  {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static JoaldunKud instantzia = new JoaldunKud();

	private JoaldunKud() {
	}

	public static JoaldunKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	
	public void gehituJoalduna(int kodea, String jaiotzeData, String pisua, String altuera, String kolorea, String ganadutegiaKode) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "INSERT INTO Joalduna set id=?, jaiotzeData=?, pisua=?, altuera=?, kolorea=?, fk_ganadutegia=?";
		String[] datuMotak={"Integer", "String", "String", "String", "String", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={kodea, jaiotzeData, pisua, altuera, kolorea, ganadutegiaKode};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
	}

	
	public void ezabatu(int kodea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "DELETE FROM Joalduna WHERE id=?";
		String[] datuMotak={"Integer"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={kodea};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
	}

	
	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM Joalduna;");
	}

	
	public Vector<JoaldunLag> getLag() {
		Vector<JoaldunLag> v = new Vector<JoaldunLag>();
		try {
			ResultSet rs = dbk.execSQL("SELECT * FROM Joalduna;");
			while (rs.next()) {
				v.add(new JoaldunLag(rs.getInt("id"), rs.getString("jaiotzeData"), rs.getFloat("pisua"), rs.getFloat("altuera"), rs.getString("kolorea")));
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
			ResultSet rs = dbk.execSQL("SELECT id FROM Joalduna;");
			while (rs.next()) {
				v.add(rs.getInt("id"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	public boolean existitzenDa(String kodea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "SELECT * FROM zezena WHERE id='"
				+ kodea+ "'";
		ResultSet rs = dbk.execSQL(kontsulta);
		try {
			while (rs.next()) {
				String konprobatzeko = rs.getString("id");
				if (kodea.equals(konprobatzeko))
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
	public String getGanadutegia(String erab){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "select id from ganadutegia where arduraduna='"+erab+"'";
		ResultSet rs = dbk.execSQL(kontsulta);
		String emaitza=null;
		try {
			rs.next();
			emaitza = rs.getString("id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emaitza;
	}
	
}
