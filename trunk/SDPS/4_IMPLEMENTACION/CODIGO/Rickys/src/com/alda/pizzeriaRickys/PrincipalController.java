package com.alda.pizzeriaRickys;

import java.net.URL;
import java.util.ResourceBundle;

import com.alda.pizzeriaRickys.Empleado;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrincipalController implements Initializable{
	@FXML private Button btnInicio;
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		btnInicio.setText("");
	}

	/*public void asignarDatos(Empleado objeto){
		lblUsuario.setText(objeto.toString().trim());
	}
	
	public void limpiarDatos(){
		lblUsuario.setText("");
	}*/
}
