package co.urbanhair.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@Table(name="empleado")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpleado;

	private String documento;

	private String email;

	
	private Timestamp fechaNacimiento;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to TipoEmpleado
	@ManyToOne
	@JoinColumn(name="idTipoEmp")
	private TipoEmpleado tipoEmpleado;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="idTipoDoc")
	private TipoDocumento tipoDocumento;

	//bi-directional many-to-one association to Nomina
	@OneToMany(mappedBy="empleado")
	private List<Nomina> nominas;

	public Empleado() {
	}

	
	public Empleado(String nombre, String documento, String email, String telefono, Timestamp fechaNacimiento,  
			TipoEmpleado tipoEmpleado, Rol rol, TipoDocumento tipoDocumento) {
		super();
		this.documento = documento;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.tipoEmpleado = tipoEmpleado;
		this.rol = rol;
		this.tipoDocumento = tipoDocumento;
	}


	public int getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public TipoEmpleado getTipoEmpleado() {
		return this.tipoEmpleado;
	}

	public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public List<Nomina> getNominas() {
		return this.nominas;
	}

	public void setNominas(List<Nomina> nominas) {
		this.nominas = nominas;
	}

	public Nomina addNomina(Nomina nomina) {
		getNominas().add(nomina);
		nomina.setEmpleado(this);

		return nomina;
	}

	public Nomina removeNomina(Nomina nomina) {
		getNominas().remove(nomina);
		nomina.setEmpleado(null);

		return nomina;
	}

}