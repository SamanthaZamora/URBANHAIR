package co.urbanhair.dao;

import co.urbanhair.entities.InformacionEmpresarial;
import co.urbanhair.util.Conexion;

public class InformacionempresarialDAO extends Conexion<InformacionEmpresarial> implements GenericDao<InformacionEmpresarial> {

	private static final long serialVersionUID = 1L;
	
	public InformacionempresarialDAO() {
		super(InformacionEmpresarial.class);
	}

}
