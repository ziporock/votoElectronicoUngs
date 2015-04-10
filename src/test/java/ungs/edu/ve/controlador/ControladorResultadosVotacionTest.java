package ungs.edu.ve.controlador;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import ungs.edu.ve.modelo.Lista;
import ungs.edu.ve.modelo.ResultadoVotacion;

public class ControladorResultadosVotacionTest {

	private static final ResultadoVotacion RESULTADOS = new ResultadoVotacion() ;
	private static final long ID_1 = 100l;
	private static final String DESCRIPCION_1 = "PARTIDO OBRERO";
	private static final String NOMBRE_1 = "PO";
	private static final long ID_2 = 101l;
	private static final String DESCRIPCION_2 = "Pan y Rosas";
	private static final String NOMBRE_2 = "PA";

	private Lista lista1;
	private Lista lista2;
	private ControladorResultadosVotacion controladorResultadosVotacion;
	
	@Before
	public void preparar() {
		lista1 = new Lista();
		lista1.setId(ID_1);
		lista1.setNombre(NOMBRE_1);
		lista1.setDescripcion(DESCRIPCION_1);
		lista2 = new Lista();
		lista2.setId(ID_2);
		lista2.setNombre(NOMBRE_2);
		lista2.setDescripcion(DESCRIPCION_2);
		Map<Lista, Double> map= new HashMap<Lista, Double>();
		map.put(lista1, 60.0);
		map.put(lista2, 40.0);
		RESULTADOS.setResultados(map);
		controladorResultadosVotacion =new ControladorResultadosVotacion();
		controladorResultadosVotacion.setResultadoVotacion(RESULTADOS);
	}
	
	@Test
	public void getResultadosTest(){
		Assert.assertNotNull(controladorResultadosVotacion.getResultados());
	}
	
	@Test
	public void getGanadorTest(){
		Assert.assertEquals(lista1, controladorResultadosVotacion.getGanador());
	}
	
	
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void testNullPointer() {

		ControladorResultadosVotacion controladorResultadosVotacion = null;
		controladorResultadosVotacion.getResultados().equals(RESULTADOS);

	}
}
