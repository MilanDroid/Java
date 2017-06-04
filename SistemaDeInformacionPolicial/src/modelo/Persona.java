package modelo;

import java.sql.Date;

import javafx.scene.image.Image;

public class Persona {
	private int codPersona;
	private String nombre;
	private String apellido;
	private String genero;
	private Date fchNacimiento;
	private int identidad;
	private Image imagenPerfil;
	private String colorOjos;
	private String colorCabello;
	private String colorPiel;
	private int estatura;
	private String otros;

	public Persona(){}

	public Persona(int codPersona, String nombre, String apellido, String genero, Date fchNacimiento,
			int identidad, Image imagenPerfil, String colorOjos, String colorCabello,
			String colorPiel, int estatura, String otros){
		this.codPersona = codPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.fchNacimiento = fchNacimiento;
		this.identidad = identidad;
		this.imagenPerfil = imagenPerfil;
		this.colorOjos = colorOjos;
		this.colorCabello = colorCabello;
		this.colorPiel = colorPiel;
		this.estatura = estatura;
		this.otros = otros;
	}

	public int getCodPersona() {
		return codPersona;
	}
	public void setCodPersona(int cod_persona) {
		this.codPersona = cod_persona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public Date getFchNacimiento() {
		return fchNacimiento;
	}
	public void setFchNacimiento(Date fchNacimiento) {
		this.fchNacimiento = fchNacimiento;
	}
	public int getIdentidad() {
		return identidad;
	}
	public void setIdentidad(int identidad) {
		this.identidad = identidad;
	}
	public Image getImagenPerfil() {
		return imagenPerfil;
	}
	public void setImagenPerfil(Image imagenPerfil) {
		this.imagenPerfil = imagenPerfil;
	}
	public String getColorOjos() {
		return colorOjos;
	}
	public void setColorOjos(String colorOjos) {
		this.colorOjos = colorOjos;
	}
	public String getColorCabello() {
		return colorCabello;
	}
	public void setColorCabello(String colorCabello) {
		this.colorCabello = colorCabello;
	}
	public String getColorPiel() {
		return colorPiel;
	}
	public void setColorPiel(String colorPiel) {
		this.colorPiel = colorPiel;
	}
	public int getEstatura() {
		return estatura;
	}
	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}
	public String getOtros() {
		return otros;
	}
	public void setOtros(String otros) {
		this.otros = otros;
	}
}
