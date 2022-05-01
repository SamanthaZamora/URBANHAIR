package co.urbanhair.dao;

import co.urbanhair.entities.Servicio;
import co.urbanhair.util.Conexion;

public class ServicioDAO extends Conexion<Servicio> implements GenericDao<Servicio> {

	private static final long serialVersionUID = 1L;
	
	public ServicioDAO() {
		super(Servicio.class);
	}

}
