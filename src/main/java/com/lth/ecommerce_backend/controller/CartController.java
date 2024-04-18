package com.lth.ecommerce_backend.controller;

import com.lth.ecommerce_backend.exception.CartIemException;
import com.lth.ecommerce_backend.exception.ProductException;
import com.lth.ecommerce_backend.exception.UserException;
import com.lth.ecommerce_backend.model.Cart;
import com.lth.ecommerce_backend.model.CartItem;
import com.lth.ecommerce_backend.model.Product;
import com.lth.ecommerce_backend.model.User;
import com.lth.ecommerce_backend.request.AddItemRequest;
import com.lth.ecommerce_backend.response.ApiResponse;
import com.lth.ecommerce_backend.service.CartItemService;
import com.lth.ecommerce_backend.service.CartService;
import com.lth.ecommerce_backend.service.UserService;
import jakarta.persistence.TableGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization")String jwt) throws UserException {
        User user = userService.findUserByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }
    @PutMapping("/add")
    public ResponseEntity<ApiResponse>addItemToCart(@RequestBody AddItemRequest req,
                                                    @RequestHeader("Authorization") String jwt) throws UserException,ProductException{
        User user = userService.findUserByJwt(jwt);

        cartService.addCartItem(user.getId(), req);

        ApiResponse res = new ApiResponse();
        res.setMessage("Item added to cart !");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteItemInCart(
                                                        @PathVariable("cartItemId") Long cartItemId,
                                                        @RequestHeader("Authorization")String jwt) throws UserException, ProductException, CartIemException {
        User user = userService.findUserByJwt(jwt);
        cartItemService.removeCartItem(user.getId(), cartItemId);
        ApiResponse res = new ApiResponse();
        res.setMessage("Item deleted to cart !");
        res.setStatus(true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PutMapping("/update/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItem(@PathVariable("cartItemId") Long cartItemId,
                                                   @RequestBody CartItem cartItem,
                                                   @RequestHeader("Authorization")String jwt) throws UserException, ProductException, CartIemException {
        User user = userService.findUserByJwt(jwt);
        CartItem newCart = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
        return new ResponseEntity<CartItem>(newCart, HttpStatus.ACCEPTED);
    }
}
