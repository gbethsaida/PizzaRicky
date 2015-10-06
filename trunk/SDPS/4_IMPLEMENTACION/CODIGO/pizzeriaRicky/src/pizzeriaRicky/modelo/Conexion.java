package pizzeriaRicky.modelo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	public Connection conexion=null;
	public Statement un_st=null;
	public DatabaseMetaData dbmd;
	public String un_sql;
	public ResultSet resultado=null;
	
	public Conexion() throws ClassNotFoundException, SQLException{
		ParametrosConexion op = new ParametrosConexion();
		op.asignarParametros();
		System.out.println("jdbc:postgresql://"+op.getIp()+":"+op.getPuerto()+"/"+op.getBaseDatos()+","+op.getUsuario()+","+op.getContrasenia());
		Class.forName("org.postgresql.Driver");
		try{
			conexion=DriverManager.getConnection("jdbc:postgresql://"+op.getIp()+":"+op.getPuerto()+"/"+op.getBaseDatos()+"",""+op.getUsuario()+"",""+op.getContrasenia()+"");			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		
		dbmd=conexion.getMetaData();
		un_st=conexion.createStatement();
	}
	
	public void desconectar(){
        try{
            conexion.close();
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}