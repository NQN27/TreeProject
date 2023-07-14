package mainScreen;


import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import exception.MinusValueNode;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import node.Node;
import tree.GenericTree;

public class MainScreen extends JFrame{
	public MainScreen() {

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
	    Runnable windowCloser = () -> SwingUtilities.invokeLater(
	            () -> this.dispose()
	        );
		this.setTitle("Main Screen");
		this.setSize(1600, 1024);
		this.setVisible(true);
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("Screen.fxml"));
					MainScreenController controller = new MainScreenController();
					controller.setWindowCloser(windowCloser);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String arg[]) {
		Node root;
		try {
			root = new Node(1);
			GenericTree tree = new GenericTree(root);
			new MainScreen();
		} catch (MinusValueNode e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	// TODO Auto-generated constructor stub
}

