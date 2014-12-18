package Logika;

import java.sql.ResultSet;
import java.sql.SQLException;

import administratzailea.AukeraAdmin;
import user.AukeraUser;

public class ErabiltzaileKudeatzailea {

	public void main(String[] args) {
		
	}

	

	public static boolean konprobatuPasahitzaEtaErabiltzailea(String izen,
			String pasahitz) {

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String kontsulta = "SELECT * FROM erabiltzailea WHERE iderabiltzailea='"
				+ izen + "'" + "and " + "pasahitza='" + pasahitz + "'";
		System.out.println(kontsulta);
		ResultSet rs = dbk.execSQL(kontsulta);

		boolean aurkitua = false;

		try {
			while (rs.next()) {
				String izena = rs.getString("iderabiltzailea");
				String pasahitza = rs.getString("pasahitza");
				if (izena.equals(izen) && pasahitza.equals(pasahitz)) {
					aurkitua = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(aurkitua);
		return aurkitua;
	}

	public void pasahitzaAldatu(String izena, String pasahitzBerria) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "UPDATE erabiltzailea set pasahitza='"
				+ pasahitzBerria + "' where iderabiltzailea='" + izena + "'";
		dbk.execSQL(kontsulta);
		System.out.println(kontsulta);

	}

	public void hasieratuAdminEdoUser(String izen, String pasahitz) {
		if (!this.konprobatuPasahitzaEtaErabiltzailea(izen, pasahitz)) {
			// Errorea gertatu dela ateratzeko
			ErroreaPasahitza errorea = new ErroreaPasahitza();
		} else {

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
				aa.main(izen);
			} else {
				AukeraUser au = new AukeraUser().getInstantzia();
				au.main(izen);
			}

		}
	}

	public void sortuErabiltzaileaEtaGehitu(String izena, String pasahitza) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "INSERT INTO erabiltzailea set iderabiltzailea='"+ izena+ "', pasahitza='" + pasahitza +"',administratzailea='ez'";
		dbk.execSQL(kontsulta);
		System.out.println(kontsulta);
	}

	public boolean existitzenDa(String izena) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String kontsulta = "SELECT * FROM erabiltzailea WHERE iderabiltzailea='"
				+ izena+ "'";
		System.out.println(kontsulta);
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
		String kontsulta = "DELETE FROM erabiltzailea where iderabiltzailea='" + izena+ "' and pasahitza='" + pasahitza + "'";
		dbk.execSQL(kontsulta);
		System.out.println(kontsulta);
	}
}
