package ve.resolvedores;

import ve.validadores.ValidadorEstrategia;

public class ResuelveColumnaMinMay extends ResuelveColumna {

	public ResuelveColumnaMinMay(ValidadorEstrategia validadorEstrategia) {

		super(validadorEstrategia);
	}

	public String resolverColumna(String nombre) throws Exception {
		String result = nombre.toLowerCase();
		result = nombre.substring(0, 1).toUpperCase()
				+ result.substring(1, nombre.length());
		return result;
	}

}
