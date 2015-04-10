package ungs.edu.ve.modelo.dao.impl;

import ungs.edu.ve.controlador.ValidadorVotante;
import ungs.edu.ve.modelo.Votante;

public class ValidadorVotanteMock extends ValidadorVotante {

	public ValidadorVotanteMock() {
		super.setVotanteDAO(new VotanteDAOImplMock());
	}

	public Votante obtenerVotante(String id) {
		if (id.equals("1")) {
			return super.obtenerVotante("1");
		} else
			return null;

	}

	public boolean estadoValido(Votante votante) {
		return super.estadoValido(votante);
	}
}
