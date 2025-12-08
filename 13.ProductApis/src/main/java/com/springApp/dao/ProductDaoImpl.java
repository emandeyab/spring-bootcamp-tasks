package com.springApp.dao;

import com.springApp.model.Product;
import com.springApp.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public ProductDetails addProduct(ProductDetails productDetails) {
        Session session = sessionFactory.getCurrentSession();
        if (productDetails.getProduct() != null) {
            session.save(productDetails.getProduct());
        }
        session.save(productDetails);
        return productDetails;
    }


    @Override
    @Transactional
    public ProductDetails updateProduct(ProductDetails productDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(productDetails);
        return productDetails;
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
    public Product getProductById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
    }

    @Override
    public ProductDetails getProductDetailsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(ProductDetails.class, id);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> products = session.createQuery("from Product", Product.class).getResultList();
        return products;
    }

    @Override
    @Transactional
    public ProductDetails getProductDetailsByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from ProductDetails p where p.name = :n", ProductDetails.class)
                .setParameter("n", name)
                .uniqueResult();
    }
}
