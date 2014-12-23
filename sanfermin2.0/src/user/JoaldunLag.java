package user;

public class JoaldunLag {

	private Integer kodea;
	private String jaiotzeData;
	private float pisua;
	private float altuera;
	private String kolorea;


	public JoaldunLag(Integer kodea, String jaiotzeData, float pisua, float altuera, String kolorea) {
		this.kodea = kodea;
		this.jaiotzeData = jaiotzeData;
		this.pisua = pisua;
		this.altuera = altuera;
		this.kolorea = kolorea;

	}

	public int getKodea() {
		return kodea;
	}

	public String getJaiotzeData() {
		return jaiotzeData;
	}

	public float getPisua() {
		return pisua;
	}
	public float getAltuera() {
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
			pisua = (Float) value;
			break;
		case 3:
			altuera = (Float) value;
			break;
		case 4:
			kolorea = (String) value;
			break;
		}
	}
}
