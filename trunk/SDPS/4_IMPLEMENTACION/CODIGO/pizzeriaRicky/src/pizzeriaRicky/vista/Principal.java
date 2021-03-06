package pizzeriaRicky.vista;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import pizzeriaRicky.controlador.ControladorLogin;
import pizzeriaRicky.modelo.Empleado;
import pizzeriaRicky.vista.Principal.btnProducto_Click;
import pizzeriaRicky.vista.Principal.btnCerrar_Click;
import pizzeriaRicky.vista.Principal.btnClientes_Click;
import pizzeriaRicky.vista.Principal.btnEmpleados_Click;
import pizzeriaRicky.vista.Principal.btnLogin_Click;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pizzeriaRicky.controlador.ControladorPrincipal;
import pizzeriaRicky.vista.Principal;

	public class Principal extends Application{
		
		ControladorVentana misVentanas = new ControladorVentana();
		ControladorPrincipal controladorPrincipal = null;
		BorderPane contenedor = null;
		
		public static Empleado EmpleadoActual = null;
		
		//public static String pantallaInicio = "Inicio";
		//public static String archivoInicio = "inicio.fxml";
		
		public static String pantallaCategoria = "Categoria";
		public static String archivoCategoria = "categorias.fxml";
		
		public static String pantallaCliente = "Cliente";
		public static String archivoCliente = "clientes.fxml";
		
		public static String pantallaEmpleado = "Empleado";
		public static String archivoEmpleado = "empleados.fxml";
		
		public static String pantallaMedida = "Medida";
		public static String archivoMedida = "medidas.fxml";
		
		public static String pantallaProducto = "Producto";
		public static String archivoProducto = "productos.fxml";
		
		public static String pantallaUnidad = "Unidad";
		public static String archivoUnidad = "unidades.fxml";
		
		//public static String pantallaLogin="Login";
		public static String archivoLogin="login.fxml";
		
		Button btnLogin = null;
		Button btnCliente = null;
		Button btnEmpleado = null;
		Button btnProducto = null;
		Button btnPedido = null;
		Button btnVentas = null;
		Button btnCerrar = null;
		Button btnMenu = null;
		
		public static void main(String[] args) {
			launch(args);
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
			//misVentanas.cargarPantalla(Principal.pantallaInicio,Principal.archivoInicio);
			//misVentanas.cargarPantalla(Principal.pantallaLogin, Principal.archivoLogin);
			misVentanas.cargarPantalla(Principal.pantallaCategoria,Principal.archivoCategoria);
			misVentanas.cargarPantalla(Principal.pantallaCliente,Principal.archivoCliente);
			misVentanas.cargarPantalla(Principal.pantallaEmpleado,Principal.archivoEmpleado);
			misVentanas.cargarPantalla(Principal.pantallaMedida,Principal.archivoMedida);
			misVentanas.cargarPantalla(Principal.pantallaProducto,Principal.archivoProducto);
			misVentanas.cargarPantalla(Principal.pantallaUnidad,Principal.archivoUnidad);
			
			//misVentanas.mostrarPantalla(Principal.pantallaInicio);
			
			
			
			StackPane root = new StackPane();
			Scene escena = new Scene(root, 1000, 745);
			URL location = getClass().getResource("principal.fxml");
			FXMLLoader fxml = new FXMLLoader(location);
			contenedor = (BorderPane)fxml.load();
			controladorPrincipal = fxml.getController();
			initComponentes();
			contenedor.setCenter(misVentanas);
			root.getChildren().add(contenedor);
			primaryStage.centerOnScreen();
			primaryStage.setScene(escena);
			primaryStage.show();

			
			}
			
		private void initComponentes(){
			contenedor.setTop(menu());
		}
	
		
	
		private HBox menu(){
		HBox mnu = new HBox();
		mnu.setPadding(new Insets(5));
		mnu.setStyle("-fx-background-color:#FF3030");

		btnLogin = new Button("Ingresar");
		btnLogin.setGraphicTextGap(1);
		btnLogin.setPrefWidth(150);
		btnLogin.setPrefHeight(50);
		btnLogin.setDisable(false);
		btnLogin.setTooltip(new Tooltip("Ingresar"));
		btnLogin.setOnAction(new btnLogin_Click());
		
		btnProducto = new Button("Productos");
		btnProducto.setPrefWidth(150);
		btnProducto.setPrefHeight(50);
		btnProducto.setDisable(true);
		btnProducto.setTooltip(new Tooltip("Productos"));
		btnProducto.setOnAction(new btnProducto_Click());
		
		btnEmpleado = new Button("Empleados");
		btnEmpleado.setPrefWidth(150);
		btnEmpleado.setPrefHeight(50);
		btnEmpleado.setDisable(true);
		btnEmpleado.setTooltip(new Tooltip("Empleados"));
		btnEmpleado.setOnAction(new btnEmpleados_Click());
		
		btnCliente = new Button("Clientes");
		btnCliente.setPrefWidth(150);
		btnCliente.setPrefHeight(50);
		btnCliente.setDisable(true);
		btnCliente.setTooltip(new Tooltip("Clientes"));
		btnCliente.setOnAction(new btnClientes_Click());
		
		btnPedido = new Button("Pedidos");
		btnPedido.setPrefWidth(150);
		btnPedido.setPrefHeight(50);
		btnPedido.setDisable(true);
		btnPedido.setTooltip(new Tooltip("Categorias"));

		btnVentas = new Button("Ventas");
		btnVentas.setPrefWidth(150);
		btnVentas.setPrefHeight(50);
		btnVentas.setDisable(true);
		btnVentas.setTooltip(new Tooltip("Categorias"));

		/*btnCategoria = new Button("Categorias");
		btnCategoria.setPrefWidth(150);
		btnCategoria.setPrefHeight(50);
		btnCategoria.setDisable(false);
		btnCategoria.setTooltip(new Tooltip("Categorias"));
		btnCategoria.setOnAction(new btnCategoria_Click());*/

		btnCerrar = new Button("Cerrar");
		btnCerrar.setGraphicTextGap(1);
		btnCerrar.setPrefWidth(150);
		btnCerrar.setPrefHeight(50);
		btnCerrar.setVisible(false);
		btnCerrar.setTooltip(new Tooltip("Cerrar"));
		btnCerrar.setOnAction(new btnCerrar_Click());
		
		//btnMenu = new Button("Menu");
		//btnMenu.setOnAction(new btnMenu_Click());
		
		/*btnMenu.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				btnCerrar.setDisable(true);
			}
		});*/
		
		mnu.setSpacing(10);
		mnu.getChildren().add(btnLogin);
		mnu.getChildren().add(btnEmpleado);
		mnu.getChildren().add(btnCliente);
		mnu.getChildren().add(btnPedido);
		mnu.getChildren().add(btnVentas);
		mnu.getChildren().add(btnProducto);
		mnu.getChildren().add(btnCerrar);
	//	mnu.getChildren().add(btnMenu);
		
		return mnu;
	}
	
	public class btnMenu_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0){
			btnCerrar.setVisible(true);
		}
	}
	
	public class btnEmpleados_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
			misVentanas.mostrarPantalla(Principal.pantallaEmpleado);
		}
	}
	
	public class btnClientes_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
			misVentanas.mostrarPantalla(Principal.pantallaCliente);
		}
	}
	
	public class btnProducto_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
			misVentanas.mostrarPantalla(Principal.pantallaProducto);
		}
	}
	
	public class btnCerrar_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
		   	controladorPrincipal.limpiarDatos();
        	btnLogin.setDisable(false);
        	btnCliente.setDisable(true);
        	btnEmpleado.setDisable(true);
        	btnProducto.setDisable(true);
        	btnPedido.setDisable(true);
        	btnVentas.setDisable(true);
        	btnCerrar.setVisible(false);
        	//Stage stage = (Stage) btnCerrar.getScene().getWindow();
		   // stage.hide();
        	misVentanas.setVisible(false);
		}
	}
	
	public class btnLogin_Click implements EventHandler<ActionEvent>{
		public void handle(ActionEvent arg0) {
			Stage primary= new Stage(StageStyle.UNDECORATED);
			try {
				FXMLLoader miCargador= new FXMLLoader(getClass().getResource(Principal.archivoLogin));
				AnchorPane frm= (AnchorPane)miCargador.load();
				ControladorLogin controlador = miCargador.getController();
				primary.setScene(new Scene(frm, 400, 500));
		        primary.setResizable(false);
		        primary.initModality(Modality.APPLICATION_MODAL);
		        primary.showAndWait();
		        if (controlador.EmpleadoActual!=null){
		        	controladorPrincipal.asignarDatos(controlador.EmpleadoActual);
		        	btnLogin.setDisable(true);
		        	btnCliente.setDisable(false);
		        	btnEmpleado.setDisable(false);
		        	btnVentas.setDisable(false);
		        	btnPedido.setDisable(false);
		        	//btnCategoria.setDisable(false);
		        	btnProducto.setDisable(false);
		        	btnCerrar.setVisible(true);
		        	misVentanas.setVisible(true);
		        }		        
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}