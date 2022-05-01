package co.urbanhair.dao;

import co.urbanhair.entities.Nomina;
import co.urbanhair.util.Conexion;

public class NominaDAO extends Conexion<Nomina> implements GenericDao<Nomina> {

	private static final long serialVersionUID = 1L;
	
	public NominaDAO() {
		super(Nomina.class);
	}

}
