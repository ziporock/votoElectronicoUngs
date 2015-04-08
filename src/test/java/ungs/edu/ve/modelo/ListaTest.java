package ungs.edu.ve.modelo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class ListaTest {

	private static final long ID = 100l;
	private static final String DESCRIPCION = "PARTIDO OBRERO";
	private static final String NOMBRE = "PO";

	private Lista lista;

	@Before
	public void preparar() {
		lista = new Lista();
		lista.setId(ID);
		lista.setNombre(NOMBRE);
		lista.setDescripcion(DESCRIPCION);

	}

	@Test
	public void testGetterLista() {

		Assert.assertNotNull(lista);
		Assert.assertEquals(lista.getDescripcion(), DESCRIPCION);
		Assert.assertEquals(lista.getNombre(), NOMBRE);
		Assert.assertTrue(lista.getId() == ID);

	}

	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		Lista listaNull = null;
		listaNull.getDescripcion().equals(DESCRIPCION);

	}
}