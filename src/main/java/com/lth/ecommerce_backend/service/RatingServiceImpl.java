package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.exception.ProductException;
import com.lth.ecommerce_backend.model.Product;
import com.lth.ecommerce_backend.model.Rating;
import com.lth.ecommerce_backend.model.User;
import com.lth.ecommerce_backend.repository.RatingRepository;
import com.lth.ecommerce_backend.request.RatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private ProductService productService;
    @Override
    public Rating createRating(RatingRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Rating rating = new Rating();
        rating.setProduct(product);
        rating.setUser(user);
        rating.setRating(req.getRating());
        rating.setCreatedAt(LocalDateTime.now());
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getProductsRating(Long productId) {
        return ratingRepository.getAllProductsRating(productId);
    }
}
