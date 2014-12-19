package Logika;

import java.util.Date;

public class DatuBaseaKargatu {
	
	public DatuBaseaKargatu(){
		erabiltzaileakKargartu();
		ganadutegiakKargatu();
		zenzenakKargartu();
		joaldunakKargartu();
		botikakKargatu();
		tratamenduakKargartu();
		entzierroakKargatu();
	}

	
	
	public void botikakKargatu(){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String ezabatu = "delete from botika";
		dbk.execSQL(ezabatu);

		String botika1 = "insert into botika set kodea= 1, izena='Paracetamol'";
		String botika2 = "insert into botika set kodea= 2, izena='Aspirina'";
		String botika3 = "insert into botika set kodea= 3, izena='Clembuterol'";
		String botika4 = "insert into botika set kodea= 4, izena='Crotoxina'";
		String botika5 = "insert into botika set kodea= 5, izena='Tiroxina'";
		String botika6 = "insert into botika set kodea= 6, izena='Antitripsina'";
		String botika7 = "insert into botika set kodea= 7, izena='Heparina'";
		String botika8 = "insert into botika set kodea= 8, izena='Citoquina'";

		dbk.execSQL(botika1);
		dbk.execSQL(botika2);
		dbk.execSQL(botika3);
		dbk.execSQL(botika4);
		dbk.execSQL(botika5);
		dbk.execSQL(botika6);
		dbk.execSQL(botika7);
		dbk.execSQL(botika8);
	}
	
	public void tratamenduakKargartu() {

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String ezabatu = "delete from tratamendua";
		dbk.execSQL(ezabatu);

		String tratamendua1 = "insert into tratamendua set data='2014-05-12',fk_botika= 1,dosia=5, fk_zezena=1001";
		String tratamendua2 = "insert into tratamendua set data='2013-12-12',fk_botika= 2,dosia=2, fk_zezena=1001";
		String tratamendua3 = "insert into tratamendua set data='2014-01-07',fk_botika= 1,dosia=7, fk_zezena=1003";
		String tratamendua4 = "insert into tratamendua set data='2013-04-21',fk_botika= 3,dosia=1, fk_zezena=1004";
		String tratamendua5 = "insert into tratamendua set data='2014-06-15',fk_botika= 4,dosia=3, fk_zezena=1004";
		String tratamendua6 = "insert into tratamendua set data='2014-07-02',fk_botika= 5,dosia=5, fk_zezena=1004";
		String tratamendua7 = "insert into tratamendua set data='2014-03-03',fk_botika= 6,dosia=2, fk_zezena=1005";
		String tratamendua8 = "insert into tratamendua set data='2014-05-09',fk_botika= 6,dosia=6, fk_zezena=1006";

		dbk.execSQL(tratamendua1);
		dbk.execSQL(tratamendua2);
		dbk.execSQL(tratamendua3);
		dbk.execSQL(tratamendua4);
		dbk.execSQL(tratamendua5);
		dbk.execSQL(tratamendua6);
		dbk.execSQL(tratamendua7);
		dbk.execSQL(tratamendua8);
	}
	
	public void ganadutegiakKargatu() {

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String ezabatu = "delete from ganadutegia";
		dbk.execSQL(ezabatu);
		
		String ganadutegi1 = "insert into ganadutegia set id=1, helbidea='Beheko Kale 14', izena='Domecq', arduraduna='ander',tlf=946213698";
		String ganadutegi2 = "insert into ganadutegia set id=2, helbidea='Goiko Kale 7', izena='Zezento', arduraduna='unai',tlf=946893254";
		String ganadutegi3 = "insert into ganadutegia set id=3, helbidea='Erdiko Kale 21', izena='Hoberena', arduraduna='nekane',tlf=959632174";
		String ganadutegi4 = "insert into ganadutegia set id=4, helbidea='Zumalakarregi 8', izena='Idiak', arduraduna='patxi',tlf=914856325";
		String ganadutegi5 = "insert into ganadutegia set id=5, helbidea='Concha 10', izena='ZezenOnak', arduraduna='aitor',tlf=927896523";
		
		dbk.execSQL(ganadutegi1);
		dbk.execSQL(ganadutegi2);
		dbk.execSQL(ganadutegi3);
		dbk.execSQL(ganadutegi4);
		dbk.execSQL(ganadutegi5);
		
	}
	
	public void erabiltzaileakKargartu() {

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String ezabatu = "delete from erabiltzailea";
		dbk.execSQL(ezabatu);

		String erabiltzailea1 = "insert into erabiltzailea set iderabiltzailea= 'leire', pasahitza='leire',administratzailea='bai'";
		String erabiltzailea2 = "insert into erabiltzailea set iderabiltzailea= 'unai', pasahitza='unai',administratzailea='ez'";
		String erabiltzailea3 = "insert into erabiltzailea set iderabiltzailea= 'xenki', pasahitza='xenki',administratzailea='bai'";
		String erabiltzailea4 = "insert into erabiltzailea set iderabiltzailea= 'ander', pasahitza='ander',administratzailea='ez'";
		String erabiltzailea5 = "insert into erabiltzailea set iderabiltzailea= 'nekane', pasahitza='nekane',administratzailea='ez'";
		String erabiltzailea6 = "insert into erabiltzailea set iderabiltzailea= 'patxi', pasahitza='nekane',administratzailea='ez'";
		String erabiltzailea7 = "insert into erabiltzailea set iderabiltzailea= 'aitor', pasahitza='aitor',administratzailea='ez'";

		dbk.execSQL(erabiltzailea1);
		dbk.execSQL(erabiltzailea2);
		dbk.execSQL(erabiltzailea3);
		dbk.execSQL(erabiltzailea4);
		dbk.execSQL(erabiltzailea5);
		dbk.execSQL(erabiltzailea6);
		dbk.execSQL(erabiltzailea7);
	}
	
	public void zenzenakKargartu() {

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String ezabatu = "delete from zezena";
		dbk.execSQL(ezabatu);

		String zezena1 = "insert into zezena set id= 1000, izena='Islero',jaiotzeData='2013-09-10',pisua=250,altuera=2.30,adarrenLuzera=1.02,fk_ganadutegia=1";
		String zezena2 = "insert into zezena set id= 1001, izena='Raton',jaiotzeData='2013-10-15',pisua=256,altuera=2.40,adarrenLuzera=1.52,fk_ganadutegia=1";
		String zezena3 = "insert into zezena set id= 1002, izena='Atrevido',jaiotzeData='2013-11-06',pisua=302,altuera=2.10,adarrenLuzera=1.06,fk_ganadutegia=1";
		String zezena4 = "insert into zezena set id= 1003, izena='Belador',jaiotzeData='2012-01-26',pisua=223,altuera=2.56,adarrenLuzera=1.32,fk_ganadutegia=2";
		String zezena5 = "insert into zezena set id= 1004, izena='Sedoso',jaiotzeData='2013-10-10',pisua=285,altuera=2.40,adarrenLuzera=0.98,fk_ganadutegia=2";
		String zezena6 = "insert into zezena set id= 1005, izena='Cimbareto',jaiotzeData='2013-02-20',pisua=260,altuera=2.24,adarrenLuzera=1.10,fk_ganadutegia=3";
		String zezena7 = "insert into zezena set id= 1006, izena='Desteñido',jaiotzeData='2013-03-10',pisua=280,altuera=2.01,adarrenLuzera=1.25,fk_ganadutegia=4";

		dbk.execSQL(zezena1);
		dbk.execSQL(zezena2);
		dbk.execSQL(zezena3);
		dbk.execSQL(zezena4);
		dbk.execSQL(zezena5);
		dbk.execSQL(zezena6);
		dbk.execSQL(zezena7);
	}

	public void joaldunakKargartu() {

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String ezabatu = "delete from Joalduna";
		dbk.execSQL(ezabatu);

		String joalduna1 = "insert into Joalduna set id= 100,jaiotzeData='2013-12-10',pisua=250,altuera=2.30,kolorea='gorria',fk_ganadutegia=1";
		String joalduna2 = "insert into Joalduna set id= 101,jaiotzeData='2013-03-15',pisua=256,altuera=2.40,kolorea='beltza',fk_ganadutegia=1";
		String joalduna3 = "insert into Joalduna set id= 102,jaiotzeData='2013-10-06',pisua=302,altuera=2.10,kolorea='marroia',fk_ganadutegia=2";
		String joalduna4 = "insert into Joalduna set id= 103,jaiotzeData='2012-09-26',pisua=223,altuera=2.56,kolorea='zuria',fk_ganadutegia=2";
		String joalduna5 = "insert into Joalduna set id= 104,jaiotzeData='2013-02-10',pisua=285,altuera=2.40,kolorea='beltza',fk_ganadutegia=2";
		String joalduna6 = "insert into Joalduna set id= 105,jaiotzeData='2013-07-20',pisua=260,altuera=2.24,kolorea='marroia',fk_ganadutegia=3";
		String joalduna7 = "insert into Joalduna set id= 106,jaiotzeData='2013-06-10',pisua=280,altuera=2.01,kolorea='gorria',fk_ganadutegia=";

		dbk.execSQL(joalduna1);
		dbk.execSQL(joalduna2);
		dbk.execSQL(joalduna3);
		dbk.execSQL(joalduna4);
		dbk.execSQL(joalduna5);
		dbk.execSQL(joalduna6);
	}
	
	public void entzierroakKargatu(){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String ezabatu = "delete from entzierroa";
		dbk.execSQL(ezabatu);

		String entzierro1 = "insert into entzierroa set id='2014-12-10',luzera=10,fk_ganadutegia=1";
		String entzierro2 = "insert into entzierroa set id='2014-10-01',luzera=10,fk_ganadutegia=2";
		String entzierro3 = "insert into entzierroa set id='2014-07-07',luzera=12,fk_ganadutegia=2";
		String entzierro4 = "insert into entzierroa set id='2014-01-07',luzera=14,fk_ganadutegia=3";
		String entzierro5 = "insert into entzierroa set id='2014-02-02',luzera=16,fk_ganadutegia=4";

		dbk.execSQL(entzierro1);
		dbk.execSQL(entzierro2);
		dbk.execSQL(entzierro3);
		dbk.execSQL(entzierro4);
		dbk.execSQL(entzierro5);
	}
}
