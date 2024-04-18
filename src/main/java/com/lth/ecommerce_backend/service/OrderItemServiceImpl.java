package com.lth.ecommerce_backend.service;

import com.lth.ecommerce_backend.model.OrderItem;
import com.lth.ecommerce_backend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Override
    public OrderItem createOrderItem(OrderItem item) {
        return orderItemRepository.save(item);
    }
}
