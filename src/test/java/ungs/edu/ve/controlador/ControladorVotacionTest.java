package ungs.edu.ve.controlador;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.impl.EntidadDAOImplMock;
import ungs.edu.ve.modelo.dao.impl.EstadoDAOImplMock;
import ungs.edu.ve.modelo.dao.impl.ValidadorVotanteMock;
import ungs.edu.ve.modelo.dao.impl.VotanteDAOImplMock;

public class ControladorVotacionTest {
	private ControladorVotacion controladorVotacion;
	private ValidadorVotanteMock validadorVotanteMock =new ValidadorVotanteMock();
	private VotanteDAOImplMock votanteDaoMock= new VotanteDAOImplMock();
	private EstadoDAOImplMock estadoDAOImplMock=new EstadoDAOImplMock();
	private EntidadDAOImplMock claustroMock =new EntidadDAOImplMock();
	
	@Before
	public void preparar() {
		controladorVotacion = new ControladorVotacion();
		validadorVotanteMock.setVotanteDAO(votanteDaoMock);
		controladorVotacion.setEstadoDAO(estadoDAOImplMock);
		controladorVotacion.setValidador(validadorVotanteMock);
		controladorVotacion.setClaustroDao(claustroMock);
		controladorVotacion.setVotanteDAO(votanteDaoMock);
		
	}

	@Test
	public void habilitarVotanteValido() throws Exception {
		controladorVotacion.habilitarVotante(votanteDaoMock.getById(Votante.class, 1L));

	}
	
	@Test(expected = Exception.class)
	public void habilitarVotanteYaFinalizado() throws Exception{
		
		controladorVotacion.habilitarVotante(votanteDaoMock.getById(Votante.class, 2L));
		
	}
	
	@Test(expected = Exception.class)
	public void habilitarVotanteInexistente() throws Exception{
		controladorVotacion.habilitarVotante(null);
		
	}
	
	
	
	@Test
	public void inicializarTest(){
		controladorVotacion.inicializar();
	}
	
	

	

	
	
	

	


}
