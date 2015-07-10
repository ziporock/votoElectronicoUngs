package ve.resolvedores;

import ve.validadores.ValidadorEstrategia;


public class ResuelveColumnaPrefijoSufijo extends ResuelveColumna{
	
	
	private int tamPrefijo;
	private int tamSufijo;
	
	
	
	public ResuelveColumnaPrefijoSufijo(ValidadorEstrategia validadorEstrategia,  String cadenaPrefijo , String cadenaSufijo ) {
		super(validadorEstrategia);
		
		tamPrefijo= cadenaPrefijo.length();
		tamSufijo= cadenaSufijo.length();
		
	}
	
		
	public String resolverColumna(String nombre) throws Exception {
		String result=nombre;
		int largo =0;
		if (tamPrefijo>0) {
			largo=result.length();
			result=result.substring(tamPrefijo,largo );
		} 
		if (tamSufijo>0){
			largo=result.length();
			result=result.substring(0,largo-tamSufijo);
		}
		
		return result;
	}



}
