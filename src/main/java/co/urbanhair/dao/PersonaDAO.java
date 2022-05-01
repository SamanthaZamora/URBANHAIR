package co.urbanhair.dao;

import co.urbanhair.util.Conexion;
import co.urbanhair.entities.Persona;


public class PersonaDAO extends Conexion<Persona> implements GenericDao<Persona>{
	
	
	private static final long serialVersionUID = 1L;

	public PersonaDAO() {
		super(Persona.class);
	}
	
	


}
