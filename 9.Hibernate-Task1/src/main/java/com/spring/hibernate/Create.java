package com.spring.hibernate;

import com.spring.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        User user = new User("Eman", "Deyab");
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }
}
