package ungs.edu.ve.modelo.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import ungs.edu.ve.modelo.dao.EntidadDAO;
import ungs.edu.ve.util.HibernateSessionManager;

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

	
	@SuppressWarnings("unchecked")
	public Object getById(Object clase, Long id) throws HibernateException {
		logger.info("getById: " + clase);
		return new Object();
	}
	
}