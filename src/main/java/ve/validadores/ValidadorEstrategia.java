package ve.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorEstrategia {

	private String patron;
	
	
	public ValidadorEstrategia(String patron){
		this.patron=patron;
	}
	
	
	public boolean validar(String nombreCol) throws Exception {
		Pattern pat = Pattern.compile(this.patron);
	     Matcher mat = pat.matcher(nombreCol);
	     if (mat.matches()) {
	       	return true;
		}
		return false ;
	}



	
	
}
