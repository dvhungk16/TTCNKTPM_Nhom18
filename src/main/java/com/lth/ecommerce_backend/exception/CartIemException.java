package com.lth.ecommerce_backend.exception;

import com.lth.ecommerce_backend.model.CartItem;

public class CartIemException extends Exception {
    public CartIemException(String message) {
        super(message);
    }
}
