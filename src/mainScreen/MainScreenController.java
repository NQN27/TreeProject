package mainScreen;


import exception.MinusValueNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import node.Node;
import tree.BalanceTree;
import tree.BinaryTree;
import tree.GenericTree;

public class MainScreenController {
    private Runnable windowCloser ;

    public void setWindowCloser(Runnable windowCloser) {
        this.windowCloser = windowCloser;
    }
    @FXML
    private RadioButton btnGT;

    @FXML
    private ToggleGroup TypeTree;

    @FXML
    private RadioButton btnBiT;

    @FXML
    private RadioButton btnBaT;

    @FXML
    private RadioButton btnBaBiT;

    @FXML
    private TextField rootTextbox;

    @FXML
    private HBox Box;

    @FXML
    private TextField diffTextBox;

    @FXML
    private VBox helpBox;

    @FXML
    void pressCreateTree(ActionEvent event) {
    	if (btnGT.isSelected()) {
    		Node root;
			try {
				root = new Node(Integer.parseInt(this.rootTextbox.getText()));
	    		GenericTree tree = new GenericTree(root);
	    		new TreeScreen(tree);
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (MinusValueNode e) {

				e.printStackTrace();
			}

    		//new sceneGenericTree(tree);
    	}
    	if (this.btnBiT.isSelected()) {
    		Node root;
			try {
				root = new Node(Integer.parseInt(this.rootTextbox.getText()));
	    		BinaryTree tree = new BinaryTree(root);
	    		new TreeScreen(tree);
			} catch (NumberFormatException e) {

				e.printStackTrace();
			} catch (MinusValueNode e) {

				e.printStackTrace();
			}

    		//new sceneBinaryTree(tree);
    	}
    	if (this.btnBaT.isSelected()) {
    		Node root;
			try {
				root = new Node(Integer.parseInt(this.rootTextbox.getText()));
	    		Integer diff = Integer.parseInt(this.diffTextBox.getText());
	    		BalanceTree tree = new BalanceTree(root,diff);
	    		new TreeScreen(tree);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MinusValueNode e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		//new sceneBalancedTree(tree);
    	}
    	if (this.btnBaBiT.isSelected()) {
    		Node root;
			try {
				root = new Node(Integer.parseInt(this.rootTextbox.getText()));
	    		Integer diff = Integer.parseInt(this.diffTextBox.getText());
	    		BalanceTree tree = new BalanceTree(root,diff);
	    		
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MinusValueNode e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    		//new sceneBalancedBinaryTree(tree);
    	}
    	this.windowCloser.run();
    }

    @FXML
    void pressHelp(ActionEvent event) {
    	if (!helpBox.isVisible()) {
    		helpBox.setVisible(true);}
    	else {helpBox.setVisible(false);}
    }

    @FXML
    void pressQuit(ActionEvent event) {
    	this.windowCloser.run();
    }
    
    @FXML
    void pressGT(ActionEvent event) {
    	this.Box.setVisible(false);
    }
    
    @FXML
    void pressBiT(ActionEvent event) {
    	this.Box.setVisible(false);
    }
    
    @FXML
    void pressBaT(ActionEvent event) {
    	this.Box.setVisible(true);
    }
    
    @FXML
    void pressBaBiT(ActionEvent event) {
    	this.Box.setVisible(true);
    }
}
