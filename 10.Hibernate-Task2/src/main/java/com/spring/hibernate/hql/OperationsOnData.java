package com.spring.hibernate.hql;

import com.spring.hibernate.hql.model.Product;
import com.spring.hibernate.hql.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class OperationsOnData {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            Query query1 = session.createQuery("SELECT SUM(stockQuantity) FROM Product");
            List<Integer> quatityList = query1.getResultList();
            System.out.println(quatityList.get(0));

            Query query2 = session.createQuery("SELECT AVG(price) FROM Product");
            List<Integer> sumList = query2.getResultList();
            System.out.println(sumList.get(0));

            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.toString());
        } finally {
            session.close();
        }
    }
}
