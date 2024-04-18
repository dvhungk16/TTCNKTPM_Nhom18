package com.lth.ecommerce_backend.controller;

import com.lth.ecommerce_backend.exception.ProductException;
import com.lth.ecommerce_backend.model.Product;
import com.lth.ecommerce_backend.request.CreateProductRequest;
import com.lth.ecommerce_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products/findAll")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.ACCEPTED);
    }
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> findProductByCategoryHandler(@RequestParam String category,
                                                                      @RequestParam List<String> color,
                                                                      @RequestParam List<String> size,
                                                                      @RequestParam Integer minPrice,
                                                                      @RequestParam Integer maxPrice,
                                                                      @RequestParam Integer minDiscount,
                                                                      @RequestParam String sort,
                                                                      @RequestParam String stock,
                                                                      @RequestParam Integer pageNumber,
                                                                      @RequestParam Integer pageSize
                                                                      ) {
        Page<Product> res = productService.getAllProducts(category, color,size,minPrice,maxPrice,minDiscount,sort,stock,pageNumber,pageSize);
        System.out.println(category);
        System.out.println("Complete products !");
        return new ResponseEntity<Page<Product>>(res, HttpStatus.ACCEPTED);
    }
    @PostMapping("/products/create")
    public ResponseEntity<Product> createNewProduct(@RequestBody CreateProductRequest req) {
        Product p = productService.createProduct(req);
        return new ResponseEntity<>(p, HttpStatus.ACCEPTED);
    }
    @GetMapping("/products/id/{productId}")
    public ResponseEntity<Product> findProductByIdHandler(@PathVariable Long productId) throws ProductException {
        Product product = productService.findProductById(productId);
        return new ResponseEntity<Product>(product, HttpStatus.ACCEPTED);
    }
//    public ResponseEntity<List<Product>> searchProductHandler(@RequestParam String q) {
////        List<Product> products = productService.searchProduct(q);
////        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
//        return HttpStatus.OK;
//    }
}
