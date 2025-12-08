package com.springApp.dao;

import com.springApp.model.Product;
import com.springApp.model.ProductDetails;

import java.util.List;

public interface ProductDao {

    public ProductDetails addProduct(ProductDetails productDetails);
    public ProductDetails updateProduct(ProductDetails productDetails);
    public void deleteProduct(int id);
    public Product getProductById(int id);
    public ProductDetails getProductDetailsById(int id);
    public List<Product> getAllProducts();
    public ProductDetails getProductDetailsByName(String name);
}
