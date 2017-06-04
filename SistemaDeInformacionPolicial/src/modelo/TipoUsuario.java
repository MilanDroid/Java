package modelo;

public class TipoUsuario {

	private int codTipoUsuario;
	private String tipoUsuario;
	private String permisos;

	public TipoUsuario(){

	}

	public TipoUsuario(int cod, String tipo, String permisos){
		this.codTipoUsuario = cod;
		this.tipoUsuario = tipo;
		this.permisos = permisos;
	}

	public int getCodTipoUsuario() {
		return codTipoUsuario;
	}
	public void setCodTipoUsuario(int codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}

	public String toString(){
		return tipoUsuario + "\t\t" +permisos;
	}
}
