package co.urbanhair.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the atencion_servicio database table.
 * 
 */
@Entity
@Table(name="atencion_servicio")
@NamedQuery(name="AtencionServicio.findAll", query="SELECT a FROM AtencionServicio a")
public class AtencionServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAtencion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private String hora;

	private float precio;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="idCita")
	private Cita cita;

	//bi-directional many-to-one association to Servicio
	@ManyToOne
	@JoinColumn(name="idServicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idPersona")
	private Persona persona;

	
	
	
	public AtencionServicio(Date fecha, String hora, float precio, Cita cita, Servicio servicio, Persona persona) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
		this.cita = cita;
		this.servicio = servicio;
		this.persona = persona;
	}

	public AtencionServicio() {
	}

	public int getIdAtencion() {
		return this.idAtencion;
	}

	public void setIdAtencion(int idAtencion) {
		this.idAtencion = idAtencion;
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

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}