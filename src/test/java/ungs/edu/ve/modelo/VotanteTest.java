package ungs.edu.ve.modelo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class VotanteTest {

	private static final long ID = 1000l;
	private static final String NOMBRE = "ALBERTO";
	private static final String APELLIDO = "PEREZ";
	private static final Integer NRODOCUMENTO = 33282892;
	private static final String TIPO = "DOCENTE";
	private static final Estado ESTADO=new Estado();
	private static final Claustro CLAUSTRO=new Claustro();
	
	private Votante votante;

	@Before
	public void preparar() {
		votante = new Votante();
		votante.setId(ID);
		votante.setNombre(NOMBRE);
		votante.setApellido(APELLIDO);
		votante.setNroDocumento(NRODOCUMENTO);
		votante.setTipo(TIPO);
		votante.setEstado(ESTADO);
		votante.setClaustro(CLAUSTRO);
	}

	@Test
	public void testGetterVotante() {

		Assert.assertNotNull(votante);
		Assert.assertEquals(votante.getApellido(), APELLIDO);
		Assert.assertEquals(votante.getNombre(), NOMBRE);
		Assert.assertEquals(votante.getTipo(), TIPO);
		Assert.assertTrue(votante.getId() == ID);
		Assert.assertTrue(votante.getNroDocumento() == NRODOCUMENTO);
		Assert.assertTrue(votante.getClaustro() == CLAUSTRO);
		Assert.assertTrue(votante.getEstado() == ESTADO);
		

	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		Votante votanteNull = null;
		votanteNull.getTipo().equals(TIPO);

	}

}