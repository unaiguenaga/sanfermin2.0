package Logika;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTextField;

import Logika.DBKudeatzaile;

public class ZezenEntzierroKud {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static ZezenEntzierroKud instantzia = new ZezenEntzierroKud();

	private ZezenEntzierroKud() {
	}

	public static ZezenEntzierroKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	//egiteke
	public void gehitu(String parteHartu, Time denbora, int zezena, Date entzierroa) {
		dbk.execSQL("INSERT INTO zezenaEntzierroa (parteHartu, denbora, fk_zezena, fk_entzierroa) VALUES ('"
				+ parteHartu
				+ "', '"
				+ denbora
				+ "', '"
				+ zezena
				+ "', '"
				+ entzierroa
				+ "')");
	}

	private void ezabatu(Date data) {
		dbk.execSQL("DELETE FROM zezenaEntzierroa WHERE fk_entzierroa='" + data + "';");
		
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM zezenaEntzierroa;");
	}

	public Vector<ZezenEntzierroLag> getLag(String data) {
		Vector<ZezenEntzierroLag> v = new Vector<ZezenEntzierroLag>();
		
		//ResultSet rs = dbk.execSQL("SELECT tratamendua.data, botika.izena, tratamendua.dosia, zezena.izena FROM tratamendua,botika,zezena WHERE tratamendua.fk_zezena=zezena.id and tratamendua.fk_botika=botika.kodea");
		String kontsulta = "SELECT ze.parteHartu, ze.denbora, z.id, e.id as data FROM zezenaEntzierroa ze INNER JOIN zezena z ON ze.fk_zezena = z.id INNER JOIN entzierroa e ON ze.fk_entzierroa = e.id AND fk_entzierroa='"+data+"'";
		ResultSet rs = dbk.execSQL(kontsulta);
		
		try {
			while (rs.next()) {
				v.add(new ZezenEntzierroLag(rs.getString("parteHartu"), rs.getTime("denbora"), rs.getString("id"), rs.getDate("data")));
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
			ResultSet rs = dbk.execSQL("SELECT fk_entzierroa FROM zezenaEntzierroa;");
			while (rs.next()) {
				v.add(rs.getString("fk_entzierroa"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
}