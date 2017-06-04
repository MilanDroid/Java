package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class NoAutorizadoController implements Initializable {

	private Main main;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void salir(){
		System.exit(0);
	}
	@FXML
	public void volver(){
		main.volverLogin();
	}
	public void setMain(Main main){
		this.main = main;
	}

	public Main getMain(){
		return main;
	}
}
