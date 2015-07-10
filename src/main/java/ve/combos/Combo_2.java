package ve.combos;

import ve.resolvedores.ResuelveColumna;
import ve.resolvedores.ResuelveColumnaMinMay;
import ve.resolvedores.ResuelveColumnaPrefijoSufijo;
import ve.validadores.ValidadorEstrategia;
import ve.validadores.ValidadorEstrategiaPrefijoSufijo;

public class Combo_2 extends Combo {

	
	private static final String PATRONVALIDOS = "[A-Za-z0-9_]+";
	private static final String PREFIJO="aa";
	private static final String SUFIJO="ff";
	private static final ValidadorEstrategia VALIDADOR_ESTRATEGIA=new ValidadorEstrategia(PATRONVALIDOS);
	private static final ResuelveColumna RESUELVE_MAY_MIN=new ResuelveColumnaMinMay(VALIDADOR_ESTRATEGIA);
	
	private  ResuelveColumna RESUELVE_PRE_SUF;
	private  ValidadorEstrategia VALIDADOR_PRE_SUF;
	
	public Combo_2 () throws Exception{
		VALIDADOR_PRE_SUF = new ValidadorEstrategiaPrefijoSufijo(PATRONVALIDOS,
				PREFIJO, SUFIJO);
		RESUELVE_PRE_SUF=new ResuelveColumnaPrefijoSufijo(VALIDADOR_PRE_SUF,"aa","ff");
		
	}
	
	public String ejecutarCombo(String param) throws Exception{
		String result=param;
		assert RESUELVE_MAY_MIN.esAplicable(result);
		assert RESUELVE_PRE_SUF.esAplicable(result);
		result= RESUELVE_PRE_SUF.resolverColumna(result);
		return RESUELVE_MAY_MIN.resolverColumna(result);
		
	}

	
	
	
	
}
