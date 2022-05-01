package co.urbanhair.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reporte database table.
 * 
 */
@Entity
@Table(name="reporte")
@NamedQuery(name="Reporte.findAll", query="SELECT r FROM Reporte r")
public class Reporte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReporte;

	private String descripcion;

	//bi-directional many-to-one association to Nomina
	@ManyToOne
	@JoinColumn(name="idNomina")
	private Nomina nomina;

	public Reporte() {
	}

	public int getIdReporte() {
		return this.idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Nomina getNomina() {
		return this.nomina;
	}

	public void setNomina(Nomina nomina) {
		this.nomina = nomina;
	}

}