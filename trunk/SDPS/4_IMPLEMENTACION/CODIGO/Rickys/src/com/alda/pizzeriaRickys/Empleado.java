package com.alda.pizzeriaRickys;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import com.alda.pizzeriaRickys.IOpciones;

public class Empleado implements IOpciones {
	
	private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellidoPaterno;
    private final SimpleStringProperty apellidoMaterno;
    private final SimpleStringProperty curp;
    private final SimpleStringProperty tipo;
    private final SimpleStringProperty usuario;
    private final SimpleStringProperty clave;
    private final SimpleIntegerProperty idEmpleado;
	
	
	public Empleado ( String nombre, String apellidoPaterno, 
			String apellidoMaterno,
			String CURP, String usuario, String clave, String tipo){
		this.nombre= new SimpleStringProperty(nombre);
		this.apellidoPaterno= new SimpleStringProperty(apellidoPaterno);
		this.apellidoMaterno= new SimpleStringProperty(apellidoMaterno);
		this.curp= new SimpleStringProperty(CURP);
		this.tipo= new SimpleStringProperty(tipo);
		this.usuario= new SimpleStringProperty(usuario);
		this.clave= new SimpleStringProperty(clave);
		this.idEmpleado=new SimpleIntegerProperty(-1);
	}
	
	public Empleado (int codigo, String nombre, 
			String apellidoPaterno, String apellidoMaterno,
			String CURP, String usuario, String clave, String tipo){
		this.nombre= new SimpleStringProperty(nombre);
		this.apellidoPaterno= new SimpleStringProperty(apellidoPaterno);
		this.apellidoMaterno= new SimpleStringProperty(apellidoMaterno);
		this.curp= new SimpleStringProperty(CURP);
		this.tipo= new SimpleStringProperty(tipo);
		this.usuario= new SimpleStringProperty(usuario);
		this.clave= new SimpleStringProperty(clave);
		this.idEmpleado=new SimpleIntegerProperty(codigo);
	}
	
	public Empleado (int codigo, String nombre, 
			String apellidoPaterno, String apellidoMaterno){
		this.nombre= new SimpleStringProperty(nombre);
		this.apellidoPaterno= new SimpleStringProperty(apellidoPaterno);
		this.apellidoMaterno= new SimpleStringProperty(apellidoMaterno);
		this.curp= new SimpleStringProperty("");
		this.tipo= new SimpleStringProperty("");
		this.usuario= new SimpleStringProperty("");
		this.clave= new SimpleStringProperty("");
		this.idEmpleado=new SimpleIntegerProperty(codigo);
	}
	
	public Empleado(){
		this.nombre= new SimpleStringProperty("");
		this.apellidoPaterno= new SimpleStringProperty("");
		this.apellidoMaterno= new SimpleStringProperty("");
		this.curp= new SimpleStringProperty("");
		this.tipo= new SimpleStringProperty("");
		this.usuario= new SimpleStringProperty("");
		this.clave= new SimpleStringProperty("");
		this.idEmpleado=new SimpleIntegerProperty(-1);
	}
	
	public int getCodigo(){
		return this.idEmpleado.get();
	}
	
	public void setUsuario(String usuario){
		this.usuario.set(usuario);
	}
	
	public String getUsuario(){
		return this.usuario.get().trim();
	}
	
	public void setClave(String clave){
		this.clave.set(clave);
	}
	
	public String getClave(){
		return this.clave.get().trim();
	}
	
	public void setCURP(String curp){
		this.curp.set(curp);
	}
	
	public String getCURP(){
		return this.curp.get().trim();
	}
	
	public void setTipo(String tipo){
		this.tipo.set(tipo);
	}
	
	public String getTipo(){
		return this.tipo.get().trim();
	}
	
	
	public void setNombre(String nombre){
		this.nombre.set(nombre.trim());
	}
	
	public String getNombre(){
		return this.nombre.get().trim();
	}
	
	public void setApellidoPaterno(String apellidoPaterno){
		this.apellidoPaterno.set(apellidoPaterno);
	}
	
	public String getApellidoPaterno(){
		return this.apellidoPaterno.get().trim();		
	}
	
	public void setApellidoMaterno(String apellidoMaterno){
		this.apellidoMaterno.set(apellidoMaterno);
	}
	
	public String getApellidoMaterno(){
		return this.apellidoMaterno.get().trim();
	}
	
	public String toString(){
		return this.nombre.get()+" "+this.apellidoPaterno.get()+" "+this.apellidoMaterno.get();
	}


	public boolean Eliminar() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException,
			Exception {
		
		Conexion cdb=new Conexion();
		cdb.un_sql="update empleado set activo='n' where idempleado="+ this.idEmpleado.get();
		cdb.un_st.execute(cdb.un_sql);
		
		cdb.desconectar();
		
		return true;
	}

	public Object Buscar(int clave) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException,
			Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean Actualizar(Object E) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException,
			Exception {
		
		Conexion cdb=new Conexion();
		cdb.un_sql="update empleado set nombre='"+this.getNombre()+"',"
				+ "apellidopaterno='"+this.getApellidoPaterno()+"',"
				+ "apellidomaterno='"+this.getApellidoMaterno()+"',"
				+ "curp='"+this.getCURP()+"',"
				+ "usuario='"+this.getUsuario()+"',"
				+ "clave='"+this.getClave()+"',"
				+ "tipo='"+this.getTipo()+"' where idempleado="+ this.idEmpleado.get();
		cdb.un_st.execute(cdb.un_sql);
		
		cdb.desconectar();
		
		return true;
	}

	public boolean Guardar() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException, SQLException,
			Exception {
		Random rnd = new Random();
		
		String query ="insert into empleado (idempleado, nombre, apellidoPaterno,";
		query+="apellidoMaterno,curp,usuario,clave,tipo,activo) values(";
		query+="'"+rnd.nextInt(100)+"',";
		query+="'"+this.nombre.get().trim()+"',";
		query+="'"+this.apellidoPaterno.get().trim()+"',";
		query+="'"+this.apellidoMaterno.get().trim()+"',";
		query+="'"+this.curp.get().trim()+"',";
		query+="'"+this.usuario.get().trim()+"',";
		query+="'"+this.clave.get().trim()+"',";
		query+="'"+this.tipo.get().trim()+"',";
		query+="'s'";
		query+=");";
		
		Conexion cdb = new Conexion();
		cdb.un_sql=query;
		cdb.un_st.execute(cdb.un_sql);
		cdb.desconectar();
		return true;
	}
	
	
	 
	public List<Empleado> Listar() throws ClassNotFoundException,
	SQLException{
		Conexion cdb = new Conexion();
		List<Empleado> lst = new ArrayList<Empleado>(); 
		cdb.un_sql="select idempleado, nombre, apellidopaterno,"
				+ " apellidomaterno,curp, usuario, clave, tipo from empleado where activo='s' order by fecha_hora_registro desc";
		cdb.resultado=cdb.un_st.executeQuery(cdb.un_sql);
		while(cdb.resultado.next()){ 
			Empleado obj = new Empleado(
					cdb.resultado.getInt("idempleado"),
					cdb.resultado.getString("nombre"),
					cdb.resultado.getString("apellidopaterno"),
					cdb.resultado.getString("apellidomaterno"),
					cdb.resultado.getString("curp"),
					cdb.resultado.getString("usuario"),
					cdb.resultado.getString("clave"),
					cdb.resultado.getString("tipo"));
			lst.add(obj);
			obj=null;
		}
		cdb.desconectar();	
		return lst;
	}
	
	public Empleado Validar() throws SQLException, Exception, ClassNotFoundException{
		Empleado obj = null;
		Conexion cdb = new Conexion(); 
		cdb.un_sql="select idempleado, nombre, apellidopaterno,"
				+ " apellidomaterno from empleado "
				+ " where usuario='"+this.getUsuario()+"'"
				+ " and clave='"+this.getClave()+"'";
		cdb.resultado=cdb.un_st.executeQuery(cdb.un_sql);
		while(cdb.resultado.next()){ 	
			obj = new Empleado(
				cdb.resultado.getInt("idempleado"),
				cdb.resultado.getString("nombre"),
				cdb.resultado.getString("apellidopaterno"),
				cdb.resultado.getString("apellidomaterno"));
		}
		cdb.desconectar();	
		return obj;
	}
}
