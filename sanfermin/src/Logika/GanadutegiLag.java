package Logika;

public class GanadutegiLag {

	private int id;
	private String helbidea;
	private String izena;
	private String arduraduna;
	private Integer tlf;

	public GanadutegiLag(String izena, String arduraduna, Integer tlf, int id, String helbidea) {
		this.izena = izena;
		this.arduraduna = arduraduna;
		this.tlf = tlf;
		this.id = id;
		this.helbidea = helbidea;
	}

	public int getId() {
		return id;
	}

	public String getHelbidea() {
		return helbidea;
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
		case 3:
			return id;
		case 4:
			return helbidea;
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
		case 3:
			id = (Integer) value;
			break;
		case 4:
			helbidea = (String) value;
			break;
		}
	}
}
