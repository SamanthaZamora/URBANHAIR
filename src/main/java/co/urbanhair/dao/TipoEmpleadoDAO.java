package co.urbanhair.dao;

import co.urbanhair.entities.TipoEmpleado;
import co.urbanhair.util.Conexion;

public class TipoEmpleadoDAO extends Conexion<TipoEmpleado> implements GenericDao<TipoEmpleado>{

	private static final long serialVersionUID = 1L;
	
	public TipoEmpleadoDAO() {
		super(TipoEmpleado.class);
	}

}