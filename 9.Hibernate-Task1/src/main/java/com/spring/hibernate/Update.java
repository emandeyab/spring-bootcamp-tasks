package com.spring.hibernate;

import com.spring.hibernate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Update {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        int userId = 1;
        try {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            user.setLastName("Deyab Hendawy");
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }
}
