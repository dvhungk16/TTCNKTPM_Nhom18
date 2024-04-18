package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.exception.ProductException;
import com.lth.ecommerce_backend.model.Rating;
import com.lth.ecommerce_backend.model.Review;
import com.lth.ecommerce_backend.model.User;
import com.lth.ecommerce_backend.request.RatingRequest;
import com.lth.ecommerce_backend.request.ReviewRequest;

import java.util.List;

public interface ReviewService {
    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReviews(Long productId);
}
