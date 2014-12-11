package Logika;

import java.sql.Date;

public class EntzierroLag {
	private Date data;
	private String ganadutegia;
	
	public EntzierroLag(Date data, String ganadutegia){
		this.data = data;
		this.ganadutegia = ganadutegia;
	}

	public Date getData() {
		return data;
	}

	public String getGanadutegia() {
		return ganadutegia;
	}
	
	public Object getBalioa(int i){
		switch (i) {
		case 0: return data;
		case 1: return ganadutegia;
		}
		return null;
	}
	
	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			data = (Date) value;
			break;
		case 1:
			ganadutegia = (String) value;
			break;
		}
	}
}
