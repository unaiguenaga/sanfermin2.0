package user;

public class BotikaLag  {

	private Integer kodea;
	private String izena;

	public BotikaLag(Integer kodea, String izena) {
		this.kodea = kodea;
		this.izena = izena;
	}

	public int getKodea() {
		return kodea;
	}

	public String getIzena() {
		return izena;
	}

	
	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return kodea;
		case 1:
			return izena;
		case 2:
		}
		return null;
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			kodea = (Integer) value;
			break;
		case 1:
			izena = (String) value;
			break;
		}
	}
}
