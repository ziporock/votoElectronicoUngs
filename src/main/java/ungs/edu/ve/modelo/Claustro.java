package ungs.edu.ve.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLAUSTRO")
public class Claustro implements Serializable {

	private static final long serialVersionUID = 5395621208737195128L;

	@Id
	@GeneratedValue
	@Column()// IDENTITY FIELD
	private long id;

	@Column()
	private String nombre;

	@Column()
	private String descripcion;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
