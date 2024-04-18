package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.exception.CartIemException;
import com.lth.ecommerce_backend.exception.UserException;
import com.lth.ecommerce_backend.model.Cart;
import com.lth.ecommerce_backend.model.CartItem;
import com.lth.ecommerce_backend.model.Product;
import com.lth.ecommerce_backend.model.User;
import com.lth.ecommerce_backend.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private UserService userService;
    @Override
    public CartItem createCartItem(CartItem cartItem) {
        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice() * cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getDiscountedPrice() * cartItem.getQuantity());

        CartItem createdCartItem = cartItemRepository.save(cartItem);
        return createdCartItem;
    }

    @Override
    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartIemException, UserException {
        CartItem item = findCartItemById(id);
        User user = userService.findUserById(userId);

        if(user.getId().equals(userId)) {
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity()*item.getProduct().getPrice());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());
        }
        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
        CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);
        return cartItem;
    }

    @Override
    public void removeCartItem(Long userId, Long cartitemId) throws CartIemException, UserException {
        CartItem item = findCartItemById(cartitemId);
        User user = userService.findUserById(item.getUserId());

        User userReq = userService.findUserById(userId);

        if(user.getId().equals(userReq.getId())) {
            cartItemRepository.deleteById(cartitemId);
        }
        else {
            throw new UserException("You can't remove another users item !");
        }
    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartIemException {
        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);

        if(opt.isPresent()) {
            return opt.get();
        }
        throw new CartIemException("Cart item not found with id: " + cartItemId);
    }
}
