package ungs.edu.ve.modelo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TerminalTest {
	private static final long ID = 1000l;
	private static final String DESCRIPCION = "TERMINAL 01";

	private Terminal terminal;

	@Before
	public void preparar() {
		terminal = new Terminal();
		terminal.setId(ID);
		terminal.setDescripcion(DESCRIPCION);

	}

	@Test
	public void testGetterTerminal() {

		Assert.assertNotNull(terminal);
		Assert.assertEquals(terminal.getDescripcion(), DESCRIPCION);
		Assert.assertTrue(terminal.getId() == ID);

	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		Terminal terminalNull = null;
		terminalNull.getDescripcion().equals(DESCRIPCION);

	}

}