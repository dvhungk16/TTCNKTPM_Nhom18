package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.exception.ProductException;
import com.lth.ecommerce_backend.model.Cart;
import com.lth.ecommerce_backend.model.User;
import com.lth.ecommerce_backend.request.AddItemRequest;

public interface CartService {
    public Cart createCart(User user);
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;
    public Cart findUserCart(Long userId);

}
