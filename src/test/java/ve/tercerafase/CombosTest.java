package ve.tercerafase;

import org.junit.Assert;
import org.junit.Test;

import ve.combos.Combo;
import ve.combos.Combo_1;
import ve.combos.Combo_2;
import ve.combos.FactoryCombos;

public class CombosTest {
	
	private static final String RESULT_ESPERADO="Persona";
	private static final String PARAM_C1="persona";
	private static final String PARAM_C2="aapersonaff";
	private static final String COMBO_1="C1";
	private static final String COMBO_2="C2";
	
	
	@Test
	public void Combo_1_test() throws Exception{
		Combo_1 combo_1=new Combo_1();
		Assert.assertEquals(RESULT_ESPERADO,combo_1.ejecutarCombo(PARAM_C1));
	}
	
	@Test
	public void Combo_2_test() throws Exception{
		Combo_2 combo_2=new Combo_2();
		Assert.assertEquals(RESULT_ESPERADO,combo_2.ejecutarCombo(PARAM_C2));
	}
	
	//El parametro existe en el archivo config.properties, y la clase combo definida para el parametro existe se crea una instancia del mismo
	@Test
	public void Combo_1_Desde_Factory() throws Exception{
		FactoryCombos factoryCombos=new FactoryCombos();
		Combo combo = factoryCombos.getCombo(COMBO_1);
		Assert.assertEquals(RESULT_ESPERADO,combo.ejecutarCombo(PARAM_C1));
	}
	
	@Test
	public void Combo_2_Desde_Factory() throws Exception{
		FactoryCombos factoryCombos=new FactoryCombos();
		Combo combo = factoryCombos.getCombo(COMBO_2);
		Assert.assertEquals(RESULT_ESPERADO,combo.ejecutarCombo(PARAM_C2));
	}
	
	////El parametro existe en el archivo config.properties, y la clase combo definida para el parametro existe se crea una instancia del mismo
	@Test(expected = Exception.class)
	public void Combo_NO_EXISTE__Desde_Factory() throws Exception{
		FactoryCombos factoryCombos=new FactoryCombos();
		Combo combo = factoryCombos.getCombo("C50");
	}
	
	//El parametro existe en el archivo config.properties, pero esta mal configurada la clase, lanza una exepcion
	@Test(expected = Exception.class)
	public void Combo_Desde_Factory_CLASE_INEXISTENTE() throws Exception{
		FactoryCombos factoryCombos=new FactoryCombos();
		Combo combo = factoryCombos.getCombo("C3");
	
	}
}
