package ve.resolvedores;

import java.util.ArrayList;
import java.util.List;

import ve.validadores.ValidadorEstrategia;


public class ResuelveColumnaNombreCompuesto extends ResuelveColumna{

	private String simbolo;
	private ValidadorEstrategia validadorEstrategia;


	public ResuelveColumnaNombreCompuesto(ValidadorEstrategia validadorEstrategia,String simbolo) {
		super(validadorEstrategia);
		this.simbolo=simbolo;
	}
	
	public String resolverColumna(String nombre) throws Exception {
		List<String> result=new ArrayList<String>();
		String[] palabras=nombre.split(simbolo);
		for (String valor : palabras) {
			result.add(valor);
		}
		return concatenarLista(result);
	}
	
	
	public String concatenarLista(List<String> nombres){
		String result="";
		for (String string : nombres) {
			result+=string;
		}
		return result;
	}
	
}
