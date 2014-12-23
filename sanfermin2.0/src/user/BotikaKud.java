package user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Logika.DBKudeatzaile;
import Logika.ErabiltzaileKudeatzailea;

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
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "INSERT INTO botika set kodea=?, izena=?";
		String[] datuMotak={"int", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={kodea, izena};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
		System.out.println(kontsulta);
	}

	
	public void ezabatu(int kodea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "DELETE FROM botika WHERE kodea=?";
		String[] datuMotak={"int"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={kodea};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
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
	
	public Vector<String> getIzenak() {
		Vector<String> v = new Vector<String>();
		try {
			ResultSet rs = dbk.execSQL("SELECT izena FROM botika;");
			while (rs.next()) {
				v.add(rs.getString("izena"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}

	public void gordeDBan(Vector<BotikaLag> datuak) {
		for (int i = 0; i<datuak.size();i++){
			ResultSet rs = dbk.execSQL("UPDATE `sanfermin`.`botika` SET `izena`='"+datuak.get(i).getIzena()+"' WHERE `kodea`='"+datuak.get(i).getKodea()+"';");
		}
	}
	
}