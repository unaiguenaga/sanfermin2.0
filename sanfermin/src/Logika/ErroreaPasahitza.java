package Logika;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErroreaPasahitza extends JFrame {

	public ErroreaPasahitza() {
		JOptionPane.showMessageDialog(null,
				"Zure erabiltzailea edo pasahitza ez da zuzena. Saiatu zaitez berriro, mesedez.", "OOOOOPS",
				JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,
				"Zure erabiltzailea edo pasahitza ez da zuzena. Saiatu zaitez berriro, mesedez.", "OOOOOPS",
				JOptionPane.ERROR_MESSAGE);
	}
}
