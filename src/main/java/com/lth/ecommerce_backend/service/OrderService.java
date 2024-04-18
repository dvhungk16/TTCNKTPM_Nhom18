package com.lth.ecommerce_backend.service;


import com.lth.ecommerce_backend.exception.OrderException;
import com.lth.ecommerce_backend.model.Address;
import com.lth.ecommerce_backend.model.Order;
import com.lth.ecommerce_backend.model.User;

import java.util.List;

public interface OrderService {
    public Order findOrderById(Long orderId) throws OrderException;
    public Order createOrder(User user, Address shippingAddress);
    public List<Order> usersOrderHistory(Long userId);
    public Order placedOrder(Long orderId) throws OrderException;
    public Order confirmedOrder(Long orderId) throws OrderException;
    public Order shippedOrder(Long orderId) throws OrderException;
    public Order deliveredOrder(Long orderId) throws OrderException;
    public Order canceledOrder(Long orderId) throws OrderException;
    public List<Order> getAllOrders();
    public void deleteOrder(Long orderId) throws OrderException;


}
