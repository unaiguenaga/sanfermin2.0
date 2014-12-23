package Logika;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Errorea extends JFrame {

	public Errorea() {
		
	}

	public static void main(String[] args) {
		
	}
	public void bozkaketa() {
		JOptionPane.showMessageDialog(null,
				"Ezin dituzu 3 boto baino gehiago eman.", "OOOOOPS",
				JOptionPane.ERROR_MESSAGE);

	}
	
	public void pasahitza() {
		JOptionPane.showMessageDialog(null,
				"Zure erabiltzailea edo pasahitza ez da zuzena. Saiatu zaitez berriro, mesedez.", "OOOOOPS",
				JOptionPane.ERROR_MESSAGE);

	}
	
}
