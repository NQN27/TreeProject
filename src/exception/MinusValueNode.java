package exception;
import javax.swing.*;
public class MinusValueNode extends Exception{
	public MinusValueNode() {
		JOptionPane.showMessageDialog(null, "Node Value must be Positive Integer", "WARNING", 0);
	}
}
