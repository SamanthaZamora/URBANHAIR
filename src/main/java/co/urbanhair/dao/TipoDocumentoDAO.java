package co.urbanhair.dao;

import co.urbanhair.entities.TipoDocumento;
import co.urbanhair.util.Conexion;

public class TipoDocumentoDAO extends Conexion<TipoDocumento> implements GenericDao<TipoDocumento>{

	private static final long serialVersionUID = 1L;
	
	public TipoDocumentoDAO() {
		super(TipoDocumento.class);
	}

}
