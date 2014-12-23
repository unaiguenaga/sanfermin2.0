package user;

public class ZezenLag {

	private Integer kodea;
	private String izena;
	private String jaiotzeData;
	private float pisua;
	private float altuera;
	private float adarLuzera;


	public ZezenLag(Integer kodea, String izena, String jaiotzeData, float pisua, float altuera, float adarLuzera) {
		this.kodea = kodea;
		this.izena = izena;
		this.jaiotzeData = jaiotzeData;
		this.pisua = pisua;
		this.altuera = altuera;
		this.adarLuzera = adarLuzera;

	}

	public int getKodea() {
		return kodea;
	}
	
	public String getIzena(){
		return izena;
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
	public float getAdarLuzera() {
		return adarLuzera;
	}

	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return kodea;
		case 1:
			return izena;
		case 2:
			return jaiotzeData;
		case 3:
			return pisua;
		case 4:
			return altuera;
		case 5:
			return adarLuzera;
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
		case 2:
			jaiotzeData = (String) value;
			break;
		case 3:
			pisua = (Float) value;
			break;
		case 4:
			altuera = (Float) value;
			break;
		case 5:
			adarLuzera = (Float) value;
			break;
		}
	}
}
