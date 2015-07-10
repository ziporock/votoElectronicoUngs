package ve.tercerafase;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ve.resolvedores.ResuelveColumna;
import ve.resolvedores.ResuelveColumnaCompuesto;
import ve.resolvedores.ResuelveColumnaMinMay;
import ve.resolvedores.ResuelveColumnaNombreCompuesto;
import ve.resolvedores.ResuelveColumnaPrefijoSufijo;
import ve.validadores.ValidadorEstrategia;
import ve.validadores.ValidadorEstrategiaCompleja;
import ve.validadores.ValidadorEstrategiaPrefijoSufijo;

public class ResuelveColumnaTest {

	private static final String PATRONVALIDOS="[A-Za-z0-9_]+";
	private static final String PREFIJO="aa";
	private static final String SUFIJO="ff";
	private static final ValidadorEstrategia VALIDADORESTRATEGIA =new ValidadorEstrategia(PATRONVALIDOS);
	private static final String NOMBREENMAYUSCULA= "PERSONA";
	private static final String NOMBREENMINUSCULA= "persona";
	private static final String NOMBREINVALIDO= "asdS9393%%&";
	private static final String NOMBRECONPREFIJOSUFIJO= "aapersonaff";
	private ResuelveColumna resuelveColumaMayMin;
	private ResuelveColumna resuelveColumaPrefijoSufijo;
	private ResuelveColumna resuelveNombreCompuesto;
	private ResuelveColumna resuelveCompuesto;
	
	
	private ValidadorEstrategia validadorEstrategiaCompleja;
	private ValidadorEstrategia validadorPrefijoSufijo;
	
	private String nombreValido= "aajk993_93ff";
	
	private Method metodoPrefijo;
	private Method metodoSufijo;
	private Method metodoContieneUn;
	private String simbolo;
	
	
	private String nombreCompuesto= "persona_TABLA";
	private String nombrePrefijo= "aapersona";
	private String nombreSufijo= "personaaa";
	
	@Before
	public void init() throws NoSuchMethodException, SecurityException{
		this.metodoPrefijo= String.class.getMethod("startsWith", String.class) ;
		this.metodoSufijo= String.class.getMethod("endsWith", String.class) ;
		this.metodoContieneUn= String.class.getMethod("contains", CharSequence.class) ;
		this.simbolo="_";
	}
	
	
	//************************************
	//EstrategiaResuelveColumna por Minuscula y Mayuscula
	//************************************
	
	//Si es un nombre valido (el validador de esta estrategia , retorno true), 
	//debe retornar el nombre en minuscula con la primer letra en mayuscula
	@Test
	public void resolverNombreMayusculaMinusculaOKTest() throws Exception{
		resuelveColumaMayMin=new ResuelveColumnaMinMay(VALIDADORESTRATEGIA);
		Assert.assertEquals(true, resuelveColumaMayMin.esAplicable(NOMBREENMAYUSCULA));
		Assert.assertEquals("Persona",resuelveColumaMayMin.resolverColumna(NOMBREENMAYUSCULA) );
		Assert.assertEquals("Persona",resuelveColumaMayMin.resolverColumna(NOMBREENMINUSCULA) );
		
	}
	
	
	//Si es un nombre es invalido no se puede ejecutar la estrategia
	
	@Test
	public void resolverNombreMayusculaMinusculaMALTest() throws Exception{
		resuelveColumaMayMin=new ResuelveColumnaMinMay(VALIDADORESTRATEGIA);
		Assert.assertEquals(false, resuelveColumaMayMin.esAplicable(NOMBREINVALIDO));
		
	}
	
	
	//************************************
	//Estrategia Resuelve columna por Prefijo/sufijo
	//************************************
	
	//Si es un nombre valido (el validador de esta estrategia , retorno true),
	//debe retornar el nombre sin prefijo si solo se pasa una cadena de prefijo	
	@Test
	public void resolverColumnaPrefijoTest() throws Exception{	
		validadorEstrategiaCompleja = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
			metodoPrefijo, PREFIJO);
		resuelveColumaPrefijoSufijo=new ResuelveColumnaPrefijoSufijo(VALIDADORESTRATEGIA,"aa","");
		Assert.assertEquals(true, resuelveColumaPrefijoSufijo.esAplicable(nombrePrefijo));
		Assert.assertEquals("persona",resuelveColumaPrefijoSufijo.resolverColumna(nombrePrefijo) );
		

	}
	
	//Si es un nombre valido (el validador de esta estrategia , retorno true),
	//debe retornar el nombre sin sufijo si solo se pasa una cadena de sufijo
	@Test
	public void resolverColumnaSufijoTest() throws Exception{
		validadorEstrategiaCompleja = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoSufijo, SUFIJO);
			resuelveColumaPrefijoSufijo=new ResuelveColumnaPrefijoSufijo(VALIDADORESTRATEGIA,"","ff");
		Assert.assertEquals(true, resuelveColumaPrefijoSufijo.esAplicable(nombreSufijo));
		Assert.assertEquals("persona",resuelveColumaPrefijoSufijo.resolverColumna(nombreSufijo) );
		

	}
	
	
	//Si es un nombre valido (el validador de esta estrategia , retorno true),
	//debe retornar el nombre sin prefijo y sufijo si se pasa ambas cadenas
	@Test
	public void resolverColumnaPrefijoSufijoTest() throws Exception{
		validadorPrefijoSufijo = new ValidadorEstrategiaPrefijoSufijo(PATRONVALIDOS,
				PREFIJO, SUFIJO);
			resuelveColumaPrefijoSufijo=new ResuelveColumnaPrefijoSufijo(VALIDADORESTRATEGIA,"aa","ff");
		Assert.assertEquals(true, resuelveColumaPrefijoSufijo.esAplicable(NOMBRECONPREFIJOSUFIJO));
		Assert.assertEquals("persona",resuelveColumaPrefijoSufijo.resolverColumna(NOMBRECONPREFIJOSUFIJO) );
		
	}
	
	//SSi es un nombre es invalido no se puede ejecutar la estrategia
		@Test
		public void resolverColumnaPrefijoSufijoInvalidoTest() throws Exception{
			validadorPrefijoSufijo = new ValidadorEstrategiaPrefijoSufijo(PATRONVALIDOS,
					PREFIJO, SUFIJO);
				resuelveColumaPrefijoSufijo=new ResuelveColumnaPrefijoSufijo(VALIDADORESTRATEGIA,"aa","ff");
			Assert.assertEquals(false, resuelveColumaPrefijoSufijo.esAplicable(NOMBREINVALIDO));
			
			
		}
	
	
	
	//************************************
	//Estrategia Resuelve columna con nombre Compuesto
	//************************************

		//Si es un nombre valido, separa la palabra compuesta , unida por simbolos,
		//en una palabra donde el inicio de cada palabra comienza con mayuscula
	@Test
	public void resolverColumnaConseparadorTest() throws Exception{
		validadorEstrategiaCompleja=new ValidadorEstrategiaCompleja(this.PATRONVALIDOS, metodoContieneUn, simbolo);
		resuelveNombreCompuesto=new ResuelveColumnaNombreCompuesto(validadorEstrategiaCompleja,simbolo);
		Assert.assertEquals(true, resuelveNombreCompuesto.esAplicable(nombreCompuesto));
		Assert.assertEquals("personaTABLA",resuelveNombreCompuesto.resolverColumna(nombreCompuesto) );
		

	}
	
	//SSi es un nombre es invalido no se puede ejecutar la estrategia
	@Test
	public void resolverColumnaNombreCompuestoInvalidoTest() throws Exception{
		validadorEstrategiaCompleja=new ValidadorEstrategiaCompleja(this.PATRONVALIDOS, metodoContieneUn, simbolo);
		resuelveNombreCompuesto=new ResuelveColumnaNombreCompuesto(validadorEstrategiaCompleja,simbolo);
		Assert.assertEquals(false, resuelveNombreCompuesto.esAplicable(NOMBREINVALIDO));
		
		
	}
	
	//************************************
	//Toma estrategias atomicas y las ejecuta en secuencia, transformado un nombre en cada una de las estrategias
	//************************************

	//Debera retornar la transformaicon en el orden de creacion de las estrategias.
	@Test
	public void resolverColumnaCompuestoOKTest() throws Exception{
		List<ResuelveColumna> resolvedores=new ArrayList<ResuelveColumna>();
		validadorEstrategiaCompleja = new ValidadorEstrategiaCompleja(PATRONVALIDOS,
				metodoSufijo, SUFIJO);
			resuelveColumaPrefijoSufijo=new ResuelveColumnaPrefijoSufijo(VALIDADORESTRATEGIA,"","ff");
		resuelveColumaMayMin=new ResuelveColumnaMinMay(VALIDADORESTRATEGIA);
		resolvedores.add(resuelveColumaPrefijoSufijo);
		resolvedores.add(resuelveColumaMayMin);
		resuelveCompuesto=new ResuelveColumnaCompuesto(VALIDADORESTRATEGIA,resolvedores);
		Assert.assertEquals(true, resuelveCompuesto.esAplicable(NOMBRECONPREFIJOSUFIJO));
		Assert.assertEquals("Aapersona", resuelveCompuesto.resolverColumna(NOMBRECONPREFIJOSUFIJO));
	}
	
	//Debera retornar la transformaicon en el orden de creacion de las estrategias.
	@Test
	public void resolverColumnaCompuestoInvalidoTest() throws Exception{
		List<ResuelveColumna> resolvedores=new ArrayList<ResuelveColumna>();
		resuelveCompuesto=new ResuelveColumnaCompuesto(VALIDADORESTRATEGIA,resolvedores);
		Assert.assertEquals(false, resuelveCompuesto.esAplicable(NOMBREINVALIDO));
		
	}
	
}
