package ungs.edu.ve.modelo.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;

import ungs.edu.ve.modelo.dao.EstadoDAO;


public class EstadoDAOImplMock implements EstadoDAO{

	@Override
	public void guardar(Object entidad) throws HibernateException {
			
	}

	@Override
	public void guardarList(List entidad) throws HibernateException {
			
	}

	@Override
	public void actualizar(Object entidad) throws HibernateException {
	
		
	}

	@Override
	public void eliminar(Object entidad) throws HibernateException {
	
		
	}

	@Override
	public Object getById(Object clase, Long id) throws HibernateException {
		
		return null;
	}

	@Override
	public List getAll(Object clase) throws HibernateException {
	
		return null;
	}

	
}
