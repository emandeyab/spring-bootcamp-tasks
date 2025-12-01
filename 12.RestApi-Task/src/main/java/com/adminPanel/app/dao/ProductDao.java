package com.adminPanel.app.dao;



import com.adminPanel.app.model.Product;

import java.util.List;

public interface ProductDao {

    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(int id);
    public Product findById(int id);
    public List<Product> getAllProducts();
    public List<Product> findByName(String name);
}
