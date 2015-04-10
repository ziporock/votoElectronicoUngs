package ungs.edu.ve.controlador;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ControladorVotacionTest {
	private ControladorVotacion controladorVotacion;

	
	@Before
	public void preparar() {
		controladorVotacion=new ControladorVotacion();
		controladorVotacion.inicializar();
	}
	
	@Test
	public void habilitarVotanteValido() throws Exception{
		controladorVotacion.habilitarVotante("2");
		
	}
	
	@Test
	public void habilitarVotanteYaFinalizado() throws Exception{
		controladorVotacion.habilitarVotante("1");
		
	}
	
	@Test
	public void habilitarVotanteInexistente() throws Exception{
		controladorVotacion.habilitarVotante("9012");
		
	}
	
	@Test
	public void habilitarDniInvalido() throws Exception{
		controladorVotacion.habilitarVotante("rewa1");
		
	}
	
	@Test
	public void cerrarVotoValido() throws Exception{
		controladorVotacion.cerrarVoto("2");
	}
	
	@Test
	public void cerrarVotoDniInexistente() throws Exception{
		controladorVotacion.cerrarVoto("20123");
	}
}
