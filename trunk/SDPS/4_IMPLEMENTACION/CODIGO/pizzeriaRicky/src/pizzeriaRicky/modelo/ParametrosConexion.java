package pizzeriaRicky.modelo;

import java.io.FileInputStream;
import java.util.Properties;

public class ParametrosConexion {
	String ip;
	String puerto;
	String baseDatos;
	String usuario;
	String contrasenia;
	String PATH = System.getProperty("user.dir");
	
	public String getIp() {
		return ip;
	}

	public String getPuerto() {
		return puerto;
	}

	public String getBaseDatos() {
		return baseDatos;
	}
 
	public String getUsuario() {
		return usuario;
	}
	 
	public String getContrasenia() {
		return contrasenia;
	}
	
	public void asignarParametros(){
		try {
			Properties propiedades = new Properties(); 
			PATH=PATH+"/src/pizzeriaRicky/modelo/propiedades.conexion";
			FileInputStream entrada = new FileInputStream(PATH);
			propiedades.load(entrada);
			contrasenia = propiedades.getProperty("CONTRASENIA");
			usuario = propiedades.getProperty("USUARIO");
			baseDatos = propiedades.getProperty("BASEDATOS");
			ip = propiedades.getProperty("IP");
			puerto = propiedades.getProperty("PUERTO");			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}