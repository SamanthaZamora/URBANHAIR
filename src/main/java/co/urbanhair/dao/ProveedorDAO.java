package co.urbanhair.dao;

import co.urbanhair.entities.Proveedor;
import co.urbanhair.util.Conexion;

public class ProveedorDAO  extends Conexion<Proveedor> implements GenericDao<Proveedor> {

	private static final long serialVersionUID = 1L;
	
	public ProveedorDAO() {
		super(Proveedor.class);
	}

}
