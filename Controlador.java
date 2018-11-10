package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controlador {

	@FXML
	private Label result;

	@FXML
	private Label Resultado;

	@FXML
	private TextField num1;
	
	@FXML
	private TextField num3;

	@FXML
	private TextField num2;

	@FXML
	private Button calcular;
	
	public void calculo(ActionEvent event) {
	
		int numero1 = Integer.parseInt(num1.getText());
		int numero2 = Integer.parseInt(num2.getText());
		int numero3 = Integer.parseInt(num3.getText());
		int resultado = numero1 + numero2 + numero3;
		result.setText(resultado + "");

	}

}
