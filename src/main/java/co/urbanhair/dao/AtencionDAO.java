package co.urbanhair.dao;

import co.urbanhair.entities.AtencionServicio;
import co.urbanhair.entities.Cita;
import co.urbanhair.util.Conexion;

public class AtencionDAO extends Conexion<AtencionServicio> implements GenericDao<AtencionServicio>{

	private static final long serialVersionUID = 1L;
	
	public AtencionDAO() {
		super(AtencionServicio.class);
	}

}
