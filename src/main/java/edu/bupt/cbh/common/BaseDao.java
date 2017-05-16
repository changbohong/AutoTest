package edu.bupt.cbh.common;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Created by scarlett on 2017/5/16.
 */
public class BaseDao extends HibernateDaoSupport{

    private static Configuration configuration = null;
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;

    /**
     * 注入SessionFactory
     */
    @Autowired
    public void setHibernateSessionFactory() {

        try {
            configuration = new Configuration().configure();
            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            this.setSessionFactory(sessionFactory);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

}
