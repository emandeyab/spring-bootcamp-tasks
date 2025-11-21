package com.springApp.controller;

import com.springApp.model.Product;
import com.springApp.model.ProductDetails;
import com.springApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "homePage";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Product product = new Product();
        product.setDetails(new ProductDetails());
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        productService.addProduct(product);
        return  "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        if (product.getDetails() == null) {
            product.setDetails(new ProductDetails());
        }
        model.addAttribute("product", product);
        return "update";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") Product product) {
        if (product.getDetails() != null) {
            product.getDetails().setProduct(product);
        }
        productService.updateProduct(product);
        return "redirect:/";
    }


    @GetMapping("/details")
    public String viewProduct(@RequestParam("id") int id, Model model) {
        Product product = productService.findById(id);
        if (product.getDetails() == null) {
            product.setDetails(new ProductDetails());
        }
        model.addAttribute("product", product);
        return "viewDetails";
    }

    @GetMapping("/search")
    public String searchProduct(@RequestParam("search") String search, Model model) {
        List<Product> products = productService.findByName(search);
        model.addAttribute("products", products);
        model.addAttribute("search", search);
        return "homePage";
    }
}
