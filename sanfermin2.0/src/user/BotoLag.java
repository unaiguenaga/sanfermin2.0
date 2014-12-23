package user;

import java.sql.Date;

public class BotoLag {

	private Integer id;
	private String izena;

	public BotoLag(Integer id, String izena) {
		this.id = id;
		this.izena = izena;

	}
	
	public Integer getId() {
		return id;
	}

	public String getIzena() {
		return izena;
	}
	
	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return izena;
		}
		return null;
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			izena = (String) value;
			break;
		}
	}
}
