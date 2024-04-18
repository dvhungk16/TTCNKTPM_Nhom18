package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.exception.ProductException;
import com.lth.ecommerce_backend.model.Product;
import com.lth.ecommerce_backend.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    public List<Product> findAllProducts();
    public Product createProduct(CreateProductRequest req);
    public String deleteProduct(Long productId) throws ProductException;
    public Product updateProduct(Long productId, Product product) throws ProductException;
    public Product findProductById(Long id) throws ProductException;
    public List<Product> findProductByCategory(String category);
    public Page<Product> getAllProducts(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice,
                                        Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize);
}
