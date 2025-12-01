package com.adminPanel.app.service;



import com.adminPanel.app.model.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(int id);
    public Product findById(int id);
    public List<Product> getAllProducts();
    public List<Product> findByName(String name);
}
