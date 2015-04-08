package ungs.edu.ve.modelo.dao;

import java.util.List;

import org.hibernate.HibernateException;


public interface EntidadDAO<T>{

	public void guardar(T entidad) throws HibernateException;
	
	public void guardarList(List<T> entidad) throws HibernateException;

	public void actualizar(T entidad) throws HibernateException;

	public void eliminar(T entidad) throws HibernateException;

	public T getById(T clase, Long id) throws HibernateException;

	public List<T> getAll(T clase) throws HibernateException;
	
}
