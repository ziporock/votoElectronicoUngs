package ungs.edu.ve.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VOTANTE")
public class Votante implements Serializable {

	private static final long serialVersionUID = 2713148938496240970L;

	@Id
	@GeneratedValue
	@Column()
	private long id;

	@Column()
	private String tipo;

	@Column()
	private Integer nroDocumento;

	@Column()
	private String apellido;

	@Column()
	private String nombre;

	@OneToOne
	@JoinColumn(name = "claustro_id")
	private Claustro claustro;
	
	@OneToOne
	@JoinColumn(name = "estado_id")
	private Estado estado;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Claustro getClaustro() {
		return claustro;
	}

	public void setClaustro(Claustro claustro) {
		this.claustro = claustro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
