package ve.resolvedores;

import ve.validadores.ValidadorEstrategia;


public abstract class ResuelveColumna {
	protected ValidadorEstrategia validador;
	
	public ResuelveColumna(ValidadorEstrategia validador) {
		this.validador = validador;
	}

	public abstract String resolverColumna(String nombre) throws Exception;

	public boolean esAplicable(String nombre) throws Exception {
		return validador.validar(nombre);
	}
	

}
