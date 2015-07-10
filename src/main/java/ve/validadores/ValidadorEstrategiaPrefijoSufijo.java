package ve.validadores;


public class ValidadorEstrategiaPrefijoSufijo extends ValidadorEstrategia {
	private String cadenaPrefijo;
	private String cadenaSufijo;
	
	

	public ValidadorEstrategiaPrefijoSufijo(String patron, String cadenaPrefijo, 
			String cadenaSufijo) throws Exception {
		super(patron);
		this.cadenaPrefijo = cadenaPrefijo;
		this.cadenaSufijo = cadenaSufijo;
	
	}

	public boolean validar(String nombreCol) throws Exception {
		if (super.validar(nombreCol) && nombreCol.startsWith(cadenaPrefijo) 
				&& nombreCol.endsWith(cadenaSufijo)) {
			return true;
			
		}return false;

	}

}
