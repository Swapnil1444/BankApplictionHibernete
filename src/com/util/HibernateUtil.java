package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Accountdetails;
import com.model.BankTransaction;
import com.model.User;

public class HibernateUtil {

	private static SessionFactory sf;

	private HibernateUtil() {
		// TODO Auto-generated constructor stub
	}

	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			Configuration configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Hibernate");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "9309");

			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			configuration.setProperty("hibernate.show_sql", "true");

			configuration.addAnnotatedClass(User.class);
			configuration.addAnnotatedClass(Accountdetails.class);
			configuration.addAnnotatedClass(BankTransaction.class);

			sf = configuration.buildSessionFactory();
		}

		return sf;

	}
	
	public static void shutdown() {
        if (sf != null && !sf.isClosed()) {
            sf.close();
        }
    }
}
