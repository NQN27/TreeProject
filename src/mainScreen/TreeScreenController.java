package mainScreen;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import node.Node;
import tree.GenericTree;

public class TreeScreenController {
	private Runnable windowCloser ;
	private GenericTree tree;
	//private List<String> keepWork = new List<String>();
    public void setWindowCloser(Runnable windowCloser) {
        this.windowCloser = windowCloser;
    }

    @FXML
    private TextField tfParent;

    @FXML
    private Button btnInsert;

    @FXML
    private TextField tfChild;

    @FXML
    private TextField tfSearch;

    @FXML
    private TextField tfRemove;

    @FXML
    private TextField tfNode;

    @FXML
    private TextField tfUpdate;

    @FXML
    private RadioButton btBFS;

    @FXML
    private ToggleGroup typeTravelsal;

    @FXML
    private RadioButton btDFS;

    @FXML
    private AnchorPane treeBoard;

    @FXML
    void btnBack(ActionEvent event) {

    }

    @FXML
    void btnBackMenu(ActionEvent event) {
    	new MainScreen();
    	this.windowCloser.run();
    	
    }

    @FXML
    void btnContinue(ActionEvent event) {

    }

    @FXML
    void btnNext(ActionEvent event) {

    }

    @FXML
    void btnPause(ActionEvent event) {

    }

    @FXML
    void btnQuit(ActionEvent event) {
    	this.windowCloser.run();
    }

    @FXML
    void btnRedo(ActionEvent event) {

    }

    @FXML
    void btnRemove(ActionEvent event) {

    }

    @FXML
    void btnSearch(ActionEvent event) {

    }

    @FXML
    void btnStart(ActionEvent event) {

    }

    @FXML
    void btnUndo(ActionEvent event) {
    
    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }

}
