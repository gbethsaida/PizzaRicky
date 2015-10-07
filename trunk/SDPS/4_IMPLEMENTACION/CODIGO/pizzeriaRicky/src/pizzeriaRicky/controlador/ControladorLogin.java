package pizzeriaRicky.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pizzeriaRicky.modelo.Empleado;

public class ControladorLogin implements Initializable{
	@FXML private TextField txtUsuario;
	@FXML private PasswordField lblpass;
	@FXML private Button btnEntrar;
	@FXML private Button btnCerrar;
	@FXML private Label lblMensaje;
	public Empleado EmpleadoActual=null;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblMensaje.setText("");
	}
	
	public void Validar() throws Exception{
		try{
			if(this.txtUsuario.getText().trim().length()>0){
				if(this.lblpass.getText().trim().length()>0){					
						lblMensaje.setText("");
						Empleado oEmpleado = new Empleado();
						oEmpleado.setUsuario(this.txtUsuario.getText());
						oEmpleado.setClave(this.lblpass.getText().toString().trim());
						EmpleadoActual=oEmpleado.Validar();
						if(EmpleadoActual==null){
							lblMensaje.setText("Credenciales no validas.");
						}else{
							Stage stage = (Stage) btnCerrar.getScene().getWindow();
						    stage.hide();
						}
						oEmpleado=null;
				}else{
					throw new Exception("Favor de ingresar la clave.");
				}
			}else{
				throw new Exception("Favor de ingresar el usuario.");
			}		
		}catch(Exception e){
			lblMensaje.setText(e.getMessage());
		}
	}
	
	public void Cerrar() throws Throwable{
		Stage stage = (Stage) btnCerrar.getScene().getWindow();
	    stage.close();
	}

}
