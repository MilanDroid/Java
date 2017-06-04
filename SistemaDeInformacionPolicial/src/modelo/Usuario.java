package modelo;

public class Usuario extends Persona{

	private int cod_usuario;
	private String usuario;
	private String pass;
	private TipoUsuario cod_tipoUsuario;
	private Persona persona;

	public Usuario(){

	}

	public Usuario(int cod, String usuario, String pass, TipoUsuario tipoUsuario, Persona persona){
		this.cod_usuario = cod;
		this.usuario = usuario;
		this.pass = pass;
		this.cod_tipoUsuario = tipoUsuario;
		this.persona = persona;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getCod_usuario() {
		return cod_usuario;
	}

	public void setCod_usuario(int cod_usuario) {
		this.cod_usuario = cod_usuario;
	}

	public TipoUsuario getTipoUsuario() {
		return cod_tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.cod_tipoUsuario = tipoUsuario;
	}

	@Override
	public String toString(){
		return usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
}
