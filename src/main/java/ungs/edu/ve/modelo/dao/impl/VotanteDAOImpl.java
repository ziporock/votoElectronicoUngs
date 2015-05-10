package ungs.edu.ve.modelo.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.VotanteDAO;

public class VotanteDAOImpl extends EntidadDAOImpl<Votante> implements
		VotanteDAO {

	@Override
	public Votante getByNroDocumento(Integer nroDocumento)
			throws HibernateException {
		logger.info("getByNroDocumento: " + nroDocumento);

		Votante votante = null;
		try {
			iniciaConexion();
			Criteria criteria = this.getSession().createCriteria(Votante.class);
			criteria.add(Restrictions.eq("nroDocumento", nroDocumento));
			votante = (Votante) criteria.uniqueResult();

		} catch (HibernateException e) {
			logger.error("Error al traer por numero Documento: " + nroDocumento
					+ "DAO");
			System.err.println(e);
			manejaExcepcion(e);

		} finally {
			getSession().close();
		}
		return votante;
	}

}
