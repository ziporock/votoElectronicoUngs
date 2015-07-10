package ve.datamapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataMapper<T> {

	public T mapRow(ResultSet resultSet,Class<T> clase) throws SQLException, IllegalArgumentException, InvocationTargetException;

	
}