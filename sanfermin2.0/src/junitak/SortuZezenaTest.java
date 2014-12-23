package junitak;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Logika.DBKudeatzaile;
import user.ZezenKud;

public class SortuZezenaTest {
	private DBKudeatzaile dbk;
	private ZezenKud zk;
	private Integer kodea;
	private String izena;
	private String jaiotzeData;
	private String adarLuzera;
	private String pisua;
	private String altuera;
	private String ganadutegiKod;
	private String kontsulta;
	private String konprobatzeko;
	private String ezabatzeko;

	@Before
	public void setUp() throws Exception {
		zk = ZezenKud.getInstantzia();
		dbk = DBKudeatzaile.getInstantzia();
		kodea = 2050;
		izena = "Toothless";
		jaiotzeData="2012-05-6";
		adarLuzera = "0.0";
		pisua = "400.0";
		altuera = "1.2";
		ganadutegiKod = "5";
		kontsulta = "select izena from zezena where fk_ganadutegia='"+5+"'";
		ezabatzeko = "delete from zezena where id = '" + kodea + "'";
	}

	@After
	public void tearDown() throws Exception {
		zk=null;
		dbk=null;
		kodea = null;
		izena = null;
		adarLuzera = null;
		pisua = null;
		altuera = null;
		ganadutegiKod = null;
		kontsulta = null;
	}

	@Test
	public void test() {	
		zk.gehitu(kodea, izena, jaiotzeData, pisua, altuera, adarLuzera, ganadutegiKod);
		ResultSet rs = dbk.execSQL(kontsulta);
		
		try {
			rs.next();
			konprobatzeko = rs.getString("izena");
		} catch (SQLException e) {
		}
		
		assertEquals("Toothless", konprobatzeko);
		dbk.execSQL(ezabatzeko);
	}

}
