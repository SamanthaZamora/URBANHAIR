package co.urbanhair.dao;

import co.urbanhair.entities.Promociones;
import co.urbanhair.util.Conexion;

public class PromocionesDAO extends Conexion<Promociones> implements GenericDao<Promociones> {

	private static final long serialVersionUID = 1L;
	
	public PromocionesDAO()  {
		super(Promociones.class);
	}

}
