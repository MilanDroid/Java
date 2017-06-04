package modelo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import application.Main;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Conexion {

	private Connection conexion;
	private String db = "db_sip";
	private String url = "jdbc:mysql://localhost/"+db;
	private String user = "root";
	private String pass = "";

	private int idTipo;

	private Sip sip;
	private Main main;
	private Conexion connect;

	public Conexion(){
		establecerConexion();
	}

	public void establecerConexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int Login(String user, String contrasena){
		InputStream inputStream;
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery("SELECT "
					+ "A.codigo_usuario, "
					+ "A.nombre_usuario, "
					+ "A.contraseña, "
					+ "A.codigo_tipoUsuario, "
					+ "B.tipo_Usuario, "
					+ "A.cod_persona, "
					+ "C.nombre_persona, "
					+ "C.apellido_persona, "
					+ "C.genero_persona, "
					+ "C.edad_persona, "
					+ "C.identidad_persona, "
					+ "C.fotografia_persona, "
					+ "C.color_ojos, "
					+ "C.color_cabello, "
					+ "C.color_piel, "
					+ "C.estatura, "
					+ "C.otros_detalles "
					+ "FROM tbl_usuario A "
					+ "INNER JOIN tbl_tipousuario B "
					+ "ON (A.codigo_tipoUsuario = B.codigo_tipoUsuario) "
					+ "INNER JOIN tbl_persona C "
					+ "ON (A.cod_persona = C.cod_persona)");
			while(resultado.next()){

				if(resultado.getString("nombre_usuario").equals(user)&&resultado.getString("contraseña").equals(contrasena)){
					System.out.println("Ingresado, los datos son correctos.");
					String permisos = "";
					if(resultado.getInt("codigo_tipoUsuario")==1){
						permisos =
								"-Agregar Policias, Administradores e informacion."+ "\n"
										+"-Editar Informacion en general y usuarios."+"\n"
											+"Eliminar usuarios y registros.";
					}
					if(resultado.getInt("codigo_tipoUsuario")==2){
						permisos =
								"-Agregar Policias e informacion."+ "\n"
										+"-Editar Informacion en general."+"\n"
											+"-Eliminar usuarios y registros.";
					}
					if(resultado.getInt("codigo_tipoUsuario")==3){
						permisos = "-Ver informacion de los registros.";
					}
				inputStream = resultado.getBinaryStream("fotografia_persona");
				Image imagen = null;
				if(inputStream!=null){
					BufferedImage bimage = ImageIO.read(inputStream);
			        WritableImage writableImage = new WritableImage(bimage.getWidth(), bimage.getHeight());
			        imagen = SwingFXUtils.toFXImage(bimage,writableImage);
		        }
					sip = new Sip(
							0,
							new Usuario(
									resultado.getInt("codigo_usuario"),
									resultado.getString("nombre_usuario"),
									resultado.getString("contraseña"),
									new TipoUsuario(
											resultado.getInt("codigo_tipoUsuario"),
											resultado.getString("tipo_Usuario"),
											permisos
											),
									new Persona(
											resultado.getInt("cod_persona"),
											resultado.getString("nombre_persona"),
											resultado.getString("apellido_persona"),
											resultado.getString("genero_persona"),
											resultado.getDate("edad_persona"),
											resultado.getInt("identidad_persona"),
											imagen,
											resultado.getString("color_ojos"),
											resultado.getString("color_cabello"),
											resultado.getString("color_piel"),
											resultado.getInt("estatura"),
											resultado.getString("otros_detalles")
											)),
							"");

					idTipo = resultado.getInt("codigo_tipoUsuario");
					System.out.println("ID de la sesion : "+sip.getIdSesion()+"\t\t"+"Codigo del usuario : "+ sip.getUsuario().getCod_usuario()
							+"\t\t"+"Usuario: "+sip.getUsuario().getUsuario()+"\t\t"+"Contraseña del usuario : "+sip.getUsuario().getPass()+
							"\t\t"+"ID tipo de usuario :"+sip.getUsuario().getTipoUsuario().getCodTipoUsuario()+"\t\t"+"Tipo usuario : "+sip.getUsuario().getTipoUsuario().getTipoUsuario()
							+"\t\t"+"Permisos del usuario :"+sip.getUsuario().getTipoUsuario().getPermisos()+"\t\t"+"Informacion consultada por el usuario : "+sip.getInformacion()
							);
					connect = new Conexion();
					if(sip.iniciarSesion(connect)==1){
						main = new Main();
						main.setUsuario(sip);
						return 1;
					}
				}
			};
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}


	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public int getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

}
