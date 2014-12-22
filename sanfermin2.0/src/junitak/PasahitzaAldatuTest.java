package junitak;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Logika.PasahitzaAldatu;

public class PasahitzaAldatuTest {

	PasahitzaAldatu pa;
	String erab1;
	String pzaharra1;
	String pberri1;
	String pberrikonpr1;
	
	String erab2;
	String pzaharra2;
	String pberri2;
	String pberrikonpr2;
	
	String erab3;
	String pzaharra3;
	String pberri3;
	String pberrikonpr3;
	
	String erab4;
	String pzaharra4;
	String pberri4;
	String pberrikonpr4;

	@Before
	public void setUp() throws Exception {
		pa = new PasahitzaAldatu();
		
		erab1 = "unai";
		pzaharra1 = "unai";
		pberri1 = "guenaga";
		pberrikonpr1 ="guenaga";
		
		erab2 = "unai";
		pzaharra2 = "guenaga";
		pberri2 = "unai";
		pberrikonpr2 = "unai";
		
		
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		pa = null;
		erab1 = null;
		pzaharra1 = null;
		pberri1 = null;
		pberrikonpr1 =null;
	}

	@Test
	public void test() {
		pa.pasahitzaAldatu(pberri1, pberrikonpr1, erab1, pzaharra1);
		pa.pasahitzaAldatu(pberri2, pberrikonpr2, erab2, pzaharra2);
	}

}
