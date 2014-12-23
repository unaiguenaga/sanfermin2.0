package Logika;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Leihoak extends JFrame {

	public Leihoak() {
		
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
	
	public void aukeratu() {
		JOptionPane.showMessageDialog(null,
				"Ez duzu lerro bat aukeratu. Bat hautatu ezazu, mesedez.", "OOOOOPS",
				JOptionPane.ERROR_MESSAGE);

	}
	public void erroreaBozkaketa(int error) {
		switch (error) {
		case 0:
			JOptionPane.showMessageDialog(null,
					"Zure botoak zuzen gorde dira datubasean.", "Botoak gorde dira.",
					JOptionPane.INFORMATION_MESSAGE);
			break;
			
		case 1:
			JOptionPane.showMessageDialog(null,
					"Ezin dituzu berriz bozkatu, aurten jada egin duzu.", "OOOOOPS",
					JOptionPane.ERROR_MESSAGE);
			break;

		case 2:
			JOptionPane.showMessageDialog(null,
					"Ezin dituzu 3 boto baino gehiago eman.", "OOOOOPS",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
	
}
