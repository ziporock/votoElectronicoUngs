package ungs.edu.ve.controlador;

import ungs.edu.ve.modelo.Claustro;
import ungs.edu.ve.modelo.Estado;
import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.EntidadDAO;
import ungs.edu.ve.modelo.dao.EstadoDAO;
import ungs.edu.ve.modelo.dao.VotanteDAO;
import ungs.edu.ve.modelo.dao.impl.EntidadDAOImpl;
import ungs.edu.ve.util.CONSTANTE;

public class ControladorVotacion {
	private ValidadorVotante validador;
	private EstadoDAO estadoDAO;
	private VotanteDAO votanteDAO;
	private EntidadDAO<Claustro> claustroDao ;

	

	public void habilitarVotante(String id) throws Exception {

		try {
			Long.parseLong(id);
		} catch (Exception e) {
			throw new Exception(CONSTANTE.ERROR_DNI_INGRESADO_INVALIDO);
		}

		Votante votante = validador.obtenerVotante(id);

		if (votante != null) {
			if (validador.estadoValido(votante)) {

			} else {
				throw new Exception(CONSTANTE.ERROR_PERSONA_YA_VOTO);
			}
		} else {
			throw new Exception(CONSTANTE.ERROR_DNI_INEXISTENTE);

		}

	}

	// public long votarListas(Set<Lista> listas) {
	// // TODO Auto-generated method stub
	// return 0;
	// }
	//
	// public ResultadoVotacion getResultados() {
	// // TODO Auto-generated method stub
	// return null;
	// }

	@SuppressWarnings("unchecked")
	public void inicializar() {

		Claustro claustro = new Claustro();
		claustro.setDescripcion("claustro desc");
		claustro.setNombre("claustro nom");

		
		claustroDao.guardar(claustro);

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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public void cerrarVoto(String string) {
		Votante votante = validador.obtenerVotante(string);
		votante.setEstado((Estado) estadoDAO.getById(Estado.class, 3L));

		votanteDAO.actualizar(votante);
	}

	public ValidadorVotante getValidador() {
		return validador;
	}

	public void setValidador(ValidadorVotante validador) {
		this.validador = validador;
	}

	public EstadoDAO getEstadoDAO() {
		return estadoDAO;
	}

	public void setEstadoDAO(EstadoDAO estadoDAO) {
		this.estadoDAO = estadoDAO;
	}

	public VotanteDAO getVotanteDAO() {
		return votanteDAO;
	}

	public void setVotanteDAO(VotanteDAO votanteDAO) {
		this.votanteDAO = votanteDAO;
	}

	public EntidadDAO<Claustro> getClaustroDao() {
		return claustroDao;
	}

	public void setClaustroDao(EntidadDAO<Claustro> claustroDao) {
		this.claustroDao = claustroDao;
	}

	
	
	
}
