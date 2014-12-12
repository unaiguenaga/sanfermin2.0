package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;

public class BotikaKud  {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static BotikaKud instantzia = new BotikaKud();

	private BotikaKud() {
	}

	public static BotikaKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	
	public void gehituBotika(int kodea, String izena) {
		dbk.execSQL("INSERT INTO botika (kodea, izena) VALUES  ('" + kodea + "', '" + izena+"');");
	}

	
	private void ezabatu(int kodea) {
		dbk.execSQL("DELETE FROM botika WHERE kodea='" + kodea + "';");
	}

	
	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM botika;");
	}

	public Vector<BotikaLag> getLag() {
		Vector<BotikaLag> v = new Vector<BotikaLag>();
		try {
			ResultSet rs = dbk.execSQL("SELECT * FROM botika;");
			while (rs.next()) {
				v.add(new BotikaLag(rs.getInt("kodea"), rs.getString("izena")));
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
			ResultSet rs = dbk.execSQL("SELECT kodea FROM botika;");
			while (rs.next()) {
				v.add(rs.getInt("kodea"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}

	
}