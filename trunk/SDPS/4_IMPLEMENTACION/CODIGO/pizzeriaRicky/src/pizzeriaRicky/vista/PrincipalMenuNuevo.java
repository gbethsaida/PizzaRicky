package pizzeriaRicky.vista;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import pizzeriaRicky.controlador.ControladorLogin;
import pizzeriaRicky.modelo.Empleado;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pizzeriaRicky.controlador.ControladorPrincipal;
import pizzeriaRicky.vista.PrincipalMenuNuevo;

public class PrincipalMenuNuevo extends Application{
	
	
	ControladorVentana misVentanas = new ControladorVentana();
	ControladorPrincipal controladorPrincipal = null;
	BorderPane contenedor = null;
	
	public static Empleado EmpleadoActual = null;
	
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
	
	boolean mostrar=true;
	Button btnLogin =  null;
	Button btnCliente;
	Button btnEmpleado;
	Button btnProducto;
	Button btnPedido;
	Button btnVentas;
	Button btnCerrar;
	Button btnMenu;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//misVentanas.cargarPantalla(Principal.pantallaInicio,Principal.archivoInicio);
		//misVentanas.cargarPantalla(Principal.pantallaLogin, Principal.archivoLogin);
		misVentanas.cargarPantalla(PrincipalMenuNuevo.pantallaCategoria,PrincipalMenuNuevo.archivoCategoria);
		misVentanas.cargarPantalla(PrincipalMenuNuevo.pantallaCliente,PrincipalMenuNuevo.archivoCliente);
		misVentanas.cargarPantalla(PrincipalMenuNuevo.pantallaEmpleado,PrincipalMenuNuevo.archivoEmpleado);
		misVentanas.cargarPantalla(PrincipalMenuNuevo.pantallaMedida,PrincipalMenuNuevo.archivoMedida);
		misVentanas.cargarPantalla(PrincipalMenuNuevo.pantallaProducto,PrincipalMenuNuevo.archivoProducto);
		misVentanas.cargarPantalla(PrincipalMenuNuevo.pantallaUnidad,PrincipalMenuNuevo.archivoUnidad);
		
		//misVentanas.mostrarPantalla(Principal.pantallaInicio);
		
		//StackPane root = new StackPane();
		Pane pane =new Pane();
		Scene escena = new Scene(pane, 1000, 745);
		//escena.getStylesheets().add("/css/prinicpal.css");
		escena.getStylesheets().add(("/pizzeriaRicky/vista/css/principal.css"));
		URL location = getClass().getResource("principal.fxml");
		FXMLLoader fxml = new FXMLLoader(location);
		contenedor = (BorderPane)fxml.load();
		controladorPrincipal = fxml.getController();
		contenedor.setCenter(misVentanas);

		pane.getChildren().addAll(contenedor);
		primaryStage.centerOnScreen();
		primaryStage.setScene(escena);
		primaryStage.show();
		
		String ruta = System.getProperty("user.dir");
		ruta+="/src/pizzeriaRicky/vista/iconos";
	
	btnLogin = new Button();
	ImageView imgLogin = new ImageView(new Image(new File(ruta+"/abrir.png").toURI().toString()));
	imgLogin.setFitWidth(40);
	imgLogin.setFitHeight(40);
	btnLogin.setGraphicTextGap(1);
	//btnLogin.setPrefWidth(70);
	//btnLogin.setPrefHeight(70);
	//btnLogin.setStyle("-fx-background-radius:40");
	btnLogin.setGraphic(imgLogin);
	btnLogin.setLayoutX(94);
	btnLogin.setLayoutY(0);
	btnLogin.setDisable(false);
	btnLogin.setVisible(false);
	btnLogin.getStyleClass().add("btn");
	btnLogin.setTooltip(new Tooltip("Ingresar"));
	btnLogin.setOnAction(new btnLogin_Click());

	btnProducto = new Button();
	ImageView imgProducto = new ImageView(new Image(new File(ruta+"/producto.png").toURI().toString()));
	imgProducto.setFitWidth(40);
	imgProducto.setFitHeight(40);
	btnProducto.setGraphic(imgProducto);
	btnProducto.setLayoutX(61);
	btnProducto.setLayoutY(63);
	btnProducto.getStyleClass().add("btn");
	btnProducto.setVisible(false);
	btnProducto.setDisable(true);
	btnProducto.setTooltip(new Tooltip("Productos"));
	btnProducto.setOnAction(new btnProducto_Click());
	
	btnEmpleado = new Button();
	ImageView imgEmpleado = new ImageView(new Image(new File(ruta+"/empleado.png").toURI().toString()));
	imgEmpleado.setFitWidth(40);
	imgEmpleado.setFitHeight(40);
	btnEmpleado.setGraphic(imgEmpleado);
	btnEmpleado.setLayoutX(0);
	btnEmpleado.setLayoutY(100);
	btnEmpleado.getStyleClass().add("btn");
	btnEmpleado.setVisible(false);
	btnEmpleado.setDisable(true);
	btnEmpleado.setTooltip(new Tooltip("Empleados"));
	btnEmpleado.setOnAction(new btnEmpleados_Click());
	
	btnCliente = new Button();
	ImageView imgCliente = new ImageView(new Image(new File(ruta+"/cliente.png").toURI().toString()));
	imgCliente.setFitWidth(40);
	imgCliente.setFitHeight(40);
	btnCliente.setGraphic(imgCliente);
	btnCliente.setLayoutX(166);
	btnCliente.setLayoutY(0);
	btnCliente.getStyleClass().add("btn");
	btnCliente.setVisible(false);
	btnCliente.setDisable(true);
	btnCliente.setTooltip(new Tooltip("Clientes"));
	btnCliente.setOnAction(new btnClientes_Click());
	
	btnPedido = new Button();
	ImageView imgPedido = new ImageView(new Image(new File(ruta+"/pedido.png").toURI().toString()));
	imgPedido.setFitWidth(40);
	imgPedido.setFitHeight(40);
	btnPedido.setGraphic(imgPedido);
	btnPedido.setLayoutX(136);
	btnPedido.setLayoutY(70);
	btnPedido.getStyleClass().add("btn");
	btnPedido.setVisible(false);
	btnPedido.setDisable(true);
	btnPedido.setTooltip(new Tooltip("Pedido"));

	btnVentas = new Button();
	ImageView imgVentas = new ImageView(new Image(new File(ruta+"/ventas.png").toURI().toString()));
	imgVentas.setFitWidth(40);
	imgVentas.setFitHeight(40);
	btnVentas.setGraphic(imgVentas);
	btnVentas.setLayoutX(70);
	btnVentas.setLayoutY(135);
	btnVentas.getStyleClass().add("btn");
	btnVentas.setVisible(false);
	btnVentas.setDisable(true);
	btnVentas.setTooltip(new Tooltip("Ventas"));

	btnCerrar = new Button();
	ImageView imgCerrar = new ImageView(new Image(new File(ruta+"/cerrar.png").toURI().toString()));
	imgCerrar.setFitWidth(40);
	imgCerrar.setFitHeight(40);
	btnCerrar.setGraphic(imgCerrar);
	btnCerrar.setGraphicTextGap(1);
	btnCerrar.setLayoutX(0);
	btnCerrar.setLayoutY(173);
	btnCerrar.getStyleClass().add("btn");
	btnCerrar.setVisible(false);
	btnCerrar.setDisable(true);
	btnCerrar.setTooltip(new Tooltip("Cerrar"));
	btnCerrar.setOnAction(new btnCerrar_Click());
	
	btnMenu = new Button();
	//btnMenu.setOnAction(new btnMenu_Click());
	ImageView imgMenu = new ImageView(new Image(new File(ruta+"/menu.png").toURI().toString()));
	imgMenu.setFitWidth(40);
	imgMenu.setFitHeight(40);
	btnMenu.setGraphic(imgMenu);
	btnMenu.setOnAction(new EventHandler<ActionEvent>(){
		public void handle(ActionEvent arg0) {
			//btnCerrar.setDisable(true);
		}
	});
	
	pane.getChildren().addAll(btnLogin ,btnEmpleado, btnCliente, btnPedido, btnVentas, btnProducto, btnCerrar);

	btnMenu.getStyleClass().add("btn");
	btnMenu.setTooltip(new Tooltip("Menu"));
	btnMenu.setLayoutX(0);
	btnMenu.setLayoutY(0);
	btnMenu.setOnMousePressed(new EventHandler() {

		public void handle(Event arg0) {
			System.out.println("Mostrar");
			if(mostrar){
				mostrar=false;
				btnLogin.setVisible(true);
				btnEmpleado.setVisible(true);
				btnCliente.setVisible(true);
				btnPedido.setVisible(true);
				btnVentas.setVisible(true);
				btnProducto.setVisible(true);
				btnCerrar.setVisible(true);
		
			}else{
				ocultar();
			}
		}
	});
	
	pane.getChildren().add(btnMenu);
	}
	public void ocultar(){

		btnLogin.setVisible(false);
		btnEmpleado.setVisible(false);
		btnCliente.setVisible(false);
		btnPedido.setVisible(false);
		btnVentas.setVisible(false);
		btnProducto.setVisible(false);
		btnCerrar.setVisible(false);
		mostrar=true;		
}

public class btnMenu_Click implements EventHandler<ActionEvent>{
	public void handle(ActionEvent arg0){
		//btnCerrar.setVisible(true);
		ocultar();

	}
}

public class btnEmpleados_Click implements EventHandler<ActionEvent>{
	public void handle(ActionEvent arg0) {
		misVentanas.mostrarPantalla(PrincipalMenuNuevo.pantallaEmpleado);
		ocultar();
	}
}

public class btnClientes_Click implements EventHandler<ActionEvent>{
	public void handle(ActionEvent arg0) {
		misVentanas.mostrarPantalla(PrincipalMenuNuevo.pantallaCliente);
		ocultar();
	}
}

public class btnProducto_Click implements EventHandler<ActionEvent>{
	public void handle(ActionEvent arg0) {
		misVentanas.mostrarPantalla(PrincipalMenuNuevo.pantallaProducto);
		ocultar();
	}
}

public class btnCerrar_Click implements EventHandler<ActionEvent>{
	public void handle(ActionEvent arg0) {
	   	controladorPrincipal.limpiarDatos();
    	btnLogin.setDisable(false);
    	btnCliente.setDisable(true);
    	btnEmpleado.setDisable(true);
    	btnVentas.setDisable(true);
    	btnPedido.setDisable(true);
    	btnProducto.setDisable(true);
    	btnCerrar.setDisable(true);
    	//Stage stage = (Stage) btnCerrar.getScene().getWindow();
	   // stage.hide();
    	misVentanas.setVisible(false);
		ocultar();
	}
}

public class btnLogin_Click implements EventHandler<ActionEvent>{
	public void handle(ActionEvent arg0) {
		Stage primary= new Stage(StageStyle.UNDECORATED);
		ocultar();
		try {
			FXMLLoader miCargador= new FXMLLoader(getClass().getResource(PrincipalMenuNuevo.archivoLogin));
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
	        	btnProducto.setDisable(false);
	        	btnCerrar.setDisable(false);
	        	misVentanas.setVisible(true);
	        }		        
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
}