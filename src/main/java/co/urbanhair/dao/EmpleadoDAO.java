package co.urbanhair.dao;

import co.urbanhair.entities.Empleado;
import co.urbanhair.util.Conexion;

public class EmpleadoDAO extends Conexion<Empleado> implements GenericDao<Empleado> {

	private static final long serialVersionUID = 1L;
	
	public EmpleadoDAO() {
		super(Empleado.class);
	}

}
