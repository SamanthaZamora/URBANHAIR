package co.urbanhair.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the informacion_empresarial database table.
 * 
 */
@Entity
@Table(name="informacion_empresarial")
@NamedQuery(name="InformacionEmpresarial.findAll", query="SELECT i FROM InformacionEmpresarial i")
public class InformacionEmpresarial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idInfo;

	private String direccion;

	private String email;

	@Lob
	private String mision;

	private String telefono;

	@Lob
	private String vision;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;

	public InformacionEmpresarial() {
	}
	
	

	public InformacionEmpresarial(String direccion, String email, String mision, String telefono, String vision,
			Rol rol) {
		super();
		this.direccion = direccion;
		this.email = email;
		this.mision = mision;
		this.telefono = telefono;
		this.vision = vision;
		this.rol = rol;
	}



	public int getIdInfo() {
		return this.idInfo;
	}

	public void setIdInfo(int idInfo) {
		this.idInfo = idInfo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMision() {
		return this.mision;
	}

	public void setMision(String mision) {
		this.mision = mision;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getVision() {
		return this.vision;
	}

	public void setVision(String vision) {
		this.vision = vision;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}