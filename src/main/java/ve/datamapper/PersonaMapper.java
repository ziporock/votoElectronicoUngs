package ve.datamapper;


import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;



public class PersonaMapper  implements DataMapper<Persona> {

    public  Persona mapRow(ResultSet resultSet) throws SQLException {
      
    	Persona bean = new Persona();
    
    	bean.setFirstName(resultSet.getString("firstname"));
        bean.setLastName(resultSet.getString("lastname"));
     //   bean.setAge(resultSet.getInt("age"));
   
        return bean;
    }

	@Override
	public Persona mapRow(ResultSet resultSet, Class<Persona> clase)
			throws SQLException, IllegalArgumentException,
			InvocationTargetException {
		// TODO Auto-generated method stub
		return null;
	}

    
 
}