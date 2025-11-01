package com.spring.hibernate.hql;

import com.spring.hibernate.hql.model.Product;
import com.spring.hibernate.hql.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class UpdateData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Query query = session.createQuery("UPDATE Product SET stockQuantity =:q, name =:n WHERE id =:id");
            query.setParameter("q", 500);
            query.setParameter("n", "Book");
            query.setParameter("id", 1);

            query.executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }
}
