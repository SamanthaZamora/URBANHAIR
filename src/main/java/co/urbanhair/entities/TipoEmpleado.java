package co.urbanhair.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_empleado database table.
 * 
 */
@Entity
@Table(name="tipo_empleado")
@NamedQuery(name="TipoEmpleado.findAll", query="SELECT t FROM TipoEmpleado t")
public class TipoEmpleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTipoEmp;

	@Lob
	private String descripcion;

	private String tipo;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="tipoEmpleado")
	private List<Empleado> empleados;

	public TipoEmpleado() {
	}

	public int getIdTipoEmp() {
		return this.idTipoEmp;
	}

	public void setIdTipoEmp(int idTipoEmp) {
		this.idTipoEmp = idTipoEmp;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setTipoEmpleado(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setTipoEmpleado(null);

		return empleado;
	}

}