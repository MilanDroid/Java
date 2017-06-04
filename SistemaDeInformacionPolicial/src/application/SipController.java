package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Conexion;
import modelo.Sip;

public class SipController implements Initializable{

	@FXML private Button btnSalir;
	@FXML private Button btnEntrar;

	@FXML private TextField txtUsuario;
	@FXML private TextField txtContrasena;

	private int idTipo;

	private Main main;
	private Conexion conexion;
	private Sip sip;

	@FXML
	public void salir(){
		System.exit(0);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		conexion = new Conexion();
	}

	@FXML
	public void comprobarLogin(){
		conexion.establecerConexion();
		if(conexion.Login(txtUsuario.getText(), txtContrasena.getText())==1){

			System.out.println(" Todo bien /._./");
			conexion.cerrarConexion();
			idTipo = conexion.getIdTipo();
			interfazSeleccion();
		}
		else{
			System.out.println("No encontrado");
			main.noAutorizadoScene();
			conexion.cerrarConexion();
		}


	}

	public void interfazSeleccion(){
		if(idTipo == 1){
			main.rootInterfaz();
		}
		if(idTipo == 2){
			main.adminInterfaz();
		}
		if(idTipo == 3){
			main.policeInterfaz();
		}

		if(idTipo==0){
			System.out.println("FCK U.U");
		}
	}

	@FXML
	public void btnDetecion(){
		btnSalir.setGraphic(new ImageView(
						new Image(getClass().getResourceAsStream("../Recursos/btnSelected.png"))
						));
	}


	public String obtenerInformacion(){
		String info = "";
		return info;
	}

	@FXML
	public void error(){
		main.noAutorizadoScene();
	}

	public void setMain(Main main){
		this.main = main;
	}

	public Main getMain(){
		return main;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

	public Sip getSip() {
		return sip;
	}

	public void setSip(Sip sip) {
		this.sip = sip;
		System.out.println("Comprobando si SIP en SipC esta vacia, usuario? ====>> "+sip.getUsuario().getUsuario());
	}
}
