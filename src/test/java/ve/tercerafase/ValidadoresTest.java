package ve.tercerafase;

import java.lang.reflect.Method;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ve.validadores.ValidadorEstrategia;
import ve.validadores.ValidadorEstrategiaCompleja;
import ve.validadores.ValidadorEstrategiaPrefijoSufijo;

public class ValidadoresTest {

	private static final String PATRONVALIDOS = "[A-Za-z0-9_]+";
	private static final String PREFIJO = "aa";
	private static final String SUFIJO = "ff";
	private static final String SIMBOLO = "_";
	private static final String NOMBREVALIDO = "aajk993_93ff";
	private static final String NOMBREVALIDOPREFIJOINVALIDO = "jk993_93ff";
	private static final String NOMBREINVALIDO = "aasdS9393%%&ff";

	private Method metodoPrefijo;
	private Method metodoSufijo;
	private Method metodoContieneUn;
	private Method metodoInvalido;

	private ValidadorEstrategia validadorEstrategia;
	private ValidadorEstrategia validadorEstrategiaCompuesto;
	private ValidadorEstrategia validadorEstrategiaPrefijoSufijo;

	@Before
	public void init() throws NoSuchMethodException, SecurityException {
		this.metodoPrefijo = String.class.getMethod("startsWith", String.class);
		this.metodoSufijo = String.class.getMethod("endsWith", String.class);
		this.metodoContieneUn = String.class.getMethod("contains",
				CharSequence.class);
		this.metodoInvalido = String.class.getMethod("toLowerCase");
	}

	// *********************************
	// validador de nombre patron simple
	// *********************************

	// Si pongo un nombre valido para el patron este deve retornar true
	@Test
	public void validadorPatronSimpleOKTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategia(PATRONVALIDOS);
		Assert.assertEquals(true, validadorEstrategia.validar(NOMBREVALIDO));
	}

	// Si pongo un nombre invalido para el patron este deve retornar false
	@Test
	public void validadorPatronSimpleMalTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategia(PATRONVALIDOS);
		Assert.assertEquals(false, validadorEstrategia.validar(NOMBREINVALIDO));
	}

	// *********************************
	// validador de nombre patron y metodo
	// *********************************

	// Si pongo un nombre valido para el patron y ademas verifica el metodo
	// pasado por parametro este deve retornar true
	@Test
	public void validadorPrefijoTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoPrefijo, PREFIJO);
		Assert.assertEquals(true, validadorEstrategia.validar(NOMBREVALIDO));
	}

	// Si pongo un nombre invalido para el patron este deve retornar false
	@Test
	public void validadorPrefijoInvalidoTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoPrefijo, PREFIJO);
		Assert.assertEquals(false, validadorEstrategia.validar(NOMBREINVALIDO));
	}

	// Si pongo un nombre valido para el patron pero no valido para el metodo
	// este deve retornar false
	@Test
	public void validadorPrefijoInvalidoPatronValidoTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoPrefijo, PREFIJO);
		Assert.assertEquals(false,
				validadorEstrategia.validar(NOMBREVALIDOPREFIJOINVALIDO));
	}

	// Si pongo un metodo invalido este devolvera una excepcion
	@Test(expected = Exception.class)
	public void validadorMetodoInvalido() throws Exception {
		validadorEstrategia = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoInvalido, PREFIJO);
		Assert.assertEquals(false,
				validadorEstrategia.validar(NOMBREVALIDOPREFIJOINVALIDO));
	}
	
	// *********************************
	// validador de nombre para prefijo sufijo al mismo tiempo
	// *********************************
	
	//Si pongo un  nombre valido para el patron y ademas verifica ambos metodos pasados por parametro  este deve retornar true
			@Test
		public void validadorPrefijoSufijoTest() throws Exception {
			validadorEstrategia = new ValidadorEstrategiaPrefijoSufijo(PATRONVALIDOS,
					 PREFIJO,SUFIJO);
			Assert.assertEquals(true, validadorEstrategia.validar(NOMBREVALIDO));
		}

			
		// Si pongo un nombre invalido para el patron este deve retornar false
		@Test
		public void validadorPrefijoSufijoInvalidoTest() throws Exception {
			validadorEstrategia = new ValidadorEstrategiaPrefijoSufijo(PATRONVALIDOS,
					 PREFIJO,SUFIJO);
			Assert.assertEquals(false, validadorEstrategia.validar(NOMBREINVALIDO));
		}

		//Si pongo un  nombre valido para el patron pero no valido para alguno 
		//de los metodos este deve retornar false
		@Test
		public void validadorPrefijoSufijoInvalidoPatronValidoTest() throws Exception {
			validadorEstrategia = new ValidadorEstrategiaPrefijoSufijo(PATRONVALIDOS,
					 PREFIJO,SUFIJO);
			Assert.assertEquals(false,
					validadorEstrategia.validar(NOMBREVALIDOPREFIJOINVALIDO));
		}


	
	
	//OTRAS PRUEBAS DE VALIDADORES
	
	@Test
	public void validadorSufijoTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoSufijo, SUFIJO);
		Assert.assertEquals(true, validadorEstrategia.validar(NOMBREVALIDO));
	}

	@Test
	public void validadorSufijoInvalidoTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoSufijo, SUFIJO);
		Assert.assertEquals(false, validadorEstrategia.validar(NOMBREINVALIDO));
	}

	@Test
	public void validadorContieneTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoContieneUn, SIMBOLO);
		Assert.assertEquals(true, validadorEstrategia.validar(NOMBREVALIDO));
	}

	@Test
	public void validadorContieneInvalidoTest() throws Exception {
		validadorEstrategia = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoContieneUn, SIMBOLO);
		Assert.assertEquals(false, validadorEstrategia.validar(NOMBREINVALIDO));
	}

}
