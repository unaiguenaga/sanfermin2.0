package Logika;

import java.sql.Date;
import java.util.Vector;

public class TratamenduLag {

	private Date data;
	private int botika;
	private String dosia;
	private int zezena;

	public TratamenduLag(Date data, int botika, String dosia, int zezena) {
		this.data = data;
		this.botika = botika;
		this.dosia = dosia;
		this.zezena= zezena;
		
	}

	public Date getIzena() {
		return data;
	}

	public int getArduraduna() {
		return botika;
	}

	public String getTlf() {
		return dosia;
	}

	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return data;
		case 1:
			return botika;
		case 2:
			return dosia;
		case 3:
			return zezena;
		}
		return null;
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			data = (Date) value;
			break;
		case 1:
			botika = (Integer) value;
			break;
		case 2:
			dosia = (String) value;
			break;
		case 3:
			zezena = (Integer) value;
		}
	}
}
