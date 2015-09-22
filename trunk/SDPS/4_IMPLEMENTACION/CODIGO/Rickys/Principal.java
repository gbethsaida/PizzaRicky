package com.alda.facilito.view;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.alda.facilito.controller.LoginController;
import com.alda.facilito.controller.PrincipalController;
import com.alda.facilito.model.Empleado;
import com.alda.facilito.view.ControladorVentana;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Principal extends Application{
	ControladorVentana misVentanas=new ControladorVentana();
	PrincipalController controladorPrincipal=null;
	BorderPane contenedor = null;
	public static Empleado EmpleadoActual=null;
	public static String pantallaInicio="Inicio";
	public static String archivoInicio="inicio.fxml";
	
	public static String pantallaClientes="Cliente";
	public static String archivoClientes="clientes.fxml";
	
	public static String pantallaEmpleados="Empleados";
	public static String archivoEmpleados="empleados.fxml";
	
	public static String pantallaCategorias="Catgorias";
	public static String archivoCategorias="categorias.fxml";
	
	public static String pantallaLogin="Login";
	public static String archivoLogin="login.fxml";

	Button btnClose =null;
	Button btnProducts = null;
	Button btnCustomers = null;
	Button btnEmployees = null;
	Button btnCategorias = null;
	Button btnLogin = null;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		misVentanas.cargarPantalla(Principal.pantallaInicio,Principal.archivoInicio);
		misVentanas.cargarPantalla(Principal.pantallaClientes,Principal.archivoClientes);
		misVentanas.cargarPantalla(Principal.pantallaEmpleados,Principal.archivoEmpleados);
		misVentanas.cargarPantalla(Principal.pantallaCategorias,Principal.archivoCategorias);


		misVentanas.mostrarPantalla(Principal.pantallaInicio);
		
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 1000, 700);
		URL location = getClass().getResource("Principal.fxml");
		FXMLLoader fxml = new FXMLLoader(location);
		contenedor = (BorderPane)fxml.load();
		controladorPrincipal = fxml.getController();
		initComponents();
		contenedor.setCenter(misVentanas);
		root.getChildren().add(contenedor);
		primaryStage.centerOnScreen();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void initComponents(){
		contenedor.setLeft(menu());
	}
	
	private VBox menu(){
		VBox mnu = new VBox();
		mnu.setPadding(new Insets(5));
		
		String ruta = System.getProperty("user.dir");
		ruta+="/src/com/alda/facilito/view/icons";
	
		ImageView imgProducts = new ImageView(new Image(new File(ruta+"/productos.png").toURI().toString()));
		imgProducts.setFitWidth(40);
		imgProducts.setFitHeight(40);
		btnProducts = new Button("Productos");
		btnProducts.setGraphic(imgProducts);
		btnProducts.setPrefWidth(150);
		btnProducts.setPrefHeight(50);
		btnProducts.setDisable(true);
		btnProducts.setTooltip(new Tooltip("Productos"));
		
		ImageView imgCategorias = new ImageView(new Image(new File(ruta+"/compras.png").toURI().toString()));
		imgCategorias.setFitWidth(40);
		imgCategorias.setFitHeight(40);
		btnCategorias = new Button("Categorias");
		btnCategorias.setGraphic(imgCategorias);
		btnCategorias.setPrefWidth(150);
		btnCategorias.setPrefHeight(50);
		btnCategorias.setDisable(true);
		btnCategorias.setTooltip(new Tooltip("Categorias"));
		btnCategorias.setOnAction(new btnCategorias_Click());
		
		ImageView imgCustomers = new ImageView(new Image(new File(ruta+"/clientes.png").toURI().toString()));
		imgCustomers.setFitWidth(40);
		imgCustomers.setFitHeight(40);
		btnCustomers = new Button("Clientes");
		btnCustomers.setGraphic(imgCustomers);
		btnCustomers.setPrefWidth(150);
		btnCustomers.setPrefHeight(50);
		btnCustomers.setDisable(true);
		btnCustomers.setTooltip(new Tooltip("Clientes"));
		btnCustomers.setOnAction(new btnClientes_Click());
		
		ImageView imgEmployees = new ImageView(new Image(new File(ruta+"/empleados.png").toURI().toString()));
		imgEmployees.setFitWidth(40);
		imgEmployees.setFitHeight(40);
		btnEmployees = new Button("Empleados");
		btnEmployees.setGraphic(imgEmployees);
		btnEmployees.setPrefWidth(150);
		btnEmployees.setPrefHeight(50);
		btnEmployees.setDisable(true);
		btnEmployees.setTooltip(new Tooltip("Empleados"));
		btnEmployees.setOnAction(new btnEmpleados_Click());
		
		ImageView imgLogin = new ImageView(new Image(new File(ruta+"/sesion.png").toURI().toString()));
		imgLogin.setFitWidth(40);
		imgLogin.setFitHeight(40);
		btnLogin = new Button("Ingresar");
		btnLogin.setGraphic(imgLogin);
		btnLogin.setGraphicTextGap(1);
		btnLogin.setPrefWidth(150);
		btnLogin.setPrefHeight(50);
		btnLogin.setTooltip(new Tooltip("Ingresar"));
		btnLogin.setOnAction(new btnLogin_Click());
		
		ImageView imgClose = new ImageView(new Image(new File(ruta+"/cerrar.png").toURI().toString()));
		imgClose.setFitWidth(40);
		imgClose.setFitHeight(40);
		btnClose = new Button("Cerrar");
		btnClose.setGraphic(imgClose);
		btnClose.setGraphicTextGap(1);
		btnClose.setPrefWidth(150);
		btnClose.setPrefHeight(50);
		btnClose.setVisible(false);
		btnClose.setTooltip(new Tooltip("Cerrar"));
		btnClose.setOnAction(new btnCerrar_Click());
		
		mnu.setSpacing(10);
		mnu.getChildren().add(btnLogin);
		mnu.getChildren().add(btnEmployees);
		mnu.getChildren().add(btnCustomers);
		mnu.getChildren().add(btnCategorias);
		mnu.getChildren().add(btnProducts);
		mnu.getChildren().add(btnClose);
		
		return mnu;
	}
	
	private class btnEmpleados_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
			misVentanas.mostrarPantalla(Principal.pantallaEmpleados);
		}
	}
	
	private class btnClientes_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
			misVentanas.mostrarPantalla(Principal.pantallaClientes);
		}
	}
	
	private class btnCategorias_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
			misVentanas.mostrarPantalla(Principal.pantallaCategorias);
		}
	}
	
	private class btnCerrar_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
		   	controladorPrincipal.limpiarDatos();
        	btnLogin.setDisable(false);
        	btnCustomers.setDisable(true);
        	btnEmployees.setDisable(true);
        	btnProducts.setDisable(true);
        	btnCategorias.setDisable(true);
        	btnClose.setVisible(false);
		}
	}
	
	private class btnLogin_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
			Stage primary= new Stage(StageStyle.UNDECORATED);
			try {
				FXMLLoader miCargador= new FXMLLoader(getClass().getResource(Principal.archivoLogin));
				AnchorPane frm= (AnchorPane)miCargador.load();
				LoginController controlador = miCargador.getController();
				primary.setScene(new Scene(frm, 300, 220));
		        primary.setResizable(false);
		        primary.initModality(Modality.APPLICATION_MODAL);
		        primary.showAndWait();
		        if (controlador.EmpleadoActual!=null){
		        	controladorPrincipal.asignarDatos(controlador.EmpleadoActual);
		        	btnLogin.setDisable(true);
		        	btnCustomers.setDisable(false);
		        	btnEmployees.setDisable(false);
		        	btnCategorias.setDisable(false);
		        	btnProducts.setDisable(false);

		        	btnClose.setVisible(true);
		        }		        
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}