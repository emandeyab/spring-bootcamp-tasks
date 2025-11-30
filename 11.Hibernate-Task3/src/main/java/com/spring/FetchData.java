package com.spring;

import com.spring.model.Passport;
import com.spring.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Query<Person> query = session.createQuery("from Person", Person.class);
            query.setFirstResult(0);
            query.setMaxResults(5);
            List<Person> persons = query.getResultList();
            for (Person person : persons){
                System.out.println(person);
            }
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
