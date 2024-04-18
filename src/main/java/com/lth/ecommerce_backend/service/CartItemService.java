package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.exception.CartIemException;
import com.lth.ecommerce_backend.exception.UserException;
import com.lth.ecommerce_backend.model.Cart;
import com.lth.ecommerce_backend.model.CartItem;
import com.lth.ecommerce_backend.model.Product;

public interface CartItemService {
    public CartItem createCartItem(CartItem cartItem);
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartIemException, UserException;
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);
    public void removeCartItem(Long userId, Long cartitemId) throws CartIemException, UserException;
    public CartItem findCartItemById(Long cartItemId) throws CartIemException;
}
