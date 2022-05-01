package co.urbanhair.dao;

import co.urbanhair.entities.Producto;
import co.urbanhair.util.Conexion;

public class ProductoDAO extends Conexion<Producto>implements GenericDao<Producto> {

	private static final long serialVersionUID = 1L;
	
	public ProductoDAO() {
		super(Producto.class);
	}

}
