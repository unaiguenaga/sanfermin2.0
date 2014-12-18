package Logika;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTextField;

import Logika.DBKudeatzaile;

public class TratamenduKud {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static TratamenduKud instantzia = new TratamenduKud();

	private TratamenduKud() {
	}

	public static TratamenduKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	public void gehitu(String data, int botika, String dosia, int zezena) {
		dbk.execSQL("INSERT INTO tratamendua (data, fk_botika, dosia, fk_zezena) VALUES ('"
				+ data
				+ "', '"
				+ botika
				+ "', '"
				+ dosia
				+ "', "
				+ zezena
				+ ");");
	}

	private void ezabatu(Date data) {
		dbk.execSQL("DELETE FROM tratamendua WHERE data='" + data + "';");
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM tratamendua;");
	}

	public Vector<TratamenduLag> getLag() {
		Vector<TratamenduLag> v = new Vector<TratamenduLag>();
		
		System.out.println("select aurretik");
		
		//ResultSet rs = dbk.execSQL("SELECT tratamendua.data, botika.izena, tratamendua.dosia, zezena.izena FROM tratamendua,botika,zezena WHERE tratamendua.fk_zezena=zezena.id and tratamendua.fk_botika=botika.kodea");
		String kontsulta = "SELECT t.data, b.izena, t.dosia, z.izenaZezen FROM tratamendua t INNER JOIN botika b ON t.fk_botika = b.kodea INNER JOIN zezena z ON t.fk_zezena = z.id";
		ResultSet rs = dbk.execSQL(kontsulta);
		
		try {
			while (rs.next()) {
				v.add(new TratamenduLag(rs.getDate("data"), rs.getInt("izena"), rs.getString("dosia"), rs.getInt("izenaZezen")));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println("select ostean");
		return v;
	}

	public Vector<String> getIzenak() {
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
	}

	// Metodo honek Zezenaren kodea eta Botikaren kodea bilatuko ditu, eta Tratamendu berria gehituko du Datu Basera
	
	public void gehituTratamendua(String data, Object zezena, Object botika,
			String dosia) {

		// ///////////////////// Zezenaren kodea bilatzeko // //////////////////////////
		String zezen = (String) zezena;
		String bilatu = "select id from zezena where izenaZezen='" + zezen + "'";

		ResultSet rs = dbk.execSQL(bilatu);

		int zezenKodea = 0;

		try {
			while (rs.next()) {
				int kode = rs.getInt("id");
				zezenKodea = kode;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// /////////////////// Botikaren kodea bilatzeko // ///////////////////////////

		String zeinBotika = (String) botika;
		String bilatuBotika = "select kodea from botika where izena='"
				+ zeinBotika + "'";

		ResultSet rs1 = dbk.execSQL(bilatuBotika);

		int botikaKodea = 0;

		try {
			while (rs1.next()) {
				int kode1 = rs1.getInt("kodea");
				botikaKodea = kode1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

		}
		
		//////////////////////// Tratamendua gehitu ///////////////////////////////
		
		TratamenduKud.getInstantzia().gehitu(data, botikaKodea, dosia, zezenKodea);
	}
}
