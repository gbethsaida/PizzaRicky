package com.alda.pizzeriaRickys;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.alda.pizzeriaRickys.Empleado;

public class LoginController implements Initializable{
	//@FXML private TextField txtUsuario;
	@FXML private PasswordField txtClave;
	@FXML private Button btnIniciar;
	//@FXML private Button btnCerrar;
	//@FXML private Label lblMensaje;
	public Empleado EmpleadoActual=null;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		//lblMensaje.setText("");
	}
	
	public void Validar() throws Exception{
		try{
			//if(this.txtUsuario.getText().trim().length()>0){
				if(this.txtClave.getText().trim().length()>0){					
						//lblMensaje.setText("");
						Empleado oEmpleado = new Empleado();
						//oEmpleado.setUsuario(this.txtUsuario.getText());
						oEmpleado.setClave(this.txtClave.getText());
						EmpleadoActual=oEmpleado.Validar();
						if(EmpleadoActual==null){
							//lblMensaje.setText("Credenciales no validas.");
						}else{
							//Stage stage = (Stage) btnCerrar.getScene().getWindow();
						   // stage.hide();
						}
						oEmpleado=null;
				}else{
					throw new Exception("Favor de ingresar la clave.");
				}
			//}else{
				throw new Exception("Favor de ingresar el usuario.");
			//}		
		}catch(Exception e){
			//lblMensaje.setText(e.getMessage());
		}
	}
	
	public void Cerrar() throws Throwable{
		//Stage stage = (Stage) btnCerrar.getScene().getWindow();
	   // stage.close();
	}

}
