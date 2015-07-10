package ve.combos;

import java.util.Properties;

public class FactoryCombos {
	private Properties properties;
	private static final String NOMBREARCHIV_STRING = "/config.properties";
	

	public FactoryCombos() throws Exception{
		properties=new Properties();
		
		try {
		properties.load(FactoryCombos.class.getResourceAsStream(NOMBREARCHIV_STRING));
	}catch(Exception exception){
		throw exception;
	}
	}

	public Combo getCombo(String param) throws Exception  {
		Combo combo;
		try{
		String path_combos=properties.getProperty("directorio_combos");
		String clase_combo=properties.getProperty(param);
		assert clase_combo==null;
		Class clase= Class.forName(path_combos+clase_combo);
		combo= (Combo) clase.newInstance();
		}catch(Exception exception){
			throw exception;
		}
		return combo; 
	}

}
