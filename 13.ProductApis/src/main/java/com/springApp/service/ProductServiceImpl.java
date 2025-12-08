package com.springApp.service;

import com.springApp.dao.ProductDao;
import com.springApp.exception.ProductNotFoundException;
import com.springApp.model.Product;
import com.springApp.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    @Transactional
    public ProductDetails addProduct(ProductDetails productDetails) {
        productDao.addProduct(productDetails);
        return productDetails;
    }

    @Override
    @Transactional
    public ProductDetails updateProduct(ProductDetails productDetails) {
        Product product = productDao.getProductById(productDetails.getProduct().getId());
        if (product == null) {
            throw new ProductNotFoundException("Cannot update: Product with ID "
                    + productDetails.getProduct().getId() + " not found");
        }
        return productDao.updateProduct(productDetails);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        Product product = productDao.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("Cannot delete: Product with ID " + id + " not found");
        }
        productDao.deleteProduct(id);
    }

    @Override
    @Transactional
    public Product getProductById(int id) {
        Product product = productDao.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
        return productDao.getProductById(id);
    }

    @Override
    @Transactional
    public ProductDetails getProductDetailsById(int id) {
        ProductDetails details = productDao.getProductDetailsById(id);
        if (details == null) {
            throw new ProductNotFoundException("Product details with ID " + id + " not found");
        }
        return productDao.getProductDetailsById(id);
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    @Override
    @Transactional
    public ProductDetails getProductDetailsByName(String name) {
        ProductDetails details = productDao.getProductDetailsByName(name);
        if (details == null) {
            throw new ProductNotFoundException("Product details with name " + name + " not found");
        }
        return productDao.getProductDetailsByName(name);
    }
}
