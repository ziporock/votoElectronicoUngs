package ungs.edu.ve.modelo;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class VotoTest {

	private static final long ID = 1000l;
	private static final Date FECHA = new Date();
	private static final Lista LISTA = new Lista();
	private static final Terminal TERMINAL = new Terminal();

	private Voto voto;

	@Before
	public void preparar() {
		voto = new Voto();
		voto.setId(ID);
		voto.setFechaVoto(FECHA);
		voto.setLista(LISTA);
		voto.setTerminal(TERMINAL);

	}

	@Test
	public void testGetterVotante() {

		Assert.assertNotNull(voto);
		Assert.assertEquals(voto.getFechaVoto(), FECHA);
		Assert.assertEquals(voto.getLista(), LISTA);
		Assert.assertEquals(voto.getTerminal(), TERMINAL);
		Assert.assertTrue(voto.getId() == ID);

	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		Voto votoNull = null;
		
		votoNull.getFechaVoto().equals(FECHA);

	}

}