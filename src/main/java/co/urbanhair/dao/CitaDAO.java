package co.urbanhair.dao;

import co.urbanhair.entities.Cita;
import co.urbanhair.util.Conexion;

public class CitaDAO extends Conexion<Cita> implements GenericDao<Cita> {

	private static final long serialVersionUID = 1L;
	
	public CitaDAO() {
		super(Cita.class);
	}

}
