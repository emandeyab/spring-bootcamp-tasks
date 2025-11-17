package com.springApp.dao;

import com.springApp.model.Product;

import java.util.List;

public interface ProductDao {

    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(int id);
    public Product findById(int id);
    public List<Product> getAllProducts();
    public List<Product> findByName(String name);
}
