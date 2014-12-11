package Logika;

import java.sql.Date;
import java.util.Vector;

public class TratamenduLag {
	
	private Date data;
	private String botika;
	private float dosia;
	
	public TratamenduLag(Date data, String botika, float dosia){
		this.data = data;
		this.botika = botika;
		this.dosia = dosia;
	}

	public Date getIzena() {
		return data;
	}

	public String getArduraduna() {
		return botika;
	}

	public float getTlf() {
		return dosia;
	}
	
	public Object getBalioa(int i){
		switch (i) {
		case 0: return data;
		case 1: return botika;
		case 2: return dosia;
		}
		return null;
	}
	
	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			data = (Date) value;
			break;
		case 1:
			botika = (String) value;
			break;
		case 2:
			dosia = (Float) value;
			break;
		}
	}
}
