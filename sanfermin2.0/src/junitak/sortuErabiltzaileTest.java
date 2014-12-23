package junitak;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import administratzailea.ErabiltzaileBerria;
import Logika.DBKudeatzaile;

public class sortuErabiltzaileTest {

	ErabiltzaileBerria eb;
	DBKudeatzaile dbk;
	
	String erab;
	String pasahitza;
	String pasahitzaKonpr;
	String kontsulta;
	String ezabatzeko;
	String lag;

	String erab2;
	String pasahitza2;
	String pasahitzaKonpr2;
	String kontsulta2;
	String lag2;

	@Before
	public void setUp() throws Exception {
		eb = new ErabiltzaileBerria();
		dbk = DBKudeatzaile.getInstantzia();
		erab = "periko";
		pasahitza = "palotes";
		pasahitzaKonpr = "palotes";
		kontsulta = "Select pasahitza from erabiltzailea where iderabiltzailea ='" + erab + "'";
		ezabatzeko = "delete from erabiltzailea where iderabiltzailea='" + erab + "'";
		lag = null;

		erab2 = "mikel";
		pasahitza2 = "ondo";
		pasahitzaKonpr2 = "txarto";
		kontsulta2 = "select pasahitza from erabiltzailea where iderabiltzailea ='" + erab2 + "'";
		lag2 = null;
	}

	@After
	public void tearDown() throws Exception {
		eb = null;
		dbk = null;
		erab = null;
		pasahitza = null;
		pasahitzaKonpr = null;
		kontsulta = null;
		lag = null;
	}

	@Test
	public void test() {
		eb.sortu(erab, pasahitzaKonpr, pasahitzaKonpr);
		ResultSet rs = dbk.execSQL(kontsulta);
		try {
			rs.next();
			lag = rs.getString("pasahitza");
		} catch (SQLException e) {
		}
		assertEquals(null, lag); //ezin bai da erabiltzailea ganadutegi gabe sortu.
		dbk.execSQL(ezabatzeko);

		eb.sortu(erab2, pasahitza2, pasahitzaKonpr2);
		rs = dbk.execSQL(kontsulta2);
		try {
			rs.next();
			lag2 = rs.getString("pasahitza");
		} catch (SQLException e) {
		}
		assertEquals(null, lag2);
	}
}
