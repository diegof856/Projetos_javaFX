package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {
	
	@FXML
	private Button btTest;
	
	public void onBtTestAction() {
		//System.out.println("Clicou no botão!!!");
		Alerts.showAlert("Alert Title", null, "Olá Mundo", AlertType.INFORMATION);
	}
	
	
}
