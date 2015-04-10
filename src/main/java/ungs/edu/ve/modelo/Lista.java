package ungs.edu.ve.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LISTA")
public class Lista implements Serializable {

	private static final long serialVersionUID = 7046700483788788960L;

	@Id
	@GeneratedValue
	@Column()
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

	@Override
	public String toString() {
		return "Lista [nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}

	
	
}
