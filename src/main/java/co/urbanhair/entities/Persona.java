package co.urbanhair.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona;
	
	private String noDocumento;

	private String contrasena;

	private String email;

	
	private Timestamp fechaNacimiento;

	private String genero;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to AtencionServicio
	@OneToMany(mappedBy="persona")
	private List<AtencionServicio> atencionServicios;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="persona")
	private List<Cita> citas;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="idTipoDoc")
	private TipoDocumento tipoDocumento;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	public Persona() {
	}
	
	

	public Persona(String nombre, String noDocumento, Timestamp fechaNacimiento , String genero,  String telefono, String email, String contrasena ,
			 TipoDocumento tipoDocumento, Rol rol) {
		super();
		this.noDocumento = noDocumento;
		this.contrasena = contrasena;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.nombre = nombre;
		this.telefono = telefono;
		this.tipoDocumento = tipoDocumento;
		this.rol = rol;
	}



	public String getNoDocumento() {
		return noDocumento;
	}



	public void setNoDocumento(String noDocumento) {
		this.noDocumento = noDocumento;
	}



	public int getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Timestamp fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public List<AtencionServicio> getAtencionServicios() {
		return this.atencionServicios;
	}

	public void setAtencionServicios(List<AtencionServicio> atencionServicios) {
		this.atencionServicios = atencionServicios;
	}

	public AtencionServicio addAtencionServicio(AtencionServicio atencionServicio) {
		getAtencionServicios().add(atencionServicio);
		atencionServicio.setPersona(this);

		return atencionServicio;
	}

	public AtencionServicio removeAtencionServicio(AtencionServicio atencionServicio) {
		getAtencionServicios().remove(atencionServicio);
		atencionServicio.setPersona(null);

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
		cita.setPersona(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setPersona(null);

		return cita;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}