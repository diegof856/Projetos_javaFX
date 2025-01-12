package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
	@FXML
	private TextField txtNumber1;
	@FXML
	private TextField txtNumber2;
	@FXML
	private Label labelResult;
	
	@FXML
	private Button btMulti;
	
	public void onBtMultiAction() {
		try {
			Locale.setDefault(Locale.US);
			double number1 = Double.parseDouble(this.txtNumber1.getText());
			double number2 = Double.parseDouble(this.txtNumber2.getText());
			double multi = number1 * number2;
			this.labelResult.setText(String.format("%.2f", multi));
		}catch(NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), Alert.AlertType.ERROR);
		}
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumber1);
		Constraints.setTextFieldDouble(txtNumber2);
		
		Constraints.setTextFieldMaxLength(txtNumber1, 5);
		Constraints.setTextFieldMaxLength(txtNumber2, 5);

	}
	
	
}
