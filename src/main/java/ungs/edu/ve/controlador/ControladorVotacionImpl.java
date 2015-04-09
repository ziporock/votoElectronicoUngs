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

public class ControladorVotacionImpl  {
	private ValidadorVotante validador;

	
	public ControladorVotacionImpl(){
		validador=new ValidadorVotante();
	}
	
	
	public void habilitarVotante(String id) throws Exception {
		Votante votante=validador.obtenerVotante(id);
		
		if (votante!=null) {
			if (validador.validarVotoPendiente(votante)) {

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
		votante.setApellido("hoal");
		votante.setNombre("gaston");
		votante.setNroDocumento(1231234);
		
		
		cargarEstados();
		
		EstadoDAO estadoDAO=new EstadoDAOImpl();
		
		
		
		votante.setEstado((Estado) estadoDAO.getById(Estado.class, 3L));

		
		votante.setClaustro(claustro);

		VotanteDAO ev = new VotanteDAOImpl();

		ev.guardar(votante);

		
	}

	private void cargarEstados() {

		Estado estadoInicial=new Estado();
		estadoInicial.setCodigo("init");
		estadoInicial.setDescripcion("inicial por defecto");
		
		Estado votando=new Estado();
		votando.setCodigo("votando");
		votando.setDescripcion("votando");
		
		Estado votoExitoso=new Estado();
		votoExitoso.setCodigo("finalizado");
		votoExitoso.setDescripcion("voto exitoso");
		
		Estado votoIncompleto=new Estado();
		votoIncompleto.setCodigo("incompleto");
		votoIncompleto.setDescripcion("no se pudo finalizar con el voto");
		
		EntidadDAO<Estado> dao=new EntidadDAOImpl<Estado>();
		dao.guardar(estadoInicial);
		dao.guardar(votando);
		dao.guardar(votoExitoso);
		dao.guardar(votoIncompleto);
		
	}

}
