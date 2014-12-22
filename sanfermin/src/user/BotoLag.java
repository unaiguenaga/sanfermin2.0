package user;

import java.sql.Date;

public class BotoLag {

	private Integer emailea;
	private Integer jasotakoa;
	private String data;

	public BotoLag(Integer emailea, Integer jasotakoa, String data) {
		this.emailea = emailea;
		this.jasotakoa = jasotakoa;
		this.data = data;

	}
	
	public Integer getEmailea() {
		return emailea;
	}

	public Integer getJasotakoa() {
		return jasotakoa;
	}

	public String getData() {
		return data;
	}


	public Object getBalioa(int i) {
		switch (i) {
		case 0:
			return emailea;
		case 1:
			return jasotakoa;
		case 2:
			return data;
		}
		return null;
	}

	public void insertElementAt(Object value, int i) {
		switch (i) {
		case 0:
			emailea = (Integer) value;
			break;
		case 1:
			jasotakoa = (Integer) value;
			break;
		case 2:
			data = (String) value;
			break;
		}
	}
}
