package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Pessoa;

public class ViewController implements Initializable {

	@FXML
	private ComboBox<Pessoa> comboBoxPessoa;
	
	@FXML
	private Button btAll;

	private ObservableList<Pessoa> obsList;
	
	public void onBtAllAction() {
		for(Pessoa p:this.comboBoxPessoa.getItems()) {
			System.out.println(p);
		}
	}
	
	@FXML
	public void onComboBoxPessoaAction() {
		Pessoa pessoa = this.comboBoxPessoa.getSelectionModel().getSelectedItem();
		System.out.println(pessoa);
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		List<Pessoa> lista = new ArrayList<>();
		lista.add(new Pessoa(1, "diego", "diego@hotmail.com"));
		lista.add(new Pessoa(2, "gabriel", "gabriel@hotmail.com"));
		lista.add(new Pessoa(3, "felipe", "felipe@gmail.com"));

		this.obsList = FXCollections.observableList(lista);
		this.comboBoxPessoa.setItems(obsList);

		Callback<ListView<Pessoa>, ListCell<Pessoa>> factory = lv -> new ListCell<Pessoa>() {
			@Override
			protected void updateItem(Pessoa item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		this.comboBoxPessoa.setCellFactory(factory);
		this.comboBoxPessoa.setButtonCell(factory.call(null));

	}

}
