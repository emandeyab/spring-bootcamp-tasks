package com.spring;

import com.spring.model.Passport;
import com.spring.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class Create {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Passport passport = new Passport("111111");
        Person person= new Person("Eman", "Hendawy", new Date());
        try {
            session.beginTransaction();
            passport.setPerson(person);
            session.save(passport);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}