package co.urbanhair.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;



@Entity
@Table(name="servicio")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idServicio;

	@Lob
	private String descripcion;

	private String duracion;

	@Lob
	private String imgURL;

	private String nombre;

	private float precio;

	//bi-directional many-to-one association to AtencionServicio
	@OneToMany(mappedBy="servicio")
	private List<AtencionServicio> atencionServicios;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="servicio")
	private List<Cita> citas;

	public Servicio() {
	}

	
	public Servicio(String nombre, String descripcion, String duracion, String imgURL, float precio) {
		super();
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.imgURL = imgURL;
		this.nombre = nombre;
		this.precio = precio;
	}


	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getImgURL() {
		return this.imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<AtencionServicio> getAtencionServicios() {
		return this.atencionServicios;
	}

	public void setAtencionServicios(List<AtencionServicio> atencionServicios) {
		this.atencionServicios = atencionServicios;
	}

	public AtencionServicio addAtencionServicio(AtencionServicio atencionServicio) {
		getAtencionServicios().add(atencionServicio);
		atencionServicio.setServicio(this);

		return atencionServicio;
	}

	public AtencionServicio removeAtencionServicio(AtencionServicio atencionServicio) {
		getAtencionServicios().remove(atencionServicio);
		atencionServicio.setServicio(null);

		return atencionServicio;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setServicio(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setServicio(null);

		return cita;
	}

}