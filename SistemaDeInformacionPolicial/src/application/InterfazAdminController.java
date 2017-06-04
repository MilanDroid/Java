package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelo.Sip;

public class InterfazAdminController implements Initializable{

	@FXML private Label lblInfo;
	@FXML private Label lblPermisos;

	private Main main;
	private Sip sip;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void imprimir(){
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void llenarPantalla(Sip sip){

	}

	public void comprobarSip(){
		if(sip != null){
			System.out.println("InAdmin no esta vacia. Fuck Yeah!");
		lblInfo.setText("- Nombre de Usuario : "+ sip.getUsuario().getUsuario());
		}
		else{
			System.out.println("InAdmin esta vacia. Fuck!");
		}
	}

	public Sip getSip() {
		return sip;
	}

	public void setSip(Sip sip) {
		this.sip = sip;
	}
}
