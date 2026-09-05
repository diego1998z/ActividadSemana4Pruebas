package com.pruebasoftware.semana4.pedidos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = Objects.requireNonNull(orderRepository, "orderRepository is required");
    }

    public Order registerOrder(String id, String customerName, List<OrderItem> items) {
        Order order = new Order(id, customerName, items, LocalDateTime.now());
        return orderRepository.save(order);
    }

    public Optional<Order> findOrder(String id) {
        return orderRepository.findById(id);
    }

    public List<Order> listOrders() {
        return orderRepository.findAll();
    }
}
