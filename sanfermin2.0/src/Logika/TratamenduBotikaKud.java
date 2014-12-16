package Logika;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTextField;

import Logika.DBKudeatzaile;

public class TratamenduBotikaKud {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static TratamenduBotikaKud instantzia = new TratamenduBotikaKud();

	private TratamenduBotikaKud() {
	}

	public static TratamenduBotikaKud getInstantzia() {
		return instantzia;
	}

	// METODOAK


	public Vector<TratamenduBotikaLag> getLag() {
		Vector<TratamenduBotikaLag> v = new Vector<TratamenduBotikaLag>();
		
		//ResultSet rs = dbk.execSQL("SELECT tratamendua.data, botika.izena, tratamendua.dosia, zezena.izena FROM tratamendua,botika,zezena WHERE tratamendua.fk_zezena=zezena.id and tratamendua.fk_botika=botika.kodea");
		String kontsulta = "SELECT t.data, b.izena, t.dosia, z.izenaZezen FROM tratamendua t INNER JOIN botika b ON t.fk_botika = b.kodea INNER JOIN zezena z ON t.fk_zezena = z.id";
		ResultSet rs = dbk.execSQL(kontsulta);
		
		try {
			while (rs.next()) {
				v.add(new TratamenduBotikaLag(rs.getDate("data"), rs.getString("izena"), rs.getString("dosia"), rs.getString("izenaZezen")));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return v;
	}

	/*public Vector<String> getIzenak() {
		Vector<String> v = new Vector<String>();
		try {
			ResultSet rs = dbk.execSQL("SELECT fk_botika FROM tratamendua;");
			while (rs.next()) {
				v.add(rs.getString("fk_botika"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}*/
}

