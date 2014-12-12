package Logika;

public class GanadutegiLag {

	private String izena;
	private String arduraduna;
	private Integer tlf;

	public GanadutegiLag(String izena, String arduraduna, Integer tlf) {
		this.izena = izena;
		this.arduraduna = arduraduna;
		this.tlf = tlf;
	}

	public String getIzena() {
		return izena;
	}

	public String getArduraduna() {
		return arduraduna;
	}

	public int getTlf() {
		return tlf;
	}

	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return izena;
		case 1:
			return arduraduna;
		case 2:
			return tlf;
		}
		return null;
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			izena = (String) value;
			break;
		case 1:
			arduraduna = (String) value;
			break;
		case 2:
			tlf = (Integer) value;
			break;
		}
	}
}
