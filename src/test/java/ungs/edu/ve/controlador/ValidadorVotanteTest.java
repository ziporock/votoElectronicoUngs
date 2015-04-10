package ungs.edu.ve.controlador;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.impl.ValidadorVotanteMock;

public class ValidadorVotanteTest {

	private ValidadorVotanteMock validadorVotante;
	private ControladorVotacion controladorVotacion;

	@Before
	public void preparar() {
		validadorVotante = new ValidadorVotanteMock();
	}

	@Test
	public void obtenerVotanteValido() throws Exception {
		validadorVotante.estadoValido(new Votante());

	}

	@Test
	public void obtenerVotante() throws Exception {
		validadorVotante.obtenerVotante("2009");

	}

	

}
