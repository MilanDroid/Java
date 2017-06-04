package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import modelo.Sip;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private Scene noAutorizadoScene;
	private Scene loginScene;
	private Scene adminScene;
	private Scene rootScene;
	private Scene policeScene;

	private SipController SipController;
	private NoAutorizadoController noAutorizadoController;
	private InterfazAdminController adminController;
	private InterfazRootController rootController;
	private InterfazPoliceControllerr policeController;
	private Sip usuarioSip;

	private Stage formularioPrincipal;

	@Override
	public void start(Stage primaryStage) {
		formularioPrincipal = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Login.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			loginScene = new Scene(root);
			loginScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(loginScene);
			primaryStage.setTitle(null);
			SipController = loader.getController();
			SipController.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void noAutorizadoScene(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("NoAutorizado.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			noAutorizadoScene = new Scene(root);
			formularioPrincipal.setScene(noAutorizadoScene);
			formularioPrincipal.setTitle(null);
			formularioPrincipal.centerOnScreen();
			noAutorizadoController = loader.getController();
			noAutorizadoController.setMain(this);
		} catch(Exception e) {
			e.printStackTrace();
			}
		}
	public void volverLogin(){
		formularioPrincipal.setScene(loginScene);
	}

	public void adminInterfaz(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("InterfazAdministrador.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			adminScene = new Scene(root);
			formularioPrincipal.setScene(adminScene);
			formularioPrincipal.setResizable(false);
			formularioPrincipal.setTitle(null);
			formularioPrincipal.centerOnScreen();
			adminController = loader.getController();
			adminController.setMain(this);
			adminController.llenarPantalla(usuarioSip);
		} catch(Exception e) {
			e.printStackTrace();
			}
		}

	public void rootInterfaz(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("InterfazRoot.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			rootScene = new Scene(root);
			formularioPrincipal.setScene(rootScene);
			formularioPrincipal.setTitle(null);
			formularioPrincipal.centerOnScreen();
			rootController = loader.getController();
			rootController.setMain(this);
		} catch(Exception e) {
			e.printStackTrace();
			}
		}

	public void policeInterfaz(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("InterfazPolice.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			policeScene = new Scene(root);
			formularioPrincipal.setScene(policeScene);
			formularioPrincipal.setTitle(null);
			formularioPrincipal.centerOnScreen();
			policeController = loader.getController();
			policeController.setMain(this);
		} catch(Exception e) {
			e.printStackTrace();
			}
		}

	public static void main(String[] args) {
		launch(args);
	}

	public Sip getUsuarioSip() {
		return usuarioSip;
	}

	public void setUsuario(Sip usuarioSip) {
		this.usuarioSip = usuarioSip;
		System.out.println("Comprobando si SIP en main esta vacia, usuario? ====>> "+usuarioSip.getUsuario().getUsuario());
	}

}
