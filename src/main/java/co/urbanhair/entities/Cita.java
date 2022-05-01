package co.urbanhair.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cita database table.
 * 
 */
@Entity
@Table(name="cita")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCita;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String hora;

	//bi-directional many-to-one association to AtencionServicio
	@OneToMany(mappedBy="cita")
	private List<AtencionServicio> atencionServicios;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idServicio")
	private Servicio servicio;

	public Cita() {
	}
	
	public Cita(Date fecha, String hora,  Persona persona, Servicio servicio) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.persona = persona;
		this.servicio = servicio;
	}


	public int getIdCita() {
		return this.idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public List<AtencionServicio> getAtencionServicios() {
		return this.atencionServicios;
	}

	public void setAtencionServicios(List<AtencionServicio> atencionServicios) {
		this.atencionServicios = atencionServicios;
	}

	public AtencionServicio addAtencionServicio(AtencionServicio atencionServicio) {
		getAtencionServicios().add(atencionServicio);
		atencionServicio.setCita(this);

		return atencionServicio;
	}

	public AtencionServicio removeAtencionServicio(AtencionServicio atencionServicio) {
		getAtencionServicios().remove(atencionServicio);
		atencionServicio.setCita(null);

		return atencionServicio;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}