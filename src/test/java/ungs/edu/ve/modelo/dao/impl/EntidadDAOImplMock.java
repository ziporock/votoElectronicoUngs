package ungs.edu.ve.modelo.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;

@SuppressWarnings("rawtypes")
public class EntidadDAOImplMock extends EntidadDAOImpl<Object> {

	public void guardar(Object entidad) {
		logger.info("guardar");
	}

	public void guardarList(List entidad) throws HibernateException {
		logger.info("guardarList");
	}		

	/**
	 * 
	 */
	public void actualizar(Object entidad) throws HibernateException {
		logger.info("actualizar");
	}

	/**
	 * 
	 */
	public void eliminar(Object entidad) throws HibernateException {
		logger.info("eliminar");
	}

	
	public Object getById(Object clase, Long id) throws HibernateException {
		logger.info("getById: " + clase);
		return new Object();
	}
	
}