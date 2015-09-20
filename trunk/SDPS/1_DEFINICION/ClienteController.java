package com.alda.controlador;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.alda.facilito.ControladorVentana;
import com.alda.facilito.IControladorVentana;
import com.alda.modelo.Cliente;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteController<Employee> implements IControladorVentana,Initializable {
	@FXML private Button btnGuardar;
	@FXML private Button btnNuevo;
	@FXML private Button btnEliminar; 
	@FXML private TextField txtNombre;
	@FXML private TextField txtAP;
	@FXML private TextField txtAM;
	@FXML private Label lblMensaje;
	@FXML private Label lblRegistros;
	
	@FXML private ComboBox<String> cboSexo;
	
	Cliente clienteSeleccionado = null;
	ControladorVentana miControlador;
	
	@FXML private TableView<Cliente> tvClientes;
	
	public void Limpiar(){
		txtNombre.setText("");
		txtAP.setText("");
		txtAM.setText("");
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub 
		try{
			LlenarCombo();
			llenarTabla();
			
		}catch(Exception e{
			System.out.println(e.getMessage());
		}
	}

	private void LlenarCombo(){
		
	}
	
	
	public void Actualizar() throws ClassNotFoundException, InstantiationException, 
	InstantiationException, SQLException, Exception
	{
		if(clienteSeleccionado!=null)
		{
			Cliente nuevo = new Cliente();
			nuevo.Guardar();
		}else{
		//	empleadoSeleccionado.setNombre(txtNombre.getText);
		}
	}
	
	public void Eliminar()
	{
		System.out.println("Voy a eliminar");
		
		if(clienteSeleccionado!=null)
		{
			System.out.println("listo");
			try {
				clienteSeleccionado.Eliminar();
				lblMensaje.setText("El empleado ah sido eliminado");
				llenarTabla();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				lblMensaje.setText("No se encontro la clase");
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				lblMensaje.setText("No se pudo instanciar");
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				lblMensaje.setText("No se pudo acceder");
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				lblMensaje.setText("Error en query");
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				lblMensaje.setText("Pos no se chavo");
				e.printStackTrace();
			}
			
		}else{
			lblMensaje.setText("Debes seleccionar un empleado");
		}
	}
	
	
	public void Save() throws ClassNotFoundException, InstantiationException, 
	InstantiationException, SQLException, Exception{

		
		
			if(!txtNombre.getText().trim().isEmpty()){
				txtAP.focusTraversableProperty();
				
				if(!txtAP.getText().trim().isEmpty()){
					if(!txtAM.getText().trim().isEmpty()){
							
								
											Cliente nuevo= new Cliente(0, txtNombre.getText(), txtAP.getText(),
													txtAM.getText());
											lblMensaje.setText("El formulario se a enviado correctamente");
											nuevo.Guardar();
											llenarTabla();
											Limpiar();


														 }else{
															 lblMensaje.setText("Seleccione un tipo de usuario.");
														 }
													}else{
														lblMensaje.setText("Clave incorrecta.");
													}
												}else{
													lblMensaje.setText("Confirma la clave.");
												}
											
										
		

		
		}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void llenarTabla() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, Exception{
		tvClientes.getItems().clear();
		List<Cliente> lst;
		Cliente obj = new Cliente();
		lst = obj.Listar();
		
		   
				
		TableColumn colNombre = new TableColumn("Nombre");
		colNombre.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
		colNombre.setMinWidth(140);
		
		TableColumn colAP = new TableColumn("A.Paterno");
		colAP.setCellValueFactory(new PropertyValueFactory<Employee, String>("LastName"));
		
		TableColumn colAM = new TableColumn("A.Materno");
		colAM.setCellValueFactory(new PropertyValueFactory<Employee, String>("SecondLastName"));
		
		tvClientes.setOnMouseClicked(new EventHandler() {

			 @Override
			 public void handle(Event arg0) {
			 clienteSeleccionado = tvClientes.getSelectionModel
			().getSelectedItems().get(0);
			 txtNombre.setText(clienteSeleccionado.getnombre());

			
			 txtAP.setText(clienteSeleccionado.getapellidoPaterno());
			 txtAM.setText(clienteSeleccionado.getapellidoMaterno());
			 
			}
			 });
		
		tvClientes.getItems().addAll();
		tvClientes.getColumns().addAll(colNombre, colAP, colAM);
		lblRegistros.setText("Total: "+ lst.size()+ " Registro(s)");
		
	}
	
	//onfocus
	//buscar la cadena de conexion para posgres
	
	public void Buscar() throws ClassNotFoundException,
	InstantiationException, IllegalAccessException, SQLException,
	Exception {
		Cliente consulta = new Cliente();
		consulta.Buscar(10);
	}
	@Override
	public void asignarVentanaPrincipal(ControladorVentana paginaInterna) {
		miControlador=paginaInterna;
	}
	
	 
	

}
