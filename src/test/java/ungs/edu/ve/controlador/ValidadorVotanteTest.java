package ungs.edu.ve.controlador;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.ve.modelo.Estado;
import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.Voto;
import ungs.edu.ve.modelo.dao.impl.ValidadorVotanteMock;
import ungs.edu.ve.util.CONSTANTE;

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
		Votante votante=new Votante();
		Estado estado=new Estado();
		estado.setCodigo(CONSTANTE.ESTADO_INICIAL);
		votante.setEstado(estado);
		validadorVotante.estadoValido(votante);

	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		ValidadorVotante validadorVotante = null;
		validadorVotante.getVotanteDAO();

	}
	
}
