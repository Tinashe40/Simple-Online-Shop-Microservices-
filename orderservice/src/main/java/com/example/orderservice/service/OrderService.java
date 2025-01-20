package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import com.example.orderservice.client.ProductClient;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.DTO.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order addOrder(Order order){
        Product product=productClient.getProductById(order.getProductId());
        if (product != null){
            return orderRepository.save(order);
        }else{
            throw new RuntimeException("Product not found");
        }
    }
}
