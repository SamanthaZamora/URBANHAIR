package co.urbanhair.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rol database table.
 * 
 */
@Entity
@Table(name="rol")
@NamedQuery(name="Rol.findAll", query="SELECT r FROM Rol r")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRol;

	private String descripcion;

	private String rol;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="rol")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to InformacionEmpresarial
	@OneToMany(mappedBy="rol")
	private List<InformacionEmpresarial> informacionEmpresarials;

	//bi-directional many-to-one association to Persona
	@OneToMany(mappedBy="rol")
	private List<Persona> personas;

	//bi-directional many-to-one association to Promocione
	@OneToMany(mappedBy="rol")
	private List<Promociones> promociones;

	//bi-directional many-to-one association to Proveedor
	@OneToMany(mappedBy="rol")
	private List<Proveedor> proveedors;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setRol(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setRol(null);

		return empleado;
	}

	public List<InformacionEmpresarial> getInformacionEmpresarials() {
		return this.informacionEmpresarials;
	}

	public void setInformacionEmpresarials(List<InformacionEmpresarial> informacionEmpresarials) {
		this.informacionEmpresarials = informacionEmpresarials;
	}

	public InformacionEmpresarial addInformacionEmpresarial(InformacionEmpresarial informacionEmpresarial) {
		getInformacionEmpresarials().add(informacionEmpresarial);
		informacionEmpresarial.setRol(this);

		return informacionEmpresarial;
	}

	public InformacionEmpresarial removeInformacionEmpresarial(InformacionEmpresarial informacionEmpresarial) {
		getInformacionEmpresarials().remove(informacionEmpresarial);
		informacionEmpresarial.setRol(null);

		return informacionEmpresarial;
	}

	public List<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona addPersona(Persona persona) {
		getPersonas().add(persona);
		persona.setRol(this);

		return persona;
	}

	public Persona removePersona(Persona persona) {
		getPersonas().remove(persona);
		persona.setRol(null);

		return persona;
	}

	public List<Promociones> getPromociones() {
		return this.promociones;
	}

	public void setPromociones(List<Promociones> promociones) {
		this.promociones = promociones;
	}

	public Promociones addPromocione(Promociones promocione) {
		getPromociones().add(promocione);
		promocione.setRol(this);

		return promocione;
	}

	public Promociones removePromocione(Promociones promocione) {
		getPromociones().remove(promocione);
		promocione.setRol(null);

		return promocione;
	}

	public List<Proveedor> getProveedors() {
		return this.proveedors;
	}

	public void setProveedors(List<Proveedor> proveedors) {
		this.proveedors = proveedors;
	}

	public Proveedor addProveedor(Proveedor proveedor) {
		getProveedors().add(proveedor);
		proveedor.setRol(this);

		return proveedor;
	}

	public Proveedor removeProveedor(Proveedor proveedor) {
		getProveedors().remove(proveedor);
		proveedor.setRol(null);

		return proveedor;
	}

}