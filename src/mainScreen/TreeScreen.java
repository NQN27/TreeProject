package mainScreen;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import tree.GenericTree;

public class TreeScreen extends JFrame{
	private int diff;
	private GenericTree tree;
	public TreeScreen(GenericTree tree) {
		this.tree = tree;
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
					FXMLLoader loader = new FXMLLoader(getClass().getResource("TreeScreen.fxml"));
					TreeScreenController controller = new TreeScreenController();
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

	
		// TODO Auto-generated constructor stub

}
