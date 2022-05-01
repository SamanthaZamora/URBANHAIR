package co.urbanhair.dao;

import co.urbanhair.entities.Reporte;
import co.urbanhair.util.Conexion;

public class ReporteDAO extends Conexion<Reporte> implements GenericDao<Reporte>{

	private static final long serialVersionUID = 1L;
	
	public ReporteDAO() {
		super(Reporte.class);
	}

}
