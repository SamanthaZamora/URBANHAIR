package co.urbanhair.dao;

import co.urbanhair.entities.Rol;
import co.urbanhair.util.Conexion;

public class RolDAO  extends Conexion<Rol>  implements GenericDao<Rol> {

	private static final long serialVersionUID = 1L;
	
	public RolDAO() {
		super(Rol.class);
	}

}
