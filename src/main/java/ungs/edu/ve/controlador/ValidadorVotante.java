package ungs.edu.ve.controlador;

import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.VotanteDAO;
import ungs.edu.ve.util.CONSTANTE;

public class ValidadorVotante {

	private VotanteDAO votanteDAO;
	
	
	@SuppressWarnings("unchecked")
	public Votante obtenerVotante(String id) {
		Votante votante=(Votante) votanteDAO.getById(Votante.class, Long.parseLong(id));
		return votante;

	}

	public boolean estadoValido(Votante votante) {
		if(votante.getEstado().getCodigo().equalsIgnoreCase(CONSTANTE.ESTADO_INICIAL)){
			return true;			
		}else{
			return false;
		}
		
	}


	public VotanteDAO getVotanteDAO() {
		return votanteDAO;
	}


	public void setVotanteDAO(VotanteDAO votanteDAO) {
		this.votanteDAO = votanteDAO;
	}
	
	

}
