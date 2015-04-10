package ungs.edu.ve.controlador;

import java.util.Set;

import ungs.edu.ve.modelo.Claustro;
import ungs.edu.ve.modelo.Estado;
import ungs.edu.ve.modelo.Lista;
import ungs.edu.ve.modelo.ResultadoVotacion;
import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.EntidadDAO;
import ungs.edu.ve.modelo.dao.EstadoDAO;
import ungs.edu.ve.modelo.dao.VotanteDAO;
import ungs.edu.ve.modelo.dao.impl.EntidadDAOImpl;
import ungs.edu.ve.modelo.dao.impl.EstadoDAOImpl;
import ungs.edu.ve.modelo.dao.impl.VotanteDAOImpl;
import ungs.edu.ve.util.CONSTANTE;

public class ControladorVotacionImpl {
	private ValidadorVotante validador;
	private EstadoDAO estadoDAO;
	private VotanteDAO votanteDAO;

	public ControladorVotacionImpl() {
		validador = new ValidadorVotante();
		estadoDAO = new EstadoDAOImpl();
		votanteDAO = new VotanteDAOImpl();
	}

	public void habilitarVotante(String id) throws Exception {
		Votante votante = validador.obtenerVotante(id);

		if (votante != null) {
			if (validador.estadoValido(votante)) {

			} else {
				throw new Exception("Esta Persona ya VOTO!");
			}
		}

	}

	public long votarListas(Set<Lista> listas) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ResultadoVotacion getResultados() {
		// TODO Auto-generated method stub
		return null;
	}

	public void inicializar() {

		Claustro claustro = new Claustro();
		claustro.setDescripcion("claustro desc");
		claustro.setNombre("claustro nom");

		EntidadDAO<Claustro> ec = new EntidadDAOImpl<Claustro>();
		ec.guardar(claustro);

		Votante votante = new Votante();
		votante.setApellido("Gaston");
		votante.setNombre("Alles");
		votante.setNroDocumento(1);

		cargarEstados();

		votante.setEstado((Estado) estadoDAO.getById(Estado.class, 3L));

		votante.setClaustro(claustro);

		votanteDAO.guardar(votante);

		Votante votante1 = new Votante();
		votante1.setApellido("guido");
		votante1.setNombre("dorrego");
		votante1.setNroDocumento(2);

		votante1.setClaustro(claustro);

		votante1.setEstado((Estado) estadoDAO.getById(Estado.class, 1L));

		votanteDAO.guardar(votante1);

	}

	private void cargarEstados() {

		Estado estadoInicial = new Estado();
		estadoInicial.setCodigo(CONSTANTE.ESTADO_INICIAL);
		estadoInicial.setDescripcion("inicial por defecto");

		Estado votando = new Estado();
		votando.setCodigo(CONSTANTE.ESTADO_PROCESO);
		votando.setDescripcion("votando");

		Estado votoExitoso = new Estado();
		votoExitoso.setCodigo(CONSTANTE.ESTADO_FINALIZADO);
		votoExitoso.setDescripcion("voto exitoso");

		estadoDAO.guardar(estadoInicial);
		estadoDAO.guardar(votando);
		estadoDAO.guardar(votoExitoso);

	}

	public void cerrarVoto(String string) {
		Votante votante = validador.obtenerVotante(string);
		votante.setEstado((Estado) estadoDAO.getById(Estado.class, 3L));

		votanteDAO.actualizar(votante);
	}

}
