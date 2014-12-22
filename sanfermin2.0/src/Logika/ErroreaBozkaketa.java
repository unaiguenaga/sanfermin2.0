package Logika;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErroreaBozkaketa extends JFrame {

	public ErroreaBozkaketa(int error) {
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