package com.example.app.controller.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Vinceal on 13.08.2014.
 */
public class Hibernate {
    private static SessionFactory sessionFactory;

    static {

        try {
            Configuration mConf = new Configuration();
            mConf.configure();
            ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(mConf.getProperties()).build();
            sessionFactory = mConf.buildSessionFactory(sr);

        }catch (Exception e){

            e.printStackTrace();
        }

    }
    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }
}
