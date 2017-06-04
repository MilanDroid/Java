package modelo;

public class Carrera {

	private int id;
	private String nombreCarrera;
	private String duracionCarrera;

	public Carrera(){

	}

	public Carrera(int id, String nombreCarrera, String duracionCarrera){
		this.id = id;
		this.nombreCarrera = nombreCarrera;
		this.duracionCarrera = duracionCarrera;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public String getDuracionCarrera() {
		return duracionCarrera;
	}
	public void setDuracionCarrera(String duracionCarrera) {
		this.duracionCarrera = duracionCarrera;
	}
}
