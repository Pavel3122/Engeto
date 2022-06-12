package com.engeto.lekce11;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    static Item itemObj;
    static Session sessionObj;
    static SessionFactory sessionFactoryObj;

    private static SessionFactory buildSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, ServiceRegistry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate SessionFactory Instance
        sessionFactoryObj = configObj.buildSessionFactory(serviceRegistryObj);
        return sessionFactoryObj;
    }


    public static void main(String[] args) throws SQLException {
        System.out.println(".......App Start.......\n");
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.engeto.lekce11.eshop");
            EntityManager em = emf.createEntityManager();
//            sessionObj = buildSessionFactory().openSession();
//            sessionObj.beginTransaction();
//
//                itemObj = new Item();
//                itemObj.setName("Test Item2");
//                sessionObj.save(itemObj);
//
//            System.out.println("\n.......Records Saved Successfully To The Database.......\n");
//
//            // Committing The Transactions To The Database
//            sessionObj.getTransaction().commit();
        } catch(Exception sqlException) {
            if(sessionObj != null && sessionObj.getTransaction() != null) {
                System.out.println("\n.......Transaction Is Being Rolled Back.......");
                sessionObj.getTransaction().rollback();
            }
            sqlException.printStackTrace();
        } finally {
            if(sessionObj != null) {
                sessionObj.close();
            }
        }
    }
}
