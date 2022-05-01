package co.urbanhair.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="promociones")
@NamedQuery(name="Promociones.findAll", query="SELECT p FROM Promociones p")
public class Promociones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPromo;
	
	private String nombre;

	
	private String descripcion;

	private Timestamp fechaFin;

	
	private Timestamp fechaInicio;

	
	private String imgURL;

	private float precio;
	
	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	public Promociones() {
	}
	
	public Promociones(String nombre, String descripcion, String imgURL, Timestamp fechaInicio, Timestamp fechaFin,  float precio, Rol rol) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaFin = fechaFin;
		this.fechaInicio = fechaInicio;
		this.rol = rol;
		this.imgURL = imgURL;
		this.precio = precio;
	}

	public int getIdPromo() {
		return this.idPromo;
	}

	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Timestamp fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getImgURL() {
		return this.imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public float getPrecio() {
		return this.precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}