package ungs.edu.ve.modelo.dao.impl;

import ungs.edu.ve.controlador.ValidadorVotante;
import ungs.edu.ve.modelo.Votante;

public class ValidadorVotanteMock extends ValidadorVotante{
	private static final long ID = 1000l;
	private static final String NOMBRE = "ALBERTO";
	private static final String APELLIDO = "PEREZ";
	private static final Integer NRODOCUMENTO = 33282892;
	private static final String TIPO = "DOCENTE";
	
	
	
	public Votante obtenerVotante(String id) {
		Votante votante=new Votante();
		votante = new Votante();
		votante.setId(ID);
		votante.setNombre(NOMBRE);
		votante.setApellido(APELLIDO);
		votante.setNroDocumento(NRODOCUMENTO);
		votante.setTipo(TIPO);
		return votante;

	}

	public boolean estadoValido(Votante votante) {
		return true;
	}
}
