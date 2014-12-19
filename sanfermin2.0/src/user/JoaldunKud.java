package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;

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
		dbk.execSQL("INSERT INTO Joalduna (id, jaiotzeData, pisua, altuera,adarrenLuzera, fk_ganadutegia) VALUES  ('" + kodea + "', '" + jaiotzeData
				+ "', '" + pisua + "', '" + altuera + "', '" + kolorea + "', '" + ganadutegiaKode +"');");
	}

	
	private void ezabatu(int kodea) {
		dbk.execSQL("DELETE FROM Joalduna WHERE kodea='" + kodea + "';");
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
			ResultSet rs = dbk.execSQL("SELECT kodea FROM Joalduna;");
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
