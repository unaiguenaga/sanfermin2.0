package junitak;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Logika.DBKudeatzaile;
import Logika.ErabiltzaileKudeatzailea;
import Logika.PasahitzaAldatu;

public class PasahitzaAldatuTest {
	DBKudeatzaile dbk;
	PasahitzaAldatu pa;

	String erab1;
	String pzaharra1;
	String pberri1;
	String pberrikonpr1;
	String kontsulta1;
	String pasahitza1;

	String erab2;
	String pzaharra2;
	String pberri2;
	String pberrikonpr2;
	String kontsulta2;
	String pasahitza2;

	String erab3;
	String pzaharra3;
	String pberri3;
	String pberrikonpr3;
	String kontsulta3;
	String pasahitza3;

	String erab4;
	String pzaharra4;
	String pberri4;
	String pberrikonpr4;
	String kontsulta4;
	String pasahitza4;

	@Before
	public void setUp() throws Exception {
		pa = new PasahitzaAldatu();
		dbk = DBKudeatzaile.getInstantzia();

		erab1 = "unai";
		pzaharra1 = "unai";
		pberri1 = "guenaga";
		pberrikonpr1 = "guenaga";
		kontsulta1 = "SELECT pasahitza FROM erabiltzailea WHERE iderabiltzailea=" + "'" + erab1 + "'";
		pasahitza1 = null;

		erab2 = "unai";
		pzaharra2 = "guenaga";
		pberri2 = "unai";
		pberrikonpr2 = "unai";
		kontsulta2 = "SELECT pasahitza FROM erabiltzailea WHERE iderabiltzailea=" + "'" + erab2 + "'";
		pasahitza2 = null;

		erab3 = "unai";
		pzaharra3 = "unai";
		pberri3 = "guenaga";
		pberrikonpr3 = "aitor";
		kontsulta3 = "SELECT pasahitza FROM erabiltzailea WHERE iderabiltzailea=" + "'" + erab3 + "'";
		pasahitza3 = null;

		erab4 = "unai";
		pzaharra4 = "txarto";
		pberri4 = "guenaga";
		pberrikonpr4 = "guenaga";
		kontsulta4 = "SELECT pasahitza FROM erabiltzailea WHERE iderabiltzailea=" + "'" + erab1 + "'";
		pasahitza4 = null;
	}

	@After
	public void tearDown() throws Exception {

		erab1 = null;
		pzaharra1 = null;
		pberri1 = null;
		pberrikonpr1 = null;

		erab2 = null;
		pzaharra2 = null;
		pberri2 = null;
		pberrikonpr2 = null;

		erab3 = null;
		pzaharra3 = null;
		pberri3 = null;
		pberrikonpr3 = null;
	}

	@Test
	public void test() {

		// password changed from unai to guenaga.
		pa.pasahitzaAldatu(pberri1, pberrikonpr1, erab1, pzaharra1);
		ResultSet rs = dbk.execSQL(kontsulta1);

		try {
			rs.next();
			pasahitza1 = rs.getString("pasahitza");
		} catch (SQLException e) {
		}

		assertEquals("guenaga", pasahitza1);
		assertNotEquals("unai", pasahitza1);

		// password changed from guenaga to unai
		pa.pasahitzaAldatu(pberri2, pberrikonpr2, erab2, pzaharra2);
		rs = dbk.execSQL(kontsulta2);

		try {
			rs.next();
			pasahitza2 = rs.getString("pasahitza");
		} catch (SQLException e) {
		}

		assertEquals("unai", pasahitza2);
		assertNotEquals("guenaga", pasahitza2);

		// pasahitza and pberrikonpr not same.
		pa.pasahitzaAldatu(pberri3, pberrikonpr3, erab3, pzaharra3);
		rs = dbk.execSQL(kontsulta3);

		try {
			rs.next();
			pasahitza3 = rs.getString("pasahitza");
		} catch (SQLException e) {
		}

		assertEquals("unai", pasahitza3);
		assertNotEquals("guenaga", pasahitza3);

		// user and password don't match
		pa.pasahitzaAldatu(pberri4, pberrikonpr4, erab4, pzaharra4);
		rs = dbk.execSQL(kontsulta4);

		try {
			rs.next();
			pasahitza4 = rs.getString("pasahitza");
		} catch (SQLException e) {
		}

		assertEquals("unai", pasahitza4);
		assertNotEquals("guenaga", pasahitza4);
	}

}
