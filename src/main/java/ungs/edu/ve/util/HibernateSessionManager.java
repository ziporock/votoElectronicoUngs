package ungs.edu.ve.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import ungs.edu.ve.modelo.Claustro;
import ungs.edu.ve.modelo.Estado;
import ungs.edu.ve.modelo.Lista;
import ungs.edu.ve.modelo.Terminal;
import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.Voto;

public class HibernateSessionManager {

	private static SessionFactory sessionFactory = buildSessionFactory();
	private static ServiceRegistry serviceRegistry;

	static Logger logger = Logger.getLogger(HibernateSessionManager.class);

	private static SessionFactory buildSessionFactory() {
		try {

			String PATH_HIBERNATE = "/hibernate.cfg.xml";

			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Votante.class)
					.addAnnotatedClass(Lista.class)
					.addAnnotatedClass(Votante.class)
					.addAnnotatedClass(Claustro.class)
					.addAnnotatedClass(Estado.class)
					.addAnnotatedClass(Voto.class)
					.addAnnotatedClass(Terminal.class)
					.configure(PATH_HIBERNATE);

			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			return sessionFactory;

		} catch (Throwable ex) {
			logger.error("error al crear la sessionFactory." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}
