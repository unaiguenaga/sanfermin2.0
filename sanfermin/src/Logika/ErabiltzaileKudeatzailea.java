package Logika;

import java.sql.ResultSet;
import java.sql.SQLException;

import administratzailea.AukeraAdmin;
import user.AukeraUser;

public class ErabiltzaileKudeatzailea {
	
	public void main(String[] args) {
		erabiltzaileakKargartu();
	}
	
	public void erabiltzaileakKargartu() {
		
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		
		String ezabatu = "delete from erabiltzailea";
		dbk.execSQL(ezabatu);
		
		String erabiltzailea1 = "insert into erabiltzailea set iderabiltzailea= 'leire', pasahitza='leire',administratzailea='bai'";
		String erabiltzailea2 = "insert into erabiltzailea set iderabiltzailea= 'unai', pasahitza='unai',administratzailea='ez'";
		String erabiltzailea3 = "insert into erabiltzailea set iderabiltzailea= 'xenki', pasahitza='xenki',administratzailea='bai'";
		String erabiltzailea4 = "insert into erabiltzailea set iderabiltzailea= 'ander', pasahitza='ander',administratzailea='ez'";
		
		dbk.execSQL(erabiltzailea1);
		dbk.execSQL(erabiltzailea2);
		dbk.execSQL(erabiltzailea3);
		dbk.execSQL(erabiltzailea4);
	}
	
	public static boolean konprobatuPasahitzaEtaErabiltzailea(String izen, String pasahitz){
		
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		
		String kontsulta="SELECT * FROM erabiltzailea WHERE iderabiltzailea='"+izen+"'"+ "and "+"pasahitza='"+pasahitz+"'";
		System.out.println(kontsulta);
		ResultSet rs = dbk.execSQL(kontsulta);
		
		boolean aurkitua=false;
		
		try {
			while(rs.next()){
				String izena=rs.getString("iderabiltzailea");
				String pasahitza=rs.getString("pasahitza");
				if(izena.equals(izen) && pasahitza.equals(pasahitz)){
					aurkitua=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(aurkitua);
		return aurkitua;
	}
	
	public boolean sortuErabiltzaileMota(String izen, String pasahitz){
		boolean aurrera=false;
		if(!this.konprobatuPasahitzaEtaErabiltzailea(izen, pasahitz)){
			//Errorea gertatu dela ateratzeko
			ErroreaPasahitza errorea = new ErroreaPasahitza();
		}
		else{
			DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
			
			String kontsulta="SELECT administratzailea FROM erabiltzailea where iderabiltzailea="+'\u0022'+izen+'\u0022';
			
			ResultSet rs = dbk.execSQL(kontsulta);
			
			boolean adminDa=false;
			
			try {
				while(rs.next()){
					String admin = rs.getString("administratzailea");
					if(admin.equals("bai")){
						adminDa=true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(adminDa){
				AukeraAdmin aa = AukeraAdmin.getInstantzia();
				aa.main(izen);
				aurrera=true;
			}
			else{
				AukeraUser au= new AukeraUser();
				au.main(izen);
				aurrera=true;
			}
		}
		return aurrera;
	}
}
