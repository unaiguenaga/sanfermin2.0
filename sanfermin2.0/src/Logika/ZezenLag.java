package Logika;

import java.sql.Date;

public class ZezenLag {
	
	private Integer id;
	private Date jaiotzeData;
	private float pisua;
	private float altuera;
	private float adarLuzera;
	private Integer idGanadutegia;
	
	public ZezenLag(int id, Date jaiotzeData, float pisua, float altuera, float adarLuzera, Integer idGanadutegia){
		this.id = id;
		this.pisua = pisua;
		this.altuera = altuera;
		this.adarLuzera = adarLuzera;
		this.idGanadutegia = idGanadutegia;
	}

	public int getId() {
		return id;
	}

	public java.sql.Date getJaiotzeData() {
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
	
//	public int getIdGanadutegia() {
//		return idGanadutegia;
//	}
	
	public Object getBalioa(int i){
		switch (i) {
		case 0: return id;
		case 1: return jaiotzeData;
		case 2: return pisua;
		case 3: return altuera;
		case 4: return adarLuzera;
		//case 5: return idGanadutegia;
		}
		return null;
	}
	
	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			id = (Integer) value;
			break;
		case 1:
			jaiotzeData = (java.sql.Date) value;
			break;
		case 2:
			pisua = (Float) value;
			break;
		case 3:
			altuera = (Float) value;
			break;
		case 4:
			adarLuzera = (Float) value;
			break;
//		case 5:
//				idGanadutegia = (Integer) value;
//			break;
		}
	}
}
