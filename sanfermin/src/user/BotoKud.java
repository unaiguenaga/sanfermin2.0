package user;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.DefaultListModel;

import Logika.DBKudeatzaile;
import Logika.GanadutegiKud;

public class BotoKud {

	// ATRIBUTUAK

	private DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

	// SINGLETON PATROIA

	private static BotoKud instantzia = new BotoKud();

	private BotoKud() {
	}

	public static BotoKud getInstantzia() {
		return instantzia;
	}

	// METODOAK

	public void gehituBotoa(int emailea, int jasotakoa, Date data) {
		dbk.execSQL("INSERT INTO botoak (fk_emailea, fk_hartzailea, data) VALUES  ('"
				+ emailea + "', '" + jasotakoa + "', '" + data + "');");
	}

	private void ezabatu(int emailea) {
		dbk.execSQL("DELETE FROM botoak WHERE fk_emailea='" + emailea + "';");
	}

	public void ezabatuDenak() {
		dbk.execSQL("DELETE FROM botoak;");
	}



	public Vector<Integer> getEmailea() {
		Vector<Integer> v = new Vector<Integer>();
		try {
			ResultSet rs = dbk.execSQL("SELECT fk_emailea FROM botoak;");
			while (rs.next()) {
				v.add(rs.getInt("fk_emailea"));
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return v;
	}
	
	// Hiru boto edo gutxiago badira eta erabiltzaileak aurten ez badu botoa eman, botoak datubasean gordeko dira.
	public int botoakGorge(String emailea, Vector<BotoLag> vHartzaileak){
		int e = GanadutegiKud.getInstantzia().getId(emailea);
		if(vHartzaileak.size()<4){
			if(aurtenBotatuDu(e)<3){
				for(int i = 0; i < vHartzaileak.size(); i++){
					System.out.println("INSERT INTO botoak (fk_emailea, fk_hartzailea, data) VALUES  ('"
							+ e + "', '" + vHartzaileak.get(i).getId() + "', DATE(NOW()));");
					dbk.execSQL("INSERT INTO botoak (fk_emailea, fk_hartzailea, data) VALUES  ('"
							+ e + "', '" + vHartzaileak.get(i).getId() + "', DATE(NOW()));");
					return 0;
				}
			}
			return 1;
		}
		return 2;
	}
	
	// Erabiltzaileak bere ganadutegiaren izenean botoa aurten eman ote duen itsuliko du.
	
	private int aurtenBotatuDu(int id){
		int zenbatDa=0;
		try {
			ResultSet rs = dbk.execSQL("SELECT count(*) FROM botoak WHERE fk_emailea = '"+id+"' AND data > DATE_SUB(NOW(), INTERVAL 1 YEAR);");
			while (rs.next()) {
				int zenbat = rs.getInt("count(*)");
				zenbatDa=zenbat;
				return zenbat;
			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return zenbatDa;
	}

	//Bektore batetan gordetzen ditu Erabiltzaileak emandako botoak (Eskuineko JList-ekoak hain zuzen)
	public Vector<String> kargatuBektorea(DefaultListModel modeloa) {
		Vector<String> bektorea = new Vector<String>();
		int kopurua = modeloa.getSize();

		for (int i = 0; i < kopurua; i++) {
			bektorea.addElement((String) modeloa.getElementAt(i));
		}

		return bektorea;
	}

	//Erabiltzailea pasatuz, modeloan gordeko ditu Erabiltzaile horrek Datu Basean dituen boto guztiak
	public DefaultListModel kargatuModeloa(String izena){
		DefaultListModel modeloa = new DefaultListModel();
		Vector<String> ganadutegiak = new Vector<String>();
		
		//Botoak eman dituen Erabiltzailearen ganadutegia bilatzeko
				ResultSet rs = dbk
						.execSQL("SELECT id FROM ganadutegia WHERE arduraduna='"
								+ izena + "'");
				System.out.println("SELECT id FROM ganadutegia WHERE arduraduna='"
								+ izena + "'");
				int id =0;
				try {
					while (rs.next()) {
						int kodea = rs.getInt("id");
						id=kodea;
					}
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		//Kontsulta honekin Erabiltzaileak botatutako ganadutegien izenak lortuko dira
		String kontsulta = "SELECT ganadutegia.izena FROM ganadutegia,botoak WHERE ganadutegia.id=botoak.fk_hartzailea and botoak.fk_emailea="+id;
		
		ResultSet rs1 = dbk.execSQL(kontsulta);
		try {
			while (rs1.next()){
				String gana = rs1.getString("izena");
				ganadutegiak.add(gana);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < ganadutegiak.size(); i++) {
			modeloa.addElement(ganadutegiak.get(i));
		}
		return modeloa;
	}

	//metodo honek modelo bat eta Erabiltzaile izena emanda, honek eman dituen botoak gordeko ditu Datu Basean
	public void gehituBotoak(DefaultListModel modeloa, String izena) {

		// Botoak nork eman dituen bilatzeko
		ResultSet rs = dbk
				.execSQL("SELECT id FROM ganadutegia WHERE arduraduna='"
						+ izena + "'");
		int id = 0;
		try {
			while (rs.next()) {
				int kodea = rs.getInt("id");
				id = kodea;
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Vector<String> bektorea = new Vector<String>();
		bektorea = this.kargatuBektorea(modeloa);

		String kontsulta = null;

		for (String b : bektorea) {

			ResultSet rs1 = dbk
					.execSQL("SELECT id FROM ganadutegia WHERE izena='" + b
							+ "'");
			int id1 = 0;
			try {
				while (rs1.next()) {
					int kodea = rs1.getInt("id");
					id1 = kodea;
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			kontsulta = "INSERT INTO botoak set fk_emailea=" + id
					+ ",fk_hartzailea=" + id1 + ",data=NOW()";
			dbk.execSQL(kontsulta);
		}
	}
}