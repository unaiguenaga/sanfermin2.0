package Logika;

import java.sql.Date;
import java.util.Vector;

public class TratamenduLag {
	
	// Taulan bistaratuko direnak:
	private String botika;
	private float dosia;
	private String zezena;
	private Date data;
	// Laguntzaileak:
	private int idZezena;
	private int idBotika;

	public TratamenduLag(String botika, float dosia, String izena, Date data, int idZezena, int idBotika) {
		this.botika = botika;
		this.dosia = dosia;
		this.zezena = izena;
		this.data = data;
		this.idZezena = idZezena;
		this.idBotika = idBotika;
	}
	
	public String getBotika() {
		return botika;
	}

	public float getDosia() {
		return dosia;
	}
	
	public String getZezena() {
		return zezena;
	}
	
	public Date getData() {
		return data;
	}
	
	public int getIdZezena() {
		return idZezena;
	}
	
	public int getIdBotika() {
		return idBotika;
	}
	
	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return botika;
		case 1:
			return dosia;
		case 2:
			return zezena;
		case 3:
			return data;
		}
		return null;
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			botika = (String) value;
			break;
		case 1:
			dosia = (Float) value;
			break;
		case 2:
			zezena = (String) value;
			break;
		case 3:
			data = (Date) value;
			break;
		}
	}
}
