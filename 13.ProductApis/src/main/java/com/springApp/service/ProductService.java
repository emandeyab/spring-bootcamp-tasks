package com.springApp.service;

import com.springApp.model.Product;
import com.springApp.model.ProductDetails;

import java.util.List;

public interface ProductService {
    public ProductDetails addProduct(ProductDetails product);
    public ProductDetails updateProduct(ProductDetails product);
    public void deleteProduct(int id);
    public Product getProductById(int id);
    public ProductDetails getProductDetailsById(int id);
    public List<Product> getAllProducts();
    public ProductDetails getProductDetailsByName(String name);
}
