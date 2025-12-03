package com.adminPanel.app.controller;

import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }


    @PostMapping()
    public Product addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return product;
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        if (product.getDetails() == null) {
            product.setDetails(new ProductDetails());
        }
        productService.updateProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        Product product = productService.findById(id);
        if (product.getDetails() == null) {
            product.setDetails(new ProductDetails());
        }
        return product;
    }

    @GetMapping("/search")
    public List<Product> searchProduct(@RequestParam("search") String search, Model model) {
        List<Product> products = productService.findByName(search);
        return products;
    }
}
