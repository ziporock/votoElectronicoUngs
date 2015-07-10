package ve.datamapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DataMapperImpl<T> implements DataMapper<T> {

	public Collection<T> map(ResultSet resultSet, Class<T> type)
			throws SQLException, IllegalArgumentException,
			InvocationTargetException {
		Collection<T> mappedObjects = new LinkedList<T>();
		while (resultSet.next()) {
			mappedObjects.add(mapRow(resultSet, type));
		}
		return mappedObjects;
	}

	public List<String> getAtributos(String clase)
			throws ClassNotFoundException {
		List<String> atributos = new ArrayList<String>();
		Class userClass = Class.forName(clase);
		Field[] userFields = userClass.getDeclaredFields();
		for (Field field : userFields) {
			atributos.add(field.getName());
		}
		return atributos;
	}

	public T mapRow(ResultSet resultSet, Class<T> clase) throws SQLException,
			IllegalArgumentException, InvocationTargetException {

		Object object = null;
		try {
			Class claseDef = Class.forName(clase.getName());
			object = claseDef.newInstance();
			List<String> atributos = getAtributos(clase.getName());
			for (Method method : claseDef.getMethods()) {
				// find all the set methods
				if (method.getName().matches("set[A-Z].*")) {

					String nombreSinSet = method.getName();
					nombreSinSet = nombreSinSet.substring(3).toLowerCase();
					Class<?>[] tipo = method.getParameterTypes();
					Class tipoParametro = null;
					
					
					tipoParametro = getTipoParametro(tipo[0]);

					Object valor=resultSet.getObject(nombreSinSet);
					
					//Object valor = getValor(resultSet, nombreSinSet,  tipo[0].getClass().getCanonicalName());
				
					/*
					Class resultSetClass = resultSet.getClass();
					for (Method methodResultSet : claseDef.getMethods()) {
						if (methodResultSet.getName().matches(
								"get" + tipoParametro.toString())) {
							Object valor = method.invoke(resultSet,
									nombreSinSet);
							System.out.println(valor);
						}
					}*/

				//	String valor = resultSet.getString(nombreSinSet);

					System.out.println(method.toString());

					String valorString=resultSet.getString(nombreSinSet);
					method.invoke(object, toObject(tipoParametro, valorString));
				}

			}

		} catch (InstantiationException e) {
			System.out.println(e);
		} catch (IllegalAccessException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return (T) object;

	}

	public static Class getTipoParametro(Class tipo) throws ClassNotFoundException{
		String tipoString= tipo.getCanonicalName();
		Class result = null;
		if (tipoString.equalsIgnoreCase("int")
				|| tipoString.equalsIgnoreCase("java.lang.Integer")) {
			result = Class.forName("java.lang.Integer");
		}
		else if (tipoString.equalsIgnoreCase("char")
				|| tipoString.equalsIgnoreCase("java.lang.String")) {
			result = Class.forName("java.lang.String");
		}
		else if (tipoString.equalsIgnoreCase("float")
				|| tipoString.equalsIgnoreCase("java.lang.Float")) {
			result = Class.forName("java.lang.Float");
		}
		else if (tipoString.equalsIgnoreCase("double")
				|| tipoString.equalsIgnoreCase("java.lang.Double")) {
			result = Class.forName("java.lang.Double");
		}
		else if (tipoString.equalsIgnoreCase("java.sql.Date")
				|| tipoString.equalsIgnoreCase("java.util.Date")) {
			result = Class.forName("java.util.Date");
		}
		else if (tipoString.equalsIgnoreCase("boolean")
				|| tipoString.equalsIgnoreCase("java.lang.Boolean")) {
			result = Class.forName("java.lang.Boolean");
		}
		
		
		
		return result;
		
	}
	
	
	public static Object toObject( Class clazz, String value ) {
	    if( Boolean.class == clazz ) return Boolean.parseBoolean( value );
	    if( Byte.class == clazz ) return Byte.parseByte( value );
	    if( Short.class == clazz ) return Short.parseShort( value );
	    if( Integer.class == clazz ) return Integer.parseInt(value );
	    if( Long.class == clazz ) return Long.parseLong( value );
	    if( Float.class == clazz ) return Float.parseFloat( value );
	    if( Double.class == clazz ) return Double.parseDouble( value );
	    return value;
	}
	
	public static Object getValor(ResultSet resultSet, String campo, String tipo) {
		Object valor = null;
		try {
			if (tipo.equalsIgnoreCase("int")
					|| tipo.equalsIgnoreCase("integer")) {
				valor = resultSet.getInt(campo);
			}
			else if (tipo.equalsIgnoreCase("char")
					|| tipo.equalsIgnoreCase("java.lang.String")) {
				valor = resultSet.getString(campo);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return valor;

	}

}
