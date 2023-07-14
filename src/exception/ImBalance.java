package exception;

import javax.swing.JOptionPane;

public class ImBalance extends Exception{
	public ImBalance() {
		JOptionPane.showMessageDialog(null, "Node Value must be Positive Integer", "WARNING", 1);
	}
}
