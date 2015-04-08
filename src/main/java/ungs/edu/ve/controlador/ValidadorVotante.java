package ungs.edu.ve.controlador;

import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.VotanteDAO;
import ungs.edu.ve.modelo.dao.impl.VotanteDAOImpl;

public class ValidadorVotante {

	private VotanteDAO votanteDAO;
	
	public ValidadorVotante(){
		votanteDAO=new VotanteDAOImpl();
	}

	
	@SuppressWarnings("unchecked")
	public Votante obtenerVotante(String id) {
		Votante votante=(Votante) votanteDAO.getById(Votante.class, Long.parseLong(id));
		return votante;

	}

	public boolean validarVotoPendiente(Votante votante) {
		if(!votante.getEstado().getCodigo().equalsIgnoreCase("finalizado")){
			return true;			
		}
		return false;
	}

}
