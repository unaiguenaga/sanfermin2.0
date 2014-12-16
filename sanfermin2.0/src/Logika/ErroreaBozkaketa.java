package Logika;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErroreaBozkaketa extends JFrame {

	public ErroreaBozkaketa() {
			JOptionPane.showMessageDialog(null,
				"Ezin dituzu 3 boto baino gehiago eman.", "OOOOOPS",
				JOptionPane.ERROR_MESSAGE);
		
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,
				"Ezin dituzu 3 boto baino gehiago eman.", "OOOOOPS",
				JOptionPane.ERROR_MESSAGE);
	}
	
}