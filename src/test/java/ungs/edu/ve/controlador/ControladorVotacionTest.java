package ungs.edu.ve.controlador;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.ve.modelo.dao.impl.EstadoDAOImplMock;
import ungs.edu.ve.modelo.dao.impl.ValidadorVotanteMock;
import ungs.edu.ve.modelo.dao.impl.VotanteDAOImplMock;

public class ControladorVotacionTest {
	private ControladorVotacion controladorVotacion;
	private EstadoDAOImplMock estadoDaoMock;
	private VotanteDAOImplMock votanteDaoMock;
	private ValidadorVotanteMock validadorVotante;
	
	@Before
	public void preparar() {
		controladorVotacion = new ControladorVotacion();
		estadoDaoMock=new EstadoDAOImplMock();
		validadorVotante=new ValidadorVotanteMock();
		
		votanteDaoMock=new VotanteDAOImplMock();
		validadorVotante.setVotanteDAO(votanteDaoMock);
		controladorVotacion.setEstadoDAO(estadoDaoMock );
		controladorVotacion.setVotanteDAO(votanteDaoMock);
		controladorVotacion.setValidador(validadorVotante);
	}

	@Test
	public void habilitarVotanteValido() throws Exception {
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
	
	@Test(expected = Exception.class)
	public void habilitarDniInvalido() throws Exception{
		controladorVotacion.habilitarVotante("rewa1");
		
	}
	

	
	
	

	
	

}
