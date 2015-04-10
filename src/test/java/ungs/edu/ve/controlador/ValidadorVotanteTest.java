package ungs.edu.ve.controlador;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.impl.ValidadorVotanteMock;

public class ValidadorVotanteTest {

	private ValidadorVotanteMock validadorVotante;

	@Before
	public void preparar() {
		validadorVotante = new ValidadorVotanteMock();
	
	}

	@Test
	public void obtenerVotanteValidoTest() throws Exception {
		validadorVotante.obtenerVotante("2");

	}

	@Test
	public void estadoValidoTest() throws Exception {
		validadorVotante.estadoValido(new Votante());

	}


}
