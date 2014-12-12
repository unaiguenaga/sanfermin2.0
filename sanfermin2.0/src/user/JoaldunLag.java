package user;

public class JoaldunLag {

	private Integer kodea;
	private String jaiotzeData;
	private String pisua;
	private String altuera;
	private String kolorea;


	public JoaldunLag(Integer kodea, String jaiotzeData, String pisua, String altuera, String kolorea) {
		this.kodea = kodea;
		this.jaiotzeData = jaiotzeData;
		this.pisua = pisua;
		this.pisua = altuera;
		this.pisua = kolorea;

	}

	public int getKodea() {
		return kodea;
	}

	public String getJaiotzeData() {
		return jaiotzeData;
	}

	public String getPisua() {
		return pisua;
	}
	public String getAltuera() {
		return altuera;
	}
	public String getKolorea() {
		return kolorea;
	}

	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return kodea;
		case 1:
			return jaiotzeData;
		case 2:
			return pisua;
		case 3:
			return altuera;
		case 4:
			return kolorea;
		}
		return null;
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			kodea = (Integer) value;
			break;
		case 1:
			jaiotzeData = (String) value;
			break;
		case 2:
			pisua = (String) value;
			break;
		case 3:
			altuera = (String) value;
			break;
		case 4:
			kolorea = (String) value;
			break;
		}
	}
}
