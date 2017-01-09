package com.nicolaslagos.festivities.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Nicolas Lagos
 * Class that creates and manages sessionFactory and sessions
 */
public class SessionUtil {

	private static SessionUtil instance = new SessionUtil();
	private SessionFactory sessionFactory;
	
	private SessionUtil() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	/**
	 * Returns an instance of SessionUtil
	 * @return SessionUtil instance
	 */
	public static SessionUtil getInstance() {
		return instance;
	}

	/**
	 * Asks factory to retrieve a session
	 * @return Session 
	 */
	public static Session getSession() {
		Session session = getInstance().sessionFactory.openSession();
		return session;
	}

}
