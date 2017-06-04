package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Alumno;
import modelo.Carrera;
import modelo.Conexion;

public class RegistroPersonaController implements Initializable {

	@FXML private ComboBox<String> cboEdad;
	@FXML private ComboBox<Carrera> cboCarrera;

	@FXML private TextField txtNombre;
	@FXML private TextField txtApellido;

	@FXML private Button btnNuevo;
	@FXML private Button btnGuardar;
	@FXML private Button btnActualizar;
	@FXML private Button btnEliminar;

	@FXML private TableView<Alumno> tblAlumnos;
	@FXML private TableColumn<Alumno, String> clmnNombre;
	@FXML private TableColumn<Alumno, String> clmnApellido;
	@FXML private TableColumn<Alumno, Number> clmnEdad;
	@FXML private TableColumn<Alumno, Carrera> clmnCarrera;


	private ObservableList<Alumno> alumnos;
	private ObservableList<String> listaEdades;
	private ObservableList<Carrera> listaCarreras;

	private Conexion conexion;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}

