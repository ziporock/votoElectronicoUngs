package ve.resolvedores;

import java.util.List;

import ve.validadores.ValidadorEstrategia;

public class ResuelveColumnaCompuesto extends ResuelveColumnaMinMay {

	private List<ResuelveColumna> estrategias;

	public ResuelveColumnaCompuesto(ValidadorEstrategia validadorEstrategia,
			List<ResuelveColumna> estrategias) {
		super(validadorEstrategia);
		this.estrategias = estrategias;
	}

	@Override
	public boolean esAplicable(String nombre) throws Exception {
		if (!super.esAplicable(nombre)) {
			return false;
		}	
			for (ResuelveColumna resuelveColumna : estrategias) {
				if (!resuelveColumna.esAplicable(nombre)) {
					return false;
				}
			}
		
		return true;

	}

	@Override
	public String resolverColumna(String nombre) throws Exception {
		for (ResuelveColumna resuelveColumna : estrategias) {
			nombre = resuelveColumna.resolverColumna(nombre);
		}
		return nombre;
	}

}