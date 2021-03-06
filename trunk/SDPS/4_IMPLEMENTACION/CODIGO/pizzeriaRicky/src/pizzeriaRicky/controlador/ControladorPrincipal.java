package pizzeriaRicky.controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import pizzeriaRicky.modelo.Empleado;

public class ControladorPrincipal implements Initializable{
		@FXML private Label lblEmpleado;
		
		public void initialize(URL arg0, ResourceBundle arg1) {
			lblEmpleado.setText("");
		}

		public void asignarDatos(Empleado objeto){
			lblEmpleado.setText(objeto.toString().trim());
		}
		
		public void limpiarDatos(){
			lblEmpleado.setText("");
		}
	}

