package com.alda.pizzeriaRickys;


public interface IOpciones {
	
	
	boolean Eliminar() throws java.lang.ClassNotFoundException,
			java.lang.InstantiationException,
			java.lang.IllegalAccessException,
			java.sql.SQLException, Exception;
	
	Object Buscar(int clave) throws java.lang.ClassNotFoundException,
			java.lang.InstantiationException,
			java.lang.IllegalAccessException,
			java.sql.SQLException, Exception;
	
	boolean Actualizar(Object E) throws java.lang.ClassNotFoundException,
			java.lang.InstantiationException,
			java.lang.IllegalAccessException,
			java.sql.SQLException, Exception;
	
	boolean Guardar()  throws java.lang.ClassNotFoundException,
		java.lang.InstantiationException,
		java.lang.IllegalAccessException,
		java.sql.SQLException, Exception;
	
	
}
