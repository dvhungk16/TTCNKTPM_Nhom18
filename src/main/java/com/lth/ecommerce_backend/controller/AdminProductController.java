package com.lth.ecommerce_backend.controller;

import com.lth.ecommerce_backend.exception.ProductException;
import com.lth.ecommerce_backend.model.Product;
import com.lth.ecommerce_backend.request.CreateProductRequest;
import com.lth.ecommerce_backend.response.ApiResponse;
import com.lth.ecommerce_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class AdminProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest req) {
        Product product = productService.createProduct(req);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<ApiResponse> createProduct(@PathVariable Long productId) throws ProductException {
        productService.deleteProduct(productId);
        ApiResponse response = new ApiResponse();
        response.setMessage("Product deleted successfully");
        response.setStatus(true);

        return new ResponseEntity<ApiResponse>(response, HttpStatus.ACCEPTED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.ACCEPTED);
    }
    @PutMapping("/{productId}/update")
    public ResponseEntity<Product> createProduct(@RequestBody Product req,
                                                     @PathVariable Long productId) throws ProductException {
        Product product = productService.updateProduct(productId, req);

        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
    }
    @PostMapping("/creates")
    public ResponseEntity<ApiResponse> createMultipleProducts(@RequestBody CreateProductRequest[] req) {
        for(CreateProductRequest product:req) {
            productService.createProduct(product);
        }
        ApiResponse res = new ApiResponse();
        res.setMessage("product created successfully");
        res.setStatus(true);
        return new ResponseEntity<>(res,HttpStatus.CREATED);
    }
}
