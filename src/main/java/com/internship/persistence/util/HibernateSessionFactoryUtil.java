package com.internship.persistence.util;

import com.internship.persistence.model.ClientEntity;
import com.internship.persistence.model.LicenseEntity;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateSessionFactoryUtil {
    private static volatile SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory () {
        if (sessionFactory == null) {
            synchronized (HibernateSessionFactoryUtil.class) {
                if (sessionFactory == null) {
                    Configuration config = new Configuration();
                    Properties properties = new Properties();
                    properties.put(Environment.DRIVER, "org.postgresql.Driver");
                    properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/licensedatabase");
                    properties.put(Environment.USER, "postgres");
                    properties.put(Environment.PASS, "00illeras");
                    properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL10Dialect");
                    properties.put(Environment.POOL_SIZE, 5);
                    properties.put(Environment.SHOW_SQL, true);
                    config.setProperties(properties);
                    config.addAnnotatedClass(LicenseEntity.class);
                    config.addAnnotatedClass(ClientEntity.class);
                    StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
                    sessionFactory = config.buildSessionFactory(standardServiceRegistry);
                }
            }
        }
        return sessionFactory;
    }
}
