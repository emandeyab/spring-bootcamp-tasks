package com.springApp.controller;

import com.springApp.model.Product;
import com.springApp.model.ProductDetails;
import com.springApp.service.ProductService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(tags = "Product Controller", value = "Operations related to products and product details")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products/details")
    @ApiOperation(value = "Add new product details")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product details created successfully"),
            @ApiResponse(code = 400, message = "Invalid input")
    })
    public ResponseEntity<ProductDetails> addProduct(@RequestBody ProductDetails productDetails) {
        productService.addProduct(productDetails);
        return new ResponseEntity<>(productDetails, HttpStatus.OK);
    }

    @PutMapping("/products/details/{id}")
    @ApiOperation(value = "Update product details")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Product details updated successfully"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @ApiParam(name = "id", value = "ID of the product to update", required = true)
    public ResponseEntity<ProductDetails> updateProduct(@PathVariable("id") int id, @RequestBody ProductDetails productDetails) {
        productDetails.setId(id);
        productService.updateProduct(productDetails);
        return new ResponseEntity<>(productDetails, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    @ApiOperation(value = "Delete product")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Product deleted successfully"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/products/{id}")
    @ApiOperation(value = "Get product by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product fetched successfully"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    @ApiParam(name = "id", value = "ID of the product to fetch", required = true)
    public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products/details/{id}")
    @ApiOperation(value = "Get product details by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product details fetched successfully"),
            @ApiResponse(code = 404, message = "Product details not found")
    })
    @ApiParam(name = "id", value = "ID of the product details to fetch", required = true)
    public ResponseEntity<ProductDetails> getProductDetails(@PathVariable("id") int id) {
        ProductDetails details = productService.getProductDetailsById(id);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping("/products")
    @ApiOperation(value = "Get all products")
    @ApiResponse(code = 200, message = "List of products fetched successfully")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/details/name/{name}")
    @ApiOperation(value = "Get product details by name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Product details fetched successfully"),
            @ApiResponse(code = 404, message = "Product details not found")
    })
    @ApiParam(name = "name", value = "Name of the product", required = true)
    public ResponseEntity<ProductDetails> getProductDetailsByName(@PathVariable("name") String name) {
        ProductDetails details = productService.getProductDetailsByName(name);
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

}
