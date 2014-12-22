
package Logika;

import java.sql.*;
import java.util.Arrays;
import java.util.Vector;

public class DBKudeatzaile {

	Connection conn = null;

	private void conOpen() {
		try {
			String userName = "sanfermin";
			String password = "sanfermin";
			String url = "jdbc:mysql://localhost/sanfermin";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection(url, userName, password);
			System.out.println("Database connection established");
		} catch (Exception e) {
			System.err.println("Cannot connect to database server");
		}
	}

	private PreparedStatement filtratu(String kontsulta, Vector<String> bektorea, Vector<Object> datuak) throws SQLException {
		PreparedStatement pstmt=null;
		try {
			pstmt = conn.prepareStatement(kontsulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i<bektorea.size(); i++) {
			switch (bektorea.get(i)) {
			case "Integer":
				pstmt.setInt(i+1, (Integer) datuak.get(i));
				break;
			case "String": 
				pstmt.setString(i+1, datuak.get(i).toString());
				break;
			default:
				break;
			}
		}
		return pstmt;
	}
	public ResultSet filter(String kontsulta, Vector<String> bektorea, Vector<Object> datuak) {
		PreparedStatement pstmt=null;
		try {
			pstmt= filtratu(kontsulta, bektorea, datuak);
			if(kontsulta.toLowerCase().contains("select")){
				return pstmt.executeQuery();
			}
			else{
				System.out.println(kontsulta);
				pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private ResultSet query(Statement s, String query) {

		ResultSet rs = null;

		try {
			s.executeQuery(query);
			rs = s.getResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	// singleton patroia
	private static DBKudeatzaile instantzia = new DBKudeatzaile();

	private DBKudeatzaile() {
		this.conOpen();
	}

	public static DBKudeatzaile getInstantzia() {
		return instantzia;
	}

	public ResultSet execSQL(String query) {
		int count = 0;
		Statement s = null;
		ResultSet rs = null;
		try {
			s = (Statement) conn.createStatement();
			if (query.toLowerCase().indexOf("select") == 0) {
				// select agindu bat
				rs = this.query(s, query);
			} else {
				// update, delete, create agindu bat
				count = s.executeUpdate(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static void main(String[] args) {
		DBKudeatzaile dbk=DBKudeatzaile.getInstantzia();
		String kontsulta= "SELECT administratzailea FROM erabiltzailea WHERE iderabiltzailea=? and pasahitza=?";
		String[] datuMotak={"String", "String"};
		Vector <String> bektorea= new Vector<String>(Arrays.asList(datuMotak));
		Object[] datuakArrayObjects={"leire", "leire"};
		Vector<Object> datuak= new Vector<Object>(Arrays.asList(datuakArrayObjects));
		ResultSet rs=dbk.filter(kontsulta, bektorea, datuak);
		System.out.println(rs);
		try {
			while(rs.next()){
				System.out.println(rs.getString("administratzailea"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}