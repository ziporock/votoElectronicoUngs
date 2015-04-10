package ungs.edu.ve.controlador;

import org.junit.Before;
import org.junit.Test;

public class ValidadorVotanteTest {

	private ValidadorVotante validadorVotante;
	private ControladorVotacion controladorVotacion;

	@Before
	public void preparar() {
		validadorVotante = new ValidadorVotante();
		controladorVotacion = new ControladorVotacion();
		controladorVotacion.inicializar();
	}

	@Test
	public void obtenerVotanteValido() throws Exception {
		controladorVotacion.habilitarVotante("2");

	}

	@Test
	public void obtenerVotanteInexistente() throws Exception {
		controladorVotacion.habilitarVotante("2009");

	}

	@Test
	public void obtenerVotanteDatosInvalidos() throws Exception {
		controladorVotacion.habilitarVotante("2009");

	}
	
	@Test
	public void obtenerVotanteExistente(){
		validadorVotante.obtenerVotante("2");
	}
	
	@Test
	public void obtenerVotanteNoExistente(){
		validadorVotante.obtenerVotante("200");
	}
	
	@Test
	public void obtenerVotanteConEstadoValido(){
		validadorVotante.obtenerVotante("2");
	}
	
	
	@Test
	public void obtenerVotanteConEstadoInvalido(){
		validadorVotante.obtenerVotante("1");
	}

}
