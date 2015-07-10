package ve.datamapper;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Primitivos {

	Map<String,Type> map;
	
	public Primitivos(){
		map=new HashMap<String, Type>();
		map.put("String", String.class);
		map.put("Integer", Integer.class);
		map.put("int", Integer.class);
		map.put("Double", Double.class);
		map.put("float", Float.class);
		map.put("Boolean", Boolean.class);
		map.put("bool", Boolean.class);
	}

	public Map<String, Type> getMap() {
		return map;
	}
	
	
}
