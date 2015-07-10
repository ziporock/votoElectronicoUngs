package ve.datamapper;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class DB<T> {

	private static String myDriver;
	private static String myUrl;
	private static Connection conn;
	private DataMapperImpl dataMapperImpl;

	public static void iniciarConexion() {
		try {
			myDriver = "com.mysql.jdbc.Driver";
			myUrl = "jdbc:mysql://localhost/votoElectronico";
			Class.forName(myDriver);
			conn = DriverManager.getConnection(myUrl, "root", "root");
			
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}
	
	
	/*
	public static void main(String[] args) {
		try {
			// create our mysql database connection
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost/votoElectronico";
			Class.forName(myDriver);
			Connection conn = DriverManager
					.getConnection(myUrl, "root", "root");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of
			// using "*"
			String query = "SELECT * FROM Persona";

			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			PersonaMapper mapper = new PersonaMapper();
			DataMapperImpl dataMapperImpl = new DataMapperImpl();

			Collection<Persona> list = dataMapperImpl.map(rs, mapper);

			// while (rs.next()) {
			for (Persona persona2 : list) {
				System.out.println(persona2.toString());
			}
			// }+ }
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
	}*/

	public static String createSelectQuery(Class clase) {
		String result = "select * from ";
		result += clase.getSimpleName();
		result += ";";
		return result;
	}

	public List<T> executeQuery(String query) {
		Collection<T> list=null;
		try {
			iniciarConexion();
			Statement st = conn.createStatement();
			this.dataMapperImpl=new DataMapperImpl<Persona>();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			
			list = dataMapperImpl.map(rs, Persona.class);

			
			st.close();
		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}
		return (List<T>) list;
	}
	
/*
    private T mapRow(ResultSet resultSet) throws SQLException {
      
    	Persona bean = new Persona();
    
    	bean.setFirstName(resultSet.getString("firstname"));
        bean.setLastName(resultSet.getString("lastname"));
        bean.setAge(resultSet.getInt("age"));
   
   //     return bean;
        return null;
    }
    
	public static <T> Collection<T> map(ResultSet resultSet) throws SQLException {
	    Collection<T> mappedObjects = new LinkedList<T>();
	    while(resultSet.next() ){
	        mappedObjects.add(mapRow(resultSet));
	    }
	    return mappedObjects;
	}
	
	
	public List<String> getAtributos (String clase) throws ClassNotFoundException{
		List<String> atributos=new ArrayList<String>();
		Class userClass = Class.forName(clase);
		Field[] userFields = userClass.getDeclaredFields();
		for (Field field : userFields) {
			atributos.add(field.getName());
		}
		return atributos;
	}
*/
}
