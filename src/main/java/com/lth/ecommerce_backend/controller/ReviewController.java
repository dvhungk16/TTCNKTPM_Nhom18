package com.lth.ecommerce_backend.controller;

import com.lth.ecommerce_backend.exception.ProductException;
import com.lth.ecommerce_backend.exception.UserException;
import com.lth.ecommerce_backend.model.Review;
import com.lth.ecommerce_backend.model.User;
import com.lth.ecommerce_backend.request.ReviewRequest;
import com.lth.ecommerce_backend.service.ReviewService;
import com.lth.ecommerce_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;
    @PostMapping("/create")
    public ResponseEntity<Review> createNewReview(@RequestBody ReviewRequest req,
                                                  @RequestHeader("Authorization")String jwt) throws UserException, ProductException {
        User user = userService.findUserByJwt(jwt);
        Review review = reviewService.createReview(req, user);
        return new ResponseEntity<Review>(review, HttpStatus.CREATED);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Review>> getProductsReview(@PathVariable("productId") Long productId) throws UserException, ProductException {
        List<Review> reviews = reviewService.getAllReviews(productId);
        return new ResponseEntity<>(reviews, HttpStatus.CREATED);
    }
}
