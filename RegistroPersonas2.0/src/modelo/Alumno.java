package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Alumno {

	private IntegerProperty id_alumno;
	private StringProperty nombre;
	private StringProperty apellido;
	private IntegerProperty edad;
	private Carrera carrera;

	public Alumno(){

	}

	public Alumno(String nombre, String apellido, int edad, Carrera carrera){
		this.nombre = new SimpleStringProperty(nombre);
		this.apellido = new SimpleStringProperty(apellido);
		this.edad = new SimpleIntegerProperty(edad);
		this.carrera = carrera;
	}

	public Alumno(int id_alumno, String nombre, String apellido, int edad, Carrera carrera){
		this.id_alumno = new SimpleIntegerProperty(id_alumno);
		this.nombre = new SimpleStringProperty(nombre);
		this.apellido = new SimpleStringProperty(apellido);
		this.edad = new SimpleIntegerProperty(edad);
		this.carrera = carrera;
	}

	public int getId_alumno(){
		return id_alumno.get();
	}

	public void setId_alumno(int id_alumno){
		this.id_alumno = new SimpleIntegerProperty(id_alumno);
	}

	public String getNombre() {
		return nombre.get();
	}

	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}

	public String getApellido() {
		return apellido.get();
	}

	public void setApellido(String apellido) {
		this.apellido = new SimpleStringProperty(apellido);
	}

	public int getEdad() {
		return edad.get();
	}

	public void setEdad(int edad) {
		this.edad = new SimpleIntegerProperty(edad);
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public String toString(){
		return nombre.get() + "\t\t"+
				apellido.get() + "\t\t"+
				edad.get() + "\t\t"+
				carrera.toString();
	}

	public int guardarAlumno(Conexion conexion){
		PreparedStatement p;
		try {
			p = conexion.getConexion().prepareStatement(
					"INSERT INTO tbl_alumnos("
					+ "nombre_alumno"
					+ "apellido_alumno"
					+ "edad_alumno"
					+ "id_carrera"
					+ ") VALUES(?,?,?,?)"
					);
			p.setString(1, nombre.get());
			p.setString(2, apellido.get());
			p.setInt(3, edad.get());
			p.setInt(4, carrera.getId());
			return p.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}
