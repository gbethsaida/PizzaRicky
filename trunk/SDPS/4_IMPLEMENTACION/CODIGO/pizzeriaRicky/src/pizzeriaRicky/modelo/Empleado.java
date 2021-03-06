package pizzeriaRicky.modelo;

import java.sql.SQLException;
import java.util.Random;

import pizzeriaRicky.modelo.interfaces.IOpciones;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


	public class Empleado implements IOpciones {
		private final SimpleStringProperty nombre;
		private final SimpleStringProperty apellidoPaterno;
	    private final SimpleStringProperty apellidoMaterno;
	  // private final SimpleIntegerProperty telefono;
	    private final SimpleStringProperty avenida;
	    private final SimpleStringProperty calle;
	    private final SimpleIntegerProperty celular;
	    private final SimpleStringProperty cargo;
	    private final SimpleStringProperty clave;
	    private final SimpleStringProperty usuario;
	    
	    public Empleado(){
	    	this.nombre= new SimpleStringProperty();
	    	this.apellidoPaterno= new SimpleStringProperty();
	    	this.apellidoMaterno= new SimpleStringProperty();
	    	//this.telefono= new SimpleIntegerProperty();
	    	this.avenida= new SimpleStringProperty();
	    	this.calle= new SimpleStringProperty();
	    	this.celular= new SimpleIntegerProperty();
	    	this.cargo= new SimpleStringProperty();
	    	this.clave= new SimpleStringProperty();
	    	this.usuario= new SimpleStringProperty();
	    	
	    }
	    
	    public Empleado (String nombre, String apellidoPaterno, String apellidoMaterno){
	    	this.nombre= new SimpleStringProperty(nombre);
	    	this.apellidoPaterno= new SimpleStringProperty(apellidoPaterno);
	    	this.apellidoMaterno= new SimpleStringProperty(apellidoMaterno);
	    	//this.telefono= new SimpleIntegerProperty(telefono);
	    	this.avenida= new SimpleStringProperty();
	    	this.calle= new SimpleStringProperty();
	    	this.celular= new SimpleIntegerProperty();
	    	this.cargo= new SimpleStringProperty();
	    	this.clave= new SimpleStringProperty();
	    	this.usuario= new SimpleStringProperty();	
	    }
	    
	    public Empleado (String nombre, String apellidoPaterno, String apellidoMaterno, String avenida, String calle, int celular){
	    	this.nombre= new SimpleStringProperty(nombre);
	    	this.apellidoPaterno= new SimpleStringProperty(apellidoPaterno);
	    	this.apellidoMaterno= new SimpleStringProperty(apellidoMaterno);
	    	//this.telefono= new SimpleIntegerProperty(telefono);
	    	this.avenida= new SimpleStringProperty(avenida);
	    	this.calle= new SimpleStringProperty(calle);
	    	this.celular= new SimpleIntegerProperty(celular);
	    	this.cargo= new SimpleStringProperty();
	    	this.clave= new SimpleStringProperty();
	    	this.usuario= new SimpleStringProperty();
	    	
	    }
	    
	    public void setNombre(String nombre){
	    	this.nombre.set(nombre.trim());
	    }
	    
	    public String getNombre(){
			return this.nombre.get();
		}
	    
	    public void setApellidoPaterno(String apellidoPaterno){
			this.apellidoPaterno.set(apellidoPaterno.trim());
			
		}
		
		public String getApellidoPaterno(){
			return this.apellidoPaterno.get();
		}
		
		public void setApellidoMaterno(String apellidoMaterno){
			this.apellidoMaterno.set(apellidoMaterno.trim());
		}
		
		public String getApellidoMaterno(){
			return this.apellidoMaterno.get();
		}
		
		/*public void setTelefono(int telefono){
			this.telefono.set(telefono);
		}
		
		public int getTelefono(){
			return this.telefono.get();
		}*/
		
		public void setAvenida(String avenida){
			this.avenida.set(avenida);
		}
		
		public String getAvenida(){
			return this.avenida.get().trim();
		}
		
		public void setCalle(String calle){
			this.calle.set(calle);
		}
		
		public String getCalle(){
			return this.calle.get().trim();
		}
		
		public void setCelular(int celular){
			this.celular.set(celular);
		}
		
		public int getCelular(){
			return this.celular.get();
		}
		
		public void setCargo(String cargo){
			this.cargo.set(cargo);
		}
		
		public String getCargo(){
			return this.cargo.get();
		}
		
		public void setClave(String contrasenia){
			this.clave.set(contrasenia);
		}
		
		public String getClave(){
			return this.clave.get();
		}
		
		public void setUsuario(String usuario){
			this.usuario.set(usuario);
		}
		
		public String getUsuario(){
			return this.usuario.get();
		}
		
		public String toString(){
			return this.nombre.get()+" "+this.apellidoPaterno.get()+" "+this.apellidoMaterno.get();
		}
		
		public boolean Eliminar() throws ClassNotFoundException,
				InstantiationException, IllegalAccessException, SQLException,
				Exception {
			Conexion cdb=new Conexion();
			cdb.un_sql="update empleados set activo='n' where id_empleado="+ this.cargo.get();
			cdb.un_st.execute(cdb.un_sql);
			
			cdb.desconectar();
			return true;
		}

		public Empleado Validar()throws SQLException, Exception, ClassNotFoundException{
			Empleado obj = null;
			Conexion cdb = new Conexion(); 
			cdb.un_sql="select cargo, nombre, apellido_paterno,"
					+ " apellido_materno from empleados "
					+ " where usuario='"+this.getUsuario()+"'"
					+ " and contrasenia='"+this.getClave()+"'";
			cdb.resultado=cdb.un_st.executeQuery(cdb.un_sql);
			while(cdb.resultado.next()){
				obj = new Empleado(
						cdb.resultado.getString("nombre"),
						cdb.resultado.getString("apellido_paterno"),
						cdb.resultado.getString("apellido_materno"));
						//cdb.resultado.getInt("telefono"));
				}
			cdb.desconectar();	
			return obj;
			}

		public boolean Actualizar(Object E) throws ClassNotFoundException,
				InstantiationException, IllegalAccessException, SQLException,
				Exception {
			
			Conexion cdb=new Conexion();
			cdb.un_sql="update empleados set nombre='"+this.getNombre()+"',"
					+ "apellido_paterno='"+this.getApellidoPaterno()+"',"
					+ "apellido_materno='"+this.getApellidoMaterno()+"',"
					
					+ "usuario='"+this.getAvenida()+"',"
					+ "contrasenia='"+this.getCalle()+"',"
					+ "tipo='"+this.getCelular()+"' where id_empleado="+ this.cargo.get();
			cdb.un_st.execute(cdb.un_sql);
			
			cdb.desconectar();
			
			return true;
			
		}

		public boolean Guardar() throws ClassNotFoundException,
				InstantiationException, IllegalAccessException, SQLException,
				Exception {
	Random rnd = new Random();
			
			String query ="insert into empleados (id_empleado, nombre, apellido_paterno,";
			query+="apellido_materno,telefono,avenida,calle,celular,cargo) values(";
			query+="'"+rnd.nextInt(100)+"',";
			query+="'"+this.nombre.get().trim()+"',";
			query+="'"+this.apellidoPaterno.get().trim()+"',";
			query+="'"+this.apellidoMaterno.get().trim()+"',";
			
			query+="'"+this.avenida.get().trim()+"',";
			query+="'"+this.calle.get().trim()+"',";
			query+="'"+this.cargo.get().trim()+"',";
			query+="'s'";
			query+=");";
			
			Conexion cdb = new Conexion();
			cdb.un_sql=query;
			cdb.un_st.execute(cdb.un_sql);
			cdb.desconectar();
			return true;
		}

		@Override
		public Object Buscar(String clave) throws ClassNotFoundException,
				InstantiationException, IllegalAccessException, SQLException,
				Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
		
	}
