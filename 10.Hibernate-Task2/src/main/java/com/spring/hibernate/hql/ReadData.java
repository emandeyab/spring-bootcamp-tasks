package com.spring.hibernate.hql;

import com.spring.hibernate.hql.model.Product;
import com.spring.hibernate.hql.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ReadData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Query<Product> query = session.createQuery("from Product");
            query.setFirstResult(0);
            query.setMaxResults(10);

            List<Product> products = query.getResultList();

            for (Product product : products) {
                System.out.println(product);
            }

            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }
}
