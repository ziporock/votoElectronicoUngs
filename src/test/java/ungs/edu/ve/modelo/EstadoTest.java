package ungs.edu.ve.modelo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class EstadoTest {

	private static final long ID = 1l;
	private static final String DESCRIPCION = "EL VOTANTE SE ENCUENTRA DENTRO DE EL CUARTO OSCURO";
	private static final String CODIGO = "VOTANDO";

	private Estado estado;

	@Before
	public void preparar() {
		estado = new Estado();
		estado.setId(ID);
		estado.setCodigo(CODIGO);
		estado.setDescripcion(DESCRIPCION);

	}

	@Test
	public void testGetterEstado() {

		Assert.assertNotNull(estado);
		Assert.assertEquals(estado.getDescripcion(), DESCRIPCION);
		Assert.assertEquals(estado.getCodigo(), CODIGO);
		Assert.assertTrue(estado.getId() == ID);

	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		Estado estadoNull = null;
		estadoNull.getDescripcion().equals(DESCRIPCION);

	}
}
