package Logika;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;

import administratzailea.AukeraAdmin;
import user.AukeraUser;

public class ErabiltzaileKudeatzailea {
	
	private static ErabiltzaileKudeatzailea instantzia = new ErabiltzaileKudeatzailea();
	
	public static ErabiltzaileKudeatzailea getInstantzia(){
		return instantzia;
	}
	
	private ErabiltzaileKudeatzailea() {
	}

	public static boolean konprobatuPasahitzaEtaErabiltzailea(String izen,
			String pasahitz) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "SELECT * FROM erabiltzailea WHERE iderabiltzailea=? and pasahitza=?";
		String[] datuMotak={"String", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={izen, pasahitz};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		ResultSet rs = dbk.filter(kontsulta, bektorea, datuak);

		boolean aurkitua=false;
		try {
		   aurkitua = rs.next();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aurkitua;
	}
	
	public Vector <String> lag1(String[] datuMotak) {
		Vector <String> bektorea= new Vector<String>(Arrays.asList(datuMotak));
		return bektorea;
	}
	public Vector<Object> lag2(Object[] datuakArrayObjects) {
		Vector<Object> datuak= new Vector<Object>(Arrays.asList(datuakArrayObjects)); 
		return datuak;
	}

	public void izenaAldatu(String izenZaharra, String izenBerria) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "UPDATE erabiltzailea set iderabiltzailea=? where iderabiltzailea=?";
		String[] datuMotak={"String", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={izenBerria,izenZaharra};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);


	}
		
	public void pasahitzaAldatu(String izena, String pasahitzBerria) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "UPDATE erabiltzailea set pasahitza=? where iderabiltzailea=?";
		String[] datuMotak={"String", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={pasahitzBerria, izena};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);

	}

	public void hasieratuAdminEdoUser(String izen, String pasahitz) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "SELECT administratzailea FROM erabiltzailea where iderabiltzailea="
				+ '\u0022' + izen + '\u0022';
		ResultSet rs = dbk.execSQL(kontsulta);
		boolean adminDa = false;

		try {
			while (rs.next()) {
				String admin = rs.getString("administratzailea");
				if (admin.equals("bai")) {
					adminDa = true;
				}
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (adminDa) {
			AukeraAdmin aa = AukeraAdmin.getInstantzia();
			aa.bistaratu(izen);
		} else {
			AukeraUser au = AukeraUser.getInstantzia();
			au.main(izen);
		}
	}

	public void sortuErabiltzaileaEtaGehitu(String izena, String pasahitza) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "INSERT INTO erabiltzailea set iderabiltzailea=?, pasahitza=? ,administratzailea='ez'";
		String[] datuMotak={"String", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={izena, pasahitza};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
		
	}

	public boolean existitzenDa(String izena) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "SELECT * FROM erabiltzailea WHERE iderabiltzailea='"
				+ izena+ "'";
		ResultSet rs = dbk.execSQL(kontsulta);
		try {
			while (rs.next()) {
				String izen = rs.getString("iderabiltzailea");
				if (izena.equals(izen))
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

	public void kenduErabiltzailea(String izena, String pasahitza) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "DELETE FROM erabiltzailea where iderabiltzailea=? and pasahitza=?";
		String[] datuMotak={"String", "String"};
		Vector <String> bektorea=ErabiltzaileKudeatzailea.getInstantzia().lag1(datuMotak);
		Object[] datuakArrayObjects={izena, pasahitza};
		Vector<Object> datuak= ErabiltzaileKudeatzailea.getInstantzia().lag2(datuakArrayObjects); 
		dbk.filter(kontsulta, bektorea, datuak);
	}
	
	public Vector<String> getIzenak(){
		Vector<String> v = new Vector<String>();
		ResultSet rs = DBKudeatzaile.getInstantzia().execSQL("SELECT iderabiltzailea FROM erabiltzailea");
		try {
			while (rs.next()) {
				String izen = rs.getString("iderabiltzailea");
				v.add(izen);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return v;
	}
}
