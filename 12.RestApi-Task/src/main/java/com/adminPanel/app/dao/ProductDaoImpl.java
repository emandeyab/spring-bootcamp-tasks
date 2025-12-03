package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addProduct(Product product) {
        ProductDetails productDetails = product.getDetails();
        if(productDetails != null){
            productDetails.setProduct(product);
        }
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        ProductDetails productDetails = product.getDetails();
        if(productDetails != null){
            productDetails.setProduct(product);
        }
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, id);
        ProductDetails productDetails = product.getDetails();
        if(productDetails != null){
            productDetails.setProduct(product);
        }
        session.delete(product);
    }

    @Override
    @Transactional
    public Product findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product").list();
        return products;
    }

    @Override
    @Transactional
    public List<Product> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product p where p.name like :name", Product.class)
                .setParameter("name", "%" + name + "%")
                .list();
    }
}
