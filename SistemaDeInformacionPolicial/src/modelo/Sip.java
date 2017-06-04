package modelo;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sip {

	private IntegerProperty idSesion;
	private Usuario cod_usuario;
	private StringProperty informacion;


	public Sip(){

	}

	public Sip(int id, Usuario usuario, String info){
		this.idSesion = new SimpleIntegerProperty(id);
		this.cod_usuario = usuario;
		this.informacion = new SimpleStringProperty(info);
	}

	public int getIdSesion() {
		return idSesion.get();
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = new SimpleIntegerProperty(idSesion);
	}

	public Usuario getUsuario() {
		return cod_usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.cod_usuario = usuario;
	}

	public String getInformacion() {
		return informacion.get();
	}

	public void setInformacion(String informacion) {
		this.informacion = new SimpleStringProperty(informacion);
	}

	@Override
	public String toString(){
		return cod_usuario.getUsuario()+ "\t\t"
				+informacion.get();
	}

	public int iniciarSesion(Conexion conexion){
		try {
			PreparedStatement ps = conexion.getConexion().prepareStatement(
					"INSERT INTO tbl_sip ( " +
							"codigo_usuario, " +
							"informacion_consultada " +
						") VALUES (?, ?)"
							);
			ps.setInt(1, cod_usuario.getCod_usuario());
			ps.setString(2, informacion.get());
			System.out.println("Insertado en la base de datos"+" "+cod_usuario.getUsuario());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

	}
}
