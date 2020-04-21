package org.formacion.di.bbdd;


public class InventarioBBDD implements InterfaceInventario {


	// Metodo de consulta a la base de datos
	
	@Override
	public int numeroProductos(String tienda, String producto) {
		return BBDD.stocs.get(tienda).get(producto);
	}

}
