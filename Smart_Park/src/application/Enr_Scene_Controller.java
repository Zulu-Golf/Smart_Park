package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

public class Enr_Scene_Controller implements Initializable {

	public Enr_Scene_Controller() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	private void exitProgramAction(MouseEvent exitProgramEvent) {        
	    System.out.println("Killing program...");
	    System.exit(0);
	}

}
