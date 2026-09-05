package com.pruebasoftware.semana4.pedidos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {
    private final String id;
    private final String customerName;
    private final List<OrderItem> items;
    private final LocalDateTime createdAt;

    public Order(String id, String customerName, List<OrderItem> items, LocalDateTime createdAt) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id is required");
        }
        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("customerName is required");
        }
        Objects.requireNonNull(items, "items is required");
        if (items.isEmpty()) {
            throw new IllegalArgumentException("items cannot be empty");
        }

        this.id = id;
        this.customerName = customerName;
        this.items = List.copyOf(items);
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
    }

    public BigDecimal total() {
        return items.stream()
                .map(OrderItem::subtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public String getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
