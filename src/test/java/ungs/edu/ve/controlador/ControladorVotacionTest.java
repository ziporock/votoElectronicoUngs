package ungs.edu.ve.controlador;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.ve.modelo.dao.impl.EstadoDAOImplMock;
import ungs.edu.ve.modelo.dao.impl.ValidadorVotanteMock;
import ungs.edu.ve.modelo.dao.impl.VotanteDAOImplMock;

public class ControladorVotacionTest {
	private ControladorVotacion controladorVotacion;
	private ValidadorVotanteMock validadorVotanteMock =new ValidadorVotanteMock();
	private VotanteDAOImplMock votanteDaoMock= new VotanteDAOImplMock();
	private EstadoDAOImplMock estadoDAOImplMock=new EstadoDAOImplMock();
	
	@Before
	public void preparar() {
		controladorVotacion = new ControladorVotacion();
		validadorVotanteMock.setVotanteDAO(votanteDaoMock);
		controladorVotacion.setEstadoDAO(estadoDAOImplMock);
		controladorVotacion.setValidador(validadorVotanteMock);
		controladorVotacion.setVotanteDAO(votanteDaoMock);
		
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
