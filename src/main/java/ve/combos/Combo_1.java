package ve.combos;

import ve.resolvedores.ResuelveColumna;
import ve.resolvedores.ResuelveColumnaMinMay;
import ve.validadores.ValidadorEstrategia;

public class Combo_1 extends Combo {

	
	private static final String PATRONVALIDOS = "[A-Za-z0-9_]+";
	private static final ValidadorEstrategia VALIDADOR_ESTRATEGIA=new ValidadorEstrategia(PATRONVALIDOS);
	private static final ResuelveColumna RESUELVE_COLUMNA=new ResuelveColumnaMinMay(VALIDADOR_ESTRATEGIA);

	public String ejecutarCombo(String param) throws Exception{
		assert RESUELVE_COLUMNA.esAplicable(param);
		return RESUELVE_COLUMNA.resolverColumna(param);
		
	}

	
	
	
	
}
