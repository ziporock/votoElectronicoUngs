package ve.validadores;

import java.lang.reflect.Method;

public class ValidadorEstrategiaCompleja extends ValidadorEstrategia {
	private String valorMetodo;

	private Method metodo;

	public ValidadorEstrategiaCompleja(String patron, Method metodo,
			String valor) {
		super(patron);
		this.metodo = metodo;
		this.valorMetodo = valor;

	}

	public boolean validar(String nombreCol) throws Exception {
		try{
		if (super.validar(nombreCol)) {
			boolean resultado = (boolean) metodo.invoke(nombreCol, valorMetodo);
			if (resultado) {
				return true;
			}

		}
		return false;}catch(Exception exception){
			throw exception;
		}

	}

}
