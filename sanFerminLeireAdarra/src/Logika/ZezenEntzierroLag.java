package Logika;

import java.sql.Date;
import java.sql.Time;
import java.util.Vector;

public class ZezenEntzierroLag {

	private String parteHartu;
	private Time denbora;
	private String zezena;
	private Date entzierroa;

	public ZezenEntzierroLag(String parteHartu, Time denbora, String zezena, Date entzierroa) {
		this.parteHartu = parteHartu;
		this.denbora = denbora;
		this.zezena = zezena;
		this.entzierroa= entzierroa;
		
	}

	public String getParteHartu() {
		return parteHartu;
	}

	public Time getDenbora() {
		return denbora;
	}

	public String getZezena() {
		return zezena;
	}

	public Date getEntzierroa() {
		return entzierroa;
	}

	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return parteHartu;
		case 1:
			return denbora;
		case 2:
			return zezena;
		case 3:
			return entzierroa;
		}
		return null;
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			parteHartu = (String) value;
			break;
		case 1:
			denbora = (Time) value;
			break;
		case 2:
			zezena = (String) value;
			break;
		case 3:
			entzierroa = (Date) value;
			break;
		}
	}
}
