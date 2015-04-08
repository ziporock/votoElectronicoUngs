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
public class EntidadDAOImpl<T> implements EntidadDAO {

	Logger logger = Logger.getLogger(EntidadDAO.class);
	private Session session;

	public void guardar(Object entidad) {
		logger.info("Guardando " + entidad.getClass());

		try {
			iniciaConexion();
			getSession().save(entidad);
			getTransaction().commit();

		} catch (HibernateException he) {
			logger.error("Error al guardar: " + entidad.getClass() + "DAO");
			manejaExcepcion(he);

		} finally {
			getSession().close();
		}
	}

	public void guardarList(List entidad) throws HibernateException {
		logger.info("Guardando " + entidad.getClass());

		try {
			iniciaConexion();
			for (Object o : entidad)
				getSession().save(o);

			getTransaction().commit();

		} catch (HibernateException he) {
			logger.error("Error al guardar: " + entidad.getClass() + "DAO");
			manejaExcepcion(he);

		} finally {
			getSession().close();
		}
	}

	/**
	 * 
	 */
	public void actualizar(Object entidad) throws HibernateException {
		logger.info("Actualizando: " + entidad.getClass());

		try {
			iniciaConexion();
			getSession().update(entidad);

			getTransaction().commit();

		} catch (HibernateException he) {
			logger.error("Error al actualizar: " + entidad.getClass() + "DAO");
			manejaExcepcion(he);

		} finally {
			getSession().close();
		}
	}

	/**
	 * 
	 */
	public void eliminar(Object entidad) throws HibernateException {
		logger.info("Eliminando sin baja logica: " + entidad.getClass());

		try {
			iniciaConexion();
			getSession().delete(entidad);
			getTransaction().commit();

		} catch (HibernateException he) {
			manejaExcepcion(he);

		} finally {
			getSession().close();
		}
	}

	@SuppressWarnings("unchecked")
	public Object getById(Object clase, Long id) throws HibernateException {
		logger.info("getById: " + clase);

		T object = null;
		try {
			iniciaConexion();
			Criteria criteria = this.getSession().createCriteria((Class) clase);
			criteria.add(Restrictions.eq("id", id));
			object = (T) criteria.uniqueResult();

		} catch (HibernateException e) {
			logger.error("Error al traer por Id: " + clase + "DAO");
			System.err.println(e);
			manejaExcepcion(e);

		} finally {
			getSession().close();
		}
		return object;
	}

	protected void iniciaConexion() throws HibernateException {
		session = HibernateSessionManager.getSessionFactory().openSession();

		session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he)
			throws HibernateException {
		session.getTransaction().rollback();
		throw new HibernateException(
				"Ocurrio un error en la capa de acceso a datos", he);
	}

	protected Session getSession() {
		return this.session;
	}

	protected Transaction getTransaction() {
		return session.getTransaction();
	}

	public List getAll(Object clase) throws HibernateException {
		logger.info("Pidiendo todos: " + clase);

		List object = null;
		try {
			iniciaConexion();
			Criteria criteria = this.getSession().createCriteria((Class) clase);
			object = (List) criteria.list();
			System.err.println("\t\t--> " + clase.toString() + "|cant: "
					+ object.size());
		} catch (HibernateException e) {
			logger.error("Error al traer todos: " + clase + "DAO");
			System.err.println(e);
			manejaExcepcion(e);
		} finally {
			this.getSession().close();
		}
		return object;
	}

}
