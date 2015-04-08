package ungs.edu.ve.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VOTO")
public class Voto implements Serializable {

	private static final long serialVersionUID = 6941196158305799522L;

	@Id
	@GeneratedValue
	@Column()
	private long id;

	@OneToOne
	@JoinColumn(name = "lista_id")
	private Lista lista;

	@Temporal(TemporalType.TIME)
	private Date fechaVoto;

	@OneToOne
	@JoinColumn()
	private Terminal terminal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Lista getLista() {
		return lista;
	}

	public void setLista(Lista lista) {
		this.lista = lista;
	}

	public Date getFechaVoto() {
		return fechaVoto;
	}

	public void setFechaVoto(Date fechaVoto) {
		this.fechaVoto = fechaVoto;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
}
