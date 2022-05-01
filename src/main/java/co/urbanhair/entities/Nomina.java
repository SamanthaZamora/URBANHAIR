package co.urbanhair.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the nomina database table.
 * 
 */
@Entity
@Table(name="nomina")
@NamedQuery(name="Nomina.findAll", query="SELECT n FROM Nomina n")
public class Nomina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idNomina;

	private Time horasExtra;

	private Time horasTrabajo;

	private float pagoFinal;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="idEmpleado")
	private Empleado empleado;

	//bi-directional many-to-one association to Reporte
	@OneToMany(mappedBy="nomina")
	private List<Reporte> reportes;

	public Nomina() {
	}

	public int getIdNomina() {
		return this.idNomina;
	}

	public void setIdNomina(int idNomina) {
		this.idNomina = idNomina;
	}

	public Time getHorasExtra() {
		return this.horasExtra;
	}

	public void setHorasExtra(Time horasExtra) {
		this.horasExtra = horasExtra;
	}

	public Time getHorasTrabajo() {
		return this.horasTrabajo;
	}

	public void setHorasTrabajo(Time horasTrabajo) {
		this.horasTrabajo = horasTrabajo;
	}

	public float getPagoFinal() {
		return this.pagoFinal;
	}

	public void setPagoFinal(float pagoFinal) {
		this.pagoFinal = pagoFinal;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Reporte> getReportes() {
		return this.reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Reporte addReporte(Reporte reporte) {
		getReportes().add(reporte);
		reporte.setNomina(this);

		return reporte;
	}

	public Reporte removeReporte(Reporte reporte) {
		getReportes().remove(reporte);
		reporte.setNomina(null);

		return reporte;
	}

}